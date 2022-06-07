package br.ufrpe.ip2.va3.questao1.models;

import java.time.LocalDate;

public class Professor extends Pessoa {
 
    private String titulacaoMaxima;

    public Professor(String nome, String telefone, String endereco,
            LocalDate dataNascimento, String titulacaoMaxima) {
        super(nome, telefone, endereco, dataNascimento);
        this.titulacaoMaxima = titulacaoMaxima;
    }

    public String getTitulacaoMaxima() {
        return titulacaoMaxima;
    }

    public void setTitulacaoMaxima(String titulacaoMaxima) {
        this.titulacaoMaxima = titulacaoMaxima;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Professor) {
            Professor castedProffessor = (Professor) obj;
            return this.getDataNascimento().equals(castedProffessor.getDataNascimento()) && this.getTelefone().equals(castedProffessor.getTelefone());
        } else {
            return false;
        }
    }
}
