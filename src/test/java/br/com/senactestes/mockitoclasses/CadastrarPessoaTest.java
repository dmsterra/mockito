package br.com.senactestes.mockitoclasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {
	
	
	//1.CRIACAO DE CENARIO
	//1.1.INSTRUMENTACAO PARA O MOCK
	//1.1.1.INSERCAO DO DESCRITOR DO MOCK
	
	@Mock
	private ApiDosCorreios apiDosCorreios;
	
	//1.1.2.INJECAO DE DEPENDENCIA DA REGRA DE NEGOCIO A SER TESTADA
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void testeCadastrarPessoa() {
		//1.2.INSERCAO DOS DADOS A SEREM MOCKADOS
		//Dados ficticios do objeto que estou mockando
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Atibaia", "Rua Antoni Massoni", "Casa", "Nova Floresta");
		
		//Execucao do mock
		Mockito.when(apiDosCorreios.buscaDadosCep(anyString())).thenReturn(dadosLocalizacao);
		
		Pessoa clayton = cadastrarPessoa.cadastrarPessoa("Clayton", "123456", LocalDate.of(1977, 5, 4), "12940330");
		
		//2.EXECUCAO E ANALISE (ASSERTS) DO TESTE		
		DadosLocalizacao enderecoClayton = clayton.getEndereco();
		assertEquals(dadosLocalizacao.getBairro(), enderecoClayton.getBairro());
		assertEquals(dadosLocalizacao.getCidade(), enderecoClayton.getCidade());
		assertEquals(dadosLocalizacao.getUf(), enderecoClayton.getUf());
		
	}
	
	//Teste de Mock para o fluxo de exceção do caso de uso, que deve disparar uma exceção por falha na API
	@Test
	void testeTentaCadastrarPessoaMasSistemadosCorreiosForaDoAr() {
		Mockito.when(apiDosCorreios.buscaDadosCep(anyString())).thenThrow(RuntimeException.class);
		
		Assertions.assertThrows(RuntimeException.class, ()-> cadastrarPessoa.cadastrarPessoa("Jose", "123456", LocalDate.of(1977, 5, 4), "123456789"));
	}

}
