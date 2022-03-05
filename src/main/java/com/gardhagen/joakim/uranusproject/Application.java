package com.gardhagen.joakim.uranusproject;


import javafx.animation.AnimationTimer;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;


public class Application extends javafx.application.Application {

    private static final int WIDHT = 1000;
    private static final int HIGHT = 500;
    private final PointLight pointLight = new PointLight();

    @Override
    public void start(Stage stage) throws IOException {

        Group group = new Group();
        group.getChildren().add(uranus());
        group.getChildren().add(new AmbientLight());
        group.getChildren().addAll(prepareLightSource());

        Camera camera = new PerspectiveCamera(true);

        Scene scene = new Scene(group, WIDHT, HIGHT,true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);

        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-500);

        camera.setNearClip(1);
        camera.setNearClip(7000);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
            switch (event.getCode())
            {
                case W:
                    camera.translateZProperty().set(camera.getTranslateZ()+10);
                    break;
                case S:
                    camera.translateZProperty().set(camera.getTranslateZ()-10);
                    break;
            }
        });

        stage.setTitle("UranusPrjoect");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                pointLight.setRotate(pointLight.getRotate()+1);
            }
        };
        timer.start();


    }
    private Node[] prepareLightSource() {
        //Create point light
        pointLight.setColor(Color.TOMATO);
        pointLight.getTransforms().add(new Translate(0, -100, 100));
        //Set axis of rotation
        pointLight.setRotationAxis(Rotate.X_AXIS);


        Sphere sphere = new Sphere(3);

        sphere.getTransforms().setAll(pointLight.getTransforms());
        sphere.rotateProperty().bind(pointLight.rotateProperty());
        sphere.rotationAxisProperty().bind(pointLight.rotationAxisProperty());

        //Return lights
        return new Node[]{pointLight, sphere};
    }
    private Sphere uranus(){
        PhongMaterial material = new PhongMaterial();

        try {
            // JavaFX dont find filepaths so u need (new javafx.scene.image.Image(file.toURI().toURL().toExternalForm()))
            // i dont really understand it yet why but its working now :)
            File file = new File("Texture.jpg");
            material.setDiffuseMap(new javafx.scene.image.Image(file.toURI().toURL().toExternalForm()));
        }catch (Exception e){
            System.out.println(e);
        }


        Sphere sphere = new Sphere(100);
        sphere.setMaterial(material);


        return sphere;
    }

    public static void main(String[] args) {
        launch();
    }
}