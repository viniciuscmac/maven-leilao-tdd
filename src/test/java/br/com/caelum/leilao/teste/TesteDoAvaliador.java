package br.com.caelum.leilao.teste;
import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Carro 0Km");
		
		leilao.propoe(new Lance(joao, 20000.0));
		leilao.propoe(new Lance(jose, 22000.0));
		leilao.propoe(new Lance(maria, 24000.0));
		leilao.propoe(new Lance(jose, 25000.0));
		leilao.propoe(new Lance(joao,26000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 26000;
		double menorEsperado = 20000;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(),0.00001);
		
		
	}
}
