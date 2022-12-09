import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> nombres=new ArrayList<String>();
        ArrayList<Integer>botes=new ArrayList<Integer>();
        ArrayList<Integer>puntos=new ArrayList<Integer>();
        Scanner leer=new Scanner(System.in);
        Scanner leer1=new Scanner(System.in);
        Scanner leer2=new Scanner(System.in);
        int tamanioTablero=0, cantBotes1=0, cantBotes2=0, ganador=0;
        String[][] TJugador1=null;
        String[][] TJugador2=null;
        String[][] TableroVacio_J1=null;
        String[][] TableroVacio_J2=null;
        String nameJugador;
        int puntuacionJugador1=0,puntuacionJugador2=0,p=0;
        System.out.println("Bienvenido a Batalla Naval");
        while(p==0) {
            System.out.print("Ingresa las dimensiones del tablero(minimo 2)(lxl): ");
            tamanioTablero = leer.nextInt();
            if(tamanioTablero>1){
                p=1;
            }
            else{
                System.out.println("valor no permitido\n intentalo de nuevo");
            }
        }
        TJugador1= new String[tamanioTablero] [tamanioTablero];
        TJugador2= new String[tamanioTablero] [tamanioTablero];
        TableroVacio_J1= new String[tamanioTablero] [tamanioTablero];
        TableroVacio_J2= new String[tamanioTablero] [tamanioTablero];
        System.out.println("Forma del tablero");
        TJugador1=Creartablero(TJugador1);
        TJugador2=Creartablero(TJugador2);
        TableroVacio_J1=Creartablero(TableroVacio_J1);
        TableroVacio_J2=Creartablero(TableroVacio_J2);
        imprimirTablero(TJugador1);
        System.out.println("-------------JUGADOR 1-------------");
        System.out.print("Ingrese el nombre del primer jugador:");
        nameJugador=leer1.nextLine();
        nombres.add(nameJugador);
        System.out.println("\nJUGADOR 1 tienes un limite de 4 botes\n");
        int si=0;
        while (si==0){
            System.out.print("Ingresa los botes que tendras: ");
            cantBotes1=leer.nextInt();
            if (cantBotes1>0 && cantBotes1<=4){
                botes.add(cantBotes1);
                System.out.println( );
                si=1;
                System.out.println("JUGADOR 1 tendras "+cantBotes1+" botes");
            }else{
                System.out.println("No se pueden este numero de botes ... \nVUELVE A INGRESAR\n");
            }
        }
        Barcos(TJugador1, leer1, cantBotes1);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
        //JUGADOR 2 TABLERO
        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------JUGADOR 2--------------");
        System.out.print("Ingresa el nombre del segundo jugador:");
        nameJugador=leer2.nextLine();
        nombres.add(nameJugador);
        System.out.println(" ");
        System.out.println("JUGADOR 2 tienes un limite de 4 botes");
        System.out.println(" ");
        int si2=0;
        while (si2==0){
            System.out.print("Ingresa cuantos botes tendras: ");
            cantBotes2=leer.nextInt();
            if (cantBotes2>0 && cantBotes2<=4){
                botes.add(cantBotes2);
                System.out.println( );
                si2=1;
                System.out.println("JUGADOR 1 tendras "+cantBotes2+" botes");
            }else{
                System.out.println("No se pueden este numero de botes ... ");
                System.out.println("VUELVE A INGRESAR");
            }
        }
        Barcos(TJugador2, leer1, cantBotes2);
        //CANTIDAD DE BOTES
        System.out.println("Jugadores en Juegos"+nombres);
        System.out.println("-------------------------------------------------------\n");
        Rondas(TJugador1, TJugador2, leer, leer1, nombres, puntuacionJugador1, TableroVacio_J1, TableroVacio_J2,puntuacionJugador2,  ganador,cantBotes1,cantBotes2);
        puntos.add(puntuacionJugador1);
        puntos.add(puntuacionJugador2);
        System.out.println("--------------------------GANADOR-------------------------");
        System.out.print("Nombre: ");
        System.out.println(nombres.get(ganador));
        System.out.print("Puntos: ");
        System.out.println(puntos.get(ganador));
        System.out.println("------------------GRACIAS POR JUGAR------------------------");
    }

    public static String[][] Creartablero(String[][] tablero_jugador){
        for (int a=0; a<tablero_jugador.length; a++){
            for (int j=0; j<tablero_jugador.length; j++){
                tablero_jugador[a][j]="#";
            }
        }
        return tablero_jugador;
    }


    // tablero jugador 1
    public static void imprimirTablero(String[][] tablero_jugador){
        int b=0;
        int c=0;
        System.out.print("   ");
        for (int i = 0; i < tablero_jugador.length; i++) {//Coordenadas de arriba
            c++;

            if (i<=8){
                System.out.print(" "+c+"   ");
            }else{
                System.out.print(" "+c+"  ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < tablero_jugador.length; i++) { //Coordenadas de los de los lados
            b++;
            if (i<=8){
                System.out.print(" "+b);
            }else{
                System.out.print(b);
            }
            for (int j = 0; j < tablero_jugador[0].length; j++) {

                if (j == 0 || j == tablero_jugador.length - 1) {
                    if (j == 0) {
                        System.out.print("| " + tablero_jugador[i][j]+"  ");

                    }
                    if (j == tablero_jugador.length - 1) {
                        System.out.print("  "+tablero_jugador[i][j] + "  |");
                    }
                } else {
                    System.out.print("  " + tablero_jugador[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }

    }
    // imprimir tablero jugador 2

    public static void Barcos(String[][] tablero_jugador, Scanner leer, int numBote1){
        int boteporponer=1;
        while (numBote1>0){
            if (boteporponer==1){
                boteporponer+=1;
                System.out.println("------------------------------------------------------");
                System.out.println("-----------------PON TU PRIMER BOTE------------------");
                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu bote");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){
                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu bote");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y=y-1;
                                x=x-1;
                                tablero_jugador[y][x]="A";
                                imprimirTablero(tablero_jugador);
                                numBote1=numBote1-1;
                                otra=1;
                                comprobarfila=1;
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }

            }else if (boteporponer==2){
                System.out.println("------------------------------------------------------");
                System.out.println("----------------PON TU SEGUNDO BOTE------------------");
                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu bote");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){

                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu bote");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y=y-1;
                                x=x-1;
                                tablero_jugador[y][x]="B";
                                otra=1;
                                comprobarfila=1;
                                imprimirTablero(tablero_jugador);
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }


                boteporponer++;
                numBote1=numBote1-1;
            }else if (boteporponer==3) {
                System.out.println("------------------------------------------------------");
                System.out.println("----------------PON TU TERCER BOTE-------------------");
                int otra=0,verificacion1=0;
                while (otra==0){
                    while(verificacion1==0) {
                        System.out.println("Ingresa la columna donde quieres poner tu bote");
                        int x = leer.nextInt();
                        if (x > 0 && x <= tablero_jugador[0].length) {
                            verificacion1 = 1;

                            int comprobarfila = 0;
                            while (comprobarfila == 0) {
                                System.out.println("Ingresa la fila donde quieres poner tu bote");
                                int y = leer.nextInt();
                                if (y > 0 && y <= tablero_jugador[0].length) {
                                    y = y - 1;
                                    x = x - 1;
                                    tablero_jugador[y][x] = "C";

                                    otra = 1;
                                    comprobarfila = 1;
                                    imprimirTablero(tablero_jugador);
                                } else {
                                    System.out.println("NO ES UNA FILA CORRECTA");
                                }
                            }
                        } else {
                            System.out.println("NO ES UNA COLUMNA CORRECTA\n Vuelva a ingresar intentarlo");
                        }
                    }
                }


                boteporponer++;
                numBote1=numBote1-1;
            }else if (boteporponer==4){
                System.out.println("------------------------------------------------------");
                System.out.println("-----------------PON TU CUARTO BOTE-------------------");

                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu bote");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){

                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu bote");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y-=1;
                                x-=1;
                                tablero_jugador[y][x]="D";
                                otra=1;
                                comprobarfila=1;
                                imprimirTablero(tablero_jugador);
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }

                boteporponer++;
                numBote1=numBote1-1;
            }
        }
    }

    public static void Rondas(String[][] tablero_jugador1, String[][] tablero_jugador2, Scanner leer, Scanner leer1, ArrayList<String> nombres,int puntuacionJugador1, String[][] tablero_nadajugador1, String[][] tablero_sinmodifjugador2,int puntuacionJugador2,int ganador,int cantbotes1,int cantbotes2){
        int rondas=0,botesrestantes1=cantbotes1,botesrestantes2=cantbotes2;

        puntuacionJugador1=0;
        puntuacionJugador2=0;
        ArrayList <Integer> puntos=new ArrayList<Integer>();
        puntos.add(puntuacionJugador1);
        puntos.add(puntuacionJugador2);
        while (rondas==0) {
            int ronda1 = 0;
            int ronda2 = 0;
            while (ronda1 == 0) {
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
                System.out.println("============TURNO JUGADOR 1============");
                System.out.print("Jugador 1: ");
                System.out.println(nombres.get(0));
                System.out.println(" EL TABLERO DEL ENEMIGO ES EL SIGUIENTE CON POSICIONES DONDE ATACASTE: ");
                imprimirTablero(tablero_sinmodifjugador2);
                System.out.println("ESTE ES TU TABLERO: ");
                imprimirTablero(tablero_jugador1);
                int verificador1 = 0;
                while (verificador1 == 0) {
                    System.out.println("Pon columna para atacar");
                    int x = leer.nextInt();
                    if (x > 0 && x <= tablero_jugador2[0].length) {
                        int comprobarfila = 0;
                        verificador1 = 1;
                        while (comprobarfila == 0) {
                            System.out.println("Pon fila para atacar");
                            int y = leer.nextInt();
                            if (y > 0 && y <= tablero_jugador2[0].length) {
                                y = y - 1;
                                x = x - 1;
                                if (!tablero_jugador2[y][x].equals("X")) {
                                    if (tablero_jugador2[y][x].equals("A") | tablero_jugador2[y][x].equals("B") | tablero_jugador2[y][x].equals("C") | tablero_jugador2[y][x].equals("D")) {
                                        System.out.println(" LE DISTE A UN BARCO GANASTE 200 PUNTOS");
                                        System.out.println("=========================================");
                                        tablero_jugador2[y][x] = "X";
                                        tablero_sinmodifjugador2[y][y] = "X";
                                        puntuacionJugador1+=200;
                                        comprobarfila = 1;
                                        ronda1 = 1;
                                        botesrestantes2--;
                                    } else {
                                        System.out.println("NO LE DISTE A NINGUN BARCO");
                                        tablero_jugador2[y][x] = "X";
                                        tablero_sinmodifjugador2[y][x] = "X";
                                        ronda1 = 1;
                                        comprobarfila = 1;
                                    }
                                }
                                else{
                                    System.out.println("ya tiraste en esta posicion");
                                    verificador1=0;
                                }
                            } else {
                                System.out.println("NO ES UNA FILA CORRECTA\n vuelve a intentar");
                            }
                        }
                    } else {
                        System.out.println("NO ES UNA COLUMNA CORRECTA\n vuelve a intentar");
                    }
                }
            }
            int t = 0;
            for (int a = 0; a < tablero_jugador2.length; a++) {
                for (int j = 0; j < tablero_jugador2.length; j++) {
                    if(botesrestantes2==0) {
                        if (!tablero_jugador2[a][j].equals("A") && !tablero_jugador2[a][j].equals("B") && !tablero_jugador2[a][j].equals("C") && !tablero_jugador2[a][j].equals("D") && t == 0) {
                            System.out.println("JUGADOR 1 GANO EL JUEGO");
                            ganador = 0;
                            rondas = 1;
                            t = 1;
                        }
                    }
                }
            }
            if (ganador != 0) {

                while (ronda2 == 0) {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
                    System.out.println("============TURNO JUGADOR 2============");
                    System.out.print("Jugador 2: ");
                    System.out.println(nombres.get(1));
                    System.out.println(" EL TABLERO DEL ENEMIGO ES EL SIGUIENTE CON POSICIONES DONDE ATACASTE: ");
                    imprimirTablero(tablero_nadajugador1);
                    System.out.println("ESTE ES TU TABLERO: ");
                    imprimirTablero(tablero_jugador2);
                    System.out.println("Pon columna para atacar");
                    int x = leer.nextInt();
                    if (x > 0 && x <= tablero_jugador1[0].length) {
                        int comprobarfila = 0;
                        while (comprobarfila == 0) {
                            System.out.println("Pon fila para atacar");
                            int y = leer.nextInt();
                            if (y > 0 && y <= tablero_jugador1[0].length) {
                                y = y - 1;
                                x = x - 1;
                                if (tablero_jugador1[y][x].equals("A") | tablero_jugador1[y][x].equals("B") | tablero_jugador1[y][x].equals("C") | tablero_jugador1[y][x].equals("D")) {
                                    System.out.println(" LE DISTE A UN BARCO GANASTE 200 PUNTOS");
                                    System.out.println("--------------------------------------------");
                                    tablero_jugador1[y][x] = "X";
                                    tablero_nadajugador1[y][x] = "X";
                                    puntuacionJugador2 += 200;
                                    comprobarfila = 1;
                                    ronda2 = 1;
                                    botesrestantes1--;
                                    System.out.println("--------------------------------------------");
                                } else {
                                    System.out.println("NO LE DISTE A NINGUN BARCO");
                                    tablero_jugador1[y][x] = "X";
                                    tablero_nadajugador1[y][x] = "X";
                                    ronda2 = 1;
                                    comprobarfila = 1;
                                }
                            } else {
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    } else {
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }
            }

            if(ganador!=0) {
                int r = 0;
                for (int a = 0; a < tablero_jugador1.length; a++) {
                    for (int j = 0; j < tablero_jugador1.length; j++) {
                        if(botesrestantes1==0) {
                            if (tablero_jugador1[a][j] != "A" && tablero_jugador1[a][j] != "B" && tablero_jugador1[a][j] != "C" && tablero_jugador1[a][j] != "D" && r == 0) {
                                System.out.println("JUGADOR 2 GANO EL JUEGO");
                                ganador = 1;
                                rondas = 1;
                                r = 1;
                            }
                        }
                    }
                }
            }
        }// cierra
    }
}