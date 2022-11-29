package br.sapiens.domain.models;

import br.sapiens.domain.enums.CursosEnum;

public class Disciplina {
    private Integer id;
    private String descricao;
    private CursosEnum curso;

    public Disciplina(Integer id, String descricao, CursosEnum curso){
        this.id = id;
        this.descricao = descricao;
        this.curso = curso;
    }

    public CursosEnum getCurso() {
        return curso;
    }
    public void setCurso(CursosEnum curso) {
        this.curso = curso;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
