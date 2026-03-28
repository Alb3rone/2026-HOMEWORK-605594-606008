package diadiatest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

    private Borsa borsa;
    private Attrezzo osso;
    private Attrezzo incudine;
    private Attrezzo lanterna;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        osso = new Attrezzo("osso", 1);
        incudine = new Attrezzo("incudine", 11);
        lanterna = new Attrezzo("lanterna", 3);
    }

    @Test
    void testAddAttrezzoSingolo() {
        assertTrue(borsa.addAttrezzo(osso));
        assertEquals(osso, borsa.getAttrezzo("osso"));
    }

    @Test
    void testAddAttrezzoTroppoPesante() {
        assertFalse(borsa.addAttrezzo(incudine), "Non dovrebbe aggiungere oggetti oltre il peso max");
        assertFalse(borsa.hasAttrezzo("incudine"));
    }

    @Test
    void testAddAttrezzoOltreLimiteNumero() {
        for (int i = 0; i < 10; i++) {
            borsa.addAttrezzo(new Attrezzo("attrezzo" + i, 0));
        }
        assertFalse(borsa.addAttrezzo(new Attrezzo("extra", 0)), "Non dovrebbe aggiungere più di 10 attrezzi");
    }

    @Test
    void testGetPesoIniziale() {
        assertEquals(0, borsa.getPeso());
    }

    @Test
    void testGetPesoDopoAggiunta() {
        borsa.addAttrezzo(osso);
        borsa.addAttrezzo(lanterna);
        assertEquals(4, borsa.getPeso());
    }

    @Test
    void testIsEmpty() {
        assertTrue(borsa.isEmpty());
        borsa.addAttrezzo(osso);
        assertFalse(borsa.isEmpty());
    }

    @Test
    void testHasAttrezzoInesistente() {
        assertFalse(borsa.hasAttrezzo("scudo"));
    }

}