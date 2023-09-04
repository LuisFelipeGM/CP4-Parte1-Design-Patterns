package br.com.fiap.observer;

import br.com.fiap.model.AlunoModel;
import br.com.fiap.model.LivroModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {

    private static Biblioteca instance;

    private List<LivroModel> livros = new ArrayList<>();;

    private List<BibliotecaObserver> observers = new ArrayList<>();


    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    public void addObserver(BibliotecaObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(BibliotecaObserver observer) {
        this.observers.remove(observer);
    }

    public void adicionarLivro(LivroModel livro) {
        livros.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' adicionado à biblioteca.");
        notifyObservers("Novo Livro: " + livro.getTitulo() + " chegou na Biblioteca! Confira já!");
    }

    public List<LivroModel> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public void emprestarLivro(LivroModel livro, AlunoModel aluno) {
        if (livro.getQuantidadeDisponivel() > 0) {
            livro.emprestar(aluno);
            System.out.println("Livro '" + livro.getTitulo() + "' emprestado para " + aluno.getNome());
        } else {
            System.out.println("Não há cópias disponíveis deste livro para empréstimo! Faça uma reserva!");
        }
    }

    public void devolverLivro(LivroModel livro, AlunoModel aluno) {
        livro.devolver(aluno);
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido por " + aluno.getNome());
        notifyObservers("O Livro: " + livro.getTitulo() + " está de volta na biblioteca!");

    }


    private void notifyObservers(String mensagem) {
        observers.forEach(o -> o.update(mensagem));
    }



}
