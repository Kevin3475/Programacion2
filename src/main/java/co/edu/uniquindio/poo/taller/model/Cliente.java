package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente
 */
public class Cliente extends Persona {
    private String telefono;
    private String direccion;
    private List<Servicio> listServicios;
    private List<Bicicleta> listBicicletas;

    /**
     * Metodo contructor de la clase cliente
     * @param nombre
     * @param id
     * @param telefono
     * @param direccion
     */
    public Cliente(String nombre, String id, String telefono, String direccion) {
        super(nombre, id);
        this.telefono = telefono;
        this.direccion = direccion;
        this.listServicios = new ArrayList<>();
        this.listBicicletas = new ArrayList<>();
    }

    /**
     * Metodo para llamar telefono
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo para actualizar el telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para llamar a direccion
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para actualizar direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo para llamar la lista de servicios
     * @return
     */
    public List<Servicio> getListServicios() {
        return listServicios;
    }

    /**
     * Metodo para actualizar la lista de servicios
     * @param listServicios
     */
    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    /**
     * Metodo para llamar la lista de bicicletas
     * @return
     */
    public List<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    /**
     * Metodo para actualizar la lista de bicicletas
     * @param listBicicletas
     */
    public void setListBicicletas(List<Bicicleta> listBicicletas) {
        this.listBicicletas = listBicicletas;
    }

    /**
     * Metodo para mostrar la info de cliente
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listServicios=" + listServicios +
                ", listBicicletas=" + listBicicletas +
                '}';
    }
}