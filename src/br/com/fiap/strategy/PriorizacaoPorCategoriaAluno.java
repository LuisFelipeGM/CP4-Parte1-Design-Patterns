package br.com.fiap.strategy;

import br.com.fiap.model.AlunoModel;
import br.com.fiap.model.LivroModel;
import br.com.fiap.model.ReservaLivroModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorizacaoPorCategoriaAluno implements PriorizacaoReservasStrategy {

    @Override
    public void priorizarReservas(List<ReservaLivroModel> reservas) {

        //Ordenando a Lista de reserva com base na categoria do Aluno
        Collections.sort(reservas, new Comparator<ReservaLivroModel>() {
            @Override
            public int compare(ReservaLivroModel reserva1, ReservaLivroModel reserva2) {
                String categoria1 = reserva1.getAluno().getCategoria();
                String categoria2 = reserva2.getAluno().getCategoria();
                return compararCategorias(categoria1, categoria2);
            }
        });

        System.out.println("Ordem de Empréstimo (CATEGORIA): ");

        for (ReservaLivroModel reserva : reservas) {
            AlunoModel aluno = reserva.getAluno();
            LivroModel livro = reserva.getLivro();

            System.out.println("Aluno " + aluno.getNome() +"  RM: " + aluno.getRm() + "  Categoria: " + aluno.getCategoria()
            + "  Livro: " + livro.getTitulo());
        }


    }

    // Função auxiliar para comparar categorias de alunos
    private int compararCategorias(String categoria1, String categoria2) {
        if (categoria1.equals("Pós-Graduação") && !categoria2.equals("Pós-Graduação")) {
            return -1;
        } else if (!categoria1.equals("Pós-Graduação") && categoria2.equals("Pós-Graduação")) {
            return 1;
        } else {
            return categoria1.compareTo(categoria2);
        }
    }

}
