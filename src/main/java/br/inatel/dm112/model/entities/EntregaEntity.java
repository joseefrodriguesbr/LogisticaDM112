package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Entrega")
public class EntregaEntity
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "numero", nullable = false)
	private PedidoEntity pedido;

	@Column(name = "cpfrecebedor", nullable = true)
	private String cpfrecebedor;

	@Column(name = "datahoraentrega", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahoraentrega;

	public EntregaEntity()
	{
	}

	public EntregaEntity(PedidoEntity pedido, String cpfrecebedor, Date datahoraentrega)
	{
		this.pedido = pedido;
		this.cpfrecebedor = cpfrecebedor;
		this.datahoraentrega = datahoraentrega;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public PedidoEntity getPedido()
	{
		return pedido;
	}

	public void setPedido(PedidoEntity pedido)
	{
		this.pedido = pedido;
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

	@Override
	public String toString()
	{
		return "EntregaEntity [id=" + id + ", pedido=" + pedido + ", cpfrecebedor=" + cpfrecebedor + ", datahoraentrega=" + datahoraentrega + "]";
	}
}
