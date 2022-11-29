package br.sapiens.domain.enums;

public enum CursosEnum {
    SI("SISTEMAS DE INFORMAÇÃO"), ENGENHARIA("ENGENHARIA DA COMPUTAÇÃO"), JOGOS("JOGOS DIGITAIS"), REDES("REDES DE COMPUTADORES");

    private String descricao;

    CursosEnum(String descricao){
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
