package br.com.fiap.model;

import br.com.fiap.model.AlunoModel;
import br.com.fiap.model.LivroModel;

public class ReservaLivroModel {

    private AlunoModel alunoModel;

    private LivroModel livroModel;

    public ReservaLivroModel(AlunoModel alunoModel, LivroModel livroModel) {
        this.alunoModel = alunoModel;
        this.livroModel = livroModel;
    }

    public AlunoModel getAluno() {
        return alunoModel;
    }

    public void setAluno(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public LivroModel getLivro() {
        return livroModel;
    }

    public void setLivro(LivroModel livroModel) {
        this.livroModel = livroModel;
    }
}
