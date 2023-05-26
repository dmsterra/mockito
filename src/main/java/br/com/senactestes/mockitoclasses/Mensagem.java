package br.com.senactestes.mockitoclasses;

import java.util.UUID;

public class Mensagem {
	
	private String id;
	
	private String mensagem;
	
	public Mensagem(final String mensagem) {
		this.id = UUID.randomUUID().toString();
		this.mensagem = mensagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
