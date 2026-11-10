module org.example.ejercicioclase_bustelo {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires mysql.connector.j;
    requires java.naming;


    opens org.example.ejercicioclase_bustelo to javafx.fxml;
    opens org.example.ejercicioclase_bustelo.controllers to javafx.fxml;
    exports org.example.ejercicioclase_bustelo;
}