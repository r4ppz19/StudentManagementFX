package com.school.studentmanagementfx.view;

import javafx.scene.Parent;

public class LoadedView<C> {
    private final Parent root;
    private final C controller;

    public LoadedView(Parent root, C controller) {
        this.root = root;
        this.controller = controller;
    }

    public Parent getRoot() {
        return root;
    }

    public C getController() {
        return controller;
    }
}
