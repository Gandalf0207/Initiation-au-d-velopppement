package TD7.Test;

import static org.junit.jupiter.api.Assertions.*;

import TD7.Fichier.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateTest {

    private Date d1;
    private Date d2;
    private Date d3;

    @BeforeEach
    void setUp() {
        d1 = new Date(28, 2, 2023); // année non bissextile
        d2 = new Date(31, 12, 2023);
        d3 = new Date(1, 1, 2024);
    }

    @Test
    void testConstructeurEtToString() {
        assertEquals("28/fevrier/2023", d1.toString());
        assertEquals("31/decembre/2023", d2.toString());
        assertEquals("1/janvier/2024", d3.toString());
    }

    @Test
    void testConstructeurParRecopie() {
        Date copie = new Date(d1);
        assertEquals(d1.toString(), copie.toString());
        assertNotSame(d1, copie, "Le constructeur par recopie doit créer un nouvel objet");
    }

    @Test
    void testNbJoursMoisNormaux() {
        assertEquals(31, new Date(1, 1, 2023).nbJoursMois());
        assertEquals(30, new Date(1, 4, 2023).nbJoursMois());
        assertEquals(31, new Date(1, 12, 2023).nbJoursMois());
    }

    @Test
    void testNbJoursMoisFevrierNonBissextile() {
        assertEquals(28, new Date(1, 2, 2023).nbJoursMois());
    }

    @Test
    void testNbJoursMoisFevrierBissextile() {
        assertEquals(29, new Date(1, 2, 2024).nbJoursMois());
    }

    @Test
    void testIncrementerChangementDeJour() {
        Date d = new Date(1, 3, 2023);
        d.incrementer();
        assertEquals("2/mars/2023", d.toString());
    }

    @Test
    void testIncrementerChangementDeMois() {
        Date d = new Date(31, 1, 2023);
        d.incrementer();
        assertEquals("1/fevrier/2023", d.toString());
    }

    @Test
    void testIncrementerChangementDAnnee() {
        Date d = new Date(31, 12, 2023);
        d.incrementer();
        assertEquals("1/janvier/2024", d.toString());
    }

    @Test
    void testIncrementerFinFevrierNonBissextile() {
        Date d = new Date(28, 2, 2023);
        d.incrementer();
        assertEquals("1/mars/2023", d.toString());
    }

    @Test
    void testIncrementerFinFevrierBissextile() {
        Date d = new Date(28, 2, 2024);
        d.incrementer();
        assertEquals("29/fevrier/2024", d.toString());
        d.incrementer();
        assertEquals("1/mars/2024", d.toString());
    }

    @Test
    void testLendemain() {
        Date d = new Date(30, 4, 2023);
        Date lendemain = d.lendemain();
        assertEquals("1/mai/2023", lendemain.toString());
        assertEquals("30/avril/2023", d.toString(), "La date d'origine ne doit pas être modifiée");
    }

    @Test
    void testEgale() {
        assertTrue(new Date(1, 1, 2024).egale(d3));
        assertFalse(d1.egale(d2));
    }

    @Test
    void testAnterieure() {
        assertTrue(d1.anterieure(d2));
        assertTrue(d2.anterieure(d3));
        assertFalse(d3.anterieure(d1));
    }

    @Test
    void testPosterieure() {
        assertTrue(d3.posterieure(d1));
        assertFalse(d1.posterieure(d3));
        assertFalse(d1.posterieure(new Date(28, 2, 2023)));
    }

    @Test
    void testEcartSimple() {
        Date d = new Date(1, 1, 2023);
        Date dPlus2 = new Date(3, 1, 2023);
        assertEquals(2, d.ecart(dPlus2));
    }

    @Test
    void testEcartChangementMois() {
        Date d1 = new Date(30, 4, 2023);
        Date d2 = new Date(2, 5, 2023);
        assertEquals(2, d1.ecart(d2));
    }

    @Test
    void testEcartChangementAnnee() {
        Date d1 = new Date(31, 12, 2023);
        Date d2 = new Date(2, 1, 2024);
        assertEquals(2, d1.ecart(d2));
    }

    @Test
    void testEcartZero() {
        Date d = new Date(15, 7, 2023);
        assertEquals(0, d.ecart(d));
    }

    @Test
    void testFevrierAnneeBissextileClassique() {
        Date d = new Date(28, 2, 2024);
        d.incrementer();
        assertEquals("29/fevrier/2024", d.toString(), "2024 est bissextile → 29 février doit exister");
        d.incrementer();
        assertEquals("1/mars/2024", d.toString());
    }

    @Test
    void testFevrierAnneeNonBissextileSiecle() {
        // 2100 est divisible par 100 mais pas par 400 → non bissextile
        Date d = new Date(28, 2, 2100);
        d.incrementer();
        assertEquals("1/mars/2100", d.toString(), "2100 n’est pas bissextile");
    }

    @Test
    void testFevrierAnneeBissextileSiecle() {
        // 2000 est divisible par 400 → bissextile
        Date d = new Date(28, 2, 2000);
        d.incrementer();
        assertEquals("29/fevrier/2000", d.toString());
        d.incrementer();
        assertEquals("1/mars/2000", d.toString());
    }

    @Test
    void testPassage31DecembreVersNouvelleAnnee() {
        Date d = new Date(31, 12, 1999);
        d.incrementer();
        assertEquals("1/janvier/2000", d.toString(), "Doit bien passer à l’an 2000");
    }

    @Test
    void testAnterieureAvecGrandEcart() {
        Date debut = new Date(1, 1, 2020);
        Date fin = new Date(1, 1, 2030);
        assertTrue(debut.anterieure(fin));
        assertFalse(fin.anterieure(debut));
    }

    @Test
    void testEcartSurPlusieursAnnees() {
        Date d1 = new Date(1, 1, 2020);
        Date d2 = new Date(1, 1, 2021);
        assertEquals(366, d1.ecart(d2), "2020 est bissextile → 366 jours d’écart");
    }

    @Test
    void testEcartInverse() {
        Date d1 = new Date(1, 1, 2024);
        Date d2 = new Date(5, 1, 2024);
        assertEquals(4, d1.ecart(d2));
        assertEquals(4, d2.ecart(d1), "L'écart doit être symétrique");
    }

    @Test
    void testComparaisonsEgalesEtOrdre() {
        Date dA = new Date(15, 5, 2025);
        Date dB = new Date(15, 5, 2025);
        Date dC = new Date(16, 5, 2025);

        assertTrue(dA.egale(dB));
        assertFalse(dA.anterieure(dB));
        assertFalse(dA.posterieure(dB));
        assertTrue(dA.anterieure(dC));
        assertTrue(dC.posterieure(dA));
    }

    @Test
    void testLendemainSurFevrierBissextile() {
        Date d = new Date(28, 2, 2024);
        Date lend = d.lendemain();
        assertEquals("29/fevrier/2024", lend.toString());
    }

    @Test
    void testLendemainSurFinAnnee() {
        Date d = new Date(31, 12, 2024);
        Date lend = d.lendemain();
        assertEquals("1/janvier/2025", lend.toString());
    }

    @Test
    void testLongEcartPlusieursAnnees() {
        Date debut = new Date(1, 1, 2000);
        Date fin = new Date(1, 1, 2005);
        int ecart = debut.ecart(fin);
        assertTrue(ecart >= 1825 && ecart <= 1827, "L’écart sur 5 ans doit tenir compte des années bissextiles");
    }
}

