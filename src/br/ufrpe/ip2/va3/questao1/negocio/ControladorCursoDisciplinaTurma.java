package br.ufrpe.ip2.va3.questao1.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import br.ufrpe.ip2.va3.questao1.dados.RepositorioGenerico;
import br.ufrpe.ip2.va3.questao1.enums.DiasDaSemana;
import br.ufrpe.ip2.va3.questao1.exceptions.AlunoJaMatriculadoNaTurmaException;
import br.ufrpe.ip2.va3.questao1.models.Aluno;
import br.ufrpe.ip2.va3.questao1.models.Curso;
import br.ufrpe.ip2.va3.questao1.models.Disciplina;
import br.ufrpe.ip2.va3.questao1.models.Professor;
import br.ufrpe.ip2.va3.questao1.models.Turma;

public class ControladorCursoDisciplinaTurma {
    
    private RepositorioGenerico<Curso> repositorioCurso;
    private RepositorioGenerico<Disciplina> repositorioDisciplina;
    private RepositorioGenerico<Turma> repositorioTurma;
    
    private static ControladorCursoDisciplinaTurma instance;

    private ControladorCursoDisciplinaTurma() {
        this.repositorioCurso = new RepositorioGenerico<>("cursos.dat");
        this.repositorioDisciplina = new RepositorioGenerico<>("disciplinas.dat");
        this.repositorioTurma = new RepositorioGenerico<>("turmas.dat");
    }
    
    public static ControladorCursoDisciplinaTurma getInstance() {
        if (instance == null) {
            instance = new ControladorCursoDisciplinaTurma();
        }
        return instance;
    }

    public void abrirTurmaAnoCorrente(Professor p, Disciplina d, int semestre) throws Exception {
        // TODO (25pts) Abrir uma turma da discilina, professor e semestre informados como parâmetro
        // Instanciar uma Turma com base na disciplina, professor e semestre informados. 
        // Usar nessa instância o ano corrente no momento da execução do método.
        // Usar dias da semana e horários à sua escolha.
        // OBS: Uma nova turma não poderá ser aberta se já houver três outras turmas 
        // no mesmo ano/semestre para a disciplina informada como parâmetro. 
        // Se necessário, implemente métodos equals nas classes básicas (models)
        // Para consultar outras turmas, use o repositorioTurma desta classe
        int contadorTurmas = 0;
        while(contadorTurmas <= 3) {
            for (Turma turma : repositorioTurma.listar()) {
                if(turma.getAno() == LocalDate.now().getYear() || turma.getSemestre() == (((int)LocalDate.now().getMonthValue()/6) + 1)) {
                    contadorTurmas += 1;
                }
            }
        }
        if(contadorTurmas < 3) {
            List<DiasDaSemana> diasDaSemana = List.of(DiasDaSemana.SEGUNDA, DiasDaSemana.QUARTA);
            List<LocalTime> horarios = List.of(LocalTime.now(), LocalTime.now().minusHours(3));
            Turma novaTurma = new Turma(LocalDate.now().getYear(), semestre, diasDaSemana, horarios, d, Collections.emptySet(), p);
            repositorioTurma.inserir(novaTurma);
        }
    }
    
    public List<Turma> buscarTurmasComPoucosAlunos() {
        // TODO (25pts) Implementar método para filtrar turmas com menos da metade da capacidade máxima de alunos
        // - Considere que turmas já foram criadas e já tiveram alunos matriculados
        // - As turmas são acessíveis através do respositorioTurma
        // - Use a constante CAPACIDADE_MAXIMA da classe Turma
        List<Turma> result = List.of();
        for (Turma turma : repositorioTurma.listar()) {
            if(turma.getAlunos().size() < Turma.CAPACIDADE_MAXIMA/2) {
                result.add(turma);
            }
        }
        return result;
    }
    
    public List<Curso> buscarCursosComCoordenadorIgualA(Professor coordenador) {
        // TODO (20pts) Implementar método para buscar Cursos cujo coordenador é informado como parâmetro
        // - Considere que cursos já foram criados e armazenados no repositório
        // - Os cursos são acessíveis através do repositorioCursos
        List<Curso> result = List.of();
        for (Curso curso : repositorioCurso.listar()) {
            if(curso.getCoordenador().equals(coordenador)) {
                result.add(curso);
            }
        }
        return result;
    }
    
    public void matricularAlunoEmTurmaDaDisciplina(Aluno aluno, Disciplina disciplina) throws Exception {
        // TODO (40pts) Realizar a matrícula do aluno em alguma turma da disciplina informada
        // Este método deve buscar por turmas que tenham poucos alunos matriculados
        // usando o método 'buscarTurmasComPoucosAlunos' e então ver se há turmas
        // ofertadas com a disciplina entregue como parâmetro e só então realizar
        // a matrícula do aluno. A matrícula será feita simplesmente adicionando 
        // elemento do tipo Aluno na turma encontrada COM MENOR NÚMERO DE ALUNOS
        
        // Há uma situação excepcional se uma matrícula de um dado aluno tentar 
        // ser feita mais de uma vez para uma mesma disciplina. Nesse caso, uma 
        // exceção deverá ser levantada representando tal ocorrência. A assinatura
        // deste método então deve ser alterada para listar a exceção e a classe 
        // que representa a exceção também deverá ser criada

        List<Turma> turmaComPoucosAlunos = this.buscarTurmasComPoucosAlunos();
        for (Turma turma : turmaComPoucosAlunos) {
            if(!turma.getDisciplina().equals(disciplina)) {
                turmaComPoucosAlunos.remove(turma);
            }
        }
        Collections.sort(turmaComPoucosAlunos, (a, b) -> {
            if(a.getAlunos().size() < b.getAlunos().size()) {
                return -1;
            } else {
                return 1;
            }
        });
        if(!turmaComPoucosAlunos.isEmpty()) {
            Turma turmaAMatricular = turmaComPoucosAlunos.get(0);
            Set<Aluno> alunosAtuaisDaTurmaAMatricular = turmaAMatricular.getAlunos();
            if(alunosAtuaisDaTurmaAMatricular.contains(aluno)) {
                throw new AlunoJaMatriculadoNaTurmaException(aluno, turmaAMatricular);
            } else {
                alunosAtuaisDaTurmaAMatricular.add(aluno);
            }
        }
    }
}
