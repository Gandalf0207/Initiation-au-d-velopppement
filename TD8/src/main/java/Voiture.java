package TD8.src.main.java;

public class Voiture {

    // Attributs à définir
    private String nom;
    private int vitesse;
    private int position;
    /**
     * Pré-requis : (à compléter)
     * Action : crée une voiture de nom unNom et de vitesse uneVitesse
     * placée à l’origine
     */
    public Voiture(String unNom, int uneVitesse) {
        this.nom = unNom;
        this.vitesse = uneVitesse;
        this.position = 0;
    }

    /**
     *
     * Action : reourne le nom
     */
    public String getNom() {
        return this.nom;
    }


    /**
     * Résultat : retourne une chaîne de caractères contenant les caractéristiques
     * de this (sous la forme de votre choix)
     */
    public String toString() {
        return String.format("nom : %s \nvitesse : %d \nposition : %d", this.nom, this.vitesse, this.position);
    }

    /**
     * Résultat : retourne une chaîne de caractères formée d’une suite d’espaces
     * suivie de la première lettre du nom de this, suivie d’un retour
     * à la ligne, le nombre d’espaces étant égal à la position de this.
     */
    public String affiche() {
        String s = "";
        for(int i = 0; i < this.position; i++) {
            s+=" ";
        }
        s+=String.format("%s\n", this.nom);

        return s;    }

    /**
     * Résultat : retourne vrai si et seulement si la position de this est
     * supérieure ou égale à limite
     */
    public boolean depasse(int limite) {
        return this.position >= limite;
    }

    /**
     * place this au départ, c-a-d à l'origine
     */
    public void placerAuDepart(){
        this.position = 0;
    }

    /**
     * Pré-requis : (à compléter)
     * Action : fait avancer this d’une distance égale à sa vitesse
     */
    public void avance() {
        this.position += this.vitesse;
    }
}