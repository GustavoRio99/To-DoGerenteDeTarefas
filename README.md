Documentação do Projeto: Gerenciador de Tarefas (GT TODO MASTER)
1. Visão Geral do Projeto
Este é um projeto de um Gerenciador de Tarefas (To-Do List) de linha de comando, desenvolvido em Java. Ele permite ao usuário criar, visualizar, editar, marcar como concluídas e remover tarefas de forma interativa através do console.

O objetivo principal do projeto é aplicar os conceitos fundamentais da programação orientada a objetos (POO) e boas práticas de desenvolvimento de software em um ambiente prático e funcional.

2. Arquitetura do Código
O sistema foi projetado seguindo o princípio da Separação de Responsabilidades, dividindo o código em três classes distintas, cada uma com um papel bem definido:

a. Tarefa.java (Camada de Modelo)
Responsabilidade: Representar a estrutura de dados de uma única tarefa. É o "molde" ou a "planta" de uma tarefa.

O que ela faz: Armazena os atributos de uma tarefa (descricao, concluido) e fornece métodos para acessar e modificar esses dados (getters e setters).

b. ServicoDeTarefas.java (Camada de Serviço / Lógica de Negócio)
Responsabilidade: Atuar como o "cérebro" da aplicação.

O que ela faz:

Contém e gerencia a lista (ArrayList) de todas as tarefas.

Implementa toda a lógica de negócio: como adicionar, remover, editar e marcar tarefas como concluídas.

Contém a lógica de validação de dados para garantir que as entradas sejam seguras e corretas.

c. GerenciadorDeTarefas.java (Camada de Apresentação / Interface)
Responsabilidade: Servir como o ponto de entrada do programa e a interface com o usuário.

O que ela faz:

Exibe o menu de opções.

Captura a entrada do usuário (as opções do menu).

Delega as ações para a classe ServicoDeTarefas. Ela não sabe como uma tarefa é adicionada, apenas "pede" para o serviço fazer isso.

3. Como Compilar e Executar
Pré-requisitos:

Java Development Kit (JDK) instalado e configurado nas variáveis de ambiente.

Estrutura de Pastas:
O código deve estar organizado da seguinte forma:

pasta_do_projeto/
└── Todo/
    ├── GerenciadorDeTarefas.java
    ├── ServicoDeTarefas.java
    └── Tarefa.java

Passos:

Abra o Terminal: Navegue com o terminal até a pasta_do_projeto (a pasta que contém a pasta Todo).

Compile todos os arquivos: Execute o seguinte comando para compilar todos os arquivos .java de uma só vez.

javac Todo/*.java

Execute o programa: Após a compilação bem-sucedida, execute o programa usando o nome completo da classe principal.

java Todo.GerenciadorDeTarefas

4. Funcionalidades
O sistema oferece as seguintes operações:

Adicionar Tarefa: Cria uma nova tarefa com uma descrição fornecida pelo usuário.

Listar Tarefas: Exibe todas as tarefas existentes, mostrando seu índice e status (concluída [X] ou pendente [ ]).

Marcar como Concluída: Altera o status de uma tarefa pendente para concluída.

Remover Tarefa: Exclui uma tarefa da lista permanentemente.

Editar Tarefa: Permite ao usuário alterar a descrição de uma tarefa existente.

Sair: Encerra o programa.

5. Pontos de Destaque e Boas Práticas Implementadas
Tratamento de Exceções: O sistema utiliza blocos try-catch para capturar InputMismatchException, impedindo que o programa quebre se o usuário digitar texto onde um número é esperado.

Robustez na Entrada de Dados: Foi criado um método auxiliar (lerEntradaNumerica) que centraliza a lógica de validação, garantindo que o programa insista até que o usuário forneça uma entrada numérica válida.

Separação de Responsabilidades: A arquitetura em três camadas torna o código mais organizado, mais fácil de entender, de testar e de dar manutenção no futuro.

Eficiência: A lógica de edição de tarefas foi otimizada para modificar o objeto existente na lista (setDescricao) em vez de recriá-lo, consumindo menos recursos.
