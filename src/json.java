import java.io.*;
import java.util.*;

public class json {

    public static void escribirJSON(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("[\n");

            for (int i = 0; i < datosArchivo.size(); i++) {
                LinkedHashMap<String, String> mapa = datosArchivo.get(i);
                bw.write("  {\n");

                int j = 0;
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    bw.write("    \"" + entry.getKey() + "\": \"" + entry.getValue() + "\"");
                    if (j < mapa.size() - 1) {
                        bw.write(",");
                    }
                    bw.write("\n");
                    j++;
                }

                bw.write("  }");
                if (i < datosArchivo.size() - 1) {
                    bw.write(",");
                }
                bw.write("\n");
            }

            bw.write("]");
        }

        System.out.println("Archivo JSON guardado en: " + archivoSalida.getAbsolutePath());
    }
}
