package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

import grafica.controladores.ControladorFinalizaVenta;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaFinalizaVenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumeroVenta;
	private JRadioButton rdbtnConfirmar;
	private JRadioButton rdbtnCancelarVenta;
	
	private ControladorFinalizaVenta controlador;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFinalizaVenta frame = new VentanaFinalizaVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"No se pudo iniciar la ventana.");
					}
			}
		});
	}

	

		
	public VentanaFinalizaVenta() {

	    controlador = new ControladorFinalizaVenta(this);

	    setTitle("Finalizacion de una venta");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 400, 300);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(198, 233, 251));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblTitulo = new JLabel("Finalizar venta");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 400, 35);
		contentPane.add(lblTitulo);
	    
	    
	    
	    JLabel lblNumeroVenta = new JLabel("Numero de venta en proceso:");
	    lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNumeroVenta.setBounds(80, 55, 300, 30);
	    contentPane.add(lblNumeroVenta);

	    tfNumeroVenta = new JTextField();
	    tfNumeroVenta.setBounds(80, 85, 240, 30);
	    contentPane.add(tfNumeroVenta);

	    rdbtnConfirmar = new JRadioButton("Confirmar");
	    rdbtnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    rdbtnConfirmar.setBackground(new Color(198, 233, 251));

	    rdbtnConfirmar.setBounds(80, 120, 240, 23);
	    contentPane.add(rdbtnConfirmar);

	    rdbtnCancelarVenta = new JRadioButton("Cancelar venta");
	    rdbtnCancelarVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    rdbtnCancelarVenta.setBackground(new Color(198, 233, 251));
	    rdbtnCancelarVenta.setBounds(80, 155, 240, 23);
	    contentPane.add(rdbtnCancelarVenta);

	    ButtonGroup grupo = new ButtonGroup();
	    grupo.add(rdbtnConfirmar);
	    grupo.add(rdbtnCancelarVenta);

	    JButton btnConfirmar = new JButton("Confirmar");
	    btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnConfirmar.setBounds(90, 200, 100, 25);
	    contentPane.add(btnConfirmar);

	    btnConfirmar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {

	            String numVenta = tfNumeroVenta.getText().trim();
	            String indicacion = "";

	            if (rdbtnConfirmar.isSelected()) {
	                indicacion = "CONFIRMAR";
	            } else if (rdbtnCancelarVenta.isSelected()) {
	                indicacion = "CANCELAR";
	            }

	            controlador.finalizarVenta(numVenta, indicacion);
	        }
	    });

	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    btnCancelar.setBounds(210, 200, 100, 25);
	    contentPane.add(btnCancelar);
	    
	    btnCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
			
	        }
	    });
	}
	// ===== Métodos para mensajes =====

    public void mostrarInfo(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
	

    public void limpiar() {
        tfNumeroVenta.setText("");
    }
}
	

