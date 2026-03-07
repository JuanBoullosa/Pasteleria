package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controladores.ControladorNuevaVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
		
		controlador  = new ControladorNuevaVenta(this);
		
		JLabel lblFechaVenta = new JLabel("Fecha:");
		lblFechaVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaVenta.setBounds(37, 61, 48, 14);
		contentPane.add(lblFechaVenta);
		
		tfDia = new JTextField();
		tfDia.setBounds(126, 61, 48, 19);
		contentPane.add(tfDia);
		tfDia.setColumns(10);
		
		tfMes = new JTextField();
		tfMes.setColumns(10);
		tfMes.setBounds(172, 61, 48, 19);
		contentPane.add(tfMes);
		
		tfAnio = new JTextField();
		tfAnio.setColumns(10);
		tfAnio.setBounds(215, 61, 48, 19);
		contentPane.add(tfAnio);

		JLabel lblDireccion = new JLabel("Direccion de\r\n Entrega");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(8, 97, 154, 34);
		contentPane.add(lblDireccion);
		
		txfDireccion = new JTextField();
		txfDireccion.setBounds(158, 102, 91, 29);
		contentPane.add(txfDireccion);
		txfDireccion.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dia = tfDia.getText().trim();
				String mes = tfMes.getText().trim();
				String Anio = tfAnio.getText().trim();
				String direccion = txfDireccion.getText().trim();
				controlador.NuevaVenta(dia,mes,Anio,direccion);
			}
		});
		btnIniciar.setBounds(73, 156, 89, 23);
		contentPane.add(btnIniciar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
				
			}
		});
		btnCancelar.setBounds(189, 156, 89, 23);
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
