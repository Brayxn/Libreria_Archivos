package archivos;

/**
 *
 * @author Brayann
 */

// CODIGO 1#
//Selecciona el archivo de texto que desea leer y te dice que contiene el archivo de texto

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

    public void leerArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = fileChooser.getSelectedFile().getAbsolutePath();

            Lectura lector = new Lectura();
            lector.leerArchivo(nombreArchivo);
        }
    }
}
