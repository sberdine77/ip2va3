package br.ufrpe.ip2.va3.questao1.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private long matricula;
    private Curso curso;

    public Aluno(String nome, String telefone, String endereco,
            LocalDate dataNascimento, long matricula, Curso curso) {
        super(nome, telefone, endereco, dataNascimento);
        this.matricula = matricula;
        this.curso = curso;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Aluno) {
            Aluno castedAluno = (Aluno) obj;
            return this.getDataNascimento().equals(castedAluno.getDataNascimento()) && this.getMatricula() == castedAluno.getMatricula();
        } else {
            return false;
        }
    }
}
