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

/**
 * clase viewController de la clase bicicleta
 */
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
    @FXML private ComboBox<Cliente> cbCliente;

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


        cbCliente.setPromptText("Seleccione un cliente");
    }

    /**
     * metodo par configurar la tabla
     */
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
        configurarAlturaTabla();
        actualizarContador();
    }

    /**
     * metodo para configurar la altura de la tabla
     */
    private void configurarAlturaTabla() {
        tblBicicletas.setFixedCellSize(35);
        tblBicicletas.prefHeightProperty().bind(
                tblBicicletas.fixedCellSizeProperty()
                        .multiply(Bindings.size(tblBicicletas.getItems()).add(2.5))
        );
    }

    /**
     * metodo para configuara automaticamente la tabla de bicicletas
     */
    private void configurarSeleccionTabla() {
        tblBicicletas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedBicicleta = newSelection;
            if (selectedBicicleta != null) {
                mostrarInformacionBicicleta(selectedBicicleta);
            }
        });
    }

    /**
     * metodo para mostrar la informacion de una bicicleta
     * @param bicicleta
     */
    private void mostrarInformacionBicicleta(Bicicleta bicicleta) {
        txtMarca.setText(bicicleta.getMarca());
        txtTipo.setText(bicicleta.getTipo());
        txtColor.setText(bicicleta.getColor());
        txtSerial.setText(bicicleta.getNumMarco());
        txtAnio.setText(String.valueOf(bicicleta.getAnio()));

        // BUSCAR Y SELECCIONAR EL CLIENTE EN EL COMBOBOX
        for (Cliente c : cbCliente.getItems()) {
            if (c.getId().equals(bicicleta.getIdCliente())) {
                cbCliente.setValue(c);
                break;
            }
        }
    }

    /**
     * metodo para llamar la lista de bicicletas
     */
    private void obtenerBicicletas() {
        listBicicletas.clear();
        listBicicletas.addAll(bicicletaController.obtenerListaBicicletas());
    }

    /**
     * metodo para actualizar el contador de bicicletas
     */
    private void actualizarContador() {
        if (lblTotalBicicletas != null) {
            lblTotalBicicletas.setText("Total bicicletas: " + listBicicletas.size());
        }
    }

    /**
     * boton para agregar bicicletas a clientes
     */
    @FXML
    void onAgregar() {
        if (validarCampos()) {
            try {
                // obtener cliente que se seleccione
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

    /**
     * metodo para validar los datos obligatorios
     * @return
     */
    private boolean validarCampos() {
        if (txtMarca.getText().isEmpty() || txtTipo.getText().isEmpty() ||
                txtColor.getText().isEmpty() || txtSerial.getText().isEmpty() ||
                txtAnio.getText().isEmpty() || cbCliente.getValue() == null) {  // ✅ VALIDAR COMBOBOX
            mostrarAlerta("Advertencia", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    /**
     * boton para limpiar los datos
     */
    @FXML
    void onLimpiar() {
        limpiarCampos();
        tblBicicletas.getSelectionModel().clearSelection();
        selectedBicicleta = null;
    }

    /**
     * boton para volver
     */
    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    /**
     * metodo para limpiar los campos
     */
    private void limpiarCampos() {
        txtMarca.clear();
        txtTipo.clear();
        txtColor.clear();
        txtSerial.clear();
        txtAnio.clear();
        cbCliente.setValue(null);// se hizo para limpiar la tabla
    }

    /**
     * metodo para mostrar una alerta
     * @param titulo
     * @param mensaje
     * @param tipo
     */
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