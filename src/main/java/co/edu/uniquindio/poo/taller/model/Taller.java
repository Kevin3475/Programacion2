package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

public class Taller {

    private String nombre;
    private String nit;
    private String telefono;
    private List<Bicicleta> listBicicletas;
    private List<Persona>listPersonas;
    private List<Servicio>listServicios;


    public Taller(String nombre,String nit,String telefono){

        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.listBicicletas = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listServicios = new ArrayList<>();


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    public void setListBicicletas(List<Bicicleta> listBicicletas) {
        this.listBicicletas = listBicicletas;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listBicicletas=" + listBicicletas +
                ", listPersonas=" + listPersonas +
                ", listServicios=" + listServicios +
                '}';
    }
}
