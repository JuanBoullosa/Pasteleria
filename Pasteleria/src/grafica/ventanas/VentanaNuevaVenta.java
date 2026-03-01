package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaNuevaVenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfFecha;
	private JTextField tfDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevaVenta frame = new VentanaNuevaVenta();
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
	public VentanaNuevaVenta() {
		setTitle("Nueva Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaVenta = new JLabel("Fecha");
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVenta.setBounds(55, 45, 48, 14);
		contentPane.add(lblFechaVenta);
		
		JLabel lblDireccion = new JLabel("Direccion de\r\n Entrega");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(20, 70, 154, 34);
		contentPane.add(lblDireccion);
		
		tfFecha = new JTextField();
		tfFecha.setBounds(155, 44, 96, 20);
		contentPane.add(tfFecha);
		tfFecha.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(155, 79, 96, 20);
		contentPane.add(tfDireccion);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(73, 156, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(189, 156, 89, 23);
		contentPane.add(btnCancelar);
	}

}
