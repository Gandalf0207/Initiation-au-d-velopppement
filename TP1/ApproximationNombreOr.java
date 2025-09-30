
public class ApproximationNombreOr {
    
    /**
     * Fonction suiteOrOrdre: calcule les valeurs de i, Vi et P(Vi)
     * pour i de 2 à n (strictement supérieur à 2)
     * @param n entier strictement supérieur à 2
     */
    public static void suiteOrOrdre(int n) {
        if (n <= 2) {
            System.out.println("Erreur: n doit être strictement supérieur à 2");
            return;
        }
        
        System.out.println("Suite pour n = " + n);
        System.out.println("i\tVi\t\tP(Vi)");
        System.out.println("----------------------------------------");
        
        for (int i = 2; i <= n; i++) {
            double Vi = calculerVi(i);
            double PVi = calculerP(Vi);
            System.out.printf("%d\t%.10f\t%.10f%n", i, Vi, PVi);
        }
        System.out.println();
    }
    
    /**
     * Calcule Vi = (1 + sqrt(5)) / 2 élevé à la puissance i
     * @param i l'exposant
     * @return Vi
     */
    private static double calculerVi(int i) {
        double phi = (1 + Math.sqrt(5)) / 2; // nombre d'or
        return Math.pow(phi, i);
    }
    
    /**
     * Calcule P(x) = x² - x - 1
     * @param x la valeur
     * @return P(x)
     */
    private static double calculerP(double x) {
        return x * x - x - 1;
    }
    
    /**
     * Fonction suiteOrEpsilon: affiche les valeurs de i, Vi et P(Vi)
     * pour lesquelles |Vi - phi| < epsilon, à partir de i = 2
     * @param epsilon le seuil de précision
     */
    public static void suiteOrEpsilon(double epsilon) {
        if (epsilon <= 0) {
            System.out.println("Erreur: epsilon doit être strictement positif");
            return;
        }
        
        double phi = (1 + Math.sqrt(5)) / 2; // nombre d'or exact
        System.out.println("Suite avec epsilon = " + epsilon);
        System.out.println("Nombre d'or exact: " + phi);
        System.out.println("\ni\tVi\t\tP(Vi)\t\t|Vi - phi|");
        System.out.println("------------------------------------------------------------");
        
        int i = 2;
        boolean trouve = false;
        
        while (!trouve) {
            double Vi = Math.pow(phi, i);
            double PVi = calculerP(Vi);
            double difference = Math.abs(Vi - phi);
            
            if (difference < epsilon) {
                System.out.printf("%d\t%.10f\t%.10f\t%.15f%n", i, Vi, PVi, difference);
                trouve = true;
            }
            
            i++;
            
            // Sécurité pour éviter une boucle infinie
            if (i > 1000) {
                System.out.println("Limite d'itérations atteinte");
                break;
            }
        }
        System.out.println();
    }
    
    /**
     * Calcule une valeur approchée du nombre d'or avec la racine de P(x)
     * @return approximation du nombre d'or
     */
    public static double calculerNombreOrApproxime() {
        // Résolution de x² - x - 1 = 0
        // x = (1 ± sqrt(5)) / 2
        // On prend la racine positive
        return (1 + Math.sqrt(5)) / 2;
    }
    
    /**
     * Méthode main pour tester les fonctions
     */
    public static void main(String[] args) {
        System.out.println("=== APPROXIMATION DU NOMBRE D'OR ===\n");
        
        // Calcul de la valeur exacte du nombre d'or
        double phi = calculerNombreOrApproxime();
        System.out.println("Nombre d'or (valeur exacte en double): " + phi);
        System.out.println("Formule: (1 + √5) / 2\n");
        
        // Test de suiteOrOrdre avec n = 10
        System.out.println("--- Test 1: suiteOrOrdre(10) ---");
        suiteOrOrdre(10);
        
        // Test de suiteOrEpsilon avec différentes valeurs d'epsilon
        System.out.println("--- Test 2: suiteOrEpsilon(0.1) ---");
        suiteOrEpsilon(0.1);
        
        System.out.println("--- Test 3: suiteOrEpsilon(0.01) ---");
        suiteOrEpsilon(0.01);
        
        System.out.println("--- Test 4: suiteOrEpsilon(0.001) ---");
        suiteOrEpsilon(0.001);
        
        // Vérification de P(phi) ≈ 0
        System.out.println("--- Vérification ---");
        System.out.println("P(φ) = φ² - φ - 1 = " + calculerP(phi));
        System.out.println("Cette valeur devrait être très proche de 0.");
    }
}