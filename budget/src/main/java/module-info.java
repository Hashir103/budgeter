module com.example.budget {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budget to javafx.fxml;
    exports com.example.budget;
}