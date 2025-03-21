package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.inatel.dm112.model.Pedido;

@Entity
@Table(name = "Pedido")
public class PedidoEntity
{
	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;

	private String CPF;

	@Column(name = "valor")
	private float valor;

	private int status;

	@Column(name = "datapedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date datapedido;

	@Column(name = "dataemissao", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataemissao;

	@Column(name = "datapagamento", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date datapagamento;

	private String email;

	private String endereco;

	public PedidoEntity()
	{
		this.status = Pedido.PENDENTE;
	}

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}

	public String getCPF()
	{
		return CPF;
	}

	public void setCPF(String cPF)
	{
		CPF = cPF;
	}

	public float getValor()
	{
		return valor;
	}

	public void setValor(float valor)
	{
		this.valor = valor;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public Date getDatapedido()
	{
		return datapedido;
	}

	public void setDatapedido(Date datapedido)
	{
		this.datapedido = datapedido;
	}

	public Date getDataemissao()
	{
		return dataemissao;
	}

	public void setDataemissao(Date dataemissao)
	{
		this.dataemissao = dataemissao;
	}

	public Date getDatapagamento()
	{
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento)
	{
		this.datapagamento = datapagamento;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
}
