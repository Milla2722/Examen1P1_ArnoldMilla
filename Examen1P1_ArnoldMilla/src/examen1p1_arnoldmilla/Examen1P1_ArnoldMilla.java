package examen1p1_arnoldmilla;
import java.util.Scanner;
import java.util.Random;

public class Examen1P1_ArnoldMilla {
static Random rand = new Random();
static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("1. Fight or Flight");
        System.out.println("2. Tri Fuerza");
        System.out.println("3. Salir del programa");
        System.out.println("[1,2,3]");
        int op = sc.nextInt();
            while (op > 0 && op < 3){
                switch(op){
                    case 1:{
                        FrF();
                    }break;//fin opcion 1 Fight or Flight
                    
                    case 2:{
                        Tri_force();
                    }break;//fin opcion 2 Tri Fuerza
                }
            System.out.println("1. Fight or Flight");
            System.out.println("2. Tri Fuerza");
            System.out.println("3. Salir del programa");
            System.out.println("[1,2,3]");
            op = sc.nextInt();
            }
    }
    public static void FrF(){
        char continuar = 's';
                    int dist = rand.nextInt(15,30);
                    int dist_f = dist;
                    int balas = 25;
                    int hpz = 25;
                    int atk = rand.nextInt(1,7);
                    int movimiento = rand.nextInt(3,5);
                    int probab = rand.nextInt(1,100);
                    int master = 65;
                    boolean hit = false;
                        System.out.println("Ingrese maestria");
                        System.out.println("1. Principiante (0% de hit extra)");
                        System.out.println("2. Intermedio (5% de hit extra)");
                        System.out.println("3. Experto (15% de hit extra)");
                        System.out.println("[1,2,3]");
                        int num = sc.nextInt();
                            if (num == 1){
                                master += 0;
                            }//verificacion maestria principiante
                            
                            else if(num == 2){
                                master += 5;
                            }//verificacion maestria intermedio
                            
                            else if(num == 3){
                                master += 15;
                            }//verificacion maestria experto
                            
                        while (hpz > 0){
                            System.out.println("El zombie se encuentra a: " + dist + " metros");
                            System.out.println("");
                            System.out.println("El jugador cuenta con " + balas + " balas");
                            if (probab > 0 && probab <= master){
                                System.out.println("");
                                System.out.println("Hit! El tiro ha reducido el HP del zombie por un total de " + atk + "!");
                                System.out.println("");
                                hpz = hpz - atk;
                                atk = rand.nextInt(1,7);
                                hit = true;
                            } //Disparo dío
                            
                                else if(probab > master){
                                    hit = false;
                                    System.out.println("");
                                    System.out.println("Ha fallado! el zombie se encuentra a: " + dist_f); 
                                }//El disparo no acerto
                            
                            if (hit == true){
                                dist_f = dist_f;
                            }//el tiro dio y el zombie no se va a mover
                            
                            else {
                                dist_f = dist_f - movimiento;
                                movimiento = rand.nextInt(3,5);
                            }//el tiro no dio y el zombie avanza
                            
                            balas -= 1;
                            if (hpz < 0){
                                    hpz = 0;
                            }//verificacion numero negativo de balas a 0
                            
                            if (hpz == 0){
                                System.out.println("Vida restante del zombie: " + hpz);
                                System.out.println("YOU WIN! has logrado vencer al zombie!");
                                break;
                            }//salir si la hp es igual a 0
                            
                            if (balas < 1){
                                System.out.println("Se quedo sin balas por lo tanto perdio");
                                break;
                            }//verif si tiene cero balas
                            
                            if (dist_f < 0){
                                dist_f = 0;
                            }//verificacion numero negativo de distancia a 0
                            
                            if (dist_f == 0){
                                System.out.println("GAME OVER, la distancia se redujo a 0");
                            }//salir si distancia es = 0 
                            
                            System.out.println("");
                            System.out.println("Vida restante del zombie: " + hpz);
                            System.out.println("Listo para otra ronda? S/N");
                            continuar = sc.next().charAt(0);
                            if (continuar == 'n' || continuar == 'N'){
                                System.out.println("Salio del juego");
                                break;
                            }
                        }
                        System.out.println("");
    }
    public static void Tri_force(){
        int cont = 0;
        System.out.println("Ingrese un tamaño mayor a 20 y par");
                        int size = sc.nextInt();
                        int cambio = (size / 2) + 1;
                            for (int contador = 0; contador <= cambio; contador++){
                                if (size < 20){
                                    System.out.println("El tamaño tiene que ser mayor que 20");
                                break;
                                }
                                if (size % 2 != 0){
                                    System.out.println("El tamaño tiene que ser par");
                                break;
                                }
                                System.out.println();
                                for (cont = contador; cont < cambio ; cont++){
                                    System.out.print(" ");
                                    
                                }//fin for lineas horizontales espacio
                                for (cont = 0; cont < contador - 1 ; cont++){
                                    if (cont == 0){
                                        System.out.print("*");
                                    }
                                    else if (contador == cambio / 2){
                                        System.out.print(" ");
                                    }
                                    else {
                                        System.out.print("*");
                                    }
                                }
                                for (cont = 0; cont < contador; cont++){
                                    if (cont == contador - 1){
                                        System.out.print("*");
                                    }
                                    else if (contador == cambio / 2){
                                        System.out.print(" ");
                                    }
                                    else {
                                        System.out.print("*");
                                    }
                                }
                                    
                            }//fin for lineas verticales
                        System.out.println("");
    }
}
