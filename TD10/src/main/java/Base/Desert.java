package TD10.src.main.java.Base;

public class Desert implements LieuCombat {
    private EO ensOrques;


    public Desert(int nbo) {
        this.ensOrques = new EO(nbo);
        for (int i = 0; i < nbo; i++) {
            this.ensOrques.ajoutElt(new Orque());
        }
    }

    public void effetAvantCombat(Orque orque) {
        orque.pertePV(10); // perte pv random
    }

    public void effetApresCombat(Orque gagnant) {
        gagnant.pertePV(15); // regen fin d'un combat
    }

    public EO getEnsOrque() {
        return this.ensOrques;
    }
}