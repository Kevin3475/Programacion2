package co.edu.uniquindio.poo.taller.viewcontroller;

import co.edu.uniquindio.poo.taller.App;
import co.edu.uniquindio.poo.taller.controller.MecanicoController;
import co.edu.uniquindio.poo.taller.model.Mecanico;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * clase viewController de la clase mecanico
 */
public class MecanicoViewController {

    private MecanicoController mecanicoController;
    private ObservableList<Mecanico> listMecanicos = FXCollections.observableArrayList();
    private Mecanico selectedMecanico;
    private App app;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEspecialidad;
    @FXML private TextField txtCertificacion;

    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colId;
    @FXML private TableColumn<Mecanico, String> colNombre;
    @FXML private TableColumn<Mecanico, String> colEspecialidad;
    @FXML private TableColumn<Mecanico, String> colCertificacion;

    @FXML private Label lblTotalMecanicos;

    @FXML
    void initialize() {
        mecanicoController = new MecanicoController(App.taller);
        initView();
    }

    private void initView() {
        colId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));
        colEspecialidad.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getEspecialidad()));
        colCertificacion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNumCertificado()));

        obtenerMecanicos();
        tblMecanicos.setItems(listMecanicos);

        tblMecanicos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMecanico = newSelection;
            mostrarInformacionMecanico(selectedMecanico);
        });

        actualizarContador();
    }

    /**
     * metodo para llamar la lista de mecanicos
     */
    private void obtenerMecanicos() {
        listMecanicos.clear();
        listMecanicos.addAll(mecanicoController.obtenerListaMecanicos());
    }

    /**
     * metodo para actualizar el contador de mecanicos
     */
    private void actualizarContador() {
        if (lblTotalMecanicos != null) {
            lblTotalMecanicos.setText("Cantidad mecanicos mecánicos: " + listMecanicos.size());
        }
    }

    /**
     * metodo para mostrar la informacion de un mecanico
     * @param mecanico
     */
    private void mostrarInformacionMecanico(Mecanico mecanico) {
        if (mecanico != null) {
            txtId.setText(mecanico.getId());
            txtNombre.setText(mecanico.getNombre());
            txtEspecialidad.setText(mecanico.getEspecialidad());
            txtCertificacion.setText(mecanico.getNumCertificado());
        }
    }

    /**
     * boton para agregar mecanicos
     * */
    @FXML
    void onAgregar() {
        if (validarCampos()) {
            Mecanico mecanico = new Mecanico(
                    txtNombre.getText(),
                    txtId.getText(),
                    txtEspecialidad.getText(),
                    txtCertificacion.getText()
            );

            if (mecanicoController.crearMecanico(mecanico)) {
                listMecanicos.add(mecanico);
                actualizarContador();
                limpiarCampos();
                mostrarAlerta("Éxito", "Mecánico agregado correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Ya existe un mecánico con ese ID", Alert.AlertType.ERROR);
            }
        }
    }

    /**
     * boton para actualizar mecanicos
     */
    @FXML
    void onActualizar() {
        if (selectedMecanico != null && validarCampos()) {
            mostrarAlerta("Información", "Función en desarrollo", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Advertencia", "Seleccione un mecánico de la tabla", Alert.AlertType.WARNING);
        }
    }

    /**
     * boton para eliminar mecanicos
     */
    @FXML
    void onEliminar() {
        if (selectedMecanico != null) {
            listMecanicos.remove(selectedMecanico);
            actualizarContador();
            limpiarSeleccion();
            mostrarAlerta("Éxito", "Mecánico eliminado correctamente", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Advertencia", "Seleccione un mecánico de la tabla", Alert.AlertType.WARNING);
        }
    }

    /**
     * metodo para validar los campos obligatorios
     * @return
     */
    private boolean validarCampos() {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtEspecialidad.getText().isEmpty() || txtCertificacion.getText().isEmpty()) {
            mostrarAlerta("Advertencia", "Todos los campos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }

    /**
     * boton para limpiar la seleccion
     */
    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    /**
     * boton para volver
     */
    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    /**
     * metodo para limpiar la seleccion
     */
    private void limpiarSeleccion() {
        tblMecanicos.getSelectionModel().clearSelection();
        limpiarCampos();
        selectedMecanico = null;
    }

    /**
     * metodo para limpiar los campos
     */
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEspecialidad.clear();
        txtCertificacion.clear();
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