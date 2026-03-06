package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import logica.valueobjects.VOVenta;
import grafica.controladores.ControladorListadoVentasxEstado;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaListadoVentasxEstado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ControladorListadoVentasxEstado controlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoVentasxEstado frame = new VentanaListadoVentasxEstado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaListadoVentasxEstado() {
		
		controlador = new ControladorListadoVentasxEstado(this);
		
		setTitle("Lista de ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIndicacion = new JLabel("Indicación:");
		lblIndicacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIndicacion.setBounds(30, 30, 150, 30);
		contentPane.add(lblIndicacion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T", "F", "P"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(140, 30, 70, 30);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 98, -204, 115);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 82, 521, 300);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Numero", "Fecha", "Direccion de entrega", "Monto total", "Estado"}
			
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(68);
		table.getColumnModel().getColumn(1).setPreferredWidth(72);
		table.getColumnModel().getColumn(2).setPreferredWidth(217);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		scrollPane_1.setViewportView(table);
		
	
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMostrar.setBounds(431, 30, 120, 30);
		contentPane.add(btnMostrar);
		btnMostrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String estado = (String) comboBox.getSelectedItem();
		        controlador.cargarListado(estado);

		    }
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(431, 393, 120, 30);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Menu menu = new Menu();
			    menu.mostrar();  
			    setVisible(false);	
	        }
		});
}


		public void cargarTabla(LinkedList<VOVenta> lista2) {
	        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	        modelo.setRowCount(0);

	        for (VOVenta v : lista2) {
	        	Object[] fila = {
	                v.getNumero(),
	                v.getFecha(),
	                v.getDireccionEnvio(),
	                v.getMontoTotal(),
	                v.getEstado()
	            };
	            modelo.addRow(fila);
	        }
		}
		
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
