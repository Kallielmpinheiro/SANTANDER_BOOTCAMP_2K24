import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class ConjuntoConvidados {
  private Set<Convidado> convidadosSet;

  public ConjuntoConvidados() {
    this.convidadosSet = new HashSet<>();
  }

  public void adicionarConvidado(String nome, int codigoConvite) {
    if (convidadosSet.add(new Convidado(nome, codigoConvite))) {
      System.out.println("Convidado adicionado com sucesso.");
    } else {
      System.out.println("Convidado já existe no conjunto.");
    }
  }

  public void removerConvidadoPorCodigoConvite(int codigoConvite) {
    if (convidadosSet.removeIf(c -> c.getCodigoConvite() == codigoConvite)) {
      System.out.println("Convidado removido com sucesso.");
    } else {
      System.out.println("Convidado não encontrado.");
    }
  }

  public int contarConvidados() {
    return convidadosSet.size();
  }

  public void exibirConvidados() {
    if (convidadosSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
    } else {
      convidadosSet.forEach(System.out::println);
    }
  }

  public static void main(String[] args) {
    ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
    System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

    conjuntoConvidados.adicionarConvidado("Alice", 1234);
    conjuntoConvidados.adicionarConvidado("Bob", 1235);
    conjuntoConvidados.adicionarConvidado("Charlie", 1235);
    conjuntoConvidados.adicionarConvidado("David", 1236);

    System.out.println("Convidados no conjunto:");
    conjuntoConvidados.exibirConvidados();

    System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

    conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
    System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");

    System.out.println("Convidados no conjunto após a remoção:");
    conjuntoConvidados.exibirConvidados();
  }
}

class Convidado {
  private final String nome;
  private final int codigoConvite;

  public Convidado(String nome, int codigoConvite) {
    this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
    this.codigoConvite = codigoConvite;
  }

  public String getNome() {
    return nome;
  }

  public int getCodigoConvite() {
    return codigoConvite;
  }

  @Override
  public String toString() {
    return "Convidado{" + "nome='" + nome + '\'' + ", codigoConvite=" + codigoConvite + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, codigoConvite);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Convidado other = (Convidado) obj;
    return codigoConvite == other.codigoConvite && nome.equals(other.nome);
  }
}
