//package ohtu.ohtuvarasto;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class VarastoTest {
//
//    Varasto varasto;
//    double vertailuTarkkuus;
//    int alkuTilavuus;
//    int testiSaldo;
//    int tyhja;
//
//    @Before
//    public void setUp() {
//        varasto = new Varasto(alkuTilavuus);
//        vertailuTarkkuus = 0.0001;
//        alkuTilavuus = 10;
//        testiSaldo = 5;
//        tyhja = 0;
//    }
//
//    @Test
//    public void konstruktoriLuoTyhjanVaraston() {
//        assertEquals(tyhja, varasto.getSaldo(), vertailuTarkkuus);
//    }
//
//    @Test
//    public void uudellaVarastollaOikeaTilavuus() {
//        assertEquals(alkuTilavuus, varasto.getTilavuus(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void uudellaVarastollaOikeaTilavuus2() {
//        Varasto v = new Varasto(alkuTilavuus, testiSaldo);
//        assertEquals(alkuTilavuus, v.getTilavuus(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void uudellaVarastollaOikeaSaldo() {
//        Varasto v = new Varasto(alkuTilavuus, testiSaldo);
//        assertEquals(testiSaldo, v.getSaldo(), vertailuTarkkuus);
//    }
//
//    @Test
//    public void lisaysLisaaSaldoa() {
//        varasto.lisaaVarastoon(testiSaldo);
//
//        // saldon pitäisi olla sama kun lisätty määrä
//        assertEquals(testiSaldo, varasto.getSaldo(), vertailuTarkkuus);
//    }
//
//    @Test
//    public void lisaysLisaaPienentaaVapaataTilaa() {
//        varasto.lisaaVarastoon(testiSaldo);
//
//        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä
//        assertEquals(alkuTilavuus - testiSaldo, varasto.paljonkoMahtuu(), vertailuTarkkuus);
//    }
//
//    @Test
//    public void ottaminenPalauttaaOikeanMaaran() {
//        varasto.lisaaVarastoon(alkuTilavuus);
//
//        double saatuMaara = varasto.otaVarastosta(testiSaldo);
//
//        assertEquals(testiSaldo, saatuMaara, vertailuTarkkuus);
//    }
//
//    @Test
//    public void ottaminenLisääTilaa() {
//        varasto.lisaaVarastoon(alkuTilavuus);
//
//        varasto.otaVarastosta(testiSaldo);
//
//        // varastossa pitäisi olla tilaa 10 - 5 + 5 eli 5
//        assertEquals(testiSaldo, varasto.paljonkoMahtuu(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void liikaLisaysTayttaaTasan() {
//        varasto.lisaaVarastoon(varasto.getTilavuus() + testiSaldo);
//        
//        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void liikaOttoTyhjentaaTasan() {
//        varasto.lisaaVarastoon(testiSaldo);
//        
//        varasto.otaVarastosta(alkuTilavuus);
//        
//        assertEquals(tyhja, varasto.getSaldo(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void negatiivinenLisaysEiTeeMitaan() {
//        varasto.lisaaVarastoon(-testiSaldo);
//        
//        assertEquals(tyhja, varasto.getSaldo(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void negatiivinenOttoEiTeeMitaan() {
//        varasto.otaVarastosta(-testiSaldo);
//        
//        assertEquals(tyhja, varasto.getSaldo(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void merkkiJonoEsitysToimii() {
//        String to = ("saldo = 0.0 , vielä tilaa 10.0");
//        assertArrayEquals(to.toCharArray(), varasto.toString().toCharArray());
//    }
//    
//    @Test
//    public void negatiiivinenTilavuusNollataan() {
//        Varasto v = new Varasto(-testiSaldo);
//        assertEquals(tyhja, v.getTilavuus(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void negatiiivinenTilavuusNollataan2() {
//        Varasto v = new Varasto(-testiSaldo, tyhja);
//        assertEquals(tyhja, v.getTilavuus(), vertailuTarkkuus);
//    }
//    
//    @Test
//    public void negatiivinenSaldoNollataan() {
//        Varasto v = new Varasto(alkuTilavuus, -testiSaldo);
//        assertEquals(tyhja, v.getSaldo(), vertailuTarkkuus);
//    }
//}