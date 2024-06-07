import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class AgendaContatos {
  private Set<Contato> contatosSet;

  public AgendaContatos() {
    this.contatosSet = new HashSet<>();
  }

  public void adicionarContato(String nome, int numero) {
    if (contatosSet.add(new Contato(nome, numero))) {
      System.out.println("Contato adicionado com sucesso.");
    } else {
      System.out.println("Contato já existe na agenda.");
    }
  }

  public void exibirContatos() {
    if (contatosSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
    } else {
      contatosSet.forEach(System.out::println);
    }
  }

  public Set<Contato> pesquisarPorNome(String nome) {
    Set<Contato> contatosPorNome = new HashSet<>();
    if (contatosSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
      return contatosPorNome;
    }
    for (Contato c : contatosSet) {
      if (c.getNome().startsWith(nome)) {
        contatosPorNome.add(c);
      }
    }
    return contatosPorNome;
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero) {
    if (contatosSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
      return null;
    }
    for (Contato c : contatosSet) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        c.setNumero(novoNumero);
        System.out.println("Número atualizado com sucesso.");
        return c;
      }
    }
    System.out.println("Contato não encontrado.");
    return null;
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();

    agendaContatos.exibirContatos();

    agendaContatos.adicionarContato("João", 123456789);
    agendaContatos.adicionarContato("Maria", 987654321);
    agendaContatos.adicionarContato("Maria Fernandes", 55555555);
    agendaContatos.adicionarContato("Ana", 88889999);
    agendaContatos.adicionarContato("Fernando", 77778888);
    agendaContatos.adicionarContato("Carolina", 55555555);

    System.out.println("Contatos na agenda:");
    agendaContatos.exibirContatos();

    System.out.println("Pesquisando contatos pelo nome 'Maria':");
    System.out.println(agendaContatos.pesquisarPorNome("Maria"));

    Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina", 44443333);
    System.out.println("Contato atualizado: " + contatoAtualizado);

    System.out.println("Contatos na agenda após atualização:");
    agendaContatos.exibirContatos();
  }
}

class Contato {
  private String nome;
  private int numero;

  public Contato(String nome, int numero) {
    this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
    return "Contato{" + "nome='" + nome + '\'' + ", numero=" + numero + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, numero);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Contato other = (Contato) obj;
    return numero == other.numero && nome.equals(other.nome);
  }
}
