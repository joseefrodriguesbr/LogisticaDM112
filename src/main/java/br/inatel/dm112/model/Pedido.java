package br.inatel.dm112.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.inatel.dm112.model.dao.PedidoRepository;
import br.inatel.dm112.model.entities.PedidoEntity;

public class Pedido
{
	public static int PENDENTE = 1;

	public static int CONFIRMADO = 2;

	public static int ENTREGUE = 3;

	private Integer numero;

	private String cpf;

	private float valor;

	private int status;

	private Date datapedido;

	private Date dataemissao;

	private Date datapagamento;

	private String email;

	private String endereco;

	protected PedidoRepository pedidoRepository;

	public Pedido(Integer numero, String cpf, float valor, int status, Date datapedido, Date dataemissao, Date datapagamento, String email, String endereco)
	{
		this.numero = numero;
		this.cpf = cpf;
		this.valor = valor;
		this.status = status;
		this.datapedido = datapedido;
		this.dataemissao = dataemissao;
		this.datapagamento = datapagamento;
		this.email = email;
		this.endereco = endereco;
	}

	public Pedido(PedidoRepository pedidoRepository)
	{
		this.pedidoRepository = pedidoRepository;
	}

	public List<Pedido> listarPedidosPorSituacao(int situacao)
	{
		List<PedidoEntity> entities = this.pedidoRepository.findByStatus(situacao);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		for (PedidoEntity entity : entities)
		{
			Pedido pedido = new Pedido(entity.getNumero(), entity.getCPF(), entity.getValor(), entity.getStatus(), entity.getDatapedido(), entity.getDataemissao(), entity.getDatapagamento(), entity.getEmail(), entity.getEndereco());
			pedidos.add(pedido);
		}
		return pedidos;
	}

	public void atualizarPedido(PedidoEntity pedidoEntity)
	{
		this.pedidoRepository.save(pedidoEntity);
	}

	public PedidoEntity consultarPedido(int id)
	{
		Optional<PedidoEntity> pedidoEntityOptional = this.pedidoRepository.findById(id);
		PedidoEntity pedidoEntity = pedidoEntityOptional.get();
		return pedidoEntity;
	}

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
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

	@Override
	public String toString()
	{
		return "Pedido [numero=" + numero + ", cpf=" + cpf + ", valor=" + valor + ", status=" + status + ", datapedido=" + datapedido + ", dataemissao=" + dataemissao + ", datapagamento=" + datapagamento + ", email=" + email + ", endereco=" + endereco + "]";
	}
}
