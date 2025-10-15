package org.uniquindio.edu.co.poo.preparcialp2.Model;

public class MotoFactory {

    public static Moto crearMoto(String placa, String marca, String modelo) {
        return new Moto.MotoBuilder()
                .setPlaca(placa)
                .setMarca(marca)
                .setModelo(modelo)
                .build();
    }
}
