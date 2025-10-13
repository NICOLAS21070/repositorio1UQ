package org.uniquindio.edu.co.poo.model;


import org.uniquindio.edu.co.poo.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class BaseDatosPedidos {
    private static BaseDatosPedidos instancia;
    private List<Pedido> pedidos;

    private BaseDatosPedidos() {
        pedidos = new ArrayList<>();
        pedidos.add(new Pedido.PedidoBuilder()
                .setCodigo("123")
                .setCliente("Juan")
                .setProducto("Laptop")
                .setCantidad(2)
                .setPrecio(3500.0)
                .build());

        pedidos.add(new Pedido.PedidoBuilder()
                .setCodigo("321")
                .setCliente("Maria")
                .setProducto("Teclado")
                .setCantidad(1)
                .setPrecio(120.0)
                .build());
        pedidos.add(new Pedido.PedidoBuilder()
                .setCodigo("456")
                .setCliente("Martha")
                .setProducto("mouse")
                .setCantidad(8)
                .setPrecio(20.0)
                .build());


    }

    public static BaseDatosPedidos getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosPedidos();
        }
        return instancia;
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }

}

