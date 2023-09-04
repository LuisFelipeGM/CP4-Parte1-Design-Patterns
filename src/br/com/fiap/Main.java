package br.com.fiap;

import br.com.fiap.model.*;
import br.com.fiap.strategy.*;
import br.com.fiap.observer.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Pegando a Instancia da Biblioteca atraves do SINGLETON
        Biblioteca biblioteca = Biblioteca.getInstance();

        // Criação dos alunos
        AlunoModel aluno1 = new AlunoModel("Luís Felipe", "2TDST", 94051, "Pós-Graduação");
        AlunoModel aluno2 = new AlunoModel("Heitor Borba", "2TDSVJ", 99425, "Graduação");
        AlunoModel aluno3 = new AlunoModel("Pedro Chueiri", "4EST", 98631, "Pós-Graduação");
        AlunoModel aluno4 = new AlunoModel("Diogo Kahn", "6ENGCT", 98647, "Graduação");

        //Add alunos ao Observer
        biblioteca.addObserver(aluno1);
        biblioteca.addObserver(aluno2);


        // Criação dos livros
        LivroModel livro1 = new LivroModel("Manual do Design Patterns", "Richard Helm", "978-65-89999-01-3", 2);
        LivroModel livro2 = new LivroModel("Modelagem de Banco de Dados", "Aiden Crane", "348-96-74189-11-9", 5);
        LivroModel livro3 = new LivroModel("Java explicado até para cavalos", "Cleiton Rasta", "185-69-18436-04-9", 6);
        biblioteca.adicionarLivro(livro1);
        System.out.println("------------------------------------------");
        // Removendo o Aluno 2 como Observer
        biblioteca.removeObserver(aluno2);

        biblioteca.adicionarLivro(livro2);
        System.out.println("------------------------------------------");
        biblioteca.adicionarLivro(livro3);


        // Utilizando o Strategy para definir a prioridade de reserva de livros
        System.out.println("\n");
        ReservaLivroModel reserva1 = new ReservaLivroModel(aluno1, livro3);
        ReservaLivroModel reserva2 = new ReservaLivroModel(aluno2, livro3);
        ReservaLivroModel reserva3 = new ReservaLivroModel(aluno3, livro3);
        ReservaLivroModel reserva4 = new ReservaLivroModel(aluno4, livro3);

        // Adicionando as Reservas
        List<ReservaLivroModel> reservas = new LinkedList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);
        reservas.add(reserva4);

        // Mostrando a ordem de empréstimo do livro por chegada:
        PriorizacaoReservasStrategy estrategiaChegada = new PriorizacaoPorOrdemDeChegada();
        ProcessadorPrioridade processador = new ProcessadorPrioridade(estrategiaChegada);
        processador.processaPriorizacao(reservas);

        System.out.println("----------------------------------------------------");

        // Mostrando a ordem de empréstimo do livro por categoria de aluno:
        PriorizacaoReservasStrategy estrategiaCategoria = new PriorizacaoPorCategoriaAluno();
        processador.setPriorizacaoReservasStrategy(estrategiaCategoria);
        processador.processaPriorizacao(reservas);



    }
}