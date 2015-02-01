package br.org.base.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.org.base.data.Data;

public class TesteData {

	@Test
	public void test() {
		Data data = new Data(01,10,2000);
		assertTrue("bissexto errado", data.anoBissexto());
	}

}
