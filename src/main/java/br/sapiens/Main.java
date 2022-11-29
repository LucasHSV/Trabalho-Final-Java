package br.sapiens;

import br.sapiens.configs.CriaEntidades;
import br.sapiens.configs.SingletonConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/layout/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Index");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = new SingletonConnection().getConn();
        new CriaEntidades().CriarTabelas(conn);
        launch();
    }

}