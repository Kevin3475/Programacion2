package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biclicleta
 */
public class Bicicleta {
    private String marca;
    private String tipo;
    private String color;
    private String numMarco;
    private int anio;
    private String idCliente; // NUEVO CAMPO
    private List<Servicio> listServicios;

    /**
     * Metodo contructor de la clase Bicicleta
     * @param marca
     * @param tipo
     * @param color
     * @param numMarco
     * @param anio
     * @param idCliente
     */
    public Bicicleta(String marca, String tipo, String color, String numMarco, int anio, String idCliente) {
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.numMarco = numMarco;
        this.anio = anio;
        this.idCliente = idCliente; // NUEVO
        this.listServicios = new ArrayList<>();
    }

    /**
     * Metodo para llamar a marca
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo para actualizar marca
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo para llamar a tipo
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo para actualizar tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para llamar a color
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo para actualizar color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo para llamar numMarco
     * @return
     */
    public String getNumMarco() {
        return numMarco;
    }

    /**
     * Metodo para actualizar numMarco
     * @param numMarco
     */
    public void setNumMarco(String numMarco) {
        this.numMarco = numMarco;
    }

    /**
     * Metodo para llamara a anio
     * @return
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Metodo para actaulizar el anio
     * @param anio
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Metodo para llamar el anio
     * @return
     */
    public String getIdCliente() {
        return idCliente;  // NUEVO GETTER
    }

    /**
     * Metodo para actualizar el IdCliente
     * @param idCliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;  // NUEVO SETTER
    }

    /**
     * Metodo para llamar la lista de servicios
     * @return
     */
    public List<Servicio> getListServicios() {
        return listServicios;
    }

    /**
     * Metodo para actualizar la lista de serviscios
     * @param listServicios
     */
    public void setListServicios(List<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    /**
     * Metodo para mostra la info de bicicleta
     * @return
     */
    @Override
    public String toString() {
        return "Bicicleta{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", numMarco='" + numMarco + '\'' +
                ", anio=" + anio +
                ", idCliente='" + idCliente + '\'' +
                ", listServicios=" + listServicios +
                '}';
    }
}