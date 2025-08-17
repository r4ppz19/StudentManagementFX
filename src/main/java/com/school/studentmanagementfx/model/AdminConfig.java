package com.school.studentmanagementfx.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Configuration class for managing admin user credentials.
 * Loads admin users from a properties file and provides authentication methods.
 */
public class AdminConfig {
    private static final String CONFIG_FILE = "/admin.properties";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";
    
    private final Map<String, String> adminUsers = new HashMap<>();
    private static AdminConfig instance;
    
    private AdminConfig() {
        loadAdminUsers();
    }
    
    /**
     * Get the singleton instance of AdminConfig
     */
    public static AdminConfig getInstance() {
        if (instance == null) {
            instance = new AdminConfig();
        }
        return instance;
    }
    
    /**
     * Load admin users from the properties file.
     * If the file doesn't exist or can't be loaded, falls back to default admin user.
     */
    private void loadAdminUsers() {
        try (InputStream input = getClass().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                Properties properties = new Properties();
                properties.load(input);
                
                // Load all properties as username=password pairs
                for (String username : properties.stringPropertyNames()) {
                    String password = properties.getProperty(username);
                    if (password != null && !password.trim().isEmpty()) {
                        adminUsers.put(username.trim(), password.trim());
                    }
                }
                
                // If no users were loaded, add default
                if (adminUsers.isEmpty()) {
                    addDefaultAdmin();
                }
            } else {
                // Properties file not found, use default
                addDefaultAdmin();
            }
        } catch (IOException e) {
            // Error loading properties, use default
            System.err.println("Warning: Could not load admin configuration, using default admin user.");
            addDefaultAdmin();
        }
    }
    
    /**
     * Add the default admin user to the configuration
     */
    private void addDefaultAdmin() {
        adminUsers.put(DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }
    
    /**
     * Authenticate a user with username and password
     * @param username the username to check
     * @param password the password to check
     * @return true if the credentials are valid, false otherwise
     */
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        
        String storedPassword = adminUsers.get(username.trim());
        return storedPassword != null && storedPassword.equals(password.trim());
    }
    
    /**
     * Get the number of configured admin users
     * @return the number of admin users
     */
    public int getAdminUserCount() {
        return adminUsers.size();
    }
    
    /**
     * Check if a username exists in the configuration
     * @param username the username to check
     * @return true if the username exists, false otherwise
     */
    public boolean hasUser(String username) {
        return username != null && adminUsers.containsKey(username.trim());
    }
}