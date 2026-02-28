package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Cliente;
import co.edu.uniquindio.poo.taller.model.Taller;

import java.util.List;

/**
 * Clase controladora de cliente
 */
public class ClienteController {
    private Taller taller;

    /**
     * Metodo construcor de la clase ClienteController
     * @param taller
     */
    public ClienteController(Taller taller) {
        this.taller = taller;
    }

    /**
     * Metodo para agregar un cliente al taller
     * @param cliente
     * @return
     */
    public boolean crearCliente(Cliente cliente) {
        return taller.agregarCliente(cliente);
    }

    /**
     * Metodo para obtenter la lista de cliente
     * @return
     */
    public List<Cliente> obtenerListaClientes() {
        return taller.getListClientes();
    }

    /**
     * Metodo para eliminar clientes del taller
     * @param id
     * @return
     */
    public boolean eliminarCliente(String id) {
        return taller.eliminarCliente(id);
    }

    /**
     * Metodo para actualizar clientes de taller
     * @param id
     * @param cliente
     * @return
     */
    public boolean actualizarCliente(String id, Cliente cliente) {
        return taller.actualizarCliente(id, cliente);
    }

    /**
     * Metodo para obtener clientes especificos por IDCliente
     * @param id
     * @return
     */
    public Cliente obtenerCliente(String id) {
        return taller.obtenerCliente(id);
    }
}