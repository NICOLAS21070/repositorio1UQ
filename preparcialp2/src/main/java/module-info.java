module org.uniquindio.edu.co.poo.preparcialp2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.uniquindio.edu.co.poo.preparcialp2 to javafx.fxml;

    opens org.uniquindio.edu.co.poo.preparcialp2.controllers to javafx.fxml;

    exports org.uniquindio.edu.co.poo.preparcialp2;
}
