package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PrimaryViewController {

    private App app;

    @FXML
    void onOpenCrudCliente() {
        app.openCrudCliente();
    }

    @FXML
    void onOpenBicicleta() {
        app.openBicicleta();
    }

    @FXML
    void onOpenMecanico() {
        app.openMecanico();
    }

    @FXML
    void onOpenServicio() {
        app.openServicio();
    }
    @FXML
    void onOpenHistorial() {
        app.openHistorial();
    }

    @FXML
    void onOpenOrdenesPorFecha() {
        app.openOrdenesPorFecha();
    }

    @FXML
    void onVerStock() {
        String alerta = App.taller.getAlertaStock();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("📦 Stock de Repuestos");
        alert.setHeaderText("ESTADO DEL INVENTARIO");
        alert.setContentText(alerta);
        alert.showAndWait();
    }

    @FXML
    void onSalir() {
        System.exit(0);
    }

    public void setApp(App app) {
        this.app = app;
    }
}