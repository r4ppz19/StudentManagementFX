package com.school.studentmanagementfx.util;

import javafx.scene.Parent;

class LoadedView<T> {
    private final Parent root;
    private final T controller;

    public LoadedView(Parent root, T controller) {
        this.root = root;
        this.controller = controller;
    }

    public Parent getRoot() {
        return root;
    }

    public T getController() {
        return controller;
    }
}
