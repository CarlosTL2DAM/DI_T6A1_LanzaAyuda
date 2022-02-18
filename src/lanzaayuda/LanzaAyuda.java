/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzaayuda;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Torres Liñán
 */
public class LanzaAyuda implements ActionListener{
    //Atributos
    JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        //Cremaos el menuBar
        menuBar = new JMenuBar();

        // Construimos el menu
        menu = new JMenu("Ayuda");
        menu.setMnemonic(KeyEvent.VK_A);
        // Añadimos el menu al menoBar
        menuBar.add(menu); 

        //MenuItems
        //Contenido de Ayuda
        menuItem = new JMenuItem("Contenido de Ayuda");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menuItem.addActionListener(this);
        // Añadimos el menuItem al menu
        menu.add(menuItem); 

        //About
        JMenuItem menuItem2 = new JMenuItem("About");
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));

        menuItem2.addActionListener(this);
        //Añadimos el menuItem al menu
        menu.add(menuItem2);

        //Creamos del objeto HelpSet y HelpBroker
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();

        // Asociamos la ayuda al menuItem
        hb.enableHelpOnButton(menuItem, "clientes", hs);

        //Devolvemos el menuBar
        return menuBar;
    }
    
    public HelpSet obtenFicAyuda()
    {
        try
        {
            //Cargamos el fichero donde se encuentra el helpSet.hs
            File file = new File(LanzaAyuda.class.getResource("/help/helpSet.hs").getFile());
            URL url = file.toURI().toURL();
            
            //Crea un objeto HelpSet
            HelpSet hs = new HelpSet(null, url);
            //Devolvemos el HelpSet
            return hs;
        }catch(Exception ex){
            //En caso de que no se encuentre el fichero
            JOptionPane.showMessageDialog(null, "Fichero HelpSet no encontrado");
            return null;
        }
    }
            
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }
    
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Se ha pulsado \"" + source.getText() + "\"";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

     private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LanzaAyuda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LanzaAyuda demo = new LanzaAyuda();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        
        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
