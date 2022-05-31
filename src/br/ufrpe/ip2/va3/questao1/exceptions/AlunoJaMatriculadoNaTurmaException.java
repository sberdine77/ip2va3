package br.ufrpe.ip2.va3.questao1.exceptions;

import br.ufrpe.ip2.va3.questao1.models.Aluno;
import br.ufrpe.ip2.va3.questao1.models.Turma;

public class AlunoJaMatriculadoNaTurmaException extends Exception {
    private Aluno aluno;
    private Turma turma;

    public AlunoJaMatriculadoNaTurmaException(Aluno aluno, Turma turma) {
        super("Aluno " + aluno.getNome() + " já matriculado na turma da disciplina " + turma.getDisciplina() + " e professor " + turma.getProfessorResponsavel());
        this.aluno = aluno;
        this.turma = turma;
    }
    
    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
