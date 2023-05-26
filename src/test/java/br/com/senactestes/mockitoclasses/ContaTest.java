package br.com.senactestes.mockitoclasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTest {
	
	@Spy
	private Conta conta = new Conta(1000);
	
	@Test
	void validarOrdemDeChamadas() {
		conta.pagarBoleto(39);
		
		InOrder inOrder = Mockito.inOrder(conta);
		inOrder.verify(conta).pagarBoleto(39);
		inOrder.verify(conta).validarSaldo(39);
		inOrder.verify(conta).debitar(39);
		inOrder.verify(conta).enviarCreditoParaEmissor(39);
	}
	
	@Test
	void validarQuantidadeDeChamadas() {
		conta.validarSaldo(300);
		conta.debitar(100);
		conta.validarSaldo(200);
		conta.debitar(50);
		conta.validarSaldo(150);
		
		Mockito.verify(conta, Mockito.times(3)).validarSaldo(ArgumentMatchers.anyInt());
		Mockito.verify(conta, Mockito.times(2)).debitar(ArgumentMatchers.anyInt());
		
	}

}
