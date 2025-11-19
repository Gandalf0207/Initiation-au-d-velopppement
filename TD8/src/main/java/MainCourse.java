package TD8.src.main.java;

public class MainCourse {

    public static void main(String[] args) {
        Voiture voit1 = new Voiture("G", 3);
        Voiture voit2 = new Voiture("H", 7);

        Course itemCourse = new Course(voit1, voit2, 45, 5);

        itemCourse.toString();
        Voiture voitureGagante = itemCourse.deroulement();

        System.out.println(String.format("C'est la voiture %s qui remporte la course", voitureGagante.getNom()));

    }
}
