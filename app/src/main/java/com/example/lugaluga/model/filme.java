package com.example.lugaluga.model;

public class filme {
    private String nome;
    private String ano;
    private String genero;

    public filme(){

    }
    public filme(String nome, String ano, String genero){
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
