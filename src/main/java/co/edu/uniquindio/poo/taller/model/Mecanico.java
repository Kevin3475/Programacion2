package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona {

    private String especialidad;
    private String numCertificado;
    private List<Servicio>listServicios;

    public Mecanico (String nombre, String id, String especialidad, String numCertificado){
        super(nombre,id);

        this.especialidad = especialidad;
        this.numCertificado = numCertificado;
        this.listServicios = new ArrayList<>();

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumCertificado() {
        return numCertificado;
    }

    public void setNumCertificado(String numCertificado) {
        this.numCertificado = numCertificado;
    }

    public List<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "especialidad='" + especialidad + '\'' +
                ", numCertificado='" + numCertificado + '\'' +
                ", listServicios=" + listServicios +
                '}';
    }
}
