package TD7.Fichier;

public class Date {
    private int d;
    private int m;
    private int y;
    private String[] moisLettres = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "decembre"} ;

    public Date(int jour, int mois, int an) {
        this.d = jour;
        this.m = mois;
        this.y = an;
    }
    public Date(Date d){
        this.d = d.d;
        this.m = d.m;
        this.y = d.y;
    }

    public String toString() {
        return this.d + "/" + this.moisLettres[this.m -1] + "/" + this.y;
    }

    public int nbJoursMois () {
        int[] jMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(this.m == 2 && this.estBisextile()) {
            return 29;
        } else {
            return jMois[this.m-1];
        }
    }

    public void incrementer(){
        if(this.d +1 <= this.nbJoursMois()) {
            this.d++;
        }
        else if (this.m+1 <=12 ){
            this.d = 1;
            this.m ++;
        } else {
            this.d = 1;
            this.m = 1;
            this.y ++;
        }

    }

    public Date lendemain () {
        Date newDate = new Date(this);
        newDate.incrementer();
        return newDate;
    }

    public boolean egale (Date d){
        return this.d == d.d && this.m == d.m && this.y == d.y;
    }

    public boolean anterieure (Date d){
        if(egale(d)) {
            return false;
        }
        else {
            if(this.y == d.y) {
                if(this.m == d.m){
                    return this.d < d.d;
                }
                else {
                    return this.m < d.m;
                }
            }
            else {
                return this.y < d.y;
            }
        }
    }

    public boolean posterieure (Date d){
        if(egale(d)) {
            return false;
        }
        else {
            if(this.y == d.y) {
                if(this.m == d.m){
                    return this.d > d.d;
                }
                else {
                    return this.m > d.m;
                }
            }
            else {
                return this.y > d.y;
            }
        }
    }

    public int ecart (Date d) {
        Date actuelle = new Date(this);
        Date newDate = new Date(d);
        if (egale(d)) {
            return 0;
        }
        else {
            int cpt = 0;
            if(anterieure(d)){ // this est avant d
                do {
                    cpt++;
                    actuelle.incrementer();
                } while(!newDate.egale(actuelle));
            }
            else { // this est après d
                do {
                    cpt++;
                    newDate.incrementer();
                } while(!actuelle.egale(newDate));
            }
            return cpt;
        }
    }

    private boolean estBisextile() {
        if(this.y%400 == 0) {
            return true;
        } else if (this.y%4 == 0 && this.y % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }


}

