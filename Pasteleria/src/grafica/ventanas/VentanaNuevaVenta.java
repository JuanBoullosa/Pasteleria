package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controladores.ControladorNuevaVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaNuevaVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAnio;
	private JTextField txfDireccion;
	
	private JButton btnIniciar;
	private JButton btnCancelar;
	
	private ControladorNuevaVenta controlador;
	

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
					JOptionPane.showMessageDialog(null,
							"No se pudo iniciar la ventana.");
					}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaNuevaVenta() {
		setBackground(new Color(240, 240, 240));
		setTitle("Nueva Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controlador  = new ControladorNuevaVenta(this);
		
		
		JLabel lblTitulo = new JLabel("Nueva Venta");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(100, 15, 250, 35);
		contentPane.add(lblTitulo);
		
		
		JLabel lblFechaVenta = new JLabel("Fecha:");
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVenta.setBounds(16, 75, 48, 20);
		contentPane.add(lblFechaVenta);

		
		
		
	
		tfDia = new JTextField("dd");
		tfDia.setForeground(Color.GRAY);
		tfDia.setHorizontalAlignment(JTextField.CENTER);
		tfDia.setBounds(160, 75, 45, 25);
		contentPane.add(tfDia);
		tfDia.setColumns(10);

		tfDia.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				if (tfDia.getText().equals("dd")) {
					tfDia.setText("");
		            tfDia.setForeground(Color.BLACK);

				}
			}

			public void focusLost(java.awt.event.FocusEvent e) {
				if (tfDia.getText().isEmpty()) {
					tfDia.setText("dd");
		            tfDia.setForeground(Color.GRAY);


				}
			}
		});
		
		tfMes = new JTextField("mm");
		tfMes.setForeground(Color.GRAY);
		tfMes.setHorizontalAlignment(JTextField.CENTER);

		tfMes.setColumns(10);
		tfMes.setBounds(225, 75, 45, 25);
		contentPane.add(tfMes);

		tfMes.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				if (tfMes.getText().equals("mm")) {
					tfMes.setText("");
					tfMes.setForeground(Color.BLACK);

				}
			}

			public void focusLost(java.awt.event.FocusEvent e) {
				if (tfMes.getText().isEmpty()) {
					tfMes.setText("mm");
					tfMes.setForeground(Color.GRAY);

				}
			}
		});
		tfAnio = new JTextField("aaaa");
		tfAnio.setForeground(Color.GRAY);
		tfAnio.setHorizontalAlignment(JTextField.CENTER);
		tfAnio.setColumns(10);
		tfAnio.setBounds(290, 75, 60, 25);
		contentPane.add(tfAnio);

		tfAnio.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				if (tfAnio.getText().equals("aaaa")) {
					tfAnio.setText("");
					tfAnio.setForeground(Color.BLACK);

				}
			}

			public void focusLost(java.awt.event.FocusEvent e) {
				if (tfAnio.getText().isEmpty()) {
					tfAnio.setText("aaaa");
					tfAnio.setForeground(Color.GRAY);

				}
			}
		});
		

		JLabel lblBarra1 = new JLabel("/");
		lblBarra1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBarra1.setBounds(210, 75, 10, 25);
		contentPane.add(lblBarra1);

		JLabel lblBarra2 = new JLabel("/");
		lblBarra2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBarra2.setBounds(275, 75, 10, 25);
		contentPane.add(lblBarra2);

		
		
		
		JLabel lblDireccion = new JLabel("Direccion de Entrega:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(16, 110, 154, 25);
		contentPane.add(lblDireccion);
		
		txfDireccion = new JTextField();
		txfDireccion.setBounds(160, 110, 210, 25);
		contentPane.add(txfDireccion);
		txfDireccion.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dia = tfDia.getText().trim();
				String mes = tfMes.getText().trim();
				String Anio = tfAnio.getText().trim();
				String direccion = txfDireccion.getText().trim();
				controlador.NuevaVenta(dia,mes,Anio,direccion);
				
			}
		});
		btnIniciar.setBounds(130, 180, 90, 25);
		contentPane.add(btnIniciar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
				
			}
		});
		btnCancelar.setBounds(230, 180, 90, 25);
		contentPane.add(btnCancelar);

		
		
		
		
	}
		
		
		//Métodos para mensajes

	    public void mostrarInfo(String msg) {
	        JOptionPane.showMessageDialog(this, msg);
	    }

	    public void mostrarError(String msg) {
	        JOptionPane.showMessageDialog(this, msg);
	    }
		

	    public void limpiar() {
	        tfDia.setText("");
	        tfMes.setText("");
	        tfAnio.setText("");
	        txfDireccion.setText("");
	    }
}
