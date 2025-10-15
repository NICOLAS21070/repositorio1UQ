package org.uniquindio.edu.co.poo.preparcialp2.Model;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosMotos {

    private static BaseDatosMotos instancia;
    private final List<Moto> motos;

    private BaseDatosMotos() {
        motos = new ArrayList<>();

        motos.add(new Moto.MotoBuilder()
                .setPlaca("ABC123")
                .setMarca("Yamaha")
                .setModelo("FZ-25")
                .build());

        motos.add(new Moto.MotoBuilder()
                .setPlaca("XYZ789")
                .setMarca("Honda")
                .setModelo("CB190R")
                .build());

        motos.add(new Moto.MotoBuilder()
                .setPlaca("QWE456")
                .setMarca("Suzuki")
                .setModelo("Gixxer")
                .build());
    }

    public static BaseDatosMotos getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosMotos();
        }
        return instancia;
    }

    public void agregarMoto(Moto moto) {
        motos.add(moto);
    }

    public void eliminarMoto(Moto moto) {
        motos.remove(moto);
    }

    public List<Moto> getMotos() {
        return motos; // ✅ devolvemos la lista real
    }
}
