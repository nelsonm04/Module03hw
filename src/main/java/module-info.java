module com.example.module03_hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.module03_hw to javafx.fxml;
    exports com.example.module03_hw;
}