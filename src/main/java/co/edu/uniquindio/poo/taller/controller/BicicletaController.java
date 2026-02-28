package co.edu.uniquindio.poo.taller.controller;

import co.edu.uniquindio.poo.taller.model.Bicicleta;
import co.edu.uniquindio.poo.taller.model.Taller;
import java.util.List;

public class BicicletaController {
    private Taller taller;

    public BicicletaController(Taller taller) {
        this.taller = taller;
    }

    public boolean crearBicicleta(Bicicleta bicicleta, String idCliente) {
        return taller.agregarBicicleta(bicicleta, idCliente);
    }

    public List<Bicicleta> obtenerListaBicicletas() {
        return taller.getListBicicletas();
    }

    public Bicicleta obtenerBicicleta(String serial) {
        return taller.obtenerBicicleta(serial);
    }

    public List<Bicicleta> obtenerBicicletasPorCliente(String idCliente) {
        return taller.getBicicletasPorCliente(idCliente);
    }
}