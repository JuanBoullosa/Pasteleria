package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanarecaudacionXPostreXfecha extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoPostre;
	private JTextField tfCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanarecaudacionXPostreXfecha frame = new VentanarecaudacionXPostreXfecha();
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
	public VentanarecaudacionXPostreXfecha() {
		setTitle("Recaudación por postre y fecha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		JLabel lblCodigoPostre = new JLabel("Codigo postre:");
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoPostre.setBounds(10, 35, 150, 30);
		contentPane.add(lblCodigoPostre);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(10, 85, 150, 30);
		contentPane.add(lblCantidad);
		

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(195, 200, 120, 30);
		contentPane.add(btnCancelar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setBounds(60, 200, 120, 30);
		contentPane.add(btnCalcular);
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setBounds(200, 35, 150, 30);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(200, 85, 150, 30);
		contentPane.add(tfCantidad);
		

	}

}
