package org.uniquindio.edu.co.poo.model;



public class Pedido {
    private String codigo;
    private String cliente;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;

    private Pedido(PedidoBuilder builder) {
        this.codigo = builder.codigo;
        this.cliente = builder.cliente;
        this.producto = builder.producto;
        this.cantidad = builder.cantidad;
        this.precio = builder.precio;
        this.total = this.cantidad * this.precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        recalcularTotal();
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        recalcularTotal();
    }

    private void recalcularTotal() {
        this.total = this.cantidad * this.precio;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Cliente: " + cliente +
                ", Producto: " + producto +
                ", Cantidad: " + cantidad +
                ", Precio: $" + precio +
                ", Total: $" + total;
    }

    public static class PedidoBuilder {
        private String codigo;
        private String cliente;
        private String producto;
        private int cantidad;
        private double precio;

        public PedidoBuilder setCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public PedidoBuilder setCliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoBuilder setProducto(String producto) {
            this.producto = producto;
            return this;
        }

        public PedidoBuilder setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public PedidoBuilder setPrecio(double precio) {
            this.precio = precio;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }
}
