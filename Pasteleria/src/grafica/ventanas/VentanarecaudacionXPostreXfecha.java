package grafica.ventanas;

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
import javax.swing.border.EmptyBorder;

import grafica.controladores.ControladorAgregarPostreVenta;
import grafica.controladores.ControladorRecaudacionXPostreXfecha;
import logica.valueobjects.VORecaudado;

public class VentanarecaudacionXPostreXfecha extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoPostre;
	private JTextField tfDia;
	
	private JButton btnCalcular;
	private JButton btnCancelar;
	

	private ControladorRecaudacionXPostreXfecha controlador;
	private JTextField tfAnio;
	private JTextField tfMes;

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
		
		controlador = new ControladorRecaudacionXPostreXfecha(this);
		
		
		JLabel lblCodigoPostre = new JLabel("Codigo postre:");
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoPostre.setBounds(10, 35, 150, 30);
		contentPane.add(lblCodigoPostre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFecha.setBounds(10, 85, 150, 30);
		contentPane.add(lblFecha);
		

		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Menu menu = new Menu();
			    menu.mostrar();  
			    setVisible(false);
			    dispose();
			}
		});
		btnCancelar.setBounds(195, 200, 120, 30);
		contentPane.add(btnCancelar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = tfCodigoPostre.getText().trim();
				String dia = tfDia.getText().trim();
				String mes = tfMes.getText().trim();
				String Anio = tfAnio.getText().trim();
				
				controlador.RecaudacioneXPostreXfecha(codigo,dia,mes,Anio);
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setBounds(60, 200, 120, 30);
		contentPane.add(btnCalcular);
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setBounds(200, 35, 150, 30);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
		tfDia = new JTextField();
		tfDia.setColumns(10);
		tfDia.setBounds(200, 85, 41, 30);
		contentPane.add(tfDia);
		
		tfAnio = new JTextField();
		tfAnio.setColumns(10);
		tfAnio.setBounds(281, 85, 41, 30);
		contentPane.add(tfAnio);
		
		tfMes = new JTextField();
		tfMes.setColumns(10);
		tfMes.setBounds(240, 85, 41, 30);
		contentPane.add(tfMes);
		

	}
	

	// Métodos para mensajes 
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
        tfCodigoPostre.setText("");
    }

    public void mostrarResultado(VORecaudado vo) {
        // Ajustá getters según tu VO (ej: getMontoTotal(), getUnidades(), etc.)
        // Si no tenés getters, podés usar vo.toString()

        String msg =
            "Monto total recaudado: " + vo.getMontoRecaudado() + "\n" +
            "Unidades vendidas: " + vo.getTotalUnidades();

        JOptionPane.showMessageDialog(this, msg);
    }
	
	

	
}
