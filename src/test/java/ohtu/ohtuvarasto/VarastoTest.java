package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaTilavuus2() {
        Varasto v = new Varasto(12, 5);
        assertEquals(12, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaSaldo() {
        Varasto v = new Varasto(12, 5);
        assertEquals(5, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void liikaLisaysTayttaaTasan() {
        varasto.lisaaVarastoon(varasto.getTilavuus() + 5);
        
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void liikaOttoTyhjentaaTasan() {
        varasto.lisaaVarastoon(5);
        
        varasto.otaVarastosta(10);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisaysEiTeeMitaan() {
        varasto.lisaaVarastoon(-1);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttoEiTeeMitaan() {
        varasto.otaVarastosta(-1);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void merkkiJonoEsitysToimii() {
        String to = ("saldo = " + 0.0 + ", vielä tilaa " + 10.0);
        assertArrayEquals(to.toCharArray(), varasto.toString().toCharArray());
    }
    
    @Test
    public void negatiiivinenTilavuusNollataan() {
        Varasto v = new Varasto(-1);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiiivinenTilavuusNollataan2() {
        Varasto v = new Varasto(-1, 0);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenSaldoNollataan() {
        Varasto v = new Varasto(12, -1);
        assertEquals(0, v.getSaldo(), vertailuTarkkuus);
    }
}