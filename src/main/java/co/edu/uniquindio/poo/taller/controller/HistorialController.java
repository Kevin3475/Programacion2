package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.util.List;

/**
 * Clase controladora de Historial
 */
public class HistorialController {

    private Taller taller;

    /**
     * Metodo construcor de la clase historialController
     * @param taller
     */
    public HistorialController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo pra obtener todas las bicicletas
     * @return
     */
    public List<Bicicleta> obtenerTodasLasBicicletas() {
        return taller.getListBicicletas();
    }

    /**
     * Metodo para llamar una bicicleta por el serial
     * @param serial
     * @return
     */
    public Bicicleta buscarBicicletaPorSerial(String serial) {
        return taller.obtenerBicicleta(serial);
    }

    /**
     * Metodo para LLamar el historial de servicios de una bicicleta por el serial
     * @param serialBicicleta
     * @return
     */
    public List<Servicio> obtenerHistorialServicios(String serialBicicleta) {
        return taller.obtenerServiciosPorBicicleta(serialBicicleta);
    }

    /**
     * Metodo para para obtener el nombre del cliente por el IdCliente
     * @param idCliente
     * @return
     */
    public String obtenerNombreCliente(String idCliente) {
        var cliente = taller.obtenerCliente(idCliente);
        return cliente != null ? cliente.getNombre() : "Desconocido";
    }
}