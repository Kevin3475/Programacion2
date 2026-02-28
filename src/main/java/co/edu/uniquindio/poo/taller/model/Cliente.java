package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String telefono;
    private String direccion;
    private List<Servicio> listServicios;
    private List<Bicicleta> listBicicletas;

    public Cliente(String nombre, String id, String telefono, String direccion) {
        super(nombre, id);
        this.telefono = telefono;
        this.direccion = direccion;
        this.listServicios = new ArrayList<>();
        this.listBicicletas = new ArrayList<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    public List<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    public void setListBicicletas(List<Bicicleta> listBicicletas) {
        this.listBicicletas = listBicicletas;
    }
}