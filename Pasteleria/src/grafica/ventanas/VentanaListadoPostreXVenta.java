package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class VentanaListadoPostreXVenta extends JFrame {

	private JPanel contentPane;
	private JTable tableListadoPostresXVenta;
	private JTextField tfnNumeroVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoPostreXVenta frame = new VentanaListadoPostreXVenta();
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
	public VentanaListadoPostreXVenta() {
		setTitle("Listado de postres de una venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JLabel lblNumeroVenta = new JLabel("Número de venta:");
		lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroVenta.setBounds(30, 30, 150, 30);
		contentPane.add(lblNumeroVenta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 98, -204, 115);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 82, 521, 300);
		contentPane.add(scrollPane_1);
		
		tableListadoPostresXVenta = new JTable();
		tableListadoPostresXVenta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Precio", "Tipo", "Cantidad"
			}
		));
		tableListadoPostresXVenta.getColumnModel().getColumn(1).setPreferredWidth(199);
		scrollPane_1.setViewportView(tableListadoPostresXVenta);
		

		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMostrar.setBounds(431, 30, 120, 30);
		contentPane.add(btnMostrar);
		
		tfnNumeroVenta = new JTextField();
		tfnNumeroVenta.setBounds(180, 30, 120, 30);
		contentPane.add(tfnNumeroVenta);
		tfnNumeroVenta.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(431, 404, 120, 30);
		contentPane.add(btnCancelar);
		
	}

}
