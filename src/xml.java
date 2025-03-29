public class xml {

    public static void escribirXML(List<LinkedHashMap<String, String>> datosArchivo, File archivoSalida)
            throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            bw.write("<filas>\n");
        }
    }
}