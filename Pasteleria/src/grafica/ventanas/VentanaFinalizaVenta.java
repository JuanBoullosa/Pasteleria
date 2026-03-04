package grafica.ventanas;

import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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
					e.printStackTrace();
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
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblNumeroVenta = new JLabel("Numero de venta en proceso:");
	    lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblNumeroVenta.setBounds(30, 25, 300, 30);
	    contentPane.add(lblNumeroVenta);

	    tfNumeroVenta = new JTextField();
	    tfNumeroVenta.setBounds(30, 60, 240, 30);
	    contentPane.add(tfNumeroVenta);

	    rdbtnConfirmar = new JRadioButton("Confirmar");
	    rdbtnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    rdbtnConfirmar.setBounds(30, 110, 240, 23);
	    contentPane.add(rdbtnConfirmar);

	    rdbtnCancelarVenta = new JRadioButton("Cancelar venta");
	    rdbtnCancelarVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    rdbtnCancelarVenta.setBounds(30, 140, 240, 23);
	    contentPane.add(rdbtnCancelarVenta);

	    ButtonGroup grupo = new ButtonGroup();
	    grupo.add(rdbtnConfirmar);
	    grupo.add(rdbtnCancelarVenta);

	    JButton btnConfirmar = new JButton("Confirmar");
	    btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnConfirmar.setBounds(57, 200, 120, 30);
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
	    btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnCancelar.setBounds(195, 200, 120, 30);
	    contentPane.add(btnCancelar);
	    
	    btnCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Menu menu = new Menu();
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
	

