package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaEliminarOBorrarPostre extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoPostre;
	private JTextField tfCantidad;
	private JTextField tfNumeroVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarOBorrarPostre frame = new VentanaEliminarOBorrarPostre();
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
	public VentanaEliminarOBorrarPostre() {
		setTitle("Eliminacion de postre de una venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblCodigoPostre = new JLabel("Codigo postre:");
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoPostre.setBounds(10, 25, 150, 30);
		contentPane.add(lblCodigoPostre);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(10, 75, 150, 30);
		contentPane.add(lblCantidad);
		
		JLabel lblNumeroVenta = new JLabel("Numero de venta:");
		lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroVenta.setBounds(10, 125, 150, 30);
		contentPane.add(lblNumeroVenta);
		

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(195, 200, 120, 30);
		contentPane.add(btnCancelar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(60, 200, 120, 30);
		contentPane.add(btnEliminar);
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setBounds(200, 25, 150, 30);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(200, 75, 150, 30);
		contentPane.add(tfCantidad);
		
		tfNumeroVenta = new JTextField();
		tfNumeroVenta.setColumns(10);
		tfNumeroVenta.setBounds(200, 125, 150, 30);
		contentPane.add(tfNumeroVenta);
	}

}
