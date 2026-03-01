package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaAltaPostre extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfEdulcorante;
	private JTextField tfDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAltaPostre frame = new VentanaAltaPostre();
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
	public VentanaAltaPostre() {
		setTitle("Alta Postre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(29, 37, 70, 22);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(29, 70, 70, 22);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(29, 103, 70, 22);
		contentPane.add(lblPrecio);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(126, 41, 96, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(126, 74, 96, 20);
		contentPane.add(tfNombre);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(126, 107, 96, 20);
		contentPane.add(tfPrecio);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(216, 231, 112, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(29, 137, 59, 22);
		contentPane.add(lblTipo);
		
		JCheckBox chckbxLight = new JCheckBox("Light");
		chckbxLight.setBounds(126, 140, 99, 23);
		contentPane.add(chckbxLight);
		
		tfEdulcorante = new JTextField();
		tfEdulcorante.setColumns(10);
		tfEdulcorante.setBounds(126, 170, 96, 20);
		tfEdulcorante.setVisible(false);
		contentPane.add(tfEdulcorante);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(126, 200, 96, 20);
		tfDescripcion.setVisible(false);
		contentPane.add(tfDescripcion);
		
		JLabel lblEdulcorante = new JLabel("Edulcorante");
		lblEdulcorante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdulcorante.setBounds(18, 173, 89, 17);
		lblEdulcorante.setVisible(false);
		contentPane.add(lblEdulcorante);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(18, 203, 98, 17);
		lblDescripcion.setVisible(false);
		contentPane.add(lblDescripcion);
	}
}
