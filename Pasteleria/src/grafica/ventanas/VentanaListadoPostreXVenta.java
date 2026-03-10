package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import grafica.controladores.ControladorListadoPostrexVenta;
import logica.valueobjects.VOVenta;
import logica.valueobjects.VOPostreCantidad;

public class VentanaListadoPostreXVenta extends JFrame {

	private JPanel contentPane;
	private JTable tableListadoPostresXVenta;
	private JTextField tfnNumeroVenta;
	
	private ControladorListadoPostrexVenta controlador ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoPostreXVenta frame = new VentanaListadoPostreXVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"No se pudo iniciar la ventana.");
					}
			}
		});
	}

	public VentanaListadoPostreXVenta() {
		setTitle("Listado de postres de una venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 233, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controlador = new ControladorListadoPostrexVenta(this);
		
		JLabel lblTitulo = new JLabel("Lista de postres en una venta");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 600, 35);
		contentPane.add(lblTitulo);
		
		
		
		
		JLabel lblNumeroVenta = new JLabel("Número de venta:");
		lblNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroVenta.setBounds(30, 61, 150, 25);
		contentPane.add(lblNumeroVenta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 103, 521, 300);
		contentPane.add(scrollPane_1);
		
		tableListadoPostresXVenta = new JTable();
		tableListadoPostresXVenta.setModel(new DefaultTableModel(
			new Object[][] {},
			new String [] { "Codigo", "Nombre", "Precio", "Tipo", "Cantidad"}	
		));
		tableListadoPostresXVenta.getColumnModel().getColumn(1).setPreferredWidth(199);
		scrollPane_1.setViewportView(tableListadoPostresXVenta);
		
		tfnNumeroVenta = new JTextField();
		tfnNumeroVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnNumeroVenta.setBounds(150, 61, 100, 25);
		contentPane.add(tfnNumeroVenta);
		tfnNumeroVenta.setColumns(10);

		

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMostrar.setBounds(451, 61, 100, 25);
		contentPane.add(btnMostrar);
		btnMostrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String numVenta = tfnNumeroVenta.getText().trim();
				controlador.cargarListado(numVenta);
			}
		});		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
			    menu.mostrar();  
			    setVisible(false);
			    dispose();
			}
		});
		
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(250, 430, 100, 25);
		contentPane.add(btnCancelar);
	}

	// Método para cargar la tabla
	public void cargarTabla(ArrayList<VOPostreCantidad> lista2) {
		DefaultTableModel modelo = (DefaultTableModel) tableListadoPostresXVenta.getModel();
		modelo.setRowCount(0);

		for (VOPostreCantidad v : lista2) {
			Object[] fila = {
				v.getCodigo(),
				v.getNombre(),
				v.getPrecio(),
				v.getTipo(),
				v.getCantidad()
			};
			modelo.addRow(fila);
		}
	}
	
	// Método para mostrar mensajes
	public void mostrarMensaje(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
