package org.uniquindio.edu.co.poo.preparcialp2.Model;

public class Moto {
    private String placa;
    private String marca;
    private String modelo;


    Moto(MotoBuilder builder) {
        this.placa = builder.placa;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
    }


    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }


    public void setMarca(String nuevaMarca) {
        this.marca = nuevaMarca;
    }

    public void setModelo(String nuevoModelo) {
        this.modelo = nuevoModelo;
    }

    @Override
    public String toString() {
        return "Moto [Placa=" + placa + ", Marca=" + marca + ", Modelo=" + modelo + "]";
    }


    public static class MotoBuilder {
        private String placa;
        private String marca;
        private String modelo;

        public MotoBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public MotoBuilder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public MotoBuilder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Moto build() {
            return new Moto(this);
        }
    }
}
