package br.sapiens.controllers;

import br.sapiens.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane painel;

    public void initialize() throws IOException {
        var label = new Label("Sapiens");
        painel.setBottom(label);
    }

    public void cadastrarAluno() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/aluno/cadastroDeAluno.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void listarAlunos() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/aluno/listagemDeAlunos.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void cadastrarDisciplina() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/disciplina/cadastroDeDisciplina.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void listarDisciplinas() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/disciplina/listagemDeDisciplinas.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void efetuarMatricula() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/matricula/efetuarMatricula.fxml"));
        painel.setCenter(fxmlLoader.load());
    }

    public void listarMatriculas() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource("/layout/matricula/listagemDeMatriculas.fxml"));
        painel.setCenter(fxmlLoader.load());
    }
}