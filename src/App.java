import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú:");
            System.out.println("1. Seleccionar carpeta");
            System.out.println("2. Lectura de fichero");
            System.out.println("3. Conversor");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            
            switch (opcion) {
                case 1:
                    break;
                case 2:                   
                    break;                
                case 3:                    
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }


}
