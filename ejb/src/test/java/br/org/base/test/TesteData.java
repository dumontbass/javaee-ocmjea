package br.org.base.test;

import br.org.base.data.Data;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TesteData {

	@Test
	public void test() {
		Data data = new Data(01,10,2000);
		assertTrue("bissexto errado", data.anoBissexto());
	}
	
	@Test
	public void insereEEditaPessoa(){

	}

}
