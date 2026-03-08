
package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import grafica.controladores.ControladorListadoDetallado;
import logica.valueobjects.VOLightDetallado;
import logica.valueobjects.VOPostre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import logica.valueobjects.VOPostreDetallado;

public class VentanaListadoDetallado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfCodigo;
	private ControladorListadoDetallado controlador;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoDetallado frame = new VentanaListadoDetallado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaListadoDetallado() {
		setTitle("Listado Detallado de Postre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 600, 315);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Detalle de un postre");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 600, 35);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 560, 60);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"Codigo","Nombre", "Precio", "Tipo", "Endulzante", "Descripcion"
			}
		));
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(600);
		table.getColumnModel().getColumn(2).setPreferredWidth(230);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);
		table.getColumnModel().getColumn(5).setPreferredWidth(1000);
		
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 80, 55, 25);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(75, 80, 96, 25);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btnMostrarCod = new JButton("Mostrar");
		btnMostrarCod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrarCod.setBounds(180, 80, 90, 25);
		contentPane.add(btnMostrarCod);
		
		controlador = new ControladorListadoDetallado(this);
	
	           btnMostrarCod.addActionListener(
	                   new ActionListener() {
	                       public void actionPerformed(ActionEvent e) {
	                    	   controlador.ObtenerVOPostreDetallado(tfCodigo.getText());
	                       }
	                   }
	               );
		
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setBounds(255, 210, 90, 25);
		contentPane.add(btnCerrar);
		
		btnCerrar.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	MenuPrincipal menu = new MenuPrincipal();
                 	   menu.mostrar();
                 	   setVisible(false);
                    }
                });
		
	}
	
	public void cargarPostresVentana(VOPostreDetallado vop) {
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);

		 if (vop instanceof VOLightDetallado) {
			 VOLightDetallado vol = (VOLightDetallado) vop;

			 modelo.addRow(new Object[] { 
					 vol.getCodigo(),
					 vol.getNombre(),"$ "+
					 vol.getPrecio(),
					 vol.getTipo(),
					 vol.getEndulzante(),
					 vol.getDescripcion()
		        });
			 
			}
				else {
					modelo.addRow(new Object[] { 
			        		vop.getCodigo(),
			        		vop.getNombre(),"$ "+
			        		vop.getPrecio(),
			        		vop.getTipo(),        		
			        });
				}
    }
	
	public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}
