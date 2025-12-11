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
        System.out.println(String.format("=====TEMPETE DE SABLE perte de 10 PDV pour Orque{%s, score= %s, pointsDeVie= %s, arme= %S\n", orque, orque.getScore(), orque.getPV(), orque.getArme()));
    }

    public void effetApresCombat(Orque gagnant) {
        gagnant.pertePV(15); // regen fin d'un combat
        System.out.println(String.format("=====OASIS INEXISTANTE perte de 15 PDV pour Orque{%s, score= %s, pointsDeVie= %s, arme= %S\n", gagnant, gagnant.getScore(), gagnant.getPV(), gagnant.getArme()));
    }

    public EO getEnsOrque() {
        return this.ensOrques;
    }

    public void AfficherLieu() {
        System.out.println("===== COMBAT EN MONTAGNE ORAGEUSE =====\n");
    }
}