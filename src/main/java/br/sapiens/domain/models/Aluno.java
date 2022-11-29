package br.sapiens.domain.models;

import br.sapiens.domain.enums.CursosEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private CursosEnum curso;
    private List<Matricula> matricula;

    public Aluno(Integer id, String nome, Date dataNascimento, CursosEnum curso) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public CursosEnum getCurso() {
        return curso;
    }

    public void setCurso(CursosEnum curso) {
        this.curso = curso;
    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
    }

}
