package org.example;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println(" - 5. Filtrar tareas por prioridad  ");
            System.out.println(" - 6. Guardar tareas en archivo de texto  ");
            System.out.println(" - 7. Salir ");
            System.out.println("");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la tarea: ");
                    String nuevaTarea = scanner.nextLine();
                    tareas.add("[ ] " + nuevaTarea);
                    System.out.println("Tarea añadida.");
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
                    System.out.println("Selecciona una prioridad a filtar (Alta, Media, Baja):");
                    String filtro = scanner.nextLine(). toUpperCase();
                    System.out.println("-----Tareas con prioridad." + filtro +"----");
                    boolean encontradas = false;
                    for  (int i = 0; i < tareas.size(); i++){
                        if(tareas.get(i).contains("[" +filtro + "]")){
                            System.out.println((i + 1) + ". " + tareas.get(i));
                            encontradas = true;
                        }
                    }
                    if (!encontradas){
                        System.out.println("No bhay tareas con esa prioridad");
                    }
                    break;

                case 6:
                    try{
                        FileWriter writer = new FileWriter("Tareas.txt");
                        for (String t : tareas) {
                            writer.write(t + "\n");
                        }
                        writer.close();
                        System.out.println("El listado se ha guardado correctamente en 'tareas.txt'.");
                    } catch (IOException e){
                        System.out.println("Hubo un error al guardar el archivo.");
                    }
                    break;


                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}