package br.sapiens.controllers;

import br.sapiens.Main;
import br.sapiens.daos.AlunoDao;
import br.sapiens.domain.enums.CursosEnum;
import br.sapiens.domain.models.Aluno;
import br.sapiens.domain.models.DateParse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class ListagemDeAlunosController {
    AlunoDao alunoDao = new AlunoDao();
    @FXML
    TableView table;

    public ListagemDeAlunosController() throws SQLException {
    }

    @FXML
    public void initialize() throws IOException, SQLException {
            TableColumn<Aluno, String> idColumn = new TableColumn("Id");
            idColumn.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Aluno, String> nomeColumn = new TableColumn("Nome");
            nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
            TableColumn<Aluno, String> dataColumn = new TableColumn("Data");
            dataColumn.setCellValueFactory(new PropertyValueFactory("dataNascimento"));
            TableColumn<Aluno, String> cursoColumn = new TableColumn("Curso");
            cursoColumn.setCellValueFactory(new PropertyValueFactory("curso"));
            table.getColumns().addAll(List.of(idColumn, nomeColumn, dataColumn, cursoColumn));
            table.getItems().addAll(alunoDao.findAll());
    }
}