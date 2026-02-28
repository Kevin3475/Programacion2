package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.BicicletaController;
import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Cliente;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

public class BicicletaViewController {

    private BicicletaController bicicletaController;
    private ObservableList<Bicicleta> listBicicletas = FXCollections.observableArrayList();
    private Bicicleta selectedBicicleta;
    private App app;

    @FXML private TextField txtMarca;
    @FXML private TextField txtTipo;
    @FXML private TextField txtColor;
    @FXML private TextField txtSerial;
    @FXML private TextField txtAnio;
    @FXML private ComboBox<Cliente> cbCliente;  // ✅ CAMBIADO DE TextField A ComboBox

    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colMarca;
    @FXML private TableColumn<Bicicleta, String> colModelo;
    @FXML private TableColumn<Bicicleta, String> colColor;
    @FXML private TableColumn<Bicicleta, String> colSerial;
    @FXML private TableColumn<Bicicleta, Integer> colAnio;
    @FXML private TableColumn<Bicicleta, String> colIdCliente;

    @FXML private Label lblTotalBicicletas;

    @FXML
    void initialize() {
        bicicletaController = new BicicletaController(App.taller);
        configurarComboBox();
        initView();
        configurarSeleccionTabla();
    }

    // ✅ NUEVO: Configurar el ComboBox de clientes
    private void configurarComboBox() {
        // Cargar todos los clientes del taller
        cbCliente.setItems(FXCollections.observableArrayList(App.taller.getListClientes()));

        // Configurar cómo se muestra cada cliente en el ComboBox
        cbCliente.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                if (cliente == null) return "";
                return cliente.getNombre() + " (ID: " + cliente.getId() + ")";
            }

            @Override
            public Cliente fromString(String string) {
                return null; // No necesario para este caso
            }
        });

        // Mostrar un prompt cuando no hay selección
        cbCliente.setPromptText("Seleccione un cliente");
    }

    private void initView() {
        // Configurar columnas
        colMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        colModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
        colColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        colSerial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMarco()));
        colAnio.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAnio()).asObject());
        colIdCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCliente()));

        // Cargar datos
        obtenerBicicletas();
        tblBicicletas.setItems(listBicicletas);

        // Configurar altura automática de la tabla
        configurarAlturaTabla();
        actualizarContador();
    }

    private void configurarAlturaTabla() {
        tblBicicletas.setFixedCellSize(35);
        tblBicicletas.prefHeightProperty().bind(
                tblBicicletas.fixedCellSizeProperty()
                        .multiply(Bindings.size(tblBicicletas.getItems()).add(2.5))
        );
    }

    private void configurarSeleccionTabla() {
        tblBicicletas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedBicicleta = newSelection;
            if (selectedBicicleta != null) {
                mostrarInformacionBicicleta(selectedBicicleta);
            }
        });
    }

    private void mostrarInformacionBicicleta(Bicicleta bicicleta) {
        txtMarca.setText(bicicleta.getMarca());
        txtTipo.setText(bicicleta.getTipo());
        txtColor.setText(bicicleta.getColor());
        txtSerial.setText(bicicleta.getNumMarco());
        txtAnio.setText(String.valueOf(bicicleta.getAnio()));

        // ✅ BUSCAR Y SELECCIONAR EL CLIENTE EN EL COMBOBOX
        for (Cliente c : cbCliente.getItems()) {
            if (c.getId().equals(bicicleta.getIdCliente())) {
                cbCliente.setValue(c);
                break;
            }
        }
    }

    private void obtenerBicicletas() {
        listBicicletas.clear();
        listBicicletas.addAll(bicicletaController.obtenerListaBicicletas());
    }

    private void actualizarContador() {
        if (lblTotalBicicletas != null) {
            lblTotalBicicletas.setText("Total bicicletas: " + listBicicletas.size());
        }
    }

    @FXML
    void onAgregar() {
        if (validarCampos()) {
            try {
                // ✅ OBTENER EL CLIENTE SELECCIONADO
                Cliente clienteSeleccionado = cbCliente.getValue();

                if (clienteSeleccionado == null) {
                    mostrarAlerta("Error", "Debe seleccionar un cliente", Alert.AlertType.ERROR);
                    return;
                }

                Bicicleta bicicleta = new Bicicleta(
                        txtMarca.getText().trim(),
                        txtTipo.getText().trim(),
                        txtColor.getText().trim(),
                        txtSerial.getText().trim(),
                        Integer.parseInt(txtAnio.getText().trim()),
                        clienteSeleccionado.getId()  // ✅ TOMAR ID DEL CLIENTE SELECCIONADO
                );

                if (bicicletaController.crearBicicleta(bicicleta, clienteSeleccionado.getId())) {
                    listBicicletas.add(bicicleta);
                    actualizarContador();
                    limpiarCampos();
                    mostrarAlerta("Éxito", "Bicicleta agregada correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarAlerta("Error", "No se pudo agregar la bicicleta. Verifique que el cliente exista y el serial no esté registrado.", Alert.AlertType.ERROR);
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El año debe ser un número válido", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean validarCampos() {
        if (txtMarca.getText().isEmpty() || txtTipo.getText().isEmpty() ||
                txtColor.getText().isEmpty() || txtSerial.getText().isEmpty() ||
                txtAnio.getText().isEmpty() || cbCliente.getValue() == null) {  // ✅ VALIDAR COMBOBOX
            mostrarAlerta("Advertencia", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    @FXML
    void onLimpiar() {
        limpiarCampos();
        tblBicicletas.getSelectionModel().clearSelection();
        selectedBicicleta = null;
    }

    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    private void limpiarCampos() {
        txtMarca.clear();
        txtTipo.clear();
        txtColor.clear();
        txtSerial.clear();
        txtAnio.clear();
        cbCliente.setValue(null);  // ✅ LIMPIAR COMBOBOX
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