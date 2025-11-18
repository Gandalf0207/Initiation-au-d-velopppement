package TD8BIS.src.java;

public class MainCourse {

    public static void main(String[] args) {

        Voiture v1 = new Voiture("Bob" , 2);
        Voiture v2 = new Voiture("Alice" , 3);
        Course c = new Course(v1,v2,20);
        v1 = c.deroulement();
        System.out.println("Gagnant : " + v1);
    }
}
