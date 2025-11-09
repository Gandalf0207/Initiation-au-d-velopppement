package TD7.Test;

import static org.junit.jupiter.api.Assertions.*;

import TD7.Fichier.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FractionAffichageNegatifTest {

    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;

    @BeforeEach
    void setUp() {
        f1 = new Fraction(1, -2);   // devient -1/2
        f2 = new Fraction(-1, 3);   // reste -1/3
        f3 = new Fraction(-2, -5);  // devient 2/5
        f4 = new Fraction(3, 4);    // reste 3/4
    }


    @Test
        // Test 1 - Dénominateur négatif → signe sur le numérateur
    void testAffichageDenominateurNegatif() {
        assertEquals("-1/2", f1.toString());
    }

    @Test
        // Test 2 - Numérateur négatif → affichage inchangé
    void testAffichageNumerateurNegatif() {
        assertEquals("-1/3", f2.toString());
    }

    @Test
        // Test 3 - Double négatif → devient positif
    void testAffichageDoubleNegatif() {
        assertEquals("2/5", f3.toString());
    }

    @Test
        // Test 4 - Fraction positive → affichage normal
    void testAffichagePositive() {
        assertEquals("3/4", f4.toString());
    }


    @Test
        // Test 5 - Réduction avec dénominateur négatif
    void testReductionAvecSignes() {
        Fraction f = new Fraction(2, -4); // doit devenir -1/2
        f.reduire();
        assertEquals("-1/2", f.toString());
    }

    @Test
        // Test 6 - Réduction double négatif → devient positive
    void testReductionDoubleNegatif() {
        Fraction f = new Fraction(-6, -9); // doit devenir 2/3
        f.reduire();
        assertEquals("2/3", f.toString());
    }


    @Test
        // Test 7 - Multiplication simple avec signes
    void testMultiplicationAvecSignes() {
        Fraction f = new Fraction(-1, 2);
        Fraction g = new Fraction(3, -4);
        Fraction resultat = f.multiplication(g); // (-1/2)*(3/-4)=3/8
        assertEquals("3/8", resultat.toString());
    }

    @Test
        // Test 8 - Multiplication négatif * positif
    void testMultiplicationNegatifPositif() {
        Fraction f = new Fraction(-1, 3);
        Fraction g = new Fraction(2, 5);
        Fraction resultat = f.multiplication(g); // (-1/3)*(2/5)=-2/15
        assertEquals("-2/15", resultat.toString());
    }

    @Test
        // Test 9 - Division simple avec signe
    void testDivisionSimple() {
        Fraction f = new Fraction(1, 2);
        Fraction g = new Fraction(1, -3);
        Fraction resultat = f.division(g); // (1/2)/(1/-3) = (1/2)*(-3/1) = -3/2
        assertEquals("-3/2", resultat.toString());
    }

    @Test
        // Test 10 - Division double négatif → positif
    void testDivisionDoubleNegatif() {
        Fraction f = new Fraction(-1, 2);
        Fraction g = new Fraction(1, -3);
        Fraction resultat = f.division(g); // (-1/2)/(1/-3) = (-1/2)*(-3/1) = 3/2
        assertEquals("3/2", resultat.toString());
    }

    @Test
        // Test 11 - Inverse d’une fraction négative
    void testInverseFractionNegative() {
        Fraction f = new Fraction(-2, 3);
        Fraction inv = f.inverse(); // → 3/-2 → -3/2
        assertEquals("-3/2", inv.toString());
    }

    @Test
        // Test 12 - Inverse avec dénominateur négatif
    void testInverseDenominateurNegatif() {
        Fraction f = new Fraction(2, -3);
        Fraction inv = f.inverse(); // → (-3)/2 = -3/2
        assertEquals("-3/2", inv.toString());
    }

    @Test
        // Test 13 - Inverse double négatif → positif
    void testInverseDoubleNegatif() {
        Fraction f = new Fraction(-2, -3);
        Fraction inv = f.inverse(); // → (-3)/(-2) = 3/2
        assertEquals("3/2", inv.toString());
    }

    @Test
        // Test 14 - Puissance positive avec fraction négative
    void testPuissancePositiveNegative() {
        Fraction f = new Fraction(-2, 3);
        Fraction resultat = f.puissance(3); // (-2/3)^3 = -8/27
        assertEquals("-8/27", resultat.toString());
    }

    @Test
        // Test 15 - Puissance paire → résultat positif
    void testPuissancePairePositive() {
        Fraction f = new Fraction(-2, 3);
        Fraction resultat = f.puissance(2); // (-2/3)^2 = 4/9
        assertEquals("4/9", resultat.toString());
    }


}
