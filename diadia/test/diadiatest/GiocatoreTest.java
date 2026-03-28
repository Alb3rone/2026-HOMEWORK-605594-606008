package diadiatest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;


class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
    }


    @Test
    void testCfuIniziali() {

        assertEquals(20, giocatore.getCfu(), "Il giocatore dovrebbe partire con 20 CFU");
    }

    @Test
    void testBorsaInizialeNotNull() {

        assertNotNull(giocatore.getBorsa(), "Il giocatore deve avere una borsa appena creato");
    }


    @Test
    void testSetCfu() {
        giocatore.setCfu(15);
        assertEquals(15, giocatore.getCfu());
    }

    @Test
    void testSetCfuZero() {
        giocatore.setCfu(0);
        assertEquals(0, giocatore.getCfu(), "I CFU dovrebbero poter scendere a zero");
    }

    @Test
    void testSetBorsa() {
        Borsa nuovaBorsa = new Borsa(50);
        giocatore.setBorsa(nuovaBorsa);
        assertSame(nuovaBorsa, giocatore.getBorsa(), "La borsa impostata deve essere la stessa restituita");
    }
}