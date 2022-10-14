import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coloque cuantas temperaturas desea ingresar: ");
        int cantidad = scanner.nextInt();
        if (cantidad > 50){
        }else{
            cantidad = 51;
        }
        double[] temperaturas = new double[cantidad];
        for (int i = 0; i < temperaturas.length; i++) {
            temperaturas[i] = (double) (Math.random() * 100);
        }
        double acumulador = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            acumulador += temperaturas[i];
        }
        double media = acumulador / temperaturas.length;
        System.out.println("La media de las temperaturas es: " + media);
        System.out.println("Las temperaturas mayores a la media son: ");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] >= media) {
                //En el texto se menciona que mayores o iguales
                System.out.println(temperaturas[i]);
            }
        }

    }
}
