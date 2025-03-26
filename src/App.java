import java.io.*;
import java.util.*;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static File carpetaSeleccionada;
    private static List<LinkedHashMap<String, String>> datosArchivo = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Seleccionar carpeta");
            System.out.println("2. Lectura de fichero");
            System.out.println("3. Conversión a (csv, json, xml)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    seleccionarCarpeta();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }

    private static void seleccionarCarpeta() {
        System.out.print("Ingrese la ruta de la carpeta: ");
        String ruta = sc.nextLine();
        carpetaSeleccionada = new File(ruta);

        if (carpetaSeleccionada.isDirectory()) {
            System.out.println("Carpeta seleccionada: " + carpetaSeleccionada.getAbsolutePath());
        } else {
            System.out.println("Ruta no válida.");
            carpetaSeleccionada = null;
        }
    }
}
