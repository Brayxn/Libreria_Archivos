/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

/**
 *
 * @author Brayan
 */

//Codigo 3#
//Permite crear un archivo de texto

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Crear extends JFrame {
    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private JMenuItem crearMenuItem;

    public Crear() {
        setTitle("Creación de Archivo de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        archivoMenu = new JMenu("Archivo");
        crearMenuItem = new JMenuItem("Crear Archivo");

        crearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearArchivo("nuevo.txt");
            }
        });

        archivoMenu.add(crearMenuItem);
        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    private void crearArchivo(String nuevotxt) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                Path archivo = fileChooser.getSelectedFile().toPath();
                Files.createFile(archivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Crear crear = new Crear();
            crear.setVisible(true);
        });
    }
}

