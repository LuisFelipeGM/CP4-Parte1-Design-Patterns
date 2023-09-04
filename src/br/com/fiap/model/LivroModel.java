package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class LivroModel {

    private String titulo;

    private String autor;

    private String isbn;

    private int quantidadeTotal;

    private int quantidadeDisponivel;

    private List<AlunoModel> alunosEmprestimo;




    public LivroModel(String titulo, String autor, String isbn, int quantidadeTotal) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.alunosEmprestimo = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void emprestar(AlunoModel aluno) {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
            alunosEmprestimo.add(aluno);
        } else {
            System.out.println("Não há cópias disponíveis deste livro para empréstimo! Faça uma reserva!");
        }
    }

    public void devolver(AlunoModel aluno) {
        if (alunosEmprestimo.contains(aluno)) {
            quantidadeDisponivel++;
            alunosEmprestimo.remove(aluno);
        } else {
            System.out.println("Este aluno não possui este livro emprestado.");
        }
    }

    public void listarAlunos(){
        System.out.println("Alunos que pegaram o Livro: " + getTitulo() + " Emprestado");
        for (AlunoModel alunos : alunosEmprestimo) {
            System.out.println("Nome: " + alunos.getNome() + "  RM: " + alunos.getRm());
        }
    }


}
