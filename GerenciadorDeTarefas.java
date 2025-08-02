package Todo;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas{
    public static void main(String[] args) {
       
       ArrayList<Tarefa> tarefas = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       
       int opcao = -1;
       while(opcao != 0) {

     exibirMenu();
 
     try {
       opcao = scanner.nextInt();
       scanner.nextLine();  

     } catch (java.util.InputMismatchException e) {

        System.out.println("ATENCAO!  Digite apenas numeros");
        scanner.nextLine();
        
        opcao = -1;
     }

     

     switch (opcao) {
         case 1:
             adicionarTarefa(tarefas, scanner);
             break;
         case 2:
            listarTarefa(tarefas);
            break;
         case 3:
            marcarConcluida(tarefas, scanner);   
            break;
         case 4:
            removerTarefa(tarefas, scanner);
            break;

         case 5:
            editarTarefa(tarefas, scanner);
            break;   
         case 0:
            System.out.println("Saindo do Sistema");
            break;           
         default:
             System.out.println("Opcao invalida");
             break;
             
     }


       }
    }

   public static void exibirMenu(){
    System.out.println("\n--- GT TODO MASTER ---");
    System.out.println("1- Adicionar Tarefa ");
    System.out.println("2- Lista Tarefa ");
    System.out.println("3- Marcar como: Concluido ");
    System.out.println("4- Remover Tarefa ");
    System.out.println("5- Editar Tarefa ");
    System.out.println("0- SAIR do Todo");

   }
   public static void adicionarTarefa(ArrayList<Tarefa> tarefas,Scanner scanner){
    System.out.print("Descricao da Tarefa: ");
    String descricao = scanner.nextLine();
    tarefas.add(new Tarefa(descricao));
    System.out.println("Tarefa Adicionada com sucesso");
   }


   public static void listarTarefa(ArrayList<Tarefa> tarefas){
     
    System.out.println("---\n Lista de Tarefas ---");
    if(tarefas.size() == 0){
        System.out.println("Nenhuma Tarefa Existente");
    } else{
        for (int i = 0; i < tarefas.size(); i++){
            System.out.println(i + ". " + tarefas.get(i));
        }
    }
   }
   
   public static void marcarConcluida(ArrayList<Tarefa> tarefas, Scanner scanner){
    listarTarefa(tarefas);
    System.out.print("Digite o numero da tarefas a ser marcada como concluida");
    int indice = scanner.nextInt();
    if (indice >=0 && indice < tarefas.size()){
        tarefas.get(indice).setConcluido(true);
        System.out.println("Tarefa Concluida com Sucesso");
    }else{
        System.out.print("Indice Invalido");
    }
    
   }

   public static void removerTarefa(ArrayList<Tarefa> tarefas, Scanner scanner){
     listarTarefa(tarefas);
     System.out.print("Digite o numero da tarefas a ser Removida.");
     int indice = scanner.nextInt();
     if (indice >= 0 && indice < tarefas.size()){
        tarefas.remove(indice);
        System.out.println(" Tarefa Removida com sucesso");
     }else {
        System.out.println("Indice Invalido");
     }

   }
   
  public static void editarTarefa(ArrayList<Tarefa> tarefas, Scanner scanner){
    listarTarefa(tarefas);
    System.out.print("Digite o numero da tarefas a ser Editada");
    int indice = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Digite a nova tarefa: ");
    String nova_Tarefa = scanner.nextLine();
    
    if (indice >= 0 && indice < tarefas.size()){
        tarefas.remove(indice);
        tarefas.add(indice,new Tarefa(nova_Tarefa));
        System.out.println("Tarefa editada com sucesso");
        listarTarefa(tarefas);
  
    }else{
        System.out.println("Tarefa nao encontrada");
    }
  }

}