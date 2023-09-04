package br.com.fiap.model;

import br.com.fiap.observer.BibliotecaObserver;

public class AlunoModel implements BibliotecaObserver {

    private String nome;

    private int rm;

    private String categoria;

    public AlunoModel(String nome, String turma, int rm, String categoria) {
        this.nome = nome;
        this.rm = rm;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        this.rm = rm;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void update(String mensagem) {
        System.out.println(getNome() + " " + mensagem);
    }
}
