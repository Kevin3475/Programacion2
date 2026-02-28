package co.edu.uniquindio.poo.taller.model;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta {
    private String marca;
    private String tipo;
    private String color;
    private String numMarco;
    private int anio;
    private String idCliente; // NUEVO CAMPO
    private List<Servicio> listServicios;

    public Bicicleta(String marca, String tipo, String color, String numMarco, int anio, String idCliente) {
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.numMarco = numMarco;
        this.anio = anio;
        this.idCliente = idCliente; // NUEVO
        this.listServicios = new ArrayList<>();
    }

    // Getters y setters...
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getNumMarco() { return numMarco; }
    public void setNumMarco(String numMarco) { this.numMarco = numMarco; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getIdCliente() { return idCliente; } // NUEVO GETTER
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; } // NUEVO SETTER

    public List<Servicio> getListServicios() { return listServicios; }
    public void setListServicios(List<Servicio> listServicios) { this.listServicios = listServicios; }
}