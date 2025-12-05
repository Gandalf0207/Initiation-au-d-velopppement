package TD10.src.main.java.Base;

import java.util.Random;

public class Orque {
    private int id;
    private int score = 0;
    private static int nextId = 0;
    private static Orque legende = null;

    void Orque() {
        this.id = Orque.nextId;
        Orque.nextId++;
    }

    public Orque duel(Orque o) {
        Random r = new Random();
        int x = r.nextInt(1);

        if (x == 0) {
            this.score++;
            this.miseAJourLegende();
            o.meurt();
            return this;
        } else {
            this.score++;
            this.miseAJourLegende();
            this.meurt();
            return o;
        }
    }

    public void meurt() {
        int a = 2;
    }

    public void miseAJourLegende() {
        if (this.score > Orque.legende.score) {
            Orque.legende = this;
        }
    }

    public String toString() {
        return String.format("Orque n°id : %s", this.id);
    }
}
