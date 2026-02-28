package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Mecanico;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.util.List;

/**
 * Clase controladora de mecanico
 */
public class MecanicoController {

    private Taller taller;

    /**
     * Metodo construcor de la clase MecanicoController
     * @param taller
     */
    public MecanicoController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo para agreagar un mecanico
     * @param mecanico
     * @return
     */
    public boolean crearMecanico(Mecanico mecanico) {
        return taller.agregarMecanico(mecanico);
    }

    /**
     * Metodo para llamar la lista de mecanicos
     * @return
     */
    public List<Mecanico> obtenerListaMecanicos() {
        return taller.getListMecanicos();
    }

    /**
     * Metodo para llamar mecanicos por el IdMecanicos
     * @param id
     * @return
     */
    public Mecanico obtenerMecanico(String id) {
        return taller.obtenerMecanico(id);
    }

    /**
     * Metodo para eliminar mecanicos
     * @param id
     * @return
     */
    public boolean eliminarMecanico(String id) {
        return taller.eliminarMecanico(id);
    }

    /**
     * Metodo para actualizar mecanicos
     * @param id
     * @param mecanicoActualizado
     * @return
     */
    public boolean actualizarMecanico(String id, Mecanico mecanicoActualizado) {
        return taller.actualizarMecanico(id, mecanicoActualizado);
    }
}