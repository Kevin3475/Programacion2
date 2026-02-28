package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase controladora de Ordenes
 */
public class OrdenesController {

    private Taller taller;

    /**
     * Metodo construcor de la clase OrdenesController
     * @param taller
     */
    public OrdenesController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo para llamar la lista de ordenes de una fecha
     * @param fecha
     * @return
     */
    public List<Servicio> obtenerOrdenesPorFecha(LocalDate fecha) {
        return taller.obtenerServiciosPorFecha(fecha);
    }
}