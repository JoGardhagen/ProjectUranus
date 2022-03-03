module com.example.uranusproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gardhagen.joakim.uranusproject to javafx.fxml;
    exports com.gardhagen.joakim.uranusproject;
}