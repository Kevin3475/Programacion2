module co.edu.uniquindio.poo.taller {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.taller to javafx.fxml;
    exports co.edu.uniquindio.poo.taller;

    opens co.edu.uniquindio.poo.taller.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.poo.taller.viewcontroller;

    opens co.edu.uniquindio.poo.taller.controller to javafx.fxml;
    exports co.edu.uniquindio.poo.taller.controller;

    opens co.edu.uniquindio.poo.taller.model to javafx.fxml;
    exports co.edu.uniquindio.poo.taller.model;
}