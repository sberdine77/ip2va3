package br.ufrpe.ip2.va3.questao1.dados;

import java.util.List;

import br.ufrpe.ip2.va3.questao1.exceptions.ElementoJaExisteException;
import br.ufrpe.ip2.va3.questao1.exceptions.ElementoNaoExisteException;

public interface IRepositorioGenerico<T> {
    
    void inserir(T obj) throws ElementoJaExisteException;
    
    List<T> listar();
    
    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;

}
