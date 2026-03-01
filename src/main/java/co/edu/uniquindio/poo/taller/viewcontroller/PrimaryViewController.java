package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * clase viewController de la clase Primary
 */
public class PrimaryViewController {

    private App app;

    /**
     * boton para abir la vista de clientes
     */
    @FXML
    void onOpenCrudCliente() {
        app.openCrudCliente();
    }

    /**
     * boton para abrir la vista de bicicleta
     */
    @FXML
    void onOpenBicicleta() {
        app.openBicicleta();
    }

    /**
     * boton para abrir la vista de mecanico
     */
    @FXML
    void onOpenMecanico() {
        app.openMecanico();
    }

    /**
     * boton para abiri la vista de servivio
     */
    @FXML
    void onOpenServicio() {
        app.openServicio();
    }

    /**
     * boton para ver el historial
     */
    @FXML
    void onOpenHistorial() {
        app.openHistorial();
    }

    /**
     * boton para ordenar por fecha
     */
    @FXML
    void onOpenOrdenesPorFecha() {
        app.openOrdenesPorFecha();
    }

    /**
     * boton para ver el stock
     */
    @FXML
    void onVerStock() {
        String alerta = App.taller.getAlertaStock();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("📦 Stock de Repuestos");
        alert.setHeaderText("Alerta de inventario");
        alert.setContentText(alerta);
        alert.showAndWait();
    }

    /**
     * boton para salir
     */
    @FXML
    void onSalir() {
        System.exit(0);
    }

    public void setApp(App app) {
        this.app = app;
    }
}