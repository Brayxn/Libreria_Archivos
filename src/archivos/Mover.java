/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

/**
 *
 * @author Brayan
 */
// Codigo 4#
// permite cambiar la ubicacion de un archivo de texto

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mover extends JFrame {
    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private JMenuItem moverMenuItem;

    public Mover() {
        setTitle("Mover Archivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        archivoMenu = new JMenu("Archivo");
        moverMenuItem = new JMenuItem("Mover Archivo");

        moverMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverArchivo();
            }
        });

        archivoMenu.add(moverMenuItem);
        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    private void moverArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            JFileChooser destinoChooser = new JFileChooser();
            destinoChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int destinoResult = destinoChooser.showSaveDialog(this);

            if (destinoResult == JFileChooser.APPROVE_OPTION) {
                File destino = new File(destinoChooser.getSelectedFile(), archivo.getName());

                if (archivo.renameTo(destino)) {
                    JOptionPane.showMessageDialog(this, "Archivo movido exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al mover el archivo");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mover mover = new Mover();
            mover.setVisible(true);
        });
    }
}

