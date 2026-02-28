package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Mecanico;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.util.List;

public class MecanicoController {

    private Taller taller;

    public MecanicoController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearMecanico(Mecanico mecanico) {
        return taller.agregarMecanico(mecanico);
    }

    public List<Mecanico> obtenerListaMecanicos() {
        return taller.getListMecanicos();
    }

    public Mecanico obtenerMecanico(String id) {
        return taller.obtenerMecanico(id);
    }

    // Métodos adicionales necesarios
    public boolean eliminarMecanico(String id) {

        return taller.eliminarMecanico(id);
    }

    public boolean actualizarMecanico(String id, Mecanico mecanicoActualizado) {

        return taller.actualizarMecanico(id, mecanicoActualizado);
    }
}