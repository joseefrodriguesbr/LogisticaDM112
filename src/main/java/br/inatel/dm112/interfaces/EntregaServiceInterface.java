package br.inatel.dm112.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import br.inatel.dm112.model.Entrega;

public interface EntregaServiceInterface
{
	public ResponseEntity<Map<String, Object>> listarPedidos();

	public ResponseEntity<Map<String, Object>> registrarEntrega(Entrega entrega);
}
