package Aufagbe_1;

import java.util.Scanner;

public class Quader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gebe die a b c Längen deines Quaders ein");
        System.out.print("a :");
        double a = scanner.nextDouble();
        System.out.print("b :");
        double b = scanner.nextDouble();
        System.out.print("c :");
        double c = scanner.nextDouble();


        double kantenlänge =  4*a + 4*b + 4*c;
        System.out.println("Deine Kantenlänge ist: " + kantenlänge);

        double oberflaeche = (a*b)*2 + (a*c)*4;
        System.out.println("Deine Oberfläche ist: " + oberflaeche);

        double volumen = a*b*c;
        System.out.println("Dein Volumen ist: " + volumen);



    }
}
