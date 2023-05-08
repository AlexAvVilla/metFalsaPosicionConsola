
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class FalsaPosicion {
   double a, b, fa, fb, xi, fxi, E;
    int i = 2;
    Scanner sc = new Scanner(System.in);
    public void FalsaPosicion(){
        System.out.println("Ejemplo a realizar: \n\t---    -0.5X^2 + 2.5X + 4.4    ---\n\t---   error < 0.0004     ---\n\n");
        System.out.println("ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.println("ingrese el valor de b: ");
        b = sc.nextDouble();
        comprobacion(a,b);
    }
    public void comprobacion(double a, double b){
        //primera iteracion para obtener fa y fb
        //utilizamos los valores dados por el usuario en la ecuacion sustituyendo cada uno en x, primero a y despues b
        fa = -.5 * (Math.pow(a, 2)) + 2.5 * a + 4.4;
        fb = -.5 * (Math.pow(b, 2)) + 2.5 * b + 4.4;
        //para poder realizar este metodo, las funciones de fa y fb deben tener signos distintos
        if(fa > 0 && fb < 0 || fa < 0 && fb > 0){
            xi = ((a * fb) - (b * fa)) / (fb - fa);
            fxi = -.5 * (Math.pow(xi, 2)) + 2.5 * xi + 4.4;
            System.out.println("\nIteracion : 1\n");
            System.out.println("a = " + a + "\nb = " + b + "\nf(a) = " + fa + "\nf(b) = " + fb + "\nxi = " + xi + "\nf(xi) = " + fxi + "\nExi = " + E);
            iteracion();
        }else{
            System.out.println("\nlos valores del intervalo no cumplen la condicion del metodo\n");
            FalsaPosicion();
        }
    }
    public void iteracion(){
        if(fa > 0 && fxi > 0 || fa < 0 && fxi < 0){
            //en la segunda iteracion se necesita actualizar valores
            //si fa y fx tienen el mismo signo (positivo o negativo), a toma el valor de xi, b sigue igual
            a = xi;
            fa = fxi;
            //formula para obtener xi ===> xi = (a*f(b)-(b*f(a)))/(f(b)-f(a))
            xi = ((a * fb) - (b * fa)) / (fb - fa);
            fxi = -.5 * (Math.pow(xi, 2)) + 2.5 * xi + 4.4;
            E = Math.abs((xi - a) / xi);
            System.out.println("\nIteracin : " + i++);
            System.out.println("a = " + a + "\nb = " + b + "\nf(a) = " + fa + "\nf(b) = " + fb + "\nxi = " + xi + "\nf(xi) = " + fxi + "\nExi = " + E);
            error();
        }else{
            //si fa y fx tiene signos diferentes, b toma el valor de xi, a sigue igual
            b = xi;
            fb = fxi;
            //formula para obtener xi ===> xi = (a*f(b)-(b*f(a)))/(f(b)-f(a))
            xi = ((a * fb) - (b * fa)) / (fb - fa);
            fxi = -.5 * (Math.pow(xi, 2)) + 2.5 * xi + 4.4;
            E = Math.abs((xi - b) / xi);
            System.out.println("\nIteracin : " + i++);
            System.out.println("a = " + a + "\nb = " + b + "\nf(a) = " + fa + "\nf(b) = " + fb + "\nxi = " + xi + "\nf(xi) = " + fxi + "\nExi = " + E);
            error();
        }
    }
    public void error(){
        //el ejemplo se repetira hasta que el error generado por x sea menor a 0.0004
        while(E > 0.0004){
            iteracion();
        }
    } 
}
