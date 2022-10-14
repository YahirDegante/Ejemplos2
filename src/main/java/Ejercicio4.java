import java.util.Scanner;

public class Ejercicio4v2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int identificadores[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int existencias[] = {1, 6, 3, 24, 22, 20, 20, 2, 23, 14, 13, 6, 6, 25, 16, 30, 12, 27, 13, 18};
        int precio[] = {30, 19, 13, 29, 13, 35, 19, 15, 15, 19, 30, 9, 23, 28, 21, 13, 23, 15, 24, 23};
        int mayor = existencias[0], pos = 0, opcion=0, identificador = 0, nuevoPrecio = 0, nuevaExistencia = 0;
        while (opcion!=5) {
            System.out.println("opcion ");
            System.out.println("1.- Producto con mas existencia");
            System.out.println("2.- Procuto mas caro");
            System.out.println("3.- Editar");
            System.out.println("4.- ver todos los productos");
            System.out.println("5.- Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < existencias.length; i++) {
                        if (existencias[i] > mayor) {
                            mayor = existencias[i];
                            pos = i;
                        }
                    }
                    System.out.println("El producto con mas existencia es: " + identificadores[pos]);
                    System.out.println("El precio es: " + precio[pos]);
                    System.out.println("La existencia es: " + mayor);
                    System.out.println("El id es: " + identificadores[pos]);
                    break;
                case 2:
                    mayor = precio[0];
                    for (int i = 0; i < precio.length; i++) {
                        if (precio[i] > mayor) {
                            mayor = precio[i];
                            pos = i;
                        }
                    }
                    System.out.println("El producto mas caro es: " + identificadores[pos]);
                    System.out.println("El precio es: " + mayor);
                    System.out.println("La existencia es: " + existencias[pos]);
                    System.out.println("El id es: " + identificadores[pos]);
                    break;
                case 3:
                    System.out.println("Ingrese el id del producto a editar");
                    identificador = leer.nextInt();
                    for (int i = 0; i < identificadores.length; i++) {
                        if (identificadores[i] == identificador) {
                            pos = i;
                        }
                    }
                    System.out.println("Ingrese el nuevo precio");
                    nuevoPrecio = leer.nextInt();
                    System.out.println("Ingrese la nueva existencia");
                    nuevaExistencia = leer.nextInt();
                    precio[pos] = nuevoPrecio;
                    existencias[pos] = nuevaExistencia;
                    break;
                case 4:
                    for (int i = 0; i < identificadores.length; i++) {
                        System.out.println("El producto es: " + identificadores[i]);
                        System.out.println("El precio es: " + precio[i]);
                        System.out.println("La existencia es: " + existencias[i]);
                        System.out.println("El id es: " + identificadores[i]);
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
