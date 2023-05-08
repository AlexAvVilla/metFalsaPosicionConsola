
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        do{
            System.out.println("\t SELECCIONE UN METODO\t\n 1.- METODO DE FALSA POSICION \n 2.- METODO DE BISECCION \n 3.- SALIR \n");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            switch(opc){
                case 1:  //falsa posicion
                    FalsaPosicion fpo = new FalsaPosicion();
                    fpo.FalsaPosicion();
                break;
                case 2:  //biseccion
                    Biseccion bi = new Biseccion();
                    bi.Biseccion();
                break;
                case 3:  //salir
                break;
                default: System.out.println("\nESA OPCION NO EXISTE, POR FAVOR, INTENTELO DE NUEVO! \n");
            }
        }while(opc > 4 || opc == 0);
    }
    
}
