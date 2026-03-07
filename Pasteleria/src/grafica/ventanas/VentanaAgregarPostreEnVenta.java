package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controladores.ControladorAgregarPostreVenta;
import grafica.controladores.ControladorNuevaVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarPostreEnVenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoPostre;
	private JTextField tfCantidad;
	private JTextField tfNumeroVenta;
	
	private JButton btnAgregar;
	private JButton btnCancelar;
	
	private ControladorAgregarPostreVenta controlador;
	
	

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		controlador  = new ControladorAgregarPostreVenta(this);

		JLabel lblTitulo = new JLabel("Ingresar postre en una venta");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 450, 35);
		contentPane.add(lblTitulo);
		
		JLabel lblCodigoPostre = new JLabel("Codigo postre:");
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoPostre.setBounds(32, 70, 150, 30);
		contentPane.add(lblCodigoPostre);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(32, 140, 150, 30);
		contentPane.add(lblCantidad);
		
		JLabel lblNumeroVenta = new JLabel("Numero de venta:");
		lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroVenta.setBounds(32, 105, 150, 30);
		contentPane.add(lblNumeroVenta);
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoPostre.setBounds(160, 70, 100, 25);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(160, 140, 100, 25);
		contentPane.add(tfCantidad);
		
		tfNumeroVenta = new JTextField();
		tfNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNumeroVenta.setColumns(10);
		tfNumeroVenta.setBounds(160, 105, 100, 25);
		contentPane.add(tfNumeroVenta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(230, 200, 90, 25);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
			    dispose();
			}
		});
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setBounds(130, 200, 90, 25);
		contentPane.add(btnAgregar);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = tfCodigoPostre.getText().trim();
				String numventa = tfNumeroVenta.getText().trim();
				String cant = tfCantidad.getText().trim();
				
				controlador.AgregarPostreVenta(codigo,numventa,cant);
			}
		});
		
		
	}
	
	  public void mostrarInfo(String msg) {
	        JOptionPane.showMessageDialog(this, msg);
	    }

	    public void mostrarError(String msg) {
	        JOptionPane.showMessageDialog(this, msg);
	    }
		

	    public void limpiar() {
	        tfCodigoPostre.setText("");
	        tfNumeroVenta.setText("");
	        tfCantidad.setText("");
	    }
		
		
	
	
	
	
}
