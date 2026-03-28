package diadiatest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

    private Stanza stanzaVuota;
    private Stanza stanzaAdiacente;
    private Attrezzo spada;

    @BeforeEach
    void setUp() {

        stanzaVuota = new Stanza("Ripostiglio");
        stanzaAdiacente = new Stanza("Corridoio");
        spada = new Attrezzo("Spada", 5);
    }

    @Test
    void testImpostaStanzaAdiacente() {
        stanzaVuota.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanzaVuota.getStanzaAdiacente("nord"));
    }

    @Test
    void testGetStanzaAdiacenteInesistente() {
        assertNull(stanzaVuota.getStanzaAdiacente("sud"));
    }

    @Test
    void testSovrascriviStanzaAdiacente() {
        Stanza altraStanza = new Stanza("Cucina");
        stanzaVuota.impostaStanzaAdiacente("nord", stanzaAdiacente);
        stanzaVuota.impostaStanzaAdiacente("nord", altraStanza);
        assertEquals(altraStanza, stanzaVuota.getStanzaAdiacente("nord"));
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(stanzaVuota.addAttrezzo(spada));
        assertTrue(stanzaVuota.hasAttrezzo("Spada"));
    }

    @Test
    void testAddAttrezzoOltreLimite() {
        for (int i = 0; i < 10; i++) {
            stanzaVuota.addAttrezzo(new Attrezzo("Attrezzo" + i, 1));
        }
        assertFalse(stanzaVuota.addAttrezzo(new Attrezzo("Extra", 1)));
    }

    @Test
    void testHasAttrezzoInesistente() {
        assertFalse(stanzaVuota.hasAttrezzo("Martello"));
    }

    @Test
    void testGetAttrezzo() {
        stanzaVuota.addAttrezzo(spada);
        assertEquals(spada, stanzaVuota.getAttrezzo("Spada"));
    }

    @Test
    void testRemoveAttrezzo() {
        stanzaVuota.addAttrezzo(spada);
        assertTrue(stanzaVuota.removeAttrezzo(spada), "Dovrebbe restituire true se l'attrezzo è rimosso");
        assertFalse(stanzaVuota.hasAttrezzo("Spada"), "L'attrezzo non dovrebbe più essere presente");
    }
}