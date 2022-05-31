package br.ufrpe.ip2.va3.questao1.negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.ufrpe.ip2.va3.questao1.dados.RepositorioGenerico;
import br.ufrpe.ip2.va3.questao1.exceptions.AlunoMenorDeIdadeException;
import br.ufrpe.ip2.va3.questao1.models.Aluno;
import br.ufrpe.ip2.va3.questao1.models.Pessoa;

public class ControladorPessoa {
    
    private RepositorioGenerico<Pessoa> repositorioPessoas;
    
    private static ControladorPessoa instance;

    private ControladorPessoa() {
        this.repositorioPessoas = new RepositorioGenerico<>("pessoas.dat");
    }
    
    public static ControladorPessoa getInstance() {
        if (instance == null) {
            instance = new ControladorPessoa();
        }
        return instance;
    }
    
    public void realizarCadastroAluno(Aluno a) throws Exception {
        // TODO (20pts) Cadastrar aluno no repositório de pessoas
        // O aluno só pode ser cadastrado se for maior de idade na data corrente
        // do momento da execução do método. Use o repositorioPessoas para salvar 
        // o objeto Aluno.
        // Se um aluno for menor de idade, uma exceção devera ser criada e levantada
        // neste método. A assinatura do método precisará ser alterada
        if(a.getDataNascimento().plusYears(18).isBefore(LocalDate.now())) {
            this.repositorioPessoas.inserir(a);
        } else {
            throw new AlunoMenorDeIdadeException(a);
        }
    }
    
    public List<Aluno> buscarAlunosComTelefoneIniciandoCom(String ddd) {
        // TODO (20pts) Listar alunos (somente alunos) cujo telefone se iniciam com o ddd informado como parâmetro
        // Observe que você não deve retornar instâncias de professores com este
        // DDD, mas somente alunos. Use o repositorioPessoas para buscar informações.
        List<Aluno> listaDeAlunos = List.of();
        for (Pessoa p : this.repositorioPessoas.listar()) {
            if(p instanceof Aluno) {
                Aluno castedAluno = (Aluno) p;
                listaDeAlunos.add(castedAluno);
            }
        }
        return listaDeAlunos.stream().filter(a -> {
            return a.getTelefone().startsWith(ddd);
        }).collect(Collectors.toList());
    }

}
