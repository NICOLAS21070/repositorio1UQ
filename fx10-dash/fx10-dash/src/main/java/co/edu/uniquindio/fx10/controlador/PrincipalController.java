package co.edu.uniquindio.fx10.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import co.edu.uniquindio.fx10.App;
import co.edu.uniquindio.fx10.modelo.Producto;
import co.edu.uniquindio.fx10.repositorio.ProductoRepository;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class PrincipalController {

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnListaProductos;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private void onVerLista() {

        cargarEnContenido("/co/edu/uniquindio/fx10/vista/Dashboard.fxml");


        /*try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/fx10/vista/Dashboard.fxml")
            );
            Parent dashboard = loader.load();

            Stage stage = (Stage) btnListaProductos.getScene().getWindow();
            stage.setScene(new Scene(dashboard));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "No se pudo cargar el Dashboard:\n" + e.getMessage()).showAndWait();
        }

         */
    }


    @FXML
    private void onCrearProducto() {
        cargarEnContenido("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml");

        /*
        try {
            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml")
            );
            Parent formulario = loader.load();

            // pasar el Stage al controlador del formulario
            FormularioProductoController controller = loader.getController();
            Stage stage = (Stage) btnAgregarProducto.getScene().getWindow();
            controller.setStage(stage);   // <- nuevo método (ver punto 2)

            stage.setScene(new Scene(formulario));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "No se pudo abrir el formulario").showAndWait();
        }

         */
    }

    private void cargarEnContenido(String recursoFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(recursoFxml));
            Parent vista = loader.load();

            // Que la vista ocupé todo el contenedor
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);

            contentPane.getChildren().setAll(vista);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                    "No se pudo cargar la vista:\n" + recursoFxml + "\n" + e.getMessage())
                    .showAndWait();
        }
    }
    @FXML
    private Button btnLimpiar;

    @FXML
    private void onLimpiarPantalla() {
        contentPane.getChildren().clear();

    }


}