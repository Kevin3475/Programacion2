package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.time.LocalDate;
import java.util.List;

public class ServicioController {

    private Taller taller;

    public ServicioController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearServicio(Servicio servicio) {
        return taller.agregarServicio(servicio);
    }

    public List<Servicio> obtenerListaServicios() {
        return taller.getListServicios();
    }

    public List<Servicio> obtenerServiciosPorFecha(LocalDate fecha) {
        return taller.obtenerServiciosPorFecha(fecha);
    }
}