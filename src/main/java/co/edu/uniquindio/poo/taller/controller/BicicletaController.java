package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.util.List;

/**
 * Clase controladora de biclicleta
 */
public class BicicletaController {
    private Taller taller;

    /**
     * Metodo construcor de la clase bicicletaController
     * @param taller
     */
    public BicicletaController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo para asignar una biclicleta a un cliente
     * @param bicicleta
     * @param idCliente
     * @return
     */
    public boolean crearBicicleta(Bicicleta bicicleta, String idCliente) {
        return taller.agregarBicicleta(bicicleta, idCliente);
    }

    /**
     * Metodo para llamar la lista de biciletas
     * @return
     */
    public List<Bicicleta> obtenerListaBicicletas() {
        return taller.getListBicicletas();
    }

    /**
     * Metodo para llamar el serial de una bicicleta
     * @param serial
     * @return
     */
    public Bicicleta obtenerBicicleta(String serial) {
        return taller.obtenerBicicleta(serial);
    }

    /**
     * metodo para llamar la bicicleta de un cliente por el IDcliente
     * @param idCliente
     * @return
     */
    public List<Bicicleta> obtenerBicicletasPorCliente(String idCliente) {
        return taller.getBicicletasPorCliente(idCliente);
    }
}