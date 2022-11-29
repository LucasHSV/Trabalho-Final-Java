package br.sapiens.controllers;

import br.sapiens.daos.AlunoDao;
import br.sapiens.daos.DisciplinaDao;
import br.sapiens.daos.MatriculaDao;
import br.sapiens.domain.enums.PeriodoEnum;
import br.sapiens.domain.models.Aluno;
import br.sapiens.domain.models.Disciplina;
import br.sapiens.domain.models.Matricula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ListagemDeMatriculasController {

    MatriculaDao matriculaDao = new MatriculaDao();
    @FXML
    TableView table;

    public ListagemDeMatriculasController() throws SQLException {
    }

    @FXML
    public void initialize() throws IOException, SQLException {

        if (table != null) {
            TableColumn<Matricula, String> alunoColumn = new TableColumn("Aluno");
            alunoColumn.setCellValueFactory(new PropertyValueFactory("alunoId"));
            TableColumn<Matricula, String> disciplinaColumn = new TableColumn("Disciplina");
            disciplinaColumn.setCellValueFactory(new PropertyValueFactory("disciplinaId"));
            TableColumn<Matricula, String> periodoColumn = new TableColumn("Periodo");
            periodoColumn.setCellValueFactory(new PropertyValueFactory("periodo"));
            table.getColumns().addAll(List.of(alunoColumn, disciplinaColumn, periodoColumn));
            table.getItems().addAll(matriculaDao.findAll());
        }
    }
}