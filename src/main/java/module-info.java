module com.example.uranusproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uranusproject to javafx.fxml;
    exports com.example.uranusproject;
}