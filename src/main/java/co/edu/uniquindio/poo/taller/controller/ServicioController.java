package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase controladora de Servivios
 */
public class ServicioController {

    private Taller taller;

    /**
     * Metodo construcor de la clase ServiciosController
     * @param taller
     */
    public ServicioController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo para agregar un servicio
     * @param servicio
     * @return
     */
    public boolean crearServicio(Servicio servicio) {
        return taller.agregarServicio(servicio);
    }

    /**
     * Metodo para llamar la lista de servicios
     * @return
     */
    public List<Servicio> obtenerListaServicios() {
        return taller.getListServicios();
    }

    /**
     * Metodo para llamar la lista de servicios de una fecha especifica
     * @param fecha
     * @return
     */
    public List<Servicio> obtenerServiciosPorFecha(LocalDate fecha) {
        return taller.obtenerServiciosPorFecha(fecha);
    }
}