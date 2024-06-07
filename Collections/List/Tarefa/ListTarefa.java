import java.util.ArrayList;
import java.util.List;

public class ListTarefa {

    private List<Tarefa> tarefaList;

    public ListTarefa(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList != null ? tarefaList : new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa t : tarefaList){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTrf(){
        return tarefaList.size();
    }

    public List<String> obterDescricaoTrf(){
        List<String> descricoes = new ArrayList<>();
        for(Tarefa t : tarefaList){
            descricoes.add(t.getDescricao());
        }
        return descricoes;
    }

    public static void main(String[] args) {
        ListTarefa listaDeTarefas = new ListTarefa(null);
        listaDeTarefas.adicionarTarefa("Estudar Java");
        listaDeTarefas.adicionarTarefa("Fazer compras");

        System.out.println("Total de tarefas: " + listaDeTarefas.obterNumeroTotalTrf());

        listaDeTarefas.removerTarefa("Estudar Java");
        System.out.println("Total de tarefas após remoção: " + listaDeTarefas.obterNumeroTotalTrf());

        System.out.println("Descrições das tarefas: " + listaDeTarefas.obterDescricaoTrf());
    }
}

