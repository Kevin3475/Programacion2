package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Taller {
    private String nombre;
    private String nit;
    private String telefono;
    private List<Bicicleta> listBicicletas;
    private List<Cliente> listClientes;
    private List<Mecanico> listMecanicos;
    private List<Servicio> listServicios;
    private int stockRepuestos = 50;
    private int stockMinimo = 10;

    public Taller(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.listBicicletas = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listMecanicos = new ArrayList<>();
        this.listServicios = new ArrayList<>();
    }

    // ========== MÉTODOS PARA CLIENTES ==========
    public boolean agregarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getId())) {
            listClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean verificarCliente(String id) {
        return listClientes.stream().anyMatch(c -> c.getId().equals(id));
    }

    public Cliente obtenerCliente(String id) {
        return listClientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarCliente(String id) {
        return listClientes.removeIf(c -> c.getId().equals(id));
    }

    public boolean actualizarCliente(String id, Cliente clienteActualizado) {
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getId().equals(id)) {
                listClientes.set(i, clienteActualizado);
                return true;
            }
        }
        return false;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }


    public boolean agregarMecanico(Mecanico mecanico) {
        if (!verificarMecanico(mecanico.getId())) {
            listMecanicos.add(mecanico);
            return true;
        }
        return false;
    }

    public boolean verificarMecanico(String id) {
        return listMecanicos.stream().anyMatch(m -> m.getId().equals(id));
    }

    public Mecanico obtenerMecanico(String id) {
        return listMecanicos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Mecanico> getListMecanicos() {
        return listMecanicos;
    }

    // ========== MÉTODOS PARA BICICLETAS ==========
    public boolean agregarBicicleta(Bicicleta bicicleta, String idCliente) {
        Cliente cliente = obtenerCliente(idCliente);
        if (cliente != null && !verificarBicicleta(bicicleta.getNumMarco())) {
            listBicicletas.add(bicicleta);
            cliente.getListBicicletas().add(bicicleta);
            return true;
        }
        return false;
    }

    public boolean verificarBicicleta(String serial) {
        return listBicicletas.stream().anyMatch(b -> b.getNumMarco().equals(serial));
    }

    public Bicicleta obtenerBicicleta(String serial) {
        return listBicicletas.stream()
                .filter(b -> b.getNumMarco().equals(serial))
                .findFirst()
                .orElse(null);
    }

    public List<Bicicleta> getBicicletasPorCliente(String idCliente) {
        Cliente cliente = obtenerCliente(idCliente);
        return cliente != null ? cliente.getListBicicletas() : new ArrayList<>();
    }

    public List<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }


    public boolean agregarServicio(Servicio servicio) {
        listServicios.add(servicio);
        servicio.getBicicleta().getListServicios().add(servicio);
        servicio.getMecanico().getListServicios().add(servicio);
        servicio.getCliente().getListServicios().add(servicio);
        return true;
    }

    public List<Servicio> obtenerServiciosPorBicicleta(String serial) {
        return listServicios.stream()
                .filter(s -> s.getBicicleta().getNumMarco().equals(serial))
                .collect(Collectors.toList());
    }

    public List<Servicio> obtenerServiciosPorFecha(java.time.LocalDate fecha) {
        return listServicios.stream()
                .filter(s -> s.getFechaIngreso() != null && s.getFechaIngreso().equals(fecha))
                .collect(Collectors.toList());
    }
    // En Taller.java, agrega estos métodos:

    public boolean eliminarMecanico(String id) {
        return listMecanicos.removeIf(m -> m.getId().equals(id));
    }

    public boolean actualizarMecanico(String id, Mecanico mecanicoActualizado) {
        for (int i = 0; i < listMecanicos.size(); i++) {
            if (listMecanicos.get(i).getId().equals(id)) {
                listMecanicos.set(i, mecanicoActualizado);
                return true;
            }
        }
        return false;
    }

    public List<Servicio> getListServicios() {
        return listServicios;
    }


    public boolean verificarStockBajo() {
        return stockRepuestos <= stockMinimo;
    }

    public String getAlertaStock() {
        return verificarStockBajo() ?
                "¡ALERTA! Stock bajo: " + stockRepuestos + " unidades (mínimo " + stockMinimo + ")" :
                "Stock normal: " + stockRepuestos + " unidades";
    }

    public void consumirRepuesto() {
        if (stockRepuestos > 0) stockRepuestos--;
    }

    public int getStockRepuestos() {
        return stockRepuestos;
    }

    public void setStockRepuestos(int stockRepuestos) {
        this.stockRepuestos = stockRepuestos;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}