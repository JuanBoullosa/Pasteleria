
package grafica.ventanas;

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
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 516, 60);
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
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);
		table.getColumnModel().getColumn(5).setPreferredWidth(1000);
		
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(30, 22, 55, 22);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(88, 25, 96, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JButton btnMostrarCod = new JButton("Mostrar");
		btnMostrarCod.setBounds(203, 24, 89, 23);
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
		btnCerrar.setBounds(164, 158, 89, 23);
		contentPane.add(btnCerrar);
		
		btnCerrar.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                 	   Menu menu = new Menu();
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
					 vol.getNombre(),
					 vol.getPrecio(),
					 vol.getTipo(),
					 vol.getEndulzante(),
					 vol.getDescripcion()
		        });
			 
			}
				else {
					modelo.addRow(new Object[] { 
			        		vop.getCodigo(),
			        		vop.getNombre(),
			        		vop.getPrecio(),
			        		vop.getTipo(),        		
			        });
				}
    }
	
	public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}
