package TD10.src.main.java.Base;

public class MainCombat {

    public static void main(String[] args) {
        LieuCombat l = new Arene(2);
        Orque winner = l.bataille();
        System.out.println("\n=====WINNER ARENE : " + winner);

        l = new Forets(3);
        winner = l.bataille();
        System.out.println("\n=====WINNER FORET: " + winner);

        l = new MontagnesOrageuses(3);
        winner = l.bataille();
        System.out.println("\n=====WINNER MONTAGNE: " + winner);

        l = new Desert(3);
        winner = l.bataille();
        System.out.println("\n=====WINNER DESERT: " + winner);

        Orque o = Orque.getLegende();
        System.out.println("\n=====ORQUE LEGENDE " + o);
    }
}