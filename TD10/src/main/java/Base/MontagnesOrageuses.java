package TD10.src.main.java.Base;


import java.util.Random;

public class MontagnesOrageuses implements LieuCombat {
    private EO ensOrques;
    Random r = new Random();

    public MontagnesOrageuses(int nbo) {
        this.ensOrques = new EO(nbo);
        for (int i = 0; i < nbo; i++) {
            this.ensOrques.ajoutElt(new Orque());
        }
    }

    public void effetAvantCombat(Orque orque) {
        if (r.nextInt(10) < 6) { // 60% de change de frapper 1 des deux orques
            orque.pertePV(20); // perte pv random
            System.out.println(String.format("CIBLE DE LA FOUDRE Orque{%s, score= %s, pointsDeVie= %S, arme= %s\n", orque, orque.getScore(), orque.getPV(), orque.getArme()));
        }
    }

    public void effetApresCombat(Orque gagnant) {
        gagnant.regenPV(5); // regen fin d'un combat
        System.out.println(String.format("=====COMPORTEMENT PAR DEFAUT +5PDV pour Orque{%s, score= %s, pointsDeVie= %s, arme= %s\n", gagnant, gagnant.getScore(), gagnant.getPV(), gagnant.getArme()));

    }

    public EO getEnsOrque() {
        return this.ensOrques;
    }

    public void AfficherLieu() {
        System.out.println("===== COMBAT EN MONTAGNE ORAGEUSE =====\n");
    }

}

