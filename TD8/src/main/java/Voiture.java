package TD8.src.main.java;

public class Voiture {

    // Attributs à définir
    private String nom;
    private int vitesse;
    private int position;
    private int sens;
    private int nbLongPiste;
    /**
     * Pré-requis : (à compléter)
     * Action : crée une voiture de nom unNom et de vitesse uneVitesse
     * placée à l’origine
     */
    public Voiture(String unNom, int uneVitesse) {
        this.nom = unNom;
        this.vitesse = uneVitesse;
        this.position = 0;
        this.sens = 1;
        this.nbLongPiste = 0;
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
    public void avance(int longueur) {
        this.position += this.vitesse*this.sens;
        if(this.position >= longueur || this.position <= 0) {
            this.position = (this.position>longueur) ? longueur:0;
            faireDemiTour();
            this.nbLongPiste++;
        }
    }

    public void avancerAvecRebondissement(int longueur) {
        this.position += this.vitesse*this.sens;
        if(this.position >= longueur || this.position <= 0) {
            this.position = (this.position>=longueur) ? longueur-(this.position-longueur):this.position*-1;
            faireDemiTour();
            this.nbLongPiste++;
        }
    }
    /**
     * Action : fait faire demi tour à la voiture -> change son sens
     * */
    private void faireDemiTour() {
        this.sens *= -1;
    }

    /**
     * Action : retourne un boolean indiquant si la voiture a parcourue plus ou moins de tours que le nombre donnée.
     * */
    public boolean aParcourue(int nbLongueurs) {
        return this.nbLongPiste >= nbLongueurs;
    }


}