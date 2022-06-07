package br.ufrpe.ip2.va3.questao1.models;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import br.ufrpe.ip2.va3.questao1.enums.DiasDaSemana;

public class Turma {
    public static final int CAPACIDADE_MAXIMA = 60;
    private int ano;
    private int semestre;

    // TODO (10pts) Crie uma enumeração para representar melhor os dias da semana
    private List<DiasDaSemana> diasDaSemana;
    private List<LocalTime> horarios;
    private Disciplina disciplina;
    private Set<Aluno> alunos;
    private Professor professorResponsavel;


    public Turma(int ano, int semestre, List<DiasDaSemana> diasDaSemana, List<LocalTime> horarios, Disciplina disciplina, Set<Aluno> alunos, Professor professorResponsavel) {
        this.ano = ano;
        this.semestre = semestre;
        this.diasDaSemana = diasDaSemana;
        this.horarios = horarios;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.professorResponsavel = professorResponsavel;
    }    

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<DiasDaSemana> getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(List<DiasDaSemana> diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public List<LocalTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<LocalTime> horarios) {
        this.horarios = horarios;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Turma) {
            Turma castedTurma = (Turma) obj;
            return this.getSemestre() == castedTurma.getSemestre() && this.getDisciplina().equals(castedTurma.getDisciplina());
        } else {
            return false;
        }
    }

}
