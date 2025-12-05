package TD10.src.main.java.Base;

import java.util.Random;

public class Arene {
    private EO ensOrques;
    private Orque vainqueur;

    public Arene(int nbo) {
        this.ensOrques = new EO(nbo);
        for (int i = 0; i < nbo; i++) {
            this.ensOrques.ajoutElt(new Orque());
        }
    }

    public Orque bataille() {
        Random r = new Random();
        while (this.ensOrques.getCardinal() != 1) {
            Orque o1 = this.ensOrques.retraitEltAleatoirement();
            Orque o2 = this.ensOrques.retraitEltAleatoirement();

            Orque gagnant = o1.duel(o2);
            this.ensOrques.ajoutElt(gagnant);
        }
        this.vainqueur = this.ensOrques.selectDernierElt();
        return this.vainqueur;
    }
}
