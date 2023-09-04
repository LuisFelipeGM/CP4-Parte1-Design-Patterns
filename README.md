# Design-Patterns-Ex
Exercicio sobre Design Patterns na aula de Digital Business Enablement no dia 04/09/2023



# Exercicio Proposto

Uma biblioteca universitária deseja modernizar seu sistema de gerenciamento. O novo sistema deve permitir o registro de livros, o empréstimo de livros aos alunos e a devolução dos mesmos.

### Requisitos:

1.Registro de Livros: A biblioteca deve ser capaz de adicionar novos livros ao sistema, cada um com um título, autor, ISBN e quantidade disponível.

2.Empréstimo de Livros: Os alunos podem pegar livros emprestados. Cada livro só pode ser emprestado a um aluno por vez.

3.Devolução de Livros: Após o empréstimo, os alunos devem devolver os livros.

<br>

# Sugestão de implementação

1.Crie um design pattern comportamental que permita que as tarefas notifiquem automaticamente os observadores quando seu status mudar.

2.Implemente outro design pattern comportamental para permitir que diferentes estratégias de priorização de tarefas sejam escolhidas em tempo de execução

3.Utilize um design pattern criacional para garantir que apenas uma única instância do sistema de gerenciamento de tarefas seja criada

~~4.Utilize um design pattern estrutural para permitir que as tarefas sejam compostas em uma estrutura de árvore , onde uma tarefa pode conter outras tarefas~~

<br>

# Design Patterns

## Singleton

O Singleton é um padrão de projeto que garante a existência de apenas uma instância de uma classe e fornece um ponto de acesso global a essa instância. Foi utilizada na classe da biblioteca <br> **PACOTE:**  *br.com.fiap.observer.Biblioteca.java*
<br>

Dessa forma garantimos que apenas 1 instancia da classe Biblioteca seja criada durante toda a execução do sistema
![Implementação do Singleton](./images/01%20-%20Singleton%201.png)

<br>

Ele evita que várias instâncias sejam criadas acidentalmente e ajuda a manter a consistência dos dados compartilhados.

![Instanciando a Classe](./images/02%20-%20Singleton%202.png)


## Observer
O Observer é um padrão de projeto comportamental que define uma relação entre objetos, de modo que quando um objeto sofre uma alteração em seu estado interno, todos os seus observadores sejam notificados e atualizados automaticamente. <br> **PACOTE:**  *br.com.fiap.observer*
<br>

Criamos uma interface que define um método update que é chamado pelo sujeito quando ocorrem mudanças relevantes.

![Interface](./images/03%20-%20Observer%201.png)

<br>

Os métodos addObserver e removeObserver servem para adicionar objetos que são filhas da interface que criamos anteriormente, e através do método notifyObservers toda vez que ocorrer qualquer mudança de estado na biblioteca como por exemplo o evento adicionarLivro todos os observadores serão notificados
![Classe Biblioteca](./images/04%20-%20Observer%202.png)

<br>

Na classe Aluno (que está implementando a interface BibliotecaObserver), sobreescrevemos o método para recebermos a mensagem que será disparada do Observer

![Classe Aluno](./images/05%20-%20Observer%203.png)

<br>

### Exemplo de execução:
Criamos 4 alunos, mas apenas adicionamos o Aluno1 (Luís) e o Aluno2 (Heitor) no Observer
Logo apenas os dois receberam notificações, mas depois de adicionar o 1° livro o aluno2 decidiu parar de ser notificado logo apenas o aluno1 será notificado!
![Classe Main](./images/06%20-%20Observer%204.png)

![Console](./images/07%20-%20Observer%205.png)


## Strategy
O Strategy é um padrão de projeto comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Ele permite selecionar um algoritmo específico de uma estratégia de negócio em tempo de execução, sem que o cliente (usuário) precise conhecer os detalhes da implementação de cada algoritmo. Permitindo que a alteração do comportamento de um objeto sem alterar sua estrutura. <br> **PACOTE:**  *br.com.fiap.strategy*
<br>

Primeiro criamos uma interface para ser implementada por todas as famílias de algoritmos (lógicas) que o sistema pode ter

![Interface](./images/08%20-%20Strategy%201.png)

<br>

Na classe com a lógica de priorização por ordem de chegada implementamos a interface, e sobrescrevemos o método
![Priorização por Chegada](./images/09%20-%20Strategy%202.png)

<br>

Fazemos o mesmo na classe de priorização por chegada
![Priorização por Categoria](./images/10%20-%20Strategy%203.png)

<br>

Já nessa classe processador será definido a logica que será utilizada (nesse caso a de priorização das reservas) e chamará o método da lógica que deseja ser implementada
![Processador](./images/11%20-%20Strategy%204.png)

<br>

Na classe main realizamos a reserva dos livros, adicionamos na lista e definimos primeiro a estretégia como a priorização por ordem de chegada, depois executamos o processador. Logo enseguida alteramos a estratégia para a priorização por categoria mudando assim a ordem de prioridade de Alunos na reservas dos livros:
![Classe Main](./images/12%20-%20Strategy%205.png)

<br>

A primeira saída é utilizando a estratégia de Ordem de Chegada, e a segunda é utilizando a estratégia de Categoria
![Console](./images/13%20-%20Strategy%206.png)

<br><br>

<img alt="LinkedIn" title="linkedIn" src="./images/linkedin.png" width="20vw" height="20vh"> - <a href="https://www.linkedin.com/in/luisfelipe-gm/">Luís Felipe Garcia Menezes</a>

