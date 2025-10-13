package org.uniquindio.edu.co.poo.model;


import java.util.ArrayList;
import java.util.List;

public class SistemaDePedidosFacade {

    // metodo para registrar Registrar pedido
    public void registrarPedido(String codigo, String cliente, String producto, int cantidad, double precio) {
        Pedido pedido = new Pedido.PedidoBuilder()
                .setCodigo(codigo)
                .setCliente(cliente)
                .setProducto(producto)
                .setCantidad(cantidad)
                .setPrecio(precio)
                .build();

        BaseDatosPedidos.getInstancia().agregarPedido(pedido);
        System.out.println(" Pedido registrado con éxito.");
    }

    // metodo para Mostrar todos los pedidos
    public void mostrarPedidos() {
        List<Pedido> lista = BaseDatosPedidos.getInstancia().getPedidos();
        if (lista.isEmpty()) {
            System.out.println(" No hay pedidos registrados.");
        } else {
            System.out.println(" Lista de pedidos:");
            for (Pedido p : lista) {
                System.out.println(" - " + p);
            }
        }
    }

    // metodo para bucar un pedido  por código
    private Pedido buscarPorCodigo(String codigo) {
        for (Pedido p : BaseDatosPedidos.getInstancia().getPedidos()) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // metodo para moidificar un pedido Modificar pedido por código
    public void modificarPedido(String codigo, String nuevoCliente, String nuevoProducto, int nuevaCantidad, double nuevoPrecio) {
        Pedido pedido = buscarPorCodigo(codigo);
        if (pedido != null) {
            pedido.setCliente(nuevoCliente);
            pedido.setProducto(nuevoProducto);
            pedido.setCantidad(nuevaCantidad);
            pedido.setPrecio(nuevoPrecio);
            System.out.println(" Pedido modificado correctamente.");
        } else {
            System.out.println("No se encontró un pedido con ese código.");
        }
    }

    // metodo para Eliminar pedido por codigo
    public void eliminarPedido(String codigo) {
        Pedido pedido = buscarPorCodigo(codigo);
        if (pedido != null) {
            BaseDatosPedidos.getInstancia().getPedidos().remove(pedido);
            System.out.println(" Pedido eliminado con éxito.");
        } else {
            System.out.println(" No existe un pedido con ese código.");
        }
    }


    // metodo para generar Reportes
    public void mostrarReportes() {
        List<Pedido> lista = BaseDatosPedidos.getInstancia().getPedidos();

        if (lista.isEmpty()) {
            System.out.println(" No hay pedidos registrados para reportar.");
            return;
        }

        double sumaTotales = 0;
        double maxTotal = 0;
        Pedido pedidoMayor = null;
        List<String> clientesUnicos = new ArrayList<>();

        for (Pedido p : lista) {
            sumaTotales += p.getTotal();

            if (!clientesUnicos.contains(p.toString())) {
                clientesUnicos.add(p.toString());
            }

            if (p.getTotal() > maxTotal) {
                maxTotal = p.getTotal();
                pedidoMayor = p;
            }
        }

        System.out.println("\n Reportes del sistema:");
        System.out.println("Total de pedidos: " + lista.size());
        System.out.println("Suma total de ventas: $" + sumaTotales);

        if (pedidoMayor != null) {
            System.out.println("Pedido con mayor valor: " + pedidoMayor);
        }
    }
}
