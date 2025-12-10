package TD10.src.main.java.Base;

import java.util.Random;

public class Orque {
    private int id;
    private int score = 0;
    private int pv = 100;
    private Arme arme;

    private static int nextId = 0;
    private static Orque legende = null;

    private Random r = new Random();


    public Orque() {
        this.id = Orque.nextId;
        Orque.nextId++;
        arme = new Arme();
    }

    public Orque duel(Orque o) {

        while (o.pv > 0 && this.pv > 0) {

            int x = r.nextInt(1);

            if (x == 0) {
                taper(this, o);
            } else {
                taper(o, this);
            }
        }

        if (this.estVivant()) {
            this.score++;
            o.miseAJourLegende();
            return this;
        } else {
            o.score++;
            this.miseAJourLegende();
            return o;
        }
    }

    public void taper(Orque attaquant, Orque defenseur) {

        if (r.nextInt(101) < attaquant.arme.getCouleur().getPourcentage()) {
            defenseur.pv -= attaquant.arme.getType().getValue();
        }

        if (defenseur.pv <= 0) {
            defenseur.meurt();
        }
    }

    public void pertePV(int nb) {
        if(this.pv - nb <=0) {
            this.pv -= Math.abs(this.pv -nb) + 1;
        }
        else {
            this.pv -= nb;
        }
    }

    public void regenPV(int nb) {
        if(this.pv + nb > 100) {
            this.pv += nb - (this.pv+nb -100);
        }
        else {
            this.pv += nb;
        }
    }

    public void meurt() {
        this.pv = 0;
    }

    public boolean estVivant() {
        return this.pv > 0;
    }

    public void miseAJourLegende() {
        if (Orque.legende == null) {
            Orque.legende = this;
        } else if (this.score > Orque.legende.score) {
            Orque.legende = this;
        }
    }

    public String toString() {
        return String.format("Orque n°id : %s", this.id);
    }

    public Orque getLegend() {
        return this.legende;
    }
}
