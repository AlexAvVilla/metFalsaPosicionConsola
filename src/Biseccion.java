
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class Biseccion {
    double Xa, Xb, Xr, fxa, fxb, fxr, e, E;
    int i = 2;
    Scanner sc = new Scanner(System.in);
    public void Biseccion(){
        System.out.println("Ejemplo a realizar : \n\t---    X^4 - 2X^3 - 12X^2 + 16X - 40   ---\n\t---    error < 0.01    ---\n\n");
        System.out.println("ingrese el valor de a: ");
        Xa = sc.nextDouble();
        System.out.println("ingrese el valor de b: ");
        Xb = sc.nextDouble();
        comprobacion(Xa,Xb);
    }
    public void comprobacion(double xa, double xb){
        //primera iteracion para obtener fxa y fxb
        //utilizamos los valores dados por el ususario en la ecuacion sustituyendo cada uno en x, primero xa y despues xb
        fxa = (Math.pow(xa, 4)) - 2 * (Math.pow(xa, 3)) - 12 * (Math.pow(xa, 2)) + 16 * xa - 40;
        fxb = (Math.pow(xb, 4)) - 2 * (Math.pow(xb, 3)) - 12 * (Math.pow(xb, 2)) + 16 * xb - 40;
        //para poder realizar este metodo, las funciones de f(xa) y f(xb) deben ser con signos distintos
        if(fxa > 0 && fxb < 0 || fxa < 0 && fxb > 0){
            Xr = (Xa + Xb) / 2;
            fxr = (Math.pow(Xr, 4)) - 2 * (Math.pow(Xr, 3)) - 12 * (Math.pow(Xr, 2)) + 16 * Xr - 40;
            System.out.println("\nIteracion : 1\n");
            System.out.println("Xa = " + Xa + "\nXb = " + Xb + "\nXr = " + Xr + "\nf(xa) = " + fxa + "\nf(xb) = " + fxb + "\nf(xr) = " + fxr + "\nE = " + E);
            iteracion();
        }else{
            System.out.println("\nlos valores del intervalo no cumplen con la condicion del metodo\n");
            Biseccion();
        }
    }
    public void iteracion(){
        if(fxa * fxr > 0){
            //en la segunda iteracion se neceita actualizar valores
            //si el producto de f(xa)*f(xr) es mayor a cero, xa toma el valor de xr y xb sigue igual
            Xa = Xr;
            fxa = fxr;
            fxb = (Math.pow(Xb, 4)) - 2 * (Math.pow(Xb, 3)) - 12 * (Math.pow(Xb, 2)) + 16 * Xb - 40;
            //formula para obtener xr ===> xr = (xa-xb)/2
            Xr = (Xa + Xb) / 2;
            fxr = (Math.pow(Xr, 4)) - 2 * (Math.pow(Xr, 3)) - 12 * (Math.pow(Xr, 2)) + 16 * Xr - 40;
            //generacion del error con los valores de Xr nuevo y Xa quien toma el valor de Xr de la iteracion anterior
            E = Math.abs((Xr - Xa) / Xr);
            System.out.println("\niteracion : " + i++ + "\n");
            System.out.println("Xa = " + Xa + "\nXb = " + Xb + "\nXr = " + Xr + "\nf(xa) = " + fxa + "\nf(xb) = " + fxb + "\nf(xr) = " + fxr + "\nE = " + E);
            error();
        }else{
            //si el producto de f(xa)*f(xr) es menor a cero, xb toma el valor de xr y xa sigue igual
            Xb = Xr;
            fxb = fxr;
            fxa = (Math.pow(Xa, 4)) - 2 * (Math.pow(Xa, 3)) - 12 * (Math.pow(Xa, 2)) + 16 * Xa - 40;
            //formula para obtener xr ===> xr = (xa-xb)/2
            Xr = (Xa + Xb) / 2;
            fxr = (Math.pow(Xr, 4)) - 2 * (Math.pow(Xr, 3)) - 12 * (Math.pow(Xr, 2)) + 16 * Xr - 40;
            //generacion del error con los valores de Xr nuevo y Xa quien toma el valor de Xr de la iteracion anterior
            E = Math.abs((Xr - Xb) / Xr);
            System.out.println("\niteracion : " + i++ + "\n");
            System.out.println("Xa = " + Xa + "\nXb = " + Xb + "\nXr = " + Xr + "\nf(xa) = " + fxa + "\nf(xb) = " + fxb + "\nf(xr) = " + fxr + "\nE = " + E);
            error();
        }
    }
    public void error(){
        //el ejemplo se repetira hasta que el error generado por xr sea menor a 0.01
        while(E > 0.01){
            iteracion();
        }
    }
}
