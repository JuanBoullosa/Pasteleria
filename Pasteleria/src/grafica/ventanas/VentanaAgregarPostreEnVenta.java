package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VentanaAgregarPostreEnVenta extends JFrame {

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
					VentanaAgregarPostreEnVenta frame = new VentanaAgregarPostreEnVenta();
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
	public VentanaAgregarPostreEnVenta() {
		setTitle("Agregado de un nuevo postre a una venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 303);
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
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoPostre.setBounds(195, 25, 150, 30);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(195, 75, 150, 30);
		contentPane.add(tfCantidad);
		
		tfNumeroVenta = new JTextField();
		tfNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNumeroVenta.setColumns(10);
		tfNumeroVenta.setBounds(195, 125, 150, 30);
		contentPane.add(tfNumeroVenta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(195, 200, 120, 30);
		contentPane.add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(60, 200, 120, 30);
		contentPane.add(btnAgregar);
	}
}
