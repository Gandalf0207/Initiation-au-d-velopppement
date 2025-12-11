package TD10.src.main.java.Base;

import java.util.Random;

public interface LieuCombat {
    void effetAvantCombat(Orque orque);

    void effetApresCombat(Orque orque);

    EO getEnsOrque();

    void AfficherLieu();


    default Orque bataille() {

        EO ensOrques = getEnsOrque();
        Random r = new Random();

        // affichage
        AfficherLieu();


        while (ensOrques.getCardinal() != 1) {

            // on prend 2 orques
            Orque o1 = ensOrques.retraitEltAleatoirement();
            Orque o2 = ensOrques.retraitEltAleatoirement();

            // effet avant combat
            Orque[] tabOrque = {o1, o2};
            effetAvantCombat(tabOrque[r.nextInt(1)]);

            // duel
            Orque gagnant = o1.duel(o2);

            // effet après combat
            effetApresCombat(gagnant);

            // remise du gagant dans la liste
            ensOrques.ajoutElt(gagnant);
        }

        return ensOrques.selectDernierElt(); // vainqueur
    }


}
