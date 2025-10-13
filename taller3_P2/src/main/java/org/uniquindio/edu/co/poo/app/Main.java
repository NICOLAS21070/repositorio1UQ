package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.SistemaDePedidosFacade;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaDePedidosFacade facade = new SistemaDePedidosFacade();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Modificar pedido");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código del pedido: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("Producto: ");
                    String producto = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    facade.registrarPedido(codigo, cliente, producto, cantidad, precio);
                }
                case 2 -> {
                    facade.mostrarPedidos();
                }
                case 3 -> {
                    System.out.print("Código del pedido a modificar: ");
                    String codigoModificar = sc.nextLine();

                    System.out.print("Nuevo cliente: ");
                    String nuevoCliente = sc.nextLine();

                    System.out.print("Nuevo producto: ");
                    String nuevoProducto = sc.nextLine();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();

                    facade.modificarPedido(codigoModificar, nuevoCliente, nuevoProducto, nuevaCantidad, nuevoPrecio);
                }
                case 4 -> {
                    System.out.print("Código del pedido a eliminar: ");
                    String codigoEliminar = sc.nextLine();
                    facade.eliminarPedido(codigoEliminar);
                }

                case 5 -> {
                    facade.mostrarReportes();
                }
                case 6 -> System.out.println(" Saliendo del sistema...");
                default -> System.out.println(" Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
