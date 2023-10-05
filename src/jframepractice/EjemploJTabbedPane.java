
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploJTabbedPane {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejemplo JTabbedPane");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        tabbedPane.addTab("Tab 1", panel1);
        tabbedPane.addTab("Tab 2", panel2);
        
        JButton cambiarContenidoButton = new JButton("Cambiar Contenido");
        
        // ActionListener para el botón
        cambiarContenidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia el contenido del panel en la pestaña activa
                int selectedIndex = tabbedPane.getSelectedIndex();
                JPanel selectedPanel = (selectedIndex == 0) ? panel1 : panel2;
                selectedPanel.removeAll();
                selectedPanel.add(new JLabel("Contenido Cambiado"));
                selectedPanel.revalidate();
                selectedPanel.repaint();
            }
        });

        // Agrega el botón en un panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cambiarContenidoButton);

        // Agrega el panel con el botón al contenido de la pestaña 1
        panel1.setLayout(new BorderLayout());
        panel1.add(buttonPanel, BorderLayout.CENTER);

        ventana.add(tabbedPane);
        ventana.setVisible(true);
    }
}
