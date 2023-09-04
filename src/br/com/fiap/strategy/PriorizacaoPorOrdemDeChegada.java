package br.com.fiap.strategy;

import br.com.fiap.model.AlunoModel;
import br.com.fiap.model.LivroModel;
import br.com.fiap.model.ReservaLivroModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PriorizacaoPorOrdemDeChegada implements  PriorizacaoReservasStrategy{

    @Override
    public void priorizarReservas(List<ReservaLivroModel> reservas) {

        Queue<ReservaLivroModel> filaDeEspera = new LinkedList<>();

        for (ReservaLivroModel reserva : reservas) {
            filaDeEspera.offer(reserva);
        }

        System.out.println("Ordem de Empréstimo (CHEGADA): ");

        while (!filaDeEspera.isEmpty()) {
            ReservaLivroModel proximaReserva = filaDeEspera.poll();
            AlunoModel aluno = proximaReserva.getAluno();
            LivroModel livro = proximaReserva.getLivro();

            System.out.println("Aluno " + aluno.getNome() +"  RM: " + aluno.getRm() + "  Livro: " + livro.getTitulo());

        }

    }
}
