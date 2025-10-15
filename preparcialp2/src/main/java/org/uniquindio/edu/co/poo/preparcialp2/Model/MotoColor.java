package org.uniquindio.edu.co.poo.preparcialp2.Model;

public class MotoColor extends Moto {

    private String color;

    // Constructor que toma una moto base y le agrega color
    public MotoColor(Moto motoBase, String color) {
        super(new Moto.MotoBuilder()
                .setPlaca(motoBase.getPlaca())
                .setMarca(motoBase.getMarca())
                .setModelo(motoBase.getModelo()));
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Color=" + color;
    }
}
