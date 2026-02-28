package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.ServicioController;
import co.edu.uniquindio.poo.taller.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioViewController {

    private ServicioController servicioController;
    private ObservableList<Servicio> listServicios = FXCollections.observableArrayList();
    private App app;

    @FXML private DatePicker dpFecha;
    @FXML private TextField txtMotivo;
    @FXML private TextField txtDiagnostico;
    @FXML private TextField txtTrabajos;
    @FXML private TextField txtCosto;

    // ✅ NUEVO: ComboBoxes en lugar de TextFields
    @FXML private ComboBox<Cliente> cbCliente;
    @FXML private ComboBox<Bicicleta> cbBicicleta;
    @FXML private ComboBox<Mecanico> cbMecanico;

    @FXML private ComboBox<TipoServicio> cbTipoServicio;
    @FXML private ComboBox<Estado> cbEstado;

    @FXML private TableView<Servicio> tblServicios;
    @FXML private TableColumn<Servicio, String> colFecha;
    @FXML private TableColumn<Servicio, String> colCliente;
    @FXML private TableColumn<Servicio, String> colBici;
    @FXML private TableColumn<Servicio, String> colEstado;

    @FXML private Label lblTotalServicios;

    @FXML
    void initialize() {
        servicioController = new ServicioController(App.taller);
        initView();
        configurarComboBoxes();
    }

    private void initView() {
        cbTipoServicio.getItems().setAll(TipoServicio.values());
        cbEstado.getItems().setAll(Estado.values());

        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFechaIngreso().toString()));
        colCliente.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        colBici.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getBicicleta().getNumMarco()));
        colEstado.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEstado().toString()));

        obtenerServicios();
        tblServicios.setItems(listServicios);
        actualizarContador();
    }

    private void configurarComboBoxes() {
        // ✅ Configurar ComboBox de Clientes
        cbCliente.setItems(FXCollections.observableArrayList(App.taller.getListClientes()));
        cbCliente.setConverter(new javafx.util.StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente == null ? "" : cliente.getNombre() + " (ID: " + cliente.getId() + ")";
            }
            @Override
            public Cliente fromString(String string) { return null; }
        });

        // ✅ Configurar ComboBox de Mecánicos
        cbMecanico.setItems(FXCollections.observableArrayList(App.taller.getListMecanicos()));
        cbMecanico.setConverter(new javafx.util.StringConverter<Mecanico>() {
            @Override
            public String toString(Mecanico mecanico) {
                return mecanico == null ? "" : mecanico.getNombre() + " - " + mecanico.getEspecialidad();
            }
            @Override
            public Mecanico fromString(String string) { return null; }
        });

        // ✅ Cuando se selecciona un cliente, filtrar sus bicicletas
        cbCliente.setOnAction(e -> {
            Cliente cliente = cbCliente.getValue();
            if (cliente != null) {
                cbBicicleta.setItems(FXCollections.observableArrayList(cliente.getListBicicletas()));
                cbBicicleta.setDisable(false);
            } else {
                cbBicicleta.getItems().clear();
                cbBicicleta.setDisable(true);
            }
        });

        // ✅ Configurar ComboBox de Bicicletas (inicialmente deshabilitado)
        cbBicicleta.setDisable(true);
        cbBicicleta.setConverter(new javafx.util.StringConverter<Bicicleta>() {
            @Override
            public String toString(Bicicleta bici) {
                return bici == null ? "" : bici.getMarca() + " - " + bici.getNumMarco() + " (" + bici.getTipo() + ")";
            }
            @Override
            public Bicicleta fromString(String string) { return null; }
        });
    }

    private void obtenerServicios() {
        listServicios.clear();
        listServicios.addAll(servicioController.obtenerListaServicios());
    }

    private void actualizarContador() {
        if (lblTotalServicios != null) {
            lblTotalServicios.setText("Total servicios: " + listServicios.size());
        }
    }

    @FXML
    void onAgregarServicio() {
        try {
            if (!validarCampos()) return;

            Cliente cliente = cbCliente.getValue();
            Bicicleta bicicleta = cbBicicleta.getValue();
            Mecanico mecanico = cbMecanico.getValue();

            if (cliente == null || bicicleta == null || mecanico == null) {
                mostrarAlerta("Error", "Debe seleccionar cliente, bicicleta y mecánico", Alert.AlertType.ERROR);
                return;
            }

            Servicio servicio = new Servicio(
                    dpFecha.getValue() != null ? dpFecha.getValue() : LocalDate.now(),
                    LocalDateTime.now(),
                    txtMotivo.getText(),
                    txtDiagnostico.getText(),
                    txtTrabajos.getText(),
                    Double.parseDouble(txtCosto.getText()),
                    mecanico,
                    cliente,
                    bicicleta,
                    cbTipoServicio.getValue() != null ? cbTipoServicio.getValue() : TipoServicio.MANTENIMIENTO,
                    cbEstado.getValue() != null ? cbEstado.getValue() : Estado.PROGRAMADO
            );

            if (servicioController.crearServicio(servicio)) {
                listServicios.add(servicio);
                actualizarContador();
                limpiarCampos();
                mostrarAlerta("Éxito", "Servicio registrado correctamente", Alert.AlertType.INFORMATION);
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Costo inválido", Alert.AlertType.ERROR);
        }
    }

    private boolean validarCampos() {
        if (txtMotivo.getText().isEmpty() || txtDiagnostico.getText().isEmpty() ||
                txtTrabajos.getText().isEmpty() || txtCosto.getText().isEmpty() ||
                cbCliente.getValue() == null || cbBicicleta.getValue() == null ||
                cbMecanico.getValue() == null) {
            mostrarAlerta("Advertencia", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    @FXML
    void onLimpiar() {
        limpiarCampos();
    }

    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    private void limpiarCampos() {
        txtMotivo.clear();
        txtDiagnostico.clear();
        txtTrabajos.clear();
        txtCosto.clear();

        cbCliente.setValue(null);
        cbMecanico.setValue(null);
        cbBicicleta.setValue(null);
        cbBicicleta.getItems().clear();
        cbBicicleta.setDisable(true);

        dpFecha.setValue(null);
        cbTipoServicio.setValue(null);
        cbEstado.setValue(null);
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