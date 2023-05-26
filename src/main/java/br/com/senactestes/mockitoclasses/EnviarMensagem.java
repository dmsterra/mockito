package br.com.senactestes.mockitoclasses;

import java.util.ArrayList;
import java.util.List;

public class EnviarMensagem {
	
	private List<Mensagem> mensagens = new ArrayList<>();
	
	public void adicionarMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}
	
	public List<Mensagem> getMensagens(){
		return this.mensagens;
	}

}
