module com.example.ds1avaliacao1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ds1avaliacao1 to javafx.fxml;
    exports com.example.ds1avaliacao1;
}