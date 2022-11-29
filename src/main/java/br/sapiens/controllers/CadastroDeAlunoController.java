package br.sapiens.controllers;

import br.sapiens.daos.AlunoDao;
import br.sapiens.domain.enums.CursosEnum;
import br.sapiens.domain.models.Aluno;
import br.sapiens.domain.models.DateParse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CadastroDeAlunoController {

    public Label id;
    AlunoDao alunoDao = new AlunoDao();
    @FXML
    TextField nome;
    @FXML
    ChoiceBox curso;
    @FXML
    DatePicker dataDeNascimento;

    public CadastroDeAlunoController() throws SQLException {
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

        LocalDate localDate = dataDeNascimento.getValue();
        Date date = new DateParse().parse(localDate);
        Aluno result = alunoDao.save(new Aluno(intId, nome.getText(), date, (CursosEnum) curso.getValue()));
        this.id.setText(result.getId().toString());
    }
}
