import java.io.*;
import java.util.*;

public class csv {

    public static void escribirCSV(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (LinkedHashMap<String, String> fila : datosArchivo) {
                bw.write(String.join(",", fila.values())); 
                bw.newLine();
            }
        }

        System.out.println("Archivo CSV guardado en: " + archivoSalida.getAbsolutePath());
    }
}