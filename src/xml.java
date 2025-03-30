/**
 * @author Jorge Alegre Maestre
 * @author Jose María Gutierrez Barrena
 */

import java.io.*;
import java.util.*;
/**
 * Clase para escribir datos en formato XML.
 */

public class xml {
/**
     * @param datosArchivo Lista de mapas que representan los elementos XML.
     * @param archivoSalida Archivo donde se guardará el XML.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */

    public static void escribirXML(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("<coches>\n");

            for (LinkedHashMap<String, String> fila : datosArchivo) {
                bw.write("  <coche>\n");
                for (Map.Entry<String, String> entrada : fila.entrySet()) {
                    bw.write("    <" + entrada.getKey() + ">" + entrada.getValue() + "</" + entrada.getKey() + ">\n");
                }
                bw.write("  </coche>\n");
            }

            bw.write("</coches>\n");
        }

        System.out.println("Archivo XML guardado en: " + archivoSalida.getAbsolutePath());
    }
}


