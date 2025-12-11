package TD10.src.main.java.Base;

public class Forets implements LieuCombat {
    private EO ensOrques;

    public Forets(int nbo) {
        this.ensOrques = new EO(nbo);
        for (int i = 0; i < nbo; i++) {
            this.ensOrques.ajoutElt(new Orque());
        }
    }

    public void effetAvantCombat(Orque orque) {
        orque.pertePV(5); // perte pv random
        System.out.println(String.format("=====COMPORTEMENT PAR DEFAUT -5PDV pour Orque{%s, score=%s, pointsDeVie=%s, arme=%s}\n", orque, orque.getScore(), orque.getPV(), orque.getArme()));

    }

    public void effetApresCombat(Orque gagnant) {
        gagnant.regenPV(20); // regen fin d'un combat
        System.out.println(String.format("=====CACHETTE EN FORET POUR REGENERER DE 20 PDV pour Orque{%s, score= %s, pointsDeVie= %s, arme= %S\n", gagnant, gagnant.getScore(), gagnant.getPV(), gagnant.getArme()));

    }

    public EO getEnsOrque() {
        return this.ensOrques;
    }

    public void AfficherLieu() {
        System.out.println("===== COMBAT EN FORET =====\n");
    }

}
