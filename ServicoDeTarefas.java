package Todo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ServicoDeTarefas {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Scanner scanner) {
        System.out.print("Descrição da Tarefa: ");
        String descricao = scanner.nextLine();
        if (descricao.trim().isEmpty()) {
            System.out.println("[ERRO] A descrição não pode ser vazia.");
            return;
        }
        this.tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso!");
    }


    public void listarTarefas() {
        System.out.println("\n--- Lista de Tarefas ---");
        if (this.tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            for (int i = 0; i < this.tarefas.size(); i++) {
                System.out.println(i + ". " + this.tarefas.get(i));
            }
        }
        System.out.println("------------------------");
    }

    public void marcarConcluida(Scanner scanner) {
        this.listarTarefas();
        if (this.tarefas.isEmpty()) return;

        int indice = lerEntradaNumerica(scanner, "Digite o número da tarefa a ser marcada como concluída: ");

        if (indice >= 0 && indice < this.tarefas.size()) {
            this.tarefas.get(indice).setConcluido(true);
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Índice Inválido!");
        }
    }

    public void removerTarefa(Scanner scanner) {
        this.listarTarefas();
        if (this.tarefas.isEmpty()) return;

        int indice = lerEntradaNumerica(scanner, "Digite o número da tarefa a ser Removida: ");

        if (indice >= 0 && indice < this.tarefas.size()) {
            this.tarefas.remove(indice);
            System.out.println("Tarefa Removida com sucesso!");
        } else {
            System.out.println("Índice Inválido!");
        }
    }

    public void editarTarefa(Scanner scanner) {
        this.listarTarefas();
        if (this.tarefas.isEmpty()) return;

        int indice = lerEntradaNumerica(scanner, "Digite o número da tarefa a ser Editada: ");

        if (indice >= 0 && indice < this.tarefas.size()) {
            System.out.print("Digite a nova descrição da tarefa: ");
            String novaDescricao = scanner.nextLine();
            
        
            this.tarefas.get(indice).setDescricao(novaDescricao);
            
            System.out.println("Tarefa editada com sucesso!");
            this.listarTarefas();
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }
    
    /**
     * CORREÇÃO 2: Método auxiliar renomeado e melhorado.
     * Agora ele recebe a mensagem de prompt para exibir ao usuário.
     */
    private int lerEntradaNumerica(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (true) {
            try {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Entrada inválida. Por favor, digite apenas números.");
                scanner.nextLine();
                System.out.print(mensagem);
            }
        }
    }
}
