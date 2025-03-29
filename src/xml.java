import java.io.*;
import java.util.*;

public class xml {

    public static void escribirXML(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("<filas>\n");

            for (LinkedHashMap<String, String> fila : datosArchivo) {
                bw.write("  <fila>\n");
                for (Map.Entry<String, String> entrada : fila.entrySet()) {
                    bw.write("    <" + entrada.getKey() + ">" + entrada.getValue() + "</" + entrada.getKey() + ">\n");
                }
                bw.write("  </fila>\n");
            }

            bw.write("</filas>\n");
        }

        System.out.println("Archivo XML guardado en: " + archivoSalida.getAbsolutePath());
    }
}


