package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;
import java.util.List;

public class HistorialController {

    private Taller taller;

    public HistorialController(Taller taller) {
        this.taller = taller;
    }

    public List<Bicicleta> obtenerTodasLasBicicletas() {
        return taller.getListBicicletas();
    }

    public Bicicleta buscarBicicletaPorSerial(String serial) {
        return taller.obtenerBicicleta(serial);
    }

    public List<Servicio> obtenerHistorialServicios(String serialBicicleta) {
        return taller.obtenerServiciosPorBicicleta(serialBicicleta);
    }

    public String obtenerNombreCliente(String idCliente) {
        var cliente = taller.obtenerCliente(idCliente);
        return cliente != null ? cliente.getNombre() : "Desconocido";
    }
}