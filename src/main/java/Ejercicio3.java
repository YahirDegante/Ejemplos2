import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros: ");
        int cantidad = scanner.nextInt();
        if (cantidad > 50){
        }else{
            cantidad = 51;
        }
        int[] numeros = new int[cantidad];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }
        int numerosOrdenados[] = ordenamientoShellDESC(numeros);
        System.out.println("El arreglo tiene " + numeros.length + " elementos");
        System.out.println("Se buscara el mayor");
        int mayor = numerosOrdenados[0];
        System.out.println("El mayor es: " + mayor);
        System.out.println("El mayor se encuentra en la posicion: " + busqueadaBinariaDESC(numeros, mayor));
    }
    public static final int busqueadaBinariaDESC(int[] numeros, int buscado){
        int inicio = 0;
        int fin = numeros.length - 1;
        int medio = (inicio + fin) / 2;
        while (inicio <= fin) {
            if (numeros[medio] == buscado) {
                return medio;
            } else if (numeros[medio] < buscado) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
            medio = (inicio + fin) / 2;
        }
        return -1;
    }
    public static final int[] ordenamientoShellDESC(int[] arreglo){
        int numero = arreglo.length;
        int salto = numero / 2;
        while (salto > 0) {
            for (int i = 0; i < numero; i++) {
                int j = i;
                int aux = arreglo[i];
                while ((j >= salto) && (arreglo[j - salto] < aux)) {
                    arreglo[j] = arreglo[j - salto];
                    j -= salto;
                }
                arreglo[j] = aux;
            }
            salto = salto / 2;
        }
        return arreglo;
    }

}
