import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FiltroPeliculas {


    public void filtrarPorGenero(String genero) {
        String archivoEntrada = "peliculas.csv";
        String archivoSalida = genero + ".csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {

            String linea;
            boolean hayPeliculas = false;

            if ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

            
                if (datos.length > 4 && datos[4].trim().equalsIgnoreCase(genero)) {
                    bw.write(linea);
                    bw.newLine();
                    hayPeliculas = true;
            }

            if (!hayPeliculas) {
                bw.write("");
            }

            System.out.println("Archivo filtrado creado exitosamente: " + archivoSalida);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FiltroPeliculas filtro = new FiltroPeliculas();
        filtro.filtrarPorGenero("Ciencia ficción");
    }
}
