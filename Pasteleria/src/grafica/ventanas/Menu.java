package grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class Menu{

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 450, 344);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JButton btn_1RegistrarPostre = new JButton("1 - REGISTRAR POSTRE");
		btn_1RegistrarPostre.setHorizontalAlignment(SwingConstants.LEFT);
		btn_1RegistrarPostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_1RegistrarPostre.setBounds(21, 11, 292, 23);
		frmMenuPrincipal.getContentPane().add(btn_1RegistrarPostre);
		
		JButton btn_2ListadoGralPostres = new JButton("2 - LISTADO GENERAL POSTRES");
		btn_2ListadoGralPostres.setHorizontalAlignment(SwingConstants.LEFT);
		btn_2ListadoGralPostres.setBounds(22, 37, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_2ListadoGralPostres);
		
		JButton btn_4AltaVenta = new JButton("4 - NUEVA VENTA");
		btn_4AltaVenta.setHorizontalAlignment(SwingConstants.LEFT);
		btn_4AltaVenta.setBounds(22, 85, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_4AltaVenta);
		
		JButton btn_5IngresoPostreaVenta = new JButton("5 - INGRESAR UN POSTRE A UNA VENTA");
		btn_5IngresoPostreaVenta.setHorizontalAlignment(SwingConstants.LEFT);
		btn_5IngresoPostreaVenta.setBounds(22, 108, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_5IngresoPostreaVenta);
		
		JButton btn_7Finaliza_o_Cancela = new JButton("7 - FINALIZO O CANCELO UNA VENTA ");
		btn_7Finaliza_o_Cancela.setHorizontalAlignment(SwingConstants.LEFT);
		btn_7Finaliza_o_Cancela.setBounds(22, 156, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_7Finaliza_o_Cancela);
		
		JButton btn_6EliminarPostredeVenta = new JButton("6 - ELIMINAR UN POSTRE DE UNA VENTA");
		btn_6EliminarPostredeVenta.setHorizontalAlignment(SwingConstants.LEFT);
		btn_6EliminarPostredeVenta.setBounds(22, 132, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_6EliminarPostredeVenta);
		
		JButton btn_9ListadoPostresVenta = new JButton("9 - LISTADO DE POSTRES EN UNA VENTA");
		btn_9ListadoPostresVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_9ListadoPostresVenta.setHorizontalAlignment(SwingConstants.LEFT);
		btn_9ListadoPostresVenta.setBounds(22, 202, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_9ListadoPostresVenta);
		
		JButton btn_3DetalledeUnPostre = new JButton("3 - DETALLE DE UN POSTRE");
		btn_3DetalledeUnPostre.setHorizontalAlignment(SwingConstants.LEFT);
		btn_3DetalledeUnPostre.setBounds(22, 60, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_3DetalledeUnPostre);
		
		JButton btn_8ListadoVentas = new JButton("8 - LISTADO DE VENTAS");
		btn_8ListadoVentas.setHorizontalAlignment(SwingConstants.LEFT);
		btn_8ListadoVentas.setBounds(22, 179, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_8ListadoVentas);
		
		JButton btn_10RecaudacionxPostreyFecha = new JButton("10 - RECAUDACION POR POSTRE Y FECHA");
		btn_10RecaudacionxPostreyFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_10RecaudacionxPostreyFecha.setHorizontalAlignment(SwingConstants.LEFT);
		btn_10RecaudacionxPostreyFecha.setBounds(22, 229, 291, 23);
		frmMenuPrincipal.getContentPane().add(btn_10RecaudacionxPostreyFecha);
		
		JButton btn_11Respaldar = new JButton("Respaldar");
		btn_11Respaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_11Respaldar.setHorizontalAlignment(SwingConstants.LEFT);
		btn_11Respaldar.setBounds(325, 273, 101, 23);
		frmMenuPrincipal.getContentPane().add(btn_11Respaldar);
	
		
		//Requermiento 1 
		btn_1RegistrarPostre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaAltaPostre ventana = new VentanaAltaPostre();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		
		//Requermiento 2
		btn_2ListadoGralPostres.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaListadoGeneral ventana = new VentanaListadoGeneral();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		
		//Requermiento 3
		
		//Requermiento 4
		btn_4AltaVenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaNuevaVenta ventana = new VentanaNuevaVenta();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		//Requermiento 5
		btn_5IngresoPostreaVenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		    	VentanaAgregarPostreEnVenta ventana = new VentanaAgregarPostreEnVenta();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		
		//Requermiento 6
		btn_6EliminarPostredeVenta.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		    	VentanaEliminarOBorrarPostre ventana = new VentanaEliminarOBorrarPostre();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		
		
		
		
		//Requermiento 7
		btn_7Finaliza_o_Cancela.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaFinalizaVenta ventana = new VentanaFinalizaVenta();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		//Requermiento 8
		
		btn_8ListadoVentas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaListadoVentasxEstado ventana = new VentanaListadoVentasxEstado();
		        ventana.setVisible(true);

		        frmMenuPrincipal.setVisible(false); 
		    }
		});
		
		//Requermiento 9
		
		//Requermiento 10
		
		//Requermiento 11
		
		
	}
	
	public void mostrar() {
	    frmMenuPrincipal.setVisible(true);
	}
	
	
	
}
