package br.sapiens.domain.models;

import br.sapiens.domain.enums.PeriodoEnum;

public class Matricula {
    private Disciplina disciplina;
    private Integer disciplinaId;
    private Aluno aluno;
    private Integer alunoId;
    private PeriodoEnum periodo;

    public Matricula (Integer disciplinaId, Integer alunoId, PeriodoEnum periodo) {
        this.disciplinaId = disciplinaId;
        this.alunoId = alunoId;
        this.periodo = periodo;
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public PeriodoEnum getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEnum periodo) {
        this.periodo = periodo;
    }
}
