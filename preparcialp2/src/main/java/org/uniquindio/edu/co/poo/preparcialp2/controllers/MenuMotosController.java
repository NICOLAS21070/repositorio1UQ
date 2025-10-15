package org.uniquindio.edu.co.poo.preparcialp2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import org.uniquindio.edu.co.poo.preparcialp2.Model.Moto;
import org.uniquindio.edu.co.poo.preparcialp2.Model.SistemaMotosFacade;

import java.util.List;
import java.util.Optional;

public class MenuMotosController {

    @FXML
    private TextArea txtSalida;

    private final SistemaMotosFacade sistema = new SistemaMotosFacade();

    @FXML
    private void crearMoto() {
        TextInputDialog dialogPlaca = new TextInputDialog();
        dialogPlaca.setHeaderText("Ingrese la placa de la moto:");
        Optional<String> placa = dialogPlaca.showAndWait();
        if (placa.isEmpty()) return;

        TextInputDialog dialogMarca = new TextInputDialog();
        dialogMarca.setHeaderText("Ingrese la marca de la moto:");
        Optional<String> marca = dialogMarca.showAndWait();
        if (marca.isEmpty()) return;

        TextInputDialog dialogModelo = new TextInputDialog();
        dialogModelo.setHeaderText("Ingrese el modelo de la moto:");
        Optional<String> modelo = dialogModelo.showAndWait();
        if (modelo.isEmpty()) return;

        sistema.registrarMoto(placa.get(), marca.get(), modelo.get());
        txtSalida.appendText("✅ Moto registrada correctamente.\n");
    }

    @FXML
    private void mostrarMotos() {
        txtSalida.clear();
        List<Moto> motos = sistema.getMotos();
        if (motos.isEmpty()) {
            txtSalida.appendText("⚠️ No hay motos registradas.\n");
        } else {
            txtSalida.appendText("📋 LISTA DE MOTOS:\n");
            for (Moto m : motos) {
                txtSalida.appendText(" - " + m + "\n");
            }
        }
    }

    @FXML
    private void eliminarMoto() {
        TextInputDialog dialogPlaca = new TextInputDialog();
        dialogPlaca.setHeaderText("Ingrese la placa de la moto a eliminar:");
        Optional<String> placa = dialogPlaca.showAndWait();
        if (placa.isEmpty()) return;

        boolean eliminado = sistema.eliminarMoto(placa.get());
        if (eliminado) {
            txtSalida.appendText("🗑️ Moto eliminada correctamente.\n");
        } else {
            txtSalida.appendText("⚠️ No se encontró una moto con esa placa.\n");
        }
    }

    @FXML
    private void modificarMoto() {
        TextInputDialog dialogPlaca = new TextInputDialog();
        dialogPlaca.setHeaderText("Ingrese la placa de la moto a modificar:");
        Optional<String> placa = dialogPlaca.showAndWait();
        if (placa.isEmpty()) return;

        TextInputDialog dialogMarca = new TextInputDialog();
        dialogMarca.setHeaderText("Ingrese la nueva marca:");
        Optional<String> marca = dialogMarca.showAndWait();
        if (marca.isEmpty()) return;

        TextInputDialog dialogModelo = new TextInputDialog();
        dialogModelo.setHeaderText("Ingrese el nuevo modelo:");
        Optional<String> modelo = dialogModelo.showAndWait();
        if (modelo.isEmpty()) return;

        boolean modificado = sistema.modificarMoto(placa.get(), marca.get(), modelo.get());
        if (modificado) {
            txtSalida.appendText("✏️ Moto modificada correctamente.\n");
        } else {
            txtSalida.appendText("⚠️ No se encontró una moto con esa placa.\n");
        }
    }

    @FXML
    private void decorarMoto() {
        TextInputDialog dialogPlaca = new TextInputDialog();
        dialogPlaca.setHeaderText("Ingrese la placa de la moto a decorar:");
        Optional<String> placa = dialogPlaca.showAndWait();
        if (placa.isEmpty()) return;

        TextInputDialog dialogColor = new TextInputDialog();
        dialogColor.setHeaderText("Ingrese el color de decoración:");
        Optional<String> color = dialogColor.showAndWait();
        if (color.isEmpty()) return;

        sistema.decorarMotoConColor(placa.get(), color.get());
        txtSalida.appendText("🎨 Moto decorada con color: " + color.get() + "\n");
    }
}
