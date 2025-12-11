package TD10.src.main.java.Base;

public class Arene implements LieuCombat {
    private EO ensOrques;


    public Arene(int nbo) {
        this.ensOrques = new EO(nbo);
        for (int i = 0; i < nbo; i++) {
            this.ensOrques.ajoutElt(new Orque());
        }
    }

    public void effetAvantCombat(Orque orque) {
        orque.pertePV(5); // perte pv random
    }

    public void effetApresCombat(Orque gagnant) {
        gagnant.regenPV(5); // regen fin d'un combat
    }

    public EO getEnsOrque() {
        return this.ensOrques;
    }
}
