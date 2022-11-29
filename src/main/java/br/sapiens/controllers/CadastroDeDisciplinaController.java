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

public class CadastroDeDisciplinaController {

    public Label id;
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    @FXML
    TextField descricao;
    @FXML
    ChoiceBox curso;

    public CadastroDeDisciplinaController() throws SQLException{
    }

    @FXML
    public void initialize() throws IOException, SQLException {
            ObservableList<CursosEnum> list = FXCollections.observableArrayList();
            list.addAll(CursosEnum.values());
            curso.setItems(list);
    }

    public void salvar() throws SQLException {
        String id = this.id.getText();
        Integer intId = null;
        if(!id.isEmpty()){
            intId = Integer.valueOf(id);
        }

        Disciplina retorno = disciplinaDao.save(new Disciplina(intId, descricao.getText(), (CursosEnum) curso.getValue()));
        this.id.setText(retorno.getId().toString());
    }
}
