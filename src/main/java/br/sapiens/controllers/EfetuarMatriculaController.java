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

public class EfetuarMatriculaController {

    MatriculaDao matriculaDao= new MatriculaDao();
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    AlunoDao alunoDao = new AlunoDao();
    @FXML
    ChoiceBox<String> aluno;
    @FXML
    ChoiceBox<String> disciplina;
    @FXML
    ChoiceBox<PeriodoEnum> periodo;

    public EfetuarMatriculaController() throws SQLException {
    }

    @FXML
    public void initialize() throws IOException, SQLException {
        if(periodo != null){
            ObservableList<PeriodoEnum> periodos = FXCollections.observableArrayList();
            periodos.addAll(PeriodoEnum.values());
            periodo.setItems(periodos);
        }
        if (aluno != null) {
            ObservableList<String> alunos = FXCollections.observableArrayList();
            List<Aluno> listaAlunos = alunoDao.findAll();
            listaAlunos.forEach((aluno) -> {
                String s = aluno.getId() + " = " + aluno.getNome();
                alunos.add(s);
            });
            aluno.setItems(alunos);
        }
        if (disciplina != null) {
            ObservableList<String> disciplinas = FXCollections.observableArrayList();
            List<Disciplina> listaDisciplinas = disciplinaDao.findAll();
            listaDisciplinas.forEach((disciplina) -> {
                String s = disciplina.getId() + " = " + disciplina.getDescricao();
                disciplinas.add(s);
            });
            disciplina.setItems(disciplinas);
        }
    }

    public void salvar() throws SQLException {
        String[] alunoMatricula = aluno.getValue().split(" = ");
        String[] disciplinaMatricula = disciplina.getValue().split(" = ");
        PeriodoEnum periodoMatricula = periodo.getValue();

        int alunoId = Integer.parseInt(alunoMatricula[0]);

        int disciplinaId = Integer.parseInt(disciplinaMatricula[0]);

        Matricula result = new Matricula(disciplinaId, alunoId, periodoMatricula);

        matriculaDao.save(result);
    }
}
