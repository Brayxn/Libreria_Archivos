/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

/**
 *
 * @author Brayan
 */

//Codigo 5#
//En este codigo puede copiar un archivo de texto y duplicarlo con otro nombre en otra ubicacion conservando ambos archivos
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copiar extends JFrame {
    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private JMenuItem copiarMenuItem;

    public Copiar() {
        setTitle("Copiar Archivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        archivoMenu = new JMenu("Archivo");
        copiarMenuItem = new JMenuItem("Copiar Archivo");

        copiarMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copiarArchivo();
            }
        });

        archivoMenu.add(copiarMenuItem);
        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    private void copiarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivoOrigen = fileChooser.getSelectedFile();

            JFileChooser destinoChooser = new JFileChooser();
            destinoChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int destinoResult = destinoChooser.showSaveDialog(this);

            if (destinoResult == JFileChooser.APPROVE_OPTION) {
                File archivoDestino = destinoChooser.getSelectedFile();

                try {
                    Path origenPath = archivoOrigen.toPath();
                    Path destinoPath = archivoDestino.toPath();
                    Files.copy(origenPath, destinoPath);
                    JOptionPane.showMessageDialog(this, "Archivo copiado exitosamente");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al copiar el archivo");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Copiar copiar = new Copiar();
            copiar.setVisible(true);
        });
    }
}

