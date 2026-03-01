package grafica.ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class VentanaFinalizaVenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFinalizaVenta frame = new VentanaFinalizaVenta();
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
	public VentanaFinalizaVenta() {
		setTitle("Finalizcion de una venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroVenta = new JLabel("Numero de venta en proceso:");
		lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroVenta.setBounds(30, 25, 240, 30);
		contentPane.add(lblNumeroVenta);
		
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(195, 200, 120, 30);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBounds(57, 200, 120, 30);
		contentPane.add(btnConfirmar);
		
		tfNumeroVenta = new JTextField();
		tfNumeroVenta.setBounds(30, 60, 240, 30);
		contentPane.add(tfNumeroVenta);
		tfNumeroVenta.setColumns(10);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
		rdbtnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnConfirmar.setBounds(30, 110, 240, 23);
		contentPane.add(rdbtnConfirmar);
		
		JRadioButton rdbtnCancelarVenta = new JRadioButton("Cancelar venta");
		rdbtnCancelarVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnCancelarVenta.setBounds(30, 140, 240, 23);
		contentPane.add(rdbtnCancelarVenta);
		
	
	}
}
