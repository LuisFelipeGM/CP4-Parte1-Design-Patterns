package br.com.fiap.strategy;

import br.com.fiap.model.ReservaLivroModel;

import java.util.List;

public interface PriorizacaoReservasStrategy {

    void priorizarReservas(List<ReservaLivroModel> reservas);

}
