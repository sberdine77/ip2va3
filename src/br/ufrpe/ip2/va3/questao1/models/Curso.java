package br.ufrpe.ip2.va3.questao1.models;

public class Curso {
    private long codigo;
    private String descricao;
    private Professor coordenador;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Curso) {
            Curso castedCurso = (Curso) obj;
            return this.getCodigo() == castedCurso.getCodigo();
        } else {
            return false;
        }
    }
}
