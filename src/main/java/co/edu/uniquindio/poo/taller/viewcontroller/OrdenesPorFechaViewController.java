package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.OrdenesController;  // ← IMPORTAR CONTROLLER
import co.edu.uniquindio.poo.taller.model.Servicio;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdenesPorFechaViewController {

    private OrdenesController ordenesController;  // ← USAR CONTROLLER
    private App app;

    @FXML private DatePicker dpFecha;
    @FXML private TableView<Servicio> tblOrdenes;
    @FXML private TableColumn<Servicio, String> colHora;
    @FXML private TableColumn<Servicio, String> colCliente;
    @FXML private TableColumn<Servicio, String> colBici;
    @FXML private TableColumn<Servicio, String> colMecanico;
    @FXML private TableColumn<Servicio, String> colMotivo;
    @FXML private TableColumn<Servicio, String> colEstado;
    @FXML private TableColumn<Servicio, Double> colCosto;

    @FXML private Label lblFechaSeleccionada;
    @FXML private Label lblTotalOrdenes;

    private ObservableList<Servicio> listOrdenes = FXCollections.observableArrayList();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    void initialize() {
        ordenesController = new OrdenesController(App.taller);  // ← INICIALIZAR CONTROLLER
        configurarTabla();
        dpFecha.setValue(LocalDate.now());
        buscarPorFecha();
    }

    private void configurarTabla() {
        colHora.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getHora().toLocalTime().toString()));
        colCliente.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        colBici.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getBicicleta().getNumMarco()));
        colMecanico.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMecanico().getNombre()));
        colMotivo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMotivoServicio()));
        colEstado.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        colCosto.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCostoTotal()).asObject());

        tblOrdenes.setItems(listOrdenes);
    }

    @FXML
    void onBuscar() {
        buscarPorFecha();
    }

    @FXML
    void onHoy() {
        dpFecha.setValue(LocalDate.now());
        buscarPorFecha();
    }

    private void buscarPorFecha() {
        LocalDate fecha = dpFecha.getValue();
        if (fecha == null) {
            mostrarAlerta("Fecha no válida", "Seleccione una fecha", Alert.AlertType.WARNING);
            return;
        }

        lblFechaSeleccionada.setText("Órdenes del: " + fecha.format(formatter));

        // USAR CONTROLLER PARA OBTENER LOS DATOS
        listOrdenes.clear();
        listOrdenes.addAll(ordenesController.obtenerOrdenesPorFecha(fecha));
        lblTotalOrdenes.setText("Total órdenes: " + listOrdenes.size());
    }

    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}