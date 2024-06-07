import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAlunoPorMatricula(long matricula) {
        Aluno alunoParaRemover = null;
        for (Aluno a : alunosSet) {
            if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
                break;
            }
        }
        if (alunoParaRemover != null) {
            alunosSet.remove(alunoParaRemover);
        } else {
            System.out.println("Matrícula não encontrada!");
        }
    }

    public void exibirAlunosPorNome() {
        if (!alunosSet.isEmpty()) {
            Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
            alunosPorNome.forEach(System.out::println);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirAlunosPorNota() {
        if (!alunosSet.isEmpty()) {
            Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
            alunosPorNota.addAll(alunosSet);
            alunosPorNota.forEach(System.out::println);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        System.out.println("Alunos no gerenciador:");
        gerenciadorAlunos.alunosSet.forEach(System.out::println);

        gerenciadorAlunos.removerAlunoPorMatricula(000L);
        gerenciadorAlunos.removerAlunoPorMatricula(123457L);
        System.out.println("Alunos após remoção:");
        gerenciadorAlunos.alunosSet.forEach(System.out::println);

        System.out.println("Alunos ordenados por nome:");
        gerenciadorAlunos.exibirAlunosPorNome();

        System.out.println("Alunos ordenados por nota:");
        gerenciadorAlunos.exibirAlunosPorNota();
    }
}

class Aluno implements Comparable<Aluno> {
    private String nome;
    private Long matricula;
    private double media;

    public Aluno(String nome, Long matricula, double media) {
        this.nome = nome;
        this.matricula = matricula;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public int compareTo(Aluno outroAluno) {
        return this.nome.compareToIgnoreCase(outroAluno.nome);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", média=" + media +
                '}';
    }
}

class ComparatorNota implements Comparator<Aluno> {
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getMedia(), a2.getMedia());
    }
}
