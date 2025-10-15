package org.uniquindio.edu.co.poo.preparcialp2.Model;


import java.util.ArrayList;
import java.util.List;

public class SistemaMotosFacade {

    private final BaseDatosMotos baseDatos;
    private final MotoFactory factory;

    public SistemaMotosFacade() {
        this.baseDatos = BaseDatosMotos.getInstancia();
        this.factory = new MotoFactory();
    }

    public Moto crearMoto(String marca, String modelo, String precio) {
        return factory.crearMoto(marca, modelo, precio);
    }

    public void guardarMoto(Moto moto) {
        baseDatos.agregarMoto(moto);
    }

    public List<Moto> obtenerMotos() {
        return new ArrayList<>(baseDatos.getMotos());
    }

    public void eliminarMoto(Moto moto) {
        baseDatos.getMotos().remove(moto);
    }

    public Moto buscarPorPlaca(String placa) {
        for (Moto m : baseDatos.getMotos()) {
            if (m.getPlaca().equalsIgnoreCase(placa)) {
                return m;
            }
        }
        return null;
    }

    public void decorarMotoConColor(String placa, String color) {
        Moto moto = buscarPorPlaca(placa);
        if (moto != null) {
            MotoColor motoColor = new MotoColor(moto, color);
            baseDatos.getMotos().remove(moto);
            baseDatos.agregarMoto(motoColor);
        }
    }
}
