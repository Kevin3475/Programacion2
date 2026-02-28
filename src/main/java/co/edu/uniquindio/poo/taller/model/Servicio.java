package co.edu.uniquindio.poo.taller.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDateTime getHora() { return hora; }
    public void setHora(LocalDateTime hora) { this.hora = hora; }

    public String getMotivoServicio() { return motivoServicio; }
    public void setMotivoServicio(String motivoServicio) { this.motivoServicio = motivoServicio; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTrabajosRealizados() { return trabajosRealizados; }
    public void setTrabajosRealizados(String trabajosRealizados) { this.trabajosRealizados = trabajosRealizados; }

    public double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }

    public Mecanico getMecanico() { return mecanico; }
    public void setMecanico(Mecanico mecanico) { this.mecanico = mecanico; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Bicicleta getBicicleta() { return bicicleta; }
    public void setBicicleta(Bicicleta bicicleta) { this.bicicleta = bicicleta; }

    public TipoServicio getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(TipoServicio tipoServicio) { this.tipoServicio = tipoServicio; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}