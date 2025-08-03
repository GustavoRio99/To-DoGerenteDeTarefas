package Todo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal. Serve como ponto de entrada e interface com o usuário.
 * Sua única responsabilidade é exibir o menu e delegar as ações para a classe de serviço.
 */
public class GerenciadorDeTarefas {

    public static void main(String[] args) {
        
        ServicoDeTarefas servico = new ServicoDeTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("Bem-vindo ao GT TODO MASTER!");

        while (opcao != 0) {
            exibirMenu();
            
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Opção inválida. Por favor, digite apenas números.");
                opcao = -1; // Reseta a opção para o loop continuar.
            } finally {
                scanner.nextLine(); // Limpa o buffer do scanner em qualquer caso.
            }

            
            switch (opcao) {
                case 1: servico.adicionarTarefa(scanner); break;
                case 2: servico.listarTarefas(); break;
                case 3: servico.marcarConcluida(scanner); break;
                case 4: servico.removerTarefa(scanner); break;
                case 5: servico.editarTarefa(scanner); break;
                case 0: System.out.println("Saindo do Sistema... Até logo!"); break;
                default:
                    if (opcao != -1) {
                        System.out.println("Opção inválida! Por favor, tente novamente.");
                    }
                    break;
            }
        }
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n--- GT TODO MASTER ---");
        System.out.println("1- Adicionar Tarefa");
        System.out.println("2- Listar Tarefas");
        System.out.println("3- Marcar como Concluída");
        System.out.println("4- Remover Tarefa");
        System.out.println("5- Editar Tarefa");
        System.out.println("0- SAIR do Todo");
    }
}
