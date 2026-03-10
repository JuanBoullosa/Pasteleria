package grafica.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;

import grafica.controladores.ControladorAltaPostre;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAltaPostre extends JFrame {

    private ControladorAltaPostre controlador;

    private JPanel contentPane;
    private JTextField tfCodigo;
    private JTextField tfNombre;
    private JTextField tfPrecio;
    private JTextField tfEdulcorante;
    private JTextField tfDescripcion;

    private JLabel lblEdulcorante;
    private JLabel lblDescripcion;
    private JCheckBox chckbxLight;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaAltaPostre frame = new VentanaAltaPostre();
                frame.setVisible(true);
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null,
            			"No se pudo iniciar la ventana.");
            	}
        });
    }

    public VentanaAltaPostre() {

        setTitle("Alta Postre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 505, 437);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		contentPane.setBackground(new Color(198, 233, 251));
        contentPane.setLayout(null);
        
       
        controlador = new ControladorAltaPostre(this);

    	JLabel lblTitulo = new JLabel("Nuevo postre");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 15, 450, 35);
		contentPane.add(lblTitulo);
        
        
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(100, 70, 97, 20);
        lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(100, 105, 105, 25);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(100, 140, 60, 25);
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblPrecio);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(100, 175, 60, 25);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblTipo); 

        tfCodigo = new JTextField();
        tfCodigo.setBounds(180, 70, 200, 25);
        tfCodigo.setColumns(10);
        contentPane.add(tfCodigo);

        tfNombre = new JTextField();
        tfNombre.setBounds(180, 105, 200, 25);
        tfNombre.setColumns(10);
        contentPane.add(tfNombre);

        tfPrecio = new JTextField();
        tfPrecio.setBounds(180, 140, 200, 25);
        tfPrecio.setColumns(10);
        contentPane.add(tfPrecio);

        tfEdulcorante = new JTextField();
        tfEdulcorante.setBounds(180, 205, 200, 25);
        tfEdulcorante.setColumns(10);
        tfEdulcorante.setVisible(false);
        contentPane.add(tfEdulcorante);

        tfDescripcion = new JTextField();
        tfDescripcion.setBounds(180, 240, 200, 25);
        tfDescripcion.setColumns(10);
        tfDescripcion.setVisible(false);
        contentPane.add(tfDescripcion);

        lblEdulcorante = new JLabel("Edulcorante:");
        lblEdulcorante.setBounds(100, 205, 83, 25);
        lblEdulcorante.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEdulcorante.setVisible(false);
        contentPane.add(lblEdulcorante);

        lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setBounds(100, 240, 81, 25);
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDescripcion.setVisible(false);
        contentPane.add(lblDescripcion);

        chckbxLight = new JCheckBox("Light");
        chckbxLight.setBackground(new Color(198, 233, 251));
        chckbxLight.setBounds(180, 175, 81, 23);
        contentPane.add(chckbxLight);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(100, 309, 130, 31);
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(btnAgregar);
        
      
        chckbxLight.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
            boolean seleccionado = chckbxLight.isSelected();

            lblEdulcorante.setVisible(seleccionado);
            tfEdulcorante.setVisible(seleccionado);
            lblDescripcion.setVisible(seleccionado);
            tfDescripcion.setVisible(seleccionado);

            contentPane.revalidate();
            contentPane.repaint();
        			}
        	}
        );
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancelar.setBounds(258, 309, 128, 31);
        contentPane.add(btnCancelar);
        
        btnCancelar.addActionListener(
        	    new ActionListener() {
        	        public void actionPerformed(ActionEvent e) {
        	        	MenuPrincipal menu = new MenuPrincipal();
        	            menu.mostrar();  
        	            setVisible(false); 
        	        }
        	    }
        );
        
        btnAgregar.addActionListener(
        	    new ActionListener() {
        	        public void actionPerformed(ActionEvent e) {
        	        	String codigo = tfCodigo.getText();
        	            String nombre = tfNombre.getText();
        	            String precioTxt = tfPrecio.getText();
        	            boolean esLight = chckbxLight.isSelected();
        	            String edulcorante = tfEdulcorante.getText();
        	            String descripcion = tfDescripcion.getText();

        	            controlador.altaPostre(codigo, nombre, precioTxt, esLight, edulcorante, descripcion); 
        	        }
        	    }
        );
      
    }

    
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void limpiarCampos() {
        tfCodigo.setText("");
        tfNombre.setText("");
        tfPrecio.setText("");
        tfEdulcorante.setText("");
        tfDescripcion.setText("");
        chckbxLight.setSelected(false);
        lblEdulcorante.setVisible(false);
        tfEdulcorante.setVisible(false);
        lblDescripcion.setVisible(false);
        tfDescripcion.setVisible(false);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
	
	

