package br.com.fiap.strategy;

import br.com.fiap.model.ReservaLivroModel;

import java.util.List;

public class ProcessadorPrioridade {

    private PriorizacaoReservasStrategy priorizacaoReservasStrategy;

    public ProcessadorPrioridade(PriorizacaoReservasStrategy priorizacaoReservasStrategy){
        this.priorizacaoReservasStrategy = priorizacaoReservasStrategy;
    }

    public void setPriorizacaoReservasStrategy(PriorizacaoReservasStrategy priorizacaoReservasStrategy){
        this.priorizacaoReservasStrategy = priorizacaoReservasStrategy;
    }

    // Mandando a Lista de Reservas para a Estretégia Apropriada:
    public void processaPriorizacao(List<ReservaLivroModel> reservas){
        priorizacaoReservasStrategy.priorizarReservas(reservas);
    }

}
