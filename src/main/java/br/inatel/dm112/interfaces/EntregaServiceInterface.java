package br.inatel.dm112.interfaces;

import java.util.List;

import br.inatel.dm112.model.Entrega;
import br.inatel.dm112.model.Pedido;

public interface EntregaServiceInterface
{
	public List<Pedido> listarPedidos();

	public void registrarEntrega(Entrega entrega);
}
