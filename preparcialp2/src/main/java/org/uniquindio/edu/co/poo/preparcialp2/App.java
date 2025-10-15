package org.uniquindio.edu.co.poo.preparcialp2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/org/uniquindio/edu/co/poo/preparcialp2/MenuMotos.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("🏍️ Sistema de Motos - Menú Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
