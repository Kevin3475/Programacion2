package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.ClienteController;
import co.edu.uniquindio.poo.taller.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteViewController {

    private ClienteController clienteController;
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private Cliente selectedCliente;
    private App app;

    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;

    @FXML
    private TableView<Cliente> tblListCliente;
    @FXML
    private TableColumn<Cliente, String> tbcCedula;
    @FXML
    private TableColumn<Cliente, String> tbcNombre;
    @FXML
    private TableColumn<Cliente, String> tbcTelefono;
    @FXML
    private TableColumn<Cliente, String> tbcDireccion;

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnVolver;

    @FXML
    void initialize() {
        clienteController = new ClienteController(App.taller);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tblListCliente.setItems(listClientes);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcDireccion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void obtenerClientes() {
        listClientes.clear();
        listClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getId());
            txtNombre.setText(cliente.getNombre());
            txtTelefono.setText(cliente.getTelefono());
            txtDireccion.setText(cliente.getDireccion());
        }
    }

    @FXML
    void onAgregarCliente() {
        if (validarCampos()) {
            Cliente cliente = buildCliente();
            if (clienteController.crearCliente(cliente)) {
                listClientes.add(cliente);
                limpiarCampos();
                mostrarAlerta("Éxito", "Cliente agregado correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Ya existe un cliente con esa cédula", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void onActualizarCliente() {
        if (selectedCliente != null) {
            if (validarCampos()) {
                if (clienteController.actualizarCliente(selectedCliente.getId(), buildCliente())) {
                    obtenerClientes();
                    limpiarSeleccion();
                    mostrarAlerta("Éxito", "Cliente actualizado correctamente", Alert.AlertType.INFORMATION);
                }
            }
        } else {
            mostrarAlerta("Advertencia", "Seleccione un cliente de la tabla", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onEliminarCliente() {
        if (selectedCliente != null) {
            if (clienteController.eliminarCliente(txtCedula.getText())) {
                listClientes.remove(selectedCliente);
                limpiarSeleccion();
                mostrarAlerta("Éxito", "Cliente eliminado correctamente", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarAlerta("Advertencia", "Seleccione un cliente de la tabla", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    private boolean validarCampos() {
        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
            mostrarAlerta("Advertencia", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    private Cliente buildCliente() {
        return new Cliente(
                txtNombre.getText(),
                txtCedula.getText(),
                txtTelefono.getText(),
                txtDireccion.getText()
        );
    }

    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtCedula.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtDireccion.clear();
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