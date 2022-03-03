package com.gardhagen.joakim.uranusproject;


import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static final int WIDHT = 1000;
    private static final int HIGHT = 500;

    @Override
    public void start(Stage stage) throws IOException {
        Sphere sphere = new Sphere(100);

        Group group = new Group();
        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera();

        Scene scene = new Scene(group, WIDHT, HIGHT);
        scene.setFill(Color.STEELBLUE);
        scene.setCamera(camera);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
            switch (event.getCode())
            {
                case W:
                    sphere.translateZProperty().set(sphere.getTranslateZ()+10);
                    break;
                case S:
                    sphere.translateZProperty().set(sphere.getTranslateZ()-10);
                    break;
            }
        });

        sphere.translateXProperty().set(WIDHT/2);
        sphere.translateYProperty().set(HIGHT/2);

        stage.setTitle("UranusPrjoect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}