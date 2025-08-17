# Student Management

A simple JavaFX desktop application for managing student records. Created as a school project and to learn desktop GUI development.

## Tech Stack

- Java
- JavaFX
- Maven
- FXML + CSS

## Requirements

- Java Development Kit (JDK) 21 or higher
- Maven (optional - Maven Wrapper is included)

## How to run
```bash
# Clone the repository
git clone https://github.com/r4ppz19/StudentManagementFX.git
cd StudentManagementFX

# Run the project

# If Maven is installed:
mvn clean javafx:run

# If Maven is NOT installed:
# (Windows)
./mvnw.cmd clean javafx:run

# (Linux/macOS)
./mvnw clean javafx:run

```

## Admin Login Configuration

The application now supports configurable admin users through a properties file. Admin credentials are no longer hard-coded in the source code.

### Default Login
- Username: `admin`
- Password: `admin`

### Configuring Additional Admin Users

You can add more admin users by editing the `admin.properties` file in the resources directory:

```properties
# Admin Users Configuration
admin=admin
administrator=secure123
schooladmin=password456
```

If the properties file is not found or cannot be loaded, the application will fall back to the default admin user.

_Student project - Work in progress_
