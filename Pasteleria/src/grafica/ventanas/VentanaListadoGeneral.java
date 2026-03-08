package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import grafica.controladores.ControladorListadoGeneral;
import logica.valueobjects.VOPostre;

public class VentanaListadoGeneral extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private ControladorListadoGeneral controlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaListadoGeneral frame = new VentanaListadoGeneral();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaListadoGeneral() {
        setTitle("Listado general de postres");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(198, 233, 251));

        setContentPane(contentPane);
        contentPane.setLayout(null);

    	JLabel lblTitulo = new JLabel("Lista de postres");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 600, 35);
		contentPane.add(lblTitulo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 61, 564, 243);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Codigo", "Nombre", "Precio", "Tipo" }
        ));
        scrollPane.setViewportView(table);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        controlador = new ControladorListadoGeneral(this);
        
        //llama al meotod para obtener la lista de Postres  desde la fachada
        controlador.ObtenerListaPostresdeFachada();

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(255, 315, 90, 25);
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(btnCerrar);

        btnCerrar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	MenuPrincipal menu = new MenuPrincipal();
                    menu.mostrar();
                    setVisible(false);
                }
            }
        );
    }
    
    
    // Recibe la lista de Postres desde el Controlador 
    public void cargarTablaPostresVentana(ArrayList<VOPostre> lista) {
    	
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);

        for (VOPostre p : lista) {
            modelo.addRow(new Object[] {
                p.getCodigo(),
                p.getNombre(), 
                "$ " + p.getPrecio(),
                p.getTipoPostre()
            });
        }

    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}