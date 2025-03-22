# LogisticaDM112

# Pós-Graduação em Desenvolvimento Mobile e Cloud Computing – Inatel
## DM112 - Cloud Computing, Programação OO, WebServices e SOA

## Trabalho final 2

### Autor: 
José Enderson Ferreira Rodrigues   
jose.rodrigues@pg.inatel.br, jose.e.f.rodrigues.br@gmail.com

### Atividade proposta: 

* Criar o serviço de logística utilizando REST e armazenar no banco de dados de sua
escolha (em memória ou arquivo).
* Integrar o serviço de e-mail (utilizado na aula) a este novo serviço de logística.
Atenção: o serviço de envio de e-mail necessita de um pequeno ajuste, pois aqui
não é necessário enviar o PDF como anexo.

### Documentação: 
https://github.com/joseefrodriguesbr/DM112-TrabalhoFinal/tree/main/documentacao

## Implementação

A implementação é composta por 2 módulos:<br/><br/>
<strong>LogisticaDM112</strong> - Serviço de logística utilizando REST e banco de dados sqlite<br/> 
Repositório : https://github.com/joseefrodriguesbr/LogisticaDM112

<strong>UtilityDM112</strong> - Serviço de envio de e-mail alterado para contemplar envio de mensagem sem anexo<br/> 
Repositório : https://github.com/joseefrodriguesbr/UtilityDM112

## Portas

 * ### Projeto UtilityDM112 : 7071
 * ### Projeto LogisticaDM112 : 8081

## Testes:
### Listar pedidos (requisição GET):<br/>
Retorna os pedidos com status 2-PENDENTE(não pago) e 3-CONFIRMADO(pago). <br/>

```sh
curl -v --location --request GET 'http://localhost:8081/LogisticaDM112/api/pedidos'
```

### Registrar entrega (requisição POST):<br/>
A execução com sucesso altera o status do pedido para 3-ENTREGUE.<br/>

Endpoint:
```sh
 http://localhost:8081/LogisticaDM112/api/registrarEntrega<br/>
```

<strong>Observação:</strong> A execução com sucesso invoca o serviço de e-mail disponível no projeto UtilityDM112, configurado na porta 7071, utilizando o GMail <br/>

```sh
{
  "idPedido": 2,
  "cpfrecebedor": "12345678900",
  "datahoraentrega": "2025-03-19T15:30:00"
}
```


