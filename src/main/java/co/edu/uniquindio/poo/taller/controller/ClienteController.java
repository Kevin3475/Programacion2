package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Cliente;
import co.edu.uniquindio.poo.taller.model.Taller;
import java.util.List;

public class ClienteController {
    private Taller taller;

    public ClienteController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearCliente(Cliente cliente) {
        return taller.agregarCliente(cliente);
    }

    public List<Cliente> obtenerListaClientes() {
        return taller.getListClientes();
    }

    public boolean eliminarCliente(String id) {
        return taller.eliminarCliente(id);
    }

    public boolean actualizarCliente(String id, Cliente cliente) {
        return taller.actualizarCliente(id, cliente);
    }

    public Cliente obtenerCliente(String id) {
        return taller.obtenerCliente(id);
    }
}