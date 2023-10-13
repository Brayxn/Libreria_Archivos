
package archivos;

/**
 *
 * @author Brayan
 */

// CODIGO 2#
// Dar clic al boton archivo para guardar correctamente el archivo de texto
//Permite crear un archivo modificando el nombre y poniendo el contenido que quieras
 import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura extends JFrame {
    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private JMenuItem guardarMenuItem;
    private JTextArea textArea;

    public Escritura() {
        setTitle("Escritura en Archivo de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        archivoMenu = new JMenu("Archivo");
        guardarMenuItem = new JMenuItem("Guardar");
        textArea = new JTextArea();

        guardarMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });

        archivoMenu.add(guardarMenuItem);
        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);
        add(new JScrollPane(textArea));

        pack();
        setLocationRelativeTo(null);
    }

    private void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                String contenido = textArea.getText();
                writer.write(contenido);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Escritura escritura = new Escritura();
            escritura.setVisible(true);
        });
    }
}


