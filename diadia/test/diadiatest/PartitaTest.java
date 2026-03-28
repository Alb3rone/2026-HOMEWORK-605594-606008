package diadiatest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

    private Partita partita;

    @BeforeEach
    void setUp() {
        partita = new Partita();
    }

    @Test
    void testVintaIniziale() {
        assertFalse(partita.vinta(), "La partita non dovrebbe essere vinta all'inizio");
    }

    @Test
    void testVintaVera() {
        Stanza vincente = partita.getLabirinto().getStanzaVincente();
        partita.getLabirinto().setStanzaCorrente(vincente);
        assertTrue(partita.vinta(), "La partita dovrebbe risultare vinta nella stanza vincente");
    }

    /* --- TEST CONDIZIONI DI FINE PARTITA (isFinita) --- */

    @Test
    void testIsFinitaIniziale() {
        assertFalse(partita.isFinita(), "La partita non dovrebbe essere finita appena creata");
    }

    @Test
    void testIsFinitaSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita dopo setFinita()");
    }

    @Test
    void testIsFinitaPerVittoria() {
        Stanza vincente = partita.getLabirinto().getStanzaVincente();
        partita.getLabirinto().setStanzaCorrente(vincente);
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita se vinta");
    }

    @Test
    void testIsFinitaPerCfuZero() {
        partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita con 0 CFU");
    }

    @Test
    void testGetLabirintoNotNull() {
        assertNotNull(partita.getLabirinto(), "La partita deve avere un labirinto");
    }

    @Test
    void testGetGiocatoreNotNull() {
    }

}
