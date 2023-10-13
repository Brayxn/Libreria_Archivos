/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

/**
 *
 * @author Brayan
 */
//Codigo 6#
//Permite seleccionar el archivo que desea eliminar 

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Eliminar extends JFrame {
    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private JMenuItem eliminarMenuItem;

    public Eliminar() {
        setTitle("Eliminar Archivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        archivoMenu = new JMenu("Archivo");
        eliminarMenuItem = new JMenuItem("Eliminar Archivo");

        eliminarMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarArchivo();
            }
        });

        archivoMenu.add(eliminarMenuItem);
        menuBar.add(archivoMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    private void eliminarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            if (archivo.exists()) {
                if (archivo.delete()) {
                    JOptionPane.showMessageDialog(this, "Archivo eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el archivo");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo no existe");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Eliminar eliminar = new Eliminar();
            eliminar.setVisible(true);
        });
    }
}
