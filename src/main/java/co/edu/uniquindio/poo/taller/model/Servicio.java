package co.edu.uniquindio.poo.taller.model;

import java.time.LocalDate;

public class Servicio {

    private String fechaIngreso;
    private LocalDate hora;
    private String motivoServicio;
    private String diagnostico;
    private Mecanico mecanico;
    private Cliente cliente;
    private Bicicleta bicicleta;
    private TipoServicio tipoServicio;
    private Estado estado;

    public Servicio(String fechaIngreso,LocalDate hora,String motivoServicio,String diagnostico,Mecanico mecanico,Cliente cliente,Bicicleta bicicleta,TipoServicio tipoServicio,Estado estado){


        this.fechaIngreso = fechaIngreso;
        this.hora = hora;
        this.motivoServicio = motivoServicio;
        this.diagnostico = diagnostico;
        this.mecanico = mecanico;
        this.cliente = cliente;
        this.bicicleta = bicicleta;
        this.tipoServicio = tipoServicio;
        this.estado = estado;


    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public String getMotivoServicio() {
        return motivoServicio;
    }

    public void setMotivoServicio(String motivoServicio) {
        this.motivoServicio = motivoServicio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", hora=" + hora +
                ", motivoServicio='" + motivoServicio + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", mecanico=" + mecanico +
                ", cliente=" + cliente +
                ", bicicleta=" + bicicleta +
                ", tipoServicio=" + tipoServicio +
                ", estado=" + estado +
                '}';
    }
}
