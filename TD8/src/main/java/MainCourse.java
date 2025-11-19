package TD8.src.main.java;

public class MainCourse {

    public static void main(String[] args) {
        Voiture voit1 = new Voiture("G", 1);
        Voiture voit2 = new Voiture("H", 1);

        Course itemCourse = new Course(voit1, voit2, 57);

        itemCourse.toString();
        Voiture voitureGagante = itemCourse.deroulement();

        System.out.println(String.format("C'est la voiture %s qui remporte la course", voitureGagante.getNom()));

    }
}
