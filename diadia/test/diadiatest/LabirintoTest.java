package diadiatest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class LabirintoTest {

	private Labirinto labirinto;

	@BeforeEach
	void setUp() {
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
	}
	@Test
	void testGetStanzaVincente() {
		assertNotNull(labirinto.getStanzaVincente());
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

	@Test
	void testGetStanzaCorrenteIniziale() {
		assertNotNull(labirinto.getStanzaCorrente());
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

	@Test
	void testSetStanzaCorrente() {
		Stanza nuovaStanza = new Stanza("Nuova Stanza");
		labirinto.setStanzaCorrente(nuovaStanza);
		assertEquals(nuovaStanza, labirinto.getStanzaCorrente());
	}


	@Test
	void testAdiacenzaAtrioBiblioteca() {

		Stanza atrio = labirinto.getStanzaCorrente();
		assertEquals("Biblioteca", atrio.getStanzaAdiacente("nord").getNome());
	}

	@Test
	void testAdiacenzaBidirezionaleAtrioBiblioteca() {

		Stanza biblioteca = labirinto.getStanzaCorrente().getStanzaAdiacente("nord");
		assertEquals("Atrio", biblioteca.getStanzaAdiacente("sud").getNome());
	}

	@Test
	void testOssoInAtrio() {

		assertTrue(labirinto.getStanzaCorrente().hasAttrezzo("osso"));
	}

	@Test
	void testLanternaInAulaN10() {
		Stanza aulaN10 = labirinto.getStanzaCorrente().getStanzaAdiacente("sud");
		assertNotNull(aulaN10);
		assertTrue(aulaN10.hasAttrezzo("lanterna"));
	}
}