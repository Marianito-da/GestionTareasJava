import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionTareas {

    static class Tarea {
        String descripcion;
        boolean completada;

        Tarea(String descripcion) {
            this.descripcion = descripcion;
            this.completada = false;
        }

        @Override
        public String toString() {
            return (completada ? "[X] " : "[ ] ") + descripcion;
        }
    }

    public static void main(String[] args) {
        ArrayList<Tarea> tareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Tareas ---");
            System.out.println("1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    verTareas(tareas);
                    break;
                case 2:
                    agregarTarea(tareas, scanner);
                    break;
                case 3:
                    marcarTareaCompletada(tareas, scanner);
                    break;
                case 4:
                    eliminarTarea(tareas, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void verTareas(ArrayList<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    private static void agregarTarea(ArrayList<Tarea> tareas, Scanner scanner) {
        System.out.print("Ingresa la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada.");
    }

    private static void marcarTareaCompletada(ArrayList<Tarea> tareas, Scanner scanner) {
        verTareas(tareas);
        if (!tareas.isEmpty()) {
            System.out.print("Ingresa el número de la tarea a marcar como completada: ");
            try {
                int numeroTarea = scanner.nextInt();
                if (numeroTarea > 0 && numeroTarea <= tareas.size()) {
                    tareas.get(numeroTarea - 1).completada = true;
                    System.out.println("Tarea marcada como completada.");
                } else {
                    System.out.println("Número de tarea no válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next();
            }
        }
    }

    private static void eliminarTarea(ArrayList<Tarea> tareas, Scanner scanner) {
        verTareas(tareas);
        if (!tareas.isEmpty()) {
            System.out.print("Ingresa el número de la tarea a eliminar: ");
            try {
                int numeroTarea = scanner.nextInt();
                if (numeroTarea > 0 && numeroTarea <= tareas.size()) {
                    tareas.remove(numeroTarea - 1);
                    System.out.println("Tarea eliminada.");
                } else {
                    System.out.println("Número de tarea no válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next();
            }
        }
    }
}