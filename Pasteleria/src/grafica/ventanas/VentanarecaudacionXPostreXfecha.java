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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		
		controlador = new ControladorRecaudacionXPostreXfecha(this);
		
		JLabel lblTitulo = new JLabel("Recaudación");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 450, 35);
		contentPane.add(lblTitulo);
		
		
		
		JLabel lblCodigoPostre = new JLabel("Codigo postre:");
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoPostre.setBounds(16, 110, 154, 25);
		contentPane.add(lblCodigoPostre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(16, 75, 48, 20);
		contentPane.add(lblFecha);
		

		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Menu menu = new Menu();
			    menu.mostrar();  
			    setVisible(false);
			    dispose();
			}
		});
		btnCancelar.setBounds(230, 180, 90, 25);
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
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcular.setBounds(130, 180, 90, 25);
		contentPane.add(btnCalcular);
		
		tfCodigoPostre = new JTextField();
		tfCodigoPostre.setBounds(160, 110, 210, 25);
		contentPane.add(tfCodigoPostre);
		tfCodigoPostre.setColumns(10);
		
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
        String msg =
            "Monto total recaudado: " +"$"+  vo.getMontoRecaudado() + "\n" +
            "Unidades vendidas: " + vo.getTotalUnidades();

        JOptionPane.showMessageDialog(this, msg);
    }
	
	

	
}
