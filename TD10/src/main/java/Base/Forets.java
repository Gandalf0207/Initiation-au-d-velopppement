package TD10.src.main.java.Base;

import java.util.Random;

public class Forets {
    private EO ensOrques;
    private Orque vainqueur;

    public Forets(int nbo) {
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

            Orque[] tabOrque = {o1, o2};

            // perte pv random
            tabOrque[r.nextInt(1)].pertePV(5);


            Orque gagnant = o1.duel(o2);
            gagnant.regenPV(20); // regen fin d'un combat
            this.ensOrques.ajoutElt(gagnant);
        }
        this.vainqueur = this.ensOrques.selectDernierElt();
        return this.vainqueur;
    }
}
