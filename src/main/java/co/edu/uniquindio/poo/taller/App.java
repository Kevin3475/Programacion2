package co.edu.uniquindio.poo.taller;

import co.edu.uniquindio.poo.taller.model.*;
import co.edu.uniquindio.poo.taller.viewcontroller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    public static Taller taller = new Taller("Taller de Bicicletas UQ", "900123456", "1234567");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de Gestión de Taller de Bicicletas");
        inicializarData();
        openViewPrincipal();
    }

    public void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/primary.fxml")
            );
            BorderPane rootLayout = loader.load();

            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/crudCliente.fxml")
            );
            BorderPane rootLayout = loader.load();

            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBicicleta() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/bicicleta.fxml")
            );
            BorderPane rootLayout = loader.load();

            BicicletaViewController bicicletaViewController = loader.getController();
            bicicletaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openMecanico() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/mecanico.fxml")
            );
            BorderPane rootLayout = loader.load();

            MecanicoViewController mecanicoViewController = loader.getController();
            mecanicoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openServicio() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/servicio.fxml")
            );
            BorderPane rootLayout = loader.load();

            ServicioViewController servicioViewController = loader.getController();
            servicioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========== NUEVAS VISTAS ==========

    public void openHistorial() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/historial.fxml")
            );
            BorderPane rootLayout = loader.load();

            HistorialViewController historialViewController = loader.getController();
            historialViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openOrdenesPorFecha() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/poo/taller/ordenesPorFecha.fxml")
            );
            BorderPane rootLayout = loader.load();

            OrdenesPorFechaViewController ordenesViewController = loader.getController();
            ordenesViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Datos de ejemplo

    public void inicializarData() {
        try {
            // Clientes
            Cliente c1 = new Cliente("Mario benneti", "12345", "555-1234", "Calle 1 #2-3");
            Cliente c2 = new Cliente("juliana maria", "67890", "555-5678", "Carrera 4 #5-6");
            taller.agregarCliente(c1);
            taller.agregarCliente(c2);

            // Mecánicos
            Mecanico m1 = new Mecanico("Sebastian Silva", "M001", "Frenos y transmisión", "CERT001");
            Mecanico m2 = new Mecanico("Facundo Hernandez", "M002", "Suspensión", "CERT002");
            taller.agregarMecanico(m1);
            taller.agregarMecanico(m2);

            // Bicicletas
            Bicicleta b1 = new Bicicleta("Trek", "MTB", "Rojo", "TREK123", 2022, "12345");
            Bicicleta b2 = new Bicicleta("Specialized", "Ruta", "Negro", "SPEC456", 2023, "67890");
            taller.agregarBicicleta(b1, "12345");
            taller.agregarBicicleta(b2, "67890");

            System.out.println("✅ Datos de inicialización cargados correctamente");
            System.out.println("   Clientes: " + taller.getListClientes().size());
            System.out.println("   Mecánicos: " + taller.getListMecanicos().size());
            System.out.println("   Bicicletas: " + taller.getListBicicletas().size());

        } catch (Exception e) {
            System.out.println("❌ Error al inicializar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}