package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println();
        System.out.println("|----------------------------------|");
        System.out.println("|                                  |");
        System.out.println("|  Bienvenido al gestor de tareas  |");
        System.out.println("|                                  |");
        System.out.println("|----------------------------------|");

        do {

            System.out.println();
            System.out.println("      ----- MENU -----");
            System.out.println();
            System.out.println(" - 1. Anadir una tarea  ");
            System.out.println(" - 2. Ver lista de tareas  ");
            System.out.println(" - 3. Marcar tarea como completada  ");
            System.out.println(" - 4. Eliminar una tarea  ");
            System.out.println(" - 5. Salir ");
            System.out.println("");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la tarea: ");
                    String nuevaTarea = scanner.nextLine();
                    tareas.add("[ ] " + nuevaTarea);
                    System.out.println("Tarea anadida.");
                    break;

                case 2:
                    System.out.println("--- TAREAS ---");
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println((i + 1) + ". " + tareas.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Numero de la tarea a completar: ");
                    int numCompletar = scanner.nextInt();
                    String tareaAntigua = tareas.get(numCompletar - 1);
                    String tareaActualizada = "[X] " + tareaAntigua.substring(4);
                    tareas.set(numCompletar - 1, tareaActualizada);
                    System.out.println("Tarea completada.");
                    break;

                case 4:
                    System.out.print("Numero de la tarea a eliminar: ");
                    int numEliminar = scanner.nextInt();
                    tareas.remove(numEliminar - 1);
                    System.out.println("Tarea eliminada.");
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}