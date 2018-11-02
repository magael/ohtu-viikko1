/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void haetaanOikeaPelaaja() {
        Player kurri = new Player("Kurri", "EDM", 37, 53);
        assertEquals(kurri.toString(), stats.search("Kurri").toString());
    }
    
    @Test
    public void olematonPelaajaPalauttaaNull() {
        assertNull(stats.search("Karri"));
    }
    
    @Test
    public void haetaanOikeaTiimi() {
        // Yhden testaus
        Player lem = new Player("Lemieux", "PIT", 45, 54);
        Player pit = stats.team("PIT").get(0);
        
        assertEquals(lem.toString(), pit.toString());
        
        // Monen testaus
        List<Player> edm = stats.team("EDM");
        
        for (Player p : edm) {
            assertEquals(p.getTeam(), "EDM");
        }
    }
    
    @Test
    public void haetaanHuippuPelaaja() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
}