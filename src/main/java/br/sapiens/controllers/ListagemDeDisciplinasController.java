package br.sapiens.controllers;

import br.sapiens.daos.AlunoDao;
import br.sapiens.daos.DisciplinaDao;
import br.sapiens.domain.enums.CursosEnum;
import br.sapiens.domain.enums.CursosEnum;
import br.sapiens.domain.models.Aluno;
import br.sapiens.domain.models.DateParse;
import br.sapiens.domain.models.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ListagemDeDisciplinasController {
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    @FXML
    TableView table;

    public ListagemDeDisciplinasController() throws SQLException {
    }

    @FXML
    public void initialize() throws IOException, SQLException {
        TableColumn<Disciplina, String> idColumn = new TableColumn("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn<Disciplina, String> descricaoColumn = new TableColumn("Descrição");
        descricaoColumn.setCellValueFactory(new PropertyValueFactory("descricao"));
        TableColumn<Disciplina, String> cursoColumn = new TableColumn("Curso");
        cursoColumn.setCellValueFactory(new PropertyValueFactory("curso"));
        table.getColumns().addAll(List.of(idColumn, descricaoColumn, cursoColumn));
        table.getItems().addAll(disciplinaDao.findAll());
    }
}
