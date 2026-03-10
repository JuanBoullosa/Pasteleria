package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import grafica.controladores.ControladorMenuPrincipal;
import grafica.paneles.PanelConFondo;

import javax.swing.JPanel;

public class MenuPrincipal {

	private JFrame frame;
	private JPanel contentPane;
	
	private ControladorMenuPrincipal controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"No se pudo iniciar la ventana.");
					}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		
		
	
		
		// Panel con imagen de fondo
        contentPane = new PanelConFondo("src/grafica/paneles/fondoPasteleria.jpg");
        contentPane.setLayout(null);
    	
        
        JLabel lblTitulo = new JLabel("Pasteleria");
		lblTitulo.setBounds(210, 180, 450, 80);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 45));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo);
        
		
		frame.setContentPane(contentPane);
		
		controlador = new ControladorMenuPrincipal(this);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
					
		JMenu mnNewMenuPOSTRES = new JMenu("POSTRES");
		menuBar.add(mnNewMenuPOSTRES);
		
		JMenuItem itm1RegistrarPostre = new JMenuItem("1 - REGISTRAR POSTRE");
		mnNewMenuPOSTRES.add(itm1RegistrarPostre);
		
		JMenuItem itm2ListadoGralPostres = new JMenuItem("2 - LISTADO GENERAL POSTRES");
		mnNewMenuPOSTRES.add(itm2ListadoGralPostres);
		
		JMenuItem itm3DetallePostre = new JMenuItem("3 - DETALLE DE UN POSTRE");
		mnNewMenuPOSTRES.add(itm3DetallePostre);
		
		JMenu mnNewMenuVENTAS = new JMenu("VENTAS");
		menuBar.add(mnNewMenuVENTAS);
		
		JMenuItem itm4NuevaVenta = new JMenuItem("4 - NUEVA VENTA");
		mnNewMenuVENTAS.add(itm4NuevaVenta);
		
		JMenuItem itm5IngresarPostreVenta = new JMenuItem("5 - INGRESAR UN POSTRE A UNA VENTA");
		mnNewMenuVENTAS.add(itm5IngresarPostreVenta);
		
		JMenuItem itm6EliminarPostreVenta = new JMenuItem("6 - ELIMINAR UN POSTRE DE UNA VENTA");
		mnNewMenuVENTAS.add(itm6EliminarPostreVenta);
		
		JMenuItem itm7FinalizarCancelarVenta = new JMenuItem("7 - FINALIZO O CANCELO UNA VENTA");
		mnNewMenuVENTAS.add(itm7FinalizarCancelarVenta);
		
		
		JMenuItem itm8ListadoVentas = new JMenuItem("8 - LISTADO DE VENTAS");
		mnNewMenuVENTAS.add(itm8ListadoVentas);
		
		JMenuItem itm9ListadoPostresVenta = new JMenuItem("9 - LISTADO DE POSTRES EN UNA VENTA");
		mnNewMenuVENTAS.add(itm9ListadoPostresVenta);
		
		
		JMenu mnNewMenuRECAUDACION = new JMenu("RECAUDACION");
		menuBar.add(mnNewMenuRECAUDACION);
		
		JMenuItem itm10RecaudadoPostrexFecha = new JMenuItem("10 - RECAUDACION POR POSTRE Y FECHA");
		mnNewMenuRECAUDACION.add(itm10RecaudadoPostrexFecha);
		
		JMenu mnNewMenuRESPALDO = new JMenu("RESPALDO");
		menuBar.add(mnNewMenuRESPALDO);
		
		JMenuItem itm11Respalar = new JMenuItem("11 - RESPALDAR");
		mnNewMenuRESPALDO.add(itm11Respalar);
	
	
		//Requerimiento 1
		itm1RegistrarPostre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        VentanaAltaPostre ventana = new VentanaAltaPostre();
		        ventana.setVisible(true);

		        frame.setVisible(false); 
		    }
		});
	
		//Requermiento 2
		itm2ListadoGralPostres.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        VentanaListadoGeneral ventana = new VentanaListadoGeneral();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				//Requermiento 3
				
		itm3DetallePostre.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        VentanaListadoDetallado ventana = new VentanaListadoDetallado();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				
				//Requermiento 4
		itm4NuevaVenta.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        VentanaNuevaVenta ventana = new VentanaNuevaVenta();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				//Requermiento 5
		itm5IngresarPostreVenta.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				    	VentanaAgregarPostreEnVenta ventana = new VentanaAgregarPostreEnVenta();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				//Requermiento 6
		itm6EliminarPostreVenta.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				    	VentanaEliminarOBorrarPostre ventana = new VentanaEliminarOBorrarPostre();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				
				
				
				//Requermiento 7
		itm7FinalizarCancelarVenta.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        VentanaFinalizaVenta ventana = new VentanaFinalizaVenta();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				//Requermiento 8
				
		itm8ListadoVentas.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        VentanaListadoVentasxEstado ventana = new VentanaListadoVentasxEstado();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				//Requermiento 9
				
		itm9ListadoPostresVenta.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				    	VentanaListadoPostreXVenta ventana = new VentanaListadoPostreXVenta();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
				
				//Requermiento 10
		itm10RecaudadoPostrexFecha.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				    	VentanarecaudacionXPostreXfecha ventana = new VentanarecaudacionXPostreXfecha();
				        ventana.setVisible(true);

				        frame.setVisible(false); 
				    }
				});
		
		itm11Respalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.RespaldarMenuPrincipal();}
		
		});
	
	}	
		
			public void mostrar() {
			frame.setVisible(true);
		}
	    public void mostrarInfo(String msg) {
	        JOptionPane.showMessageDialog( frame, msg);
	    }

	    public void mostrarError(String msg) {
	        JOptionPane.showMessageDialog(frame, msg);
	    }
	}
	

