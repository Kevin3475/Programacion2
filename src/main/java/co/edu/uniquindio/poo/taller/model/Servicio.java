package co.edu.uniquindio.poo.taller.model;

import  java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * cLase servicio
 */
public class Servicio {
    private LocalDate fechaIngreso;
    private LocalDateTime hora;
    private String motivoServicio;
    private String diagnostico;
    private String trabajosRealizados;
    private double costoTotal;
    private Mecanico mecanico;
    private Cliente cliente;
    private Bicicleta bicicleta;
    private TipoServicio tipoServicio;
    private Estado estado;

    /**
     * Metodo contructor de la clase servico
     * @param fechaIngreso
     * @param hora
     * @param motivoServicio
     * @param diagnostico
     * @param trabajosRealizados
     * @param costoTotal
     * @param mecanico
     * @param cliente
     * @param bicicleta
     * @param tipoServicio
     * @param estado
     */
    public Servicio(LocalDate fechaIngreso, LocalDateTime hora, String motivoServicio,
                    String diagnostico, String trabajosRealizados, double costoTotal,
                    Mecanico mecanico, Cliente cliente, Bicicleta bicicleta,
                    TipoServicio tipoServicio, Estado estado) {
        this.fechaIngreso = fechaIngreso;
        this.hora = hora;
        this.motivoServicio = motivoServicio;
        this.diagnostico = diagnostico;
        this.trabajosRealizados = trabajosRealizados;
        this.costoTotal = costoTotal;
        this.mecanico = mecanico;
        this.cliente = cliente;
        this.bicicleta = bicicleta;
        this.tipoServicio = tipoServicio;
        this.estado = estado;
    }

    /**
     * Metodo para llamar fechaIngreso
     * @return
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Metodo para actualizar fechaIngreso
     * @param fechaIngreso
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Metodo para llamar hora
     * @return
     */
    public LocalDateTime getHora() {
        return hora;
    }

    /**
     * }Metodo para actualizar hora
     * @param hora
     */
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    /**
     * Metodo para llamar motivoServicio
     * @return
     */
    public String getMotivoServicio() {
        return motivoServicio;
    }

    /**
     * Metodo para actualizar motivoServico
     * @param motivoServicio
     */
    public void setMotivoServicio(String motivoServicio) {
        this.motivoServicio = motivoServicio;
    }

    /**
     * Metodo para llamar diagnostico
     * @return
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Metodo para actalizar diagnostico
     * @param diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Metodo para llamar trabajoRealizado
     * @return
     */
    public String getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Metodo para actualizar trabajoRealizado
     * @param trabajosRealizados
     */
    public void setTrabajosRealizados(String trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo para llamar el costoTotal
     * @return
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Metodo para actualizar costoTotaL
     * @param costoTotal
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * Metodo para llamar mecanico
     * @return
     */
    public Mecanico getMecanico() {
        return mecanico;
    }

    /**
     * Metodo para actualizar mecanico
     * @param mecanico
     */
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Metodo para llamara cliente
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Metodo para actualizar cliente
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo para llamar bicicleta
     * @return
     */
    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    /**
     * Metodo para actualizar bicicleta
     * @param bicicleta
     */
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    /**
     * Metodo para llamar tipoServicio
     * @return
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Metodo para actualizar tipoServicio
     * @param tipoServicio
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Metodo para llamar estado
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Metodo para actualizar estado
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Metodo para mostrar la info de servicio
     * @return
     */
    @Override
    public String toString() {
        return "Servicio{" +
                "fechaIngreso=" + fechaIngreso +
                ", hora=" + hora +
                ", motivoServicio='" + motivoServicio + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", trabajosRealizados='" + trabajosRealizados + '\'' +
                ", costoTotal=" + costoTotal +
                ", mecanico=" + mecanico +
                ", cliente=" + cliente +
                ", bicicleta=" + bicicleta +
                ", tipoServicio=" + tipoServicio +
                ", estado=" + estado +
                '}';
    }
}