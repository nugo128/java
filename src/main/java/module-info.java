module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mapstruct;



    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}