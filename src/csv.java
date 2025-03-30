/**
 * @author Jorge Alegre Maestre
 * @author Jose María Gutierrez Barrena
 */

import java.io.*;
import java.util.*;

/**
 * Clase para escribir datos en formato CSV.
 */
public class csv {
    /**
     * Escribe una lista de datos a un archivo CSV.
     * 
     * @param datosArchivo  Lista de mapas que representan las filas del CSV.
     * @param archivoSalida Archivo donde se guardará el CSV.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */

    public static void escribirCSV(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida)
            throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (LinkedHashMap<String, String> fila : datosArchivo) {
                bw.write(String.join(",", fila.values()));
                bw.newLine();
            }
        }

        System.out.println("Archivo CSV guardado en: " + archivoSalida.getAbsolutePath());
    }
}