package vista;

import controlador.GestionLenguaje;
import java.util.Scanner;

public class SistemaRegistro {
    public static void main(String[] args) {
        SistemaRegistro sistema = new SistemaRegistro();
        sistema.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        GestionLenguaje gestionLenguaje = new GestionLenguaje();

        int opcion;

        do {
            System.out.println("\n----- Menu de Opciones ----1");
            System.out.println("1. Agregar lenguaje");
            System.out.println("2. Buscar lenguaje");
            System.out.println("3. Eliminar lenguaje");
            System.out.println("4. Imprimir lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> { 
                    System.out.print("Ingrese el nombre del lenguaje: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el año de creacion: ");
                    int anioCreacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese la caracteristica principal: ");
                    String caracteristicaPrincipal = scanner.nextLine();
                    System.out.print("Ingrese la utilizacion: ");
                    String utilizacion = scanner.nextLine();

                    gestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
                }
                case 2 -> { 
                    System.out.print("Ingrese el nombre del lenguaje a buscar: ");
                    String nombre = scanner.nextLine();
                    var lenguaje = gestionLenguaje.buscarLenguaje(nombre);

                    if (lenguaje != null) {
                        System.out.println("Lenguaje encontrado:\n" + lenguaje);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
                    String nombre = scanner.nextLine();
                    boolean eliminado = gestionLenguaje.eliminarLenguaje(nombre);

                    if (eliminado) {
                        System.out.println("Lenguaje eliminado exitosamente.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                case 4 -> 
                        gestionLenguaje.imprimirLenguajes();
                case 5 -> System.out.println("Saliendo del sistema, Hasta luego");
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
