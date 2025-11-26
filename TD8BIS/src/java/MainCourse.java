package TD8BIS.src.java;

public class MainCourse {

    public static void main(String[] args) {

        vehicule v1 = new Voiture("Bob", 2);
        vehicule v2 = new Velo("Alice", 3);
        Course c = new Course(v1, v2, 60);
        System.out.println(v1);
        System.out.println(v2);
        v1 = c.deroulement();
        System.out.println("Gagnant : " + v1);
    }
}
