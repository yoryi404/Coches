/**
 * @author Jorge Alegre Maestre
 * @author Jose María Gutierrez Barrena
 */

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
                    leerArchivo();
                    break;
                case 3:
                    convertirArchivo();
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
            mostrarContenidoCarpeta();
        } else {
            System.out.println("Ruta no válida.");
            carpetaSeleccionada = null;
        }
    }

    private static void mostrarContenidoCarpeta() {
        File[] archivos = carpetaSeleccionada.listFiles();
    
        if (archivos != null && archivos.length > 0) {
            System.out.println("Contenido de la carpeta:");
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    System.out.println("[Carpeta] " + archivo.getName());
                } else {
                    System.out.println("[Archivo] " + archivo.getName());
                }
            }
        } else {
            System.out.println("La carpeta está vacía.");
        }
    }

    private static void leerArchivo() {
        if (carpetaSeleccionada == null) {
            System.out.println("Debe seleccionar una carpeta primero");
            return;
        }

        System.out.print("Ingrese el nombre del fichero: ");
        String nombreArchivo = sc.nextLine();
        File archivo = new File(carpetaSeleccionada, nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("El fichero no existe");
            return;
        }

        datosArchivo.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            String[] encabezados = br.readLine().split(",");
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                LinkedHashMap<String, String> fila = new LinkedHashMap<>();
                for (int i = 0; i < encabezados.length && i < valores.length; i++) {
                    fila.put(encabezados[i].trim(), valores[i].trim()); 
                }
                datosArchivo.add(fila);
            }
            System.out.println("Archivo leído correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    private static void convertirArchivo() {
        if (datosArchivo.isEmpty()) {
            System.out.println("Debe leer un archivo primero.");
            return;
        }

    

        System.out.print("Seleccione el formato (csv/json/xml): ");
        String formato = sc.nextLine().toLowerCase();
        System.out.print("Ingrese el nombre del archivo de salida: ");
        String nombreArchivoSalida = sc.nextLine() + "." + formato;
        File archivoSalida = new File(carpetaSeleccionada, nombreArchivoSalida);

        try {
            switch (formato) {
                case "csv":
                csv.escribirCSV(datosArchivo, archivoSalida);
                    break;
                case "json":
                json.escribirJSON(datosArchivo, archivoSalida);
                    break;
                case "xml":
                xml.escribirXML(datosArchivo, archivoSalida);
                    break;
                default:
                    System.out.println("Formato no válido.");
                    return;
            }
            System.out.println("Archivo convertido con éxito: " + archivoSalida.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error al convertir el archivo: " + e.getMessage());
        }
    }
}
