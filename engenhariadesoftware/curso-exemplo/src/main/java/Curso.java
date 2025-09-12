import java.util.List;
import java.util.LinkedList;

public class Curso {
    private List<Aluno> alunos = new LinkedList<>();
    private List<Professor> professors = new LinkedList<>();

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    public void addProf(Professor prof) {
        professors.add(prof);
    }
}