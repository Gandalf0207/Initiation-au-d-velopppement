package TD7.Test;

import static org.junit.jupiter.api.Assertions.*;

import TD7.Fichier.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionTest {

    private Fraction f1;
    private Fraction f2;
    private Fraction f3;

    @BeforeEach
    void setUp() {
        f1 = new Fraction(2, 4);   // équivaut à 1/2 après réduction
        f2 = new Fraction(3, 9);   // équivaut à 1/3 après réduction
        f3 = new Fraction(f1);     // copie de f1
    }

    @Test
        // Test 1 - Constructeur simple
    void testConstructeurSimple() {
        assertEquals("2/4", f1.toString());
        assertEquals("3/9", f2.toString());
    }

    @Test
        // Test 2 - Constructeur par recopie
    void testConstructeurParRecopie() {
        assertEquals(f1.toString(), f3.toString());
        assertNotSame(f1, f3); // doit être une nouvelle instance
    }

    @Test
        // Test 3 - Méthode toString()
    void testToString() {
        Fraction f = new Fraction(5, 7);
        assertEquals("5/7", f.toString());
    }

    @Test
        // Test 4 - Réduction de fraction
    void testReduire() {
        f1.reduire();
        assertEquals("1/2", f1.toString());
        f2.reduire();
        assertEquals("1/3", f2.toString());
    }

    @Test
        // Test 5 - Fraction avec dénominateur négatif
    void testFractionNegativeDenominateur() {
        Fraction f = new Fraction(2, -6);
        f.reduire();
        assertEquals("2/-6", new Fraction(2, -6).toString());
        assertEquals("1/-3", f.toString());
    }

    @Test
        // Test 6 - Fraction doublement négative
    void testFractionDoublementNegative() {
        Fraction f = new Fraction(-4, -8);
        f.reduire();
        assertEquals("-1/-2", f.toString());
    }

    @Test
        // Test 7 - Méthode fractionReduite()
    void testFractionReduite() {
        Fraction reduite = f1.fractionReduite();
        assertEquals("1/2", reduite.toString());
        assertEquals("2/4", f1.toString(), "f1 ne doit pas être modifiée");
    }

    @Test
        // Test 8 - Multiplication simple
    void testMultiplication() {
        Fraction resultat = f1.multiplication(f2);
        assertEquals("6/36", resultat.toString());
        resultat.reduire();
        assertEquals("1/6", resultat.toString());
    }

    @Test
        // Test 9 - Inverse d’une fraction simple
    void testInverseSimple() {
        Fraction f = new Fraction(2, 3);
        Fraction inv = f.inverse();
        assertEquals("3/2", inv.toString());
        assertEquals("2/3", f.toString(), "La fraction d’origine ne doit pas être modifiée");
    }

    @Test
        // Test 10 - Inverse d’une fraction négative
    void testInverseNegative() {
        Fraction f = new Fraction(-2, 5);
        Fraction inv = f.inverse();
        assertEquals("5/-2", inv.toString());
    }

    @Test
        // Test 11 - Inverse avec dénominateur négatif
    void testInverseDenominateurNegatif() {
        Fraction f = new Fraction(2, -3);
        Fraction inv = f.inverse();
        assertEquals("-3/2", inv.toString());
    }

    @Test
        // Test 12 - Inverse avec double négatif
    void testInverseDoubleNegative() {
        Fraction f = new Fraction(-2, -3);
        Fraction inv = f.inverse();
        assertEquals("-3/-2", inv.toString());
    }

    @Test
        // Test 13 - Puissance zéro
    void testPuissanceZero() {
        Fraction result = f1.puissance(0);
        assertEquals("1/1", result.toString());
    }

    @Test
        // Test 14 - Puissance positive
    void testPuissancePositive() {
        Fraction f = new Fraction(2, 3);
        Fraction result = f.puissance(3);
        assertEquals("8/27", result.toString());
    }

    @Test
        // Test 15 - Puissance avec fraction négative
    void testPuissanceAvecFractionNegative() {
        Fraction f = new Fraction(-2, 3);
        Fraction result = f.puissance(3);
        assertEquals("-8/27", result.toString(), "Puissance impaire conserve le signe négatif");
        result = f.puissance(2);
        assertEquals("4/9", result.toString(), "Puissance paire rend le résultat positif");
    }

    @Test
        // Test 16 - Fraction avec numérateur négatif
    void testFractionNegativeNumerateur() {
        Fraction f = new Fraction(-2, 6);
        f.reduire();
        assertEquals("-1/3", f.toString());
    }

    @Test
        // Test 17 - Multiplication avec fraction négative
    void testMultiplicationAvecNegatif() {
        Fraction fPos = new Fraction(1, 2);
        Fraction fNeg = new Fraction(-3, 5);
        Fraction resultat = fPos.multiplication(fNeg);
        assertEquals("-3/10", resultat.toString());
    }

    @Test
        // Test 18 - Division simple
    void testDivisionSimple() {
        Fraction f = f1.division(f2); // (1/2) / (1/3) = 3/2
        assertEquals("3/2", f.toString());
    }

    @Test
        // Test 19 - Division avec fraction négative
    void testDivisionAvecNegatif() {
        Fraction f = f1.division(new Fraction(-1,2)); // (1/2)/(-1/2) = -1
        assertEquals("1/-1", f.toString());
    }

    @Test
        // Test 20 - Division avec dénominateur négatif
    void testDivisionAvecDenominateurNegatif() {
        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(1, -4);
        Fraction result = a.division(b); // (2/3)/(1/-4) = -8/3
        assertEquals("-8/3", result.toString());
    }


    @Test
        // Test 21 - Division après inversion
    void testOperationsInverseDivision() {
        Fraction a = new Fraction(5, 6);
        Fraction b = new Fraction(2, 3);
        Fraction result = a.division(b.inverse()); // (5/6)/(3/2) = 5/9
        assertEquals("5/9", result.toString());
    }

}

