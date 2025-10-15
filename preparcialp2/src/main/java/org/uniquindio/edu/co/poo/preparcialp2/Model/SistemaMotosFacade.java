package org.uniquindio.edu.co.poo.preparcialp2.Model;

import java.util.List;

public class SistemaMotosFacade {

    public void registrarMoto(String placa, String marca, String modelo) {
        Moto moto = MotoFactory.crearMoto(placa, marca, modelo);
        BaseDatosMotos.getInstancia().agregarMoto(moto);
    }

    public List<Moto> getMotos() {
        return BaseDatosMotos.getInstancia().getMotos();
    }

    public boolean eliminarMoto(String placa) {
        Moto moto = buscarPorPlaca(placa);
        if (moto != null) {
            BaseDatosMotos.getInstancia().eliminarMoto(moto);
            return true;
        }
        return false;
    }

    public boolean modificarMoto(String placa, String nuevaMarca, String nuevoModelo) {
        Moto moto = buscarPorPlaca(placa);
        if (moto != null) {
            moto.setMarca(nuevaMarca);
            moto.setModelo(nuevoModelo);
            return true;
        }
        return false;
    }

    public void decorarMotoConColor(String placa, String color) {
        Moto moto = buscarPorPlaca(placa);
        if (moto != null) {
            MotoColor decorada = new MotoColor(moto, color);
            BaseDatosMotos.getInstancia().eliminarMoto(moto);
            BaseDatosMotos.getInstancia().agregarMoto(decorada);
        }
    }

    private Moto buscarPorPlaca(String placa) {
        for (Moto m : BaseDatosMotos.getInstancia().getMotos()) {
            if (m.getPlaca().equalsIgnoreCase(placa)) {
                return m;
            }
        }
        return null;
    }
}
