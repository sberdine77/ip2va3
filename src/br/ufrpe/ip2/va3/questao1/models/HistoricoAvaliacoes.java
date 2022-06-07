package br.ufrpe.ip2.va3.questao1.models;

import java.time.LocalDate;
import java.util.List;

import br.ufrpe.ip2.va3.questao1.dados.RepositorioGenerico;

public class HistoricoAvaliacoes {
    private List<Avaliacao> listaDeAvaliacoes;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Aluno aluno;

    public HistoricoAvaliacoes(RepositorioGenerico<Avaliacao> repositorioDeAvaliacoes, LocalDate dataInicial, LocalDate dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        for (Avaliacao avaliacao : repositorioDeAvaliacoes.listar()) {
            if(avaliacao.getAlunoRealizador().equals(aluno) && avaliacaoEstaDentroDoIntervalo(avaliacao)) {
                this.listaDeAvaliacoes.add(avaliacao);
            }
        }
    }

    private boolean avaliacaoEstaDentroDoIntervalo(Avaliacao avaliacao) {
        int anoAvaliacao = avaliacao.getDataHoraRealizacao().getYear();
        int mesAvaliacao = avaliacao.getDataHoraRealizacao().getMonthValue();
        int diaAvaliacao = avaliacao.getDataHoraRealizacao().getDayOfMonth();

        LocalDate dataAvaliacaoLocalDate = LocalDate.of(anoAvaliacao, mesAvaliacao, diaAvaliacao);

        if(dataAvaliacaoLocalDate.isAfter(dataInicial) && dataAvaliacaoLocalDate.isBefore(dataFinal)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Avaliacao> getListaDeAvaliacoes() {
        return this.listaDeAvaliacoes;
    }

    public void setListaDeAvaliacoes(List<Avaliacao> listaDeAvaliacoes) {
        this.listaDeAvaliacoes = listaDeAvaliacoes;
    }

    public LocalDate getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getAverage() {
        double result = 0;
        for (Avaliacao avaliacao : listaDeAvaliacoes) {
            result += avaliacao.getNota();
        }
        result /= listaDeAvaliacoes.size();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HistoricoAvaliacoes) {
            HistoricoAvaliacoes castedHistoricoAvaliacoes = (HistoricoAvaliacoes) obj;
            return this.getAluno().equals(castedHistoricoAvaliacoes.getAluno()) && this.getAverage() == castedHistoricoAvaliacoes.getAverage();
        } else {
            return false;
        }
    }
}
