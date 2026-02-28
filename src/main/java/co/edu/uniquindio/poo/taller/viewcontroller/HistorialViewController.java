package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.HistorialController;  // ← IMPORTAR CONTROLLER
import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Servicio;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

public class HistorialViewController {

    private HistorialController historialController;  // ← USAR CONTROLLER
    private App app;

    @FXML private ComboBox<Bicicleta> cbBicicletas;
    @FXML private TableView<Servicio> tblHistorial;
    @FXML private TableColumn<Servicio, String> colFecha;
    @FXML private TableColumn<Servicio, String> colHora;
    @FXML private TableColumn<Servicio, String> colMecanico;
    @FXML private TableColumn<Servicio, String> colDiagnostico;
    @FXML private TableColumn<Servicio, String> colTrabajos;
    @FXML private TableColumn<Servicio, Double> colCosto;
    @FXML private TableColumn<Servicio, String> colEstado;

    @FXML private Label lblSerial;
    @FXML private Label lblMarca;
    @FXML private Label lblTipo;
    @FXML private Label lblCliente;
    @FXML private Label lblTotalServicios;

    private ObservableList<Servicio> listHistorial = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        historialController = new HistorialController(App.taller);  // ← INICIALIZAR CONTROLLER
        configurarComboBox();
        configurarTabla();
    }

    private void configurarComboBox() {
        // Usar el controller para obtener las bicicletas
        cbBicicletas.setItems(FXCollections.observableArrayList(
                historialController.obtenerTodasLasBicicletas()  // ← A TRAVÉS DEL CONTROLLER
        ));

        cbBicicletas.setConverter(new StringConverter<Bicicleta>() {
            @Override
            public String toString(Bicicleta bici) {
                if (bici == null) return "";
                return bici.getMarca() + " - " + bici.getNumMarco() + " (" + bici.getTipo() + ")";
            }
            @Override
            public Bicicleta fromString(String string) { return null; }
        });

        cbBicicletas.setPromptText("Seleccione una bicicleta");
        cbBicicletas.setEditable(true);

        cbBicicletas.setOnAction(e -> {
            Bicicleta seleccionada = cbBicicletas.getValue();
            if (seleccionada != null) {
                cargarHistorial(seleccionada);
            }
        });
    }

    private void configurarTabla() {
        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFechaIngreso().toString()));
        colHora.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getHora().toLocalTime().toString()));
        colMecanico.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMecanico().getNombre()));
        colDiagnostico.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDiagnostico()));
        colTrabajos.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTrabajosRealizados()));
        colCosto.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getCostoTotal()).asObject());
        colEstado.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstado().toString()));

        tblHistorial.setItems(listHistorial);
    }

    private void cargarHistorial(Bicicleta bicicleta) {
        lblSerial.setText(bicicleta.getNumMarco());
        lblMarca.setText(bicicleta.getMarca());
        lblTipo.setText(bicicleta.getTipo());

        // Usar controller para obtener nombre del cliente
        lblCliente.setText(historialController.obtenerNombreCliente(bicicleta.getIdCliente()));

        // Usar controller para obtener historial
        listHistorial.clear();
        listHistorial.addAll(historialController.obtenerHistorialServicios(bicicleta.getNumMarco()));
        lblTotalServicios.setText("Total servicios: " + listHistorial.size());
    }

    @FXML
    void onBuscar() {
        String texto = cbBicicletas.getEditor().getText();
        if (!texto.isEmpty()) {
            // Usar controller para buscar bicicleta
            Bicicleta bici = historialController.buscarBicicletaPorSerial(texto);
            if (bici != null) {
                cbBicicletas.setValue(bici);
                cargarHistorial(bici);
            } else {
                mostrarAlerta("No encontrada", "No existe bicicleta con ese serial", Alert.AlertType.WARNING);
            }
        }
    }

    @FXML
    void onLimpiar() {
        cbBicicletas.setValue(null);
        cbBicicletas.getEditor().clear();
        listHistorial.clear();
        lblSerial.setText("-");
        lblMarca.setText("-");
        lblTipo.setText("-");
        lblCliente.setText("-");
        lblTotalServicios.setText("Total servicios: 0");
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