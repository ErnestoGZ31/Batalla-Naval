import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa las columnas del tablero: ");
        int tableroColumnas = scanner.nextInt();
        System.out.print("Ingresa las filas del tablero: ");
        int tablefroFilas = scanner.nextInt();
        if (tableroColumnas < 4 || tablefroFilas < 3) {
            System.out.println("El tablero debe ser de un tamaño mínimo de 4 x 3");
            System.exit(0);
        }
        for (int i = 1; i <= tableroColumnas; i++) {

            if (i <= 1) {
                System.out.print("  ");
            }
            if (i < 10) {
                System.out.print("0");
            }
            System.out.print(i + " ");
            if (i == tableroColumnas) {
                System.out.println("");
            }

        }

        for (int i = 1; i <= tablefroFilas; i++) {
            for (int j = 1; j <= tableroColumnas; j++) {
                if (j <= 1) {

                    if (i < 10) {
                        System.out.print("0");
                    }
                    System.out.print(i + " ");
                }
                System.out.print("*" + "  ");
            }

            System.out.println("");
        }
    }
}