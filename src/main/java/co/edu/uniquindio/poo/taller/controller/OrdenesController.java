package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Servicio;
import co.edu.uniquindio.poo.taller.model.Taller;
import java.time.LocalDate;
import java.util.List;

public class OrdenesController {

    private Taller taller;

    public OrdenesController(Taller taller) {
        this.taller = taller;
    }

    public List<Servicio> obtenerOrdenesPorFecha(LocalDate fecha) {
        return taller.obtenerServiciosPorFecha(fecha);
    }
}