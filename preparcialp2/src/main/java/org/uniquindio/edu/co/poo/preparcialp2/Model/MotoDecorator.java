package org.uniquindio.edu.co.poo.preparcialp2.Model;

public class MotoDecorator extends Moto {

    protected Moto motoBase;

    public MotoDecorator(Moto motoBase) {
        super(new Moto.MotoBuilder()
                .setPlaca(motoBase.getPlaca())
                .setMarca(motoBase.getMarca())
                .setModelo(motoBase.getModelo()));
        this.motoBase = motoBase;
    }

    @Override
    public String getPlaca() {
        return motoBase.getPlaca();
    }

    @Override
    public String getMarca() {
        return motoBase.getMarca();
    }

    @Override
    public String getModelo() {
        return motoBase.getModelo();
    }

    @Override
    public String toString() {
        return motoBase.toString();
    }
}
