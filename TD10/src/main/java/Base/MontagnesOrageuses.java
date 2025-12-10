package TD10.src.main.java.Base;

import java.util.Random;

public class MontagnesOrageuses {
    private EO ensOrques;
    private Orque vainqueur;

    public MontagnesOrageuses(int nbo) {
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
            if(r.nextInt(10) < 6) { // 60% de change de frapper 1 des deux orques
                tabOrque[r.nextInt(1)].pertePV(20);
            }


            Orque gagnant = o1.duel(o2);
            gagnant.regenPV(5); // regen fin d'un combat
            this.ensOrques.ajoutElt(gagnant);
        }
        this.vainqueur = this.ensOrques.selectDernierElt();
        return this.vainqueur;
    }
}

