module com.example.serpinski {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.serpinski to javafx.fxml;
    exports com.example.serpinski;
}