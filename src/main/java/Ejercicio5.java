import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se contemplan 999 numeros enteros aleatorios del 0 al 2000");
        int[] numeros = new int[999];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 2000);
        }
        System.out.println("ordenamientoShell DESC");
        long startTime1 = System.nanoTime();
        int numerosOrdenados[] = ordenamientoShellDESC(numeros);
        long endTime1 = System.nanoTime() - startTime1;
        System.out.println("El arreglo tiene " + numeros.length + " elementos");
        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.println("numerosOrdenados[" + i + "] = " + numerosOrdenados[i]);
        }
        System.out.println("Ordenamiento burbuja descendente");
        long startTime2 = System.nanoTime();
        int numerosOrdenados2[] = ordenamientoBurbujaDESC(numeros);
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("El arreglo tiene " + numeros.length + " elementos");
        for (int i = 0; i < numerosOrdenados2.length; i++) {
            System.out.println("numerosOrdenados2[" + i + "] = " + numerosOrdenados2[i]);
        }
        System.out.println("Ordenamiento quicksort descendente");
        long startTime3 = System.nanoTime();
        int numerosOrdenados3[] = quicksort(numeros, numeros.length - 1,0 );
        long endTime3 = System.nanoTime() - startTime3;
        for (int i = 0; i < numerosOrdenados3.length; i++) {
            System.out.println("numerosOrdenados3[" + i + "] = " + numerosOrdenados3[i]);
        }
        System.out.println("Busqueda binaria ");
        System.out.println("coloque un numero a buscar");
        int buscado = scanner.nextInt();
        long startTime4 = System.nanoTime();
        int posicion = busqueadaBinaria(numerosOrdenados3, buscado);
        long endTime4 = System.nanoTime() - startTime4;
        long startTime5 = System.nanoTime();
        int[] ordenados = ordenamientoBurbujaDESC(numerosOrdenados3);
        long endTime5 = System.nanoTime() - startTime5;
        long startTime6 = System.nanoTime();
        int[] ordenados2 = ordenamientoShellDESC(numerosOrdenados3);
        long endTime6 = System.nanoTime() - startTime6;
        long startTime7 = System.nanoTime();
        int[] ordenados3 = quicksort(numerosOrdenados3, numerosOrdenados3.length - 1, 0);
        long endTime7 = System.nanoTime() - startTime7;
        System.out.println("El numero buscado es: " + buscado);
        System.out.println("El numero buscado se encuentra en la posicion: " + posicion);
        System.out.println("Tiempo de ejecucion ordenamientoShell DESC: " + endTime1);
        System.out.println("Tiempo de ejecucion ordenamiento burbuja DESC: " + endTime2);
        System.out.println("Tiempo de ejecucion ordenamiento quicksort DESC: " + endTime3);
        System.out.println("Tiempo de ejecucion busqueda binaria: " + endTime4);
        System.out.println("Tiempo de ejecucion ordenamiento burbuja DESC: (ya ordenados) " + endTime5);
        System.out.println("Tiempo de ejecucion ordenamientoShell DESC: (ya ordenados) " + endTime6);
        System.out.println("Tiempo de ejecucion ordenamiento quicksort DESC: (ya ordenados) " + endTime7);
    }

    public static final int[] ordenamientoBurbujaDESC(int[] arreglo) {
        int numero = arreglo.length;
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
        return arreglo;
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
    public static final int[] quicksort(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            while (arreglo[i] <= pivote && i < j) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i < j) {
                auxIntercambio = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxIntercambio;
            }
        }
        arreglo[izquierda] = arreglo[j];
        arreglo[j] = pivote;
        if (izquierda < j - 1) {
            quicksort(arreglo, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            quicksort(arreglo, j + 1, derecha);
        }
        return arreglo;
    }
    public static final int busqueadaBinaria(int[] numeros, int buscado){
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
    public static final int busquedaBinariaDESC(int[] numeros, int buscado){
        int inicio = numeros.length - 1;
        int fin = 0;
        int medio = (inicio + fin) / 2;
        while (inicio <= fin) {
            if (numeros[medio] == buscado) {
                return medio;
            } else if (numeros[medio] > buscado) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
            medio = (inicio + fin) / 2;
        }
        return -1;
    }


}
