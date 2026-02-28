package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Mecanico
 */
public class Mecanico extends Persona {
    private String especialidad;
    private String numCertificado;
    private List<Servicio> listServicios;

    /**
     * Metodo para constructor de la clase mecanico
     * @param nombre
     * @param id
     * @param especialidad
     * @param numCertificado
     */
    public Mecanico(String nombre, String id, String especialidad, String numCertificado) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.numCertificado = numCertificado;
        this.listServicios = new ArrayList<>();
    }

    /**
     * Metodo para llamar especialidad
     * @return
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Metodo para actualizar especialidad
     * @param especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Metodo para llamar numCertificado
     * @return
     */
    public String getNumCertificado() {
        return numCertificado;
    }

    /**
     * Metodo para actualizar numCertificado
     * @param numCertificado
     */
    public void setNumCertificado(String numCertificado) {
        this.numCertificado = numCertificado;
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
     * Metodo para mostrar la info de mecanico
     * @return
     */
    @Override
    public String toString() {
        return "Mecanico{" +
                "especialidad='" + especialidad + '\'' +
                ", numCertificado='" + numCertificado + '\'' +
                ", listServicios=" + listServicios +
                '}';
    }
}