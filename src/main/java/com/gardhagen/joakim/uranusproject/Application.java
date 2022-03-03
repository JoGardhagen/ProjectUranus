package com.gardhagen.joakim.uranusproject;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Sphere sphere = new Sphere(50);

        Group group = new Group();
        group.getChildren().add(sphere);

        Scene scene = new Scene(group,1400,800);

        stage.setTitle("UranusPrjoect");
        stage.setScene(scene);
        stage.show();

     
    }

    public static void main(String[] args) {
        launch();
    }
}