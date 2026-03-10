package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import grafica.controladores.ControladorAgregarPostreVenta;
import grafica.controladores.ControladorEliminarOBorrarPostre;

public class VentanaEliminarOBorrarPostre extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoPostre;
	private JTextField tfCantidad;
	private JTextField tfNumeroVenta;
	
	
	private JButton btnEliminar;
	private JButton btnCancelar;
	
	private ControladorEliminarOBorrarPostre controlador;

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
					JOptionPane.showMessageDialog(null,
							"No se pudo iniciar la ventana.");
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		controlador  = new ControladorEliminarOBorrarPostre(this);

		
		JLabel lblTitulo = new JLabel("Eliminar postre en una venta");
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
		tfCodigoPostre.setBounds(160, 70, 100, 25);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(160, 140, 100, 25);
		contentPane.add(tfCantidad);
		
		tfNumeroVenta = new JTextField();
		tfNumeroVenta.setColumns(10);
		tfNumeroVenta.setBounds(160, 105, 100, 25);
		contentPane.add(tfNumeroVenta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
			    dispose();
			}
		});
		btnCancelar.setBounds(230, 200, 90, 25);
		contentPane.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = tfCodigoPostre.getText().trim();
				String numventa = tfNumeroVenta.getText().trim();
				String cant = tfCantidad.getText().trim();
				
				controlador.EliminarOBorrarPostre(codigo,numventa,cant);
				
				
				
			}
		});
		
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(130, 200, 90, 25);
		contentPane.add(btnEliminar);
		

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
