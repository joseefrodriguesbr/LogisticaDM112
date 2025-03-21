package br.inatel.dm112.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.dm112.model.Entrega;
import br.inatel.dm112.model.Mensageiro;
import br.inatel.dm112.model.Pedido;
import br.inatel.dm112.model.dao.EntregaRepository;
import br.inatel.dm112.model.dao.PedidoRepository;
import br.inatel.dm112.model.entities.EntregaEntity;
import br.inatel.dm112.model.entities.PedidoEntity;

@Service
public class EntregaService
{
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EntregaRepository entregareRepository;

	@Autowired
	private Mensageiro mensageiro;

	public List<Pedido> listarPedidos()
	{
		return new Pedido(pedidoRepository).listarPedidosPorSituacao(Pedido.CONFIRMADO);
	}

	@Transactional
	public void registrarEntrega(int idPedido, String cpfRecebedor, Date dataHoraEntrega)
	{
		Pedido pedido = new Pedido(pedidoRepository);
		PedidoEntity pedidoEntity = pedido.consultarPedido(idPedido);
		pedidoEntity.setStatus(Pedido.ENTREGUE);
		pedido.atualizarPedido(pedidoEntity);
		//
		EntregaEntity entregaEntity = new EntregaEntity(pedidoEntity, cpfRecebedor, dataHoraEntrega);
		entregaEntity = new Entrega(this.entregareRepository).persistirEntrega(entregaEntity);
		//
		notificarEntrega(idPedido, entregaEntity.getId());
	}

	private void notificarEntrega(int idPedido, int idEntrega)
	{
		PedidoEntity pedidoEntity = new Pedido(pedidoRepository).consultarPedido(idPedido);
		EntregaEntity entregaEntity = new Entrega(this.entregareRepository).consultarEntrega(idEntrega);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("=== NOTIFICAÇÃO DE ENTREGA LOGÍSTICA DM112 === \n");
		stringBuilder.append("Número do pedido  : " + pedidoEntity.getNumero() + "\n");
		stringBuilder.append("CPF recebedor     : " + entregaEntity.getCpfrecebedor() + "\n");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String dataHoraEntrega = simpleDateFormat.format(entregaEntity.getDatahoraentrega());
		stringBuilder.append("Data/hora entrega : " + dataHoraEntrega + "\n");
		stringBuilder.append("Endereço entrega  : " + pedidoEntity.getEndereco() + "\n");
		String emailDestino = pedidoEntity.getEmail();
		String conteudo = stringBuilder.toString();
		// Mensageiro mensageiro = new Mensageiro();
		this.mensageiro.enviarEmail(pedidoEntity.getNumero(), emailDestino, conteudo);
	}
}