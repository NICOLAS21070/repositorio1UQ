package org.uniquindio.edu.co.poo.preparcialp2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import org.uniquindio.edu.co.poo.preparcialp2.Model.Moto;
import org.uniquindio.edu.co.poo.preparcialp2.Model.MotoColor;
import org.uniquindio.edu.co.poo.preparcialp2.Model.SistemaMotosFacade;

import java.util.List;
import java.util.Optional;

public class MenuMotosController {

    @FXML
    private TextArea txtSalida;

    private final SistemaMotosFacade sistema = new SistemaMotosFacade();

    @FXML
    private void crearMoto() {
        try {
            TextInputDialog dialogMarca = new TextInputDialog();
            dialogMarca.setTitle("Crear Moto");
            dialogMarca.setHeaderText("Ingrese la marca de la moto:");
            Optional<String> marca = dialogMarca.showAndWait();
            if (marca.isEmpty()) return;

            TextInputDialog dialogModelo = new TextInputDialog();
            dialogModelo.setHeaderText("Ingrese el modelo de la moto:");
            Optional<String> modelo = dialogModelo.showAndWait();
            if (modelo.isEmpty()) return;

            TextInputDialog dialogPrecio = new TextInputDialog();
            dialogPrecio.setHeaderText("Ingrese el precio de la moto:");
            Optional<String> precioStr = dialogPrecio.showAndWait();
            if (precioStr.isEmpty()) return;

            double precio = Double.parseDouble(precioStr.get());
            Moto moto = sistema.crearMoto(marca.get(), modelo.get(), precio);
            sistema.guardarMoto(moto);

            txtSalida.appendText("✅ Moto creada y guardada: " + moto + "\n");

        } catch (Exception e) {
            txtSalida.appendText("⚠️ Error al crear moto: " + e.getMessage() + "\n");
        }
    }

    /**
     * ✅ Mostrar todas las motos
     */
    @FXML
    private void mostrarMotos() {
        List<Moto> motos = sistema.obtenerMotos();
        txtSalida.appendText("\n📋 LISTA DE MOTOS:\n");
        if (motos.isEmpty()) {
            txtSalida.appendText("No hay motos registradas.\n");
        } else {
            for (Moto m : motos) {
                txtSalida.appendText(m + "\n");
            }
        }
    }

    /**
     * ✅ Decorar moto con color (patrón Decorator)
     */
    @FXML
    private void decorarMoto() {
        List<Moto> motos = sistema.obtenerMotos();
        if (motos.isEmpty()) {
            txtSalida.appendText("⚠️ No hay motos para decorar.\n");
            return;
        }

        TextInputDialog dialogIndice = new TextInputDialog();
        dialogIndice.setHeaderText("Ingrese el número de moto a decorar (1-" + motos.size() + "):");
        Optional<String> indiceStr = dialogIndice.showAndWait();
        if (indiceStr.isEmpty()) return;

        int indice;
        try {
            indice = Integer.parseInt(indiceStr.get()) - 1;
        } catch (NumberFormatException e) {
            txtSalida.appendText("⚠️ Ingrese un número válido.\n");
            return;
        }

        if (indice < 0 || indice >= motos.size()) {
            txtSalida.appendText("⚠️ Índice inválido.\n");
            return;
        }

        TextInputDialog dialogColor = new TextInputDialog();
        dialogColor.setHeaderText("Ingrese el color de decoración:");
        Optional<String> color = dialogColor.showAndWait();
        if (color.isEmpty()) return;

        Moto motoSeleccionada = motos.get(indice);
        Moto motoDecorada = new MotoColor(motoSeleccionada, color.get());
        sistema.guardarMoto(motoDecorada);

        txtSalida.appendText("🎨 Moto decorada con color " + color.get() + ": " + motoDecorada + "\n");
    }

    /**
     * ✅ Eliminar moto
     */
    @FXML
    private void eliminarMoto() {
        List<Moto> motos = sistema.obtenerMotos();
        if (motos.isEmpty()) {
            txtSalida.appendText("⚠️ No hay motos para eliminar.\n");
            return;
        }

        TextInputDialog dialogIndice = new TextInputDialog();
        dialogIndice.setHeaderText("Ingrese el número de moto a eliminar (1-" + motos.size() + "):");
        Optional<String> indiceStr = dialogIndice.showAndWait();
        if (indiceStr.isEmpty()) return;

        try {
            int indice = Integer.parseInt(indiceStr.get()) - 1;
            if (indice < 0 || indice >= motos.size()) {
                txtSalida.appendText("⚠️ Índice inválido.\n");
                return;
            }

            Moto moto = motos.get(indice);
            sistema.eliminarMoto(moto);
            txtSalida.appendText("🗑️ Moto eliminada: " + moto + "\n");

        } catch (NumberFormatException e) {
            txtSalida.appendText("⚠️ Debe ingresar un número válido.\n");
        }
    }

    /**
     * ✅ Buscar moto por marca o modelo
     */
    @FXML
    private void buscarMoto() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Ingrese una palabra clave (marca o modelo):");
        Optional<String> filtro = dialog.showAndWait();
        if (filtro.isEmpty()) return;

        List<Moto> motos = sistema.obtenerMotos();
        txtSalida.appendText("\n🔍 Resultados de búsqueda:\n");

        boolean encontrada = false;
        for (Moto m : motos) {
            if (m.getMarca().toLowerCase().contains(filtro.get().toLowerCase()) ||
                    m.getModelo().toLowerCase().contains(filtro.get().toLowerCase())) {
                txtSalida.appendText(m + "\n");
                encontrada = true;
            }
        }

        if (!encontrada) {
            txtSalida.appendText("No se encontraron motos con ese criterio.\n");
        }
    }
}
