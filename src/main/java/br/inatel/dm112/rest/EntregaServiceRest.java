package br.inatel.dm112.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.dm112.interfaces.EntregaServiceInterface;
import br.inatel.dm112.model.Entrega;
import br.inatel.dm112.model.Pedido;
import br.inatel.dm112.services.EntregaService;

@RestController
@RequestMapping("/api")
public class EntregaServiceRest implements EntregaServiceInterface
{
	@Autowired
	private EntregaService entregaService;

	@Override
	@GetMapping("/pedidos")
	public List<Pedido> listarPedidos()
	{
		System.out.println("EntregaServiceRest - getAllPedidos");
		return entregaService.listarPedidos();
	}

	@Override
	@PostMapping("/registrarEntrega")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void registrarEntrega(@RequestBody
	Entrega entrega)
	{
		entregaService.registrarEntrega(entrega.getIdPedido(), entrega.getCpfrecebedor(), entrega.getDatahoraentrega());
	}
}
