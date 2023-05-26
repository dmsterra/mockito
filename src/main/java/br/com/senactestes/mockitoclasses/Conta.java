package br.com.senactestes.mockitoclasses;

public class Conta {
	
	private int saldo;
	
	public Conta(int saldo) {
		this.saldo = saldo;
	}
	
	public void pagarBoleto(int valorAPagar) {
		validarSaldo(valorAPagar);
		debitar(valorAPagar);
		enviarCreditoParaEmissor(valorAPagar);
	}

	
	
	public void validarSaldo(int valorAPagar) {
		if(valorAPagar > saldo) {
			throw new IllegalStateException("Saldo insuficiente!");
		}
	}

	
	public void debitar(int valorAPagar) {
		this.saldo = this.saldo - valorAPagar;
	}

	
	public void enviarCreditoParaEmissor(int valorAPagar) {
		//consome a API para enviar valor para emissor do boleto
		
	}

}
