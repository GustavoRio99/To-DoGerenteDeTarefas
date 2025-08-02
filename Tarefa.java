//Gerente de tarefas
// 1- Adicionar Try cat para que o problema nao pare se caso eu digitar qualquer string aleatorioa


package Todo;

public class Tarefa {
    //Estudo: criando dois atributos Concluido e Descricao.
    private String descricao;
    private boolean concluido;

    //Metodo Tarefa responsavel por receber os parametros descricao e inicia concluido como false.

    public Tarefa(String descricao){
        this.descricao=descricao;
        this.concluido = false;
    }

    //Getters e Setts/

    //pega Descricao 
    public String getDescricao(){
        return descricao;
    }

    public boolean isConcluido(){
        return concluido;
    }

    public void setConcluido(boolean concluido){

        this.concluido = concluido;

    }
    @Override
    public String toString(){

        return (concluido ? "[X]" : "[ ]") + descricao;
    }


}
