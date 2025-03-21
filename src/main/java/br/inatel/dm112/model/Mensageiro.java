package br.inatel.dm112.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class Mensageiro
{
	@Value("${utility.rest.email.url}")
	private String restURL;

	private String mailEndpoint = "/mail";

	public void enviarEmail(int numeroPedido, String to, String conteudo)
	{
		try
		{
			String url = restURL + mailEndpoint;
			System.out.println("URL: " + url);
			MailRequestData mrd = new MailRequestData(numeroPedido, to, null, conteudo);
			// ResponseEntity<String> response = WebClient.create(url).post().contentType(MediaType.APPLICATION_JSON).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(mrd), MailRequestData.class).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).defaultIfEmpty("").log().block();
			ResponseEntity<String> response = WebClient.create(url).post().contentType(MediaType.APPLICATION_JSON).bodyValue(mrd).retrieve().toEntity(String.class).block();
			if (response.getStatusCode().isError())
			{
				throw new RuntimeException("Erro HTTP: " + response.getStatusCode() + " - " + response.getBody());
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Erro HTTP: " + e.getMessage());
		}
	}
}
