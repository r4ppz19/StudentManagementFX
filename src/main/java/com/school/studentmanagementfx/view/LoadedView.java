package com.school.studentmanagementfx.view;

import javafx.scene.Parent;

public class LoadedView<T> {
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
