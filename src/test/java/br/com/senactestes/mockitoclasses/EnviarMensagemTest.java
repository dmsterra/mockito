package br.com.senactestes.mockitoclasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTest {
	
	//somente para espiar o comportamento da classe EnviarMensagem
	@Spy
	private EnviarMensagem enviarMensagem;
	
	@Test
	void verificarComportamentoDaClasse() {
		//verificar que a fila está vazia
		Mockito.verifyNoInteractions(enviarMensagem);
		
		Mensagem mensagem = new Mensagem("Olá Diego, tudo bem? Quanto tempo...");
		enviarMensagem.adicionarMensagem(mensagem);
		//verificar se o estado anterior dele tá diferente
		Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);
		
		Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
		
		
		
	}

}
