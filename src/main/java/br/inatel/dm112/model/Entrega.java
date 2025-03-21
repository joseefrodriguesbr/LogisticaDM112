package br.inatel.dm112.model;

import java.util.Date;
import java.util.Optional;

import br.inatel.dm112.model.dao.EntregaRepository;
import br.inatel.dm112.model.entities.EntregaEntity;

public class Entrega
{
	private Integer id;

	private Integer idPedido;

	private String cpfrecebedor;

	private Date datahoraentrega;

	protected EntregaRepository entregaRepository;

	public Entrega(Integer id, Integer idPedido, String cpfrecebedor, Date datahoraentrega)
	{
		this.id = id;
		this.idPedido = idPedido;
		this.cpfrecebedor = cpfrecebedor;
		this.datahoraentrega = datahoraentrega;
	}

	public Entrega(EntregaRepository entregaRepository)
	{
		this.entregaRepository = entregaRepository;
	}

	public EntregaEntity persistirEntrega(EntregaEntity entregaEntity)
	{
		entregaEntity = this.entregaRepository.save(entregaEntity);
		return entregaEntity;
	}

	public EntregaEntity consultarEntrega(int id)
	{
		Optional<EntregaEntity> entregaEntityOptional = this.entregaRepository.findById(id);
		EntregaEntity entregaEntity = entregaEntityOptional.get();
		return entregaEntity;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getIdPedido()
	{
		return idPedido;
	}

	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}

	public String getCpfrecebedor()
	{
		return cpfrecebedor;
	}

	public void setCpfrecebedor(String cpfrecebedor)
	{
		this.cpfrecebedor = cpfrecebedor;
	}

	public Date getDatahoraentrega()
	{
		return datahoraentrega;
	}

	public void setDatahoraentrega(Date datahoraentrega)
	{
		this.datahoraentrega = datahoraentrega;
	}

	public EntregaRepository getEntregaRepository()
	{
		return entregaRepository;
	}

	public void setEntregaRepository(EntregaRepository entregaRepository)
	{
		this.entregaRepository = entregaRepository;
	}
}
