package TD10.src.main.java.Base;

import java.util.Random;

public class Orque {
    private int id;
    private int score = 0;
    private int pv = 100;
    private Arme arme;

    private static int nextId = 0;
    private static Orque legende = null;

    public Orque() {
        this.id = Orque.nextId;
        Orque.nextId++;
        arme = new Arme();
    }

    public Orque duel(Orque o) {
        Random r = new Random();


        while (o.pv > 0 && this.pv > 0) {

            int x = r.nextInt(1);
            // il faut faire les dégats :
            if (x == 0) {
                this.score++;
                o.miseAJourLegende();
                o.meurt();
                return this;
            } else {
                o.score++;
                this.miseAJourLegende();
                this.meurt();
                return o;
            }
        }
    }

    public void meurt() {
        this.pv = 0;
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
