package br.inatel.dm112.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Map<String, Object>> listarPedidos()
	{
		Map<String, Object> resposta = new HashMap<>();
		try
		{
			System.out.println("EntregaServiceRest - getAllPedidos");
			List<Pedido> pedidos = entregaService.listarPedidos();
			resposta.put("status", HttpStatus.OK.value());
			resposta.put("mensagem", "Transação executada com sucesso");
			resposta.put("data", pedidos);
			return ResponseEntity.status(HttpStatus.OK).body(resposta);
		}
		catch (Exception e)
		{
			resposta.put("status", HttpStatus.UNAUTHORIZED.value());
			resposta.put("erro", e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
		}
	}

	@Override
	@PostMapping("/registrarEntrega")
	public ResponseEntity<Map<String, Object>> registrarEntrega(@RequestBody
	Entrega entrega)
	{
		Map<String, Object> resposta = new HashMap<>();
		try
		{
			entregaService.registrarEntrega(entrega.getIdPedido(), entrega.getCpfrecebedor(), entrega.getDatahoraentrega());
			resposta.put("status", HttpStatus.OK.value());
			resposta.put("mensagem", "Entrega registrada com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(resposta);
		}
		catch (Exception e)
		{
			resposta.put("status", HttpStatus.UNAUTHORIZED.value());
			resposta.put("erro", e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
		}
	}
}
