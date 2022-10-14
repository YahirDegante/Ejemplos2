import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un numero: "+(i+1)+" : ");
            numeros[i] = scanner.nextInt();
        }
        int pares = 0;
        int impares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        System.out.println("Cantidad de numeros pares: "+pares);
        System.out.println("Cantidad de numeros impares: "+impares);
        System.out.println("Numeros pares: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.print(numeros[i]+" ");
            }
        }
        System.out.println("");
        System.out.println("Numeros impares: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.print(numeros[i]+" ");
            }
        }
    }
}
