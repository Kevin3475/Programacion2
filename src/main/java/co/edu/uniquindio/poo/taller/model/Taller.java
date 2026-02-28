package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase taller
 */
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

    /**
     * Metodo contructor de la clase taller
     * @param nombre
     * @param nit
     * @param telefono
     */
    public Taller(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.listBicicletas = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listMecanicos = new ArrayList<>();
        this.listServicios = new ArrayList<>();
    }

    //Metodos para clientes
    /**
     * Metodo para agregar clientes
     * @param cliente
     * @return
     */
    public boolean agregarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getId())) {
            listClientes.add(cliente);
            return true;
        }
        return false;
    }

    /**
     * Metodo para verificar clientes
     * @param id
     * @return
     */
    public boolean verificarCliente(String id) {
        return listClientes.stream().anyMatch(c -> c.getId().equals(id));
    }

    /**
     * Metodo para llamar a cliente
     * @param id
     * @return
     */
    public Cliente obtenerCliente(String id) {
        return listClientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo para elimiar un cliente
     * @param id
     * @return
     */
    public boolean eliminarCliente(String id) {
        return listClientes.removeIf(c -> c.getId().equals(id));
    }

    /**
     * Metodo para actualizar un cliente
     * @param id
     * @param clienteActualizado
     * @return
     */
    public boolean actualizarCliente(String id, Cliente clienteActualizado) {
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getId().equals(id)) {
                listClientes.set(i, clienteActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para llamar la lista de clientes
     * @return
     */
    public List<Cliente> getListClientes() {
        return listClientes;
    }

    /**
     * Metodo para agregar mecanicos al taller
     * @param mecanico
     * @return
     */
    public boolean agregarMecanico(Mecanico mecanico) {
        if (!verificarMecanico(mecanico.getId())) {
            listMecanicos.add(mecanico);
            return true;
        }
        return false;
    }

    /**
     * Metodo para verificar mecanicos
     * @param id
     * @return
     */
    public boolean verificarMecanico(String id) {
        return listMecanicos.stream().anyMatch(m -> m.getId().equals(id));
    }

    /**
     * Metodo para llamar mecanico
     * @param id
     * @return
     */
    public Mecanico obtenerMecanico(String id) {
        return listMecanicos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo para llamar la lista de mecanicos
     * @return
     */
    public List<Mecanico> getListMecanicos() {
        return listMecanicos;
    }
    //Metodos de bicicletas
    /**
     * Metodo para agregar bicicletas al taller
     * @param bicicleta
     * @param idCliente
     * @return
     */
    public boolean agregarBicicleta(Bicicleta bicicleta, String idCliente) {
        Cliente cliente = obtenerCliente(idCliente);
        if (cliente != null && !verificarBicicleta(bicicleta.getNumMarco())) {
            listBicicletas.add(bicicleta);
            cliente.getListBicicletas().add(bicicleta);
            return true;
        }
        return false;
    }

    /**
     * Metodo para verificar las bicicletas
     * @param serial
     * @return
     */
    public boolean verificarBicicleta(String serial) {
        return listBicicletas.stream().anyMatch(b -> b.getNumMarco().equals(serial));
    }

    /**
     * Metodo para llamar bicicletas
     * @param serial
     * @return
     */
    public Bicicleta obtenerBicicleta(String serial) {
        return listBicicletas.stream()
                .filter(b -> b.getNumMarco().equals(serial))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo para agregar las bicicletas a los clientes
     * @param idCliente
     * @return
     */
    public List<Bicicleta> getBicicletasPorCliente(String idCliente) {
        Cliente cliente = obtenerCliente(idCliente);
        return cliente != null ? cliente.getListBicicletas() : new ArrayList<>();
    }

    /**
     * Metodo para llamar la lista de bicicletas
     * @return
     */
    public List<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    /**
     * Metodo para agregar servicios
     * @param servicio
     * @return
     */
    public boolean agregarServicio(Servicio servicio) {
        listServicios.add(servicio);
        servicio.getBicicleta().getListServicios().add(servicio);
        servicio.getMecanico().getListServicios().add(servicio);
        servicio.getCliente().getListServicios().add(servicio);
        return true;
    }

    /**
     * Metodo para llamar los servicos que tiene cada bicicleta
     * @param serial
     * @return
     */
    public List<Servicio> obtenerServiciosPorBicicleta(String serial) {
        return listServicios.stream()
                .filter(s -> s.getBicicleta().getNumMarco().equals(serial))
                .collect(Collectors.toList());
    }

    /**
     * Metodo para obtener todos los servicios en una fecha especifica
     * @param fecha
     * @return
     */
    public List<Servicio> obtenerServiciosPorFecha(java.time.LocalDate fecha) {
        return listServicios.stream()
                .filter(s -> s.getFechaIngreso() != null && s.getFechaIngreso().equals(fecha))
                .collect(Collectors.toList());
    }

    /**
     * Metodo para eliminar mecanicos
     * @param id
     * @return
     */
    public boolean eliminarMecanico(String id) {
        return listMecanicos.removeIf(m -> m.getId().equals(id));
    }

    /**
     * Metodo para actualizar mecanicos
     * @param id
     * @param mecanicoActualizado
     * @return
     */
    public boolean actualizarMecanico(String id, Mecanico mecanicoActualizado) {
        for (int i = 0; i < listMecanicos.size(); i++) {
            if (listMecanicos.get(i).getId().equals(id)) {
                listMecanicos.set(i, mecanicoActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para llamar la lista de servicios
     * @return
     */
    public List<Servicio> getListServicios() {
        return listServicios;
    }

    /**
     * Metodo para verificar el stockBajo
     * @return
     */
    public boolean verificarStockBajo() {
        return stockRepuestos <= stockMinimo;
    }

    /**
     * Metodo para generar una alerta por stockBajo
     * @return
     */
    public String getAlertaStock() {
        return verificarStockBajo() ?
                "¡ALERTA! Stock bajo: " + stockRepuestos + " unidades (mínimo " + stockMinimo + ")" :
                "Stock normal: " + stockRepuestos + " unidades";
    }

    /**
     * Metodo para consumir repuestos
     */
    public void consumirRepuesto() {
        if (stockRepuestos > 0) stockRepuestos--;
    }

    /**
     * Metodo para llamar stockRepuestos
     * @return
     */
    public int getStockRepuestos() {
        return stockRepuestos;
    }

    /**
     * Metodo para actualizar stockRepuestos
     * @param stockRepuestos
     */
    public void setStockRepuestos(int stockRepuestos) {
        this.stockRepuestos = stockRepuestos;
    }

    /**
     * Metodo para llamar nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para actualizar nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para llamar nit
     * @return
     */
    public String getNit() {
        return nit;
    }

    /**
     * Metodo para actualizar nit
     * @param nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Metodo para llamar telefono
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo para actualizar telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para mostra la info de taller
     * @return
     */
    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listBicicletas=" + listBicicletas +
                ", listClientes=" + listClientes +
                ", listMecanicos=" + listMecanicos +
                ", listServicios=" + listServicios +
                ", stockRepuestos=" + stockRepuestos +
                ", stockMinimo=" + stockMinimo +
                '}';
    }
}