package grafica.ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;

import grafica.controladores.ControladorAltaPostre;

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
                e.printStackTrace();
            }
        });
    }

    public VentanaAltaPostre() {

        setTitle("Alta Postre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 504, 360);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

       
        controlador = new ControladorAltaPostre(this);

        JLabel lblCodigo = new JLabel("Codigo Postre");
        lblCodigo.setBounds(29, 35, 97, 20);
        lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblNombre = new JLabel("Nombre Postre");
        lblNombre.setBounds(29, 67, 105, 20);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblPrecio = new JLabel("Precio $");
        lblPrecio.setBounds(29, 99, 56, 20);
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(29, 131, 30, 20);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));

        tfCodigo = new JTextField();
        tfCodigo.setBounds(154, 37, 200, 20);
        tfCodigo.setColumns(10);

        tfNombre = new JTextField();
        tfNombre.setBounds(154, 69, 200, 20);
        tfNombre.setColumns(10);

        tfPrecio = new JTextField();
        tfPrecio.setBounds(154, 101, 200, 20);
        tfPrecio.setColumns(10);

        tfEdulcorante = new JTextField();
        tfEdulcorante.setBounds(154, 167, 200, 20);
        tfEdulcorante.setColumns(10);
        tfEdulcorante.setVisible(false);

        tfDescripcion = new JTextField();
        tfDescripcion.setBounds(154, 199, 200, 20);
        tfDescripcion.setColumns(10);
        tfDescripcion.setVisible(false);

        lblEdulcorante = new JLabel("Edulcorante");
        lblEdulcorante.setBounds(29, 165, 83, 20);
        lblEdulcorante.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEdulcorante.setVisible(false);

        lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setBounds(29, 197, 81, 20);
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDescripcion.setVisible(false);

        chckbxLight = new JCheckBox("Light");
        chckbxLight.setBounds(154, 132, 81, 23);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(270, 249, 130, 31);
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.setLayout(null);
        contentPane.add(lblCodigo);
        contentPane.add(lblNombre);
        contentPane.add(lblPrecio);
        contentPane.add(lblTipo);
        contentPane.add(lblEdulcorante);
        contentPane.add(lblDescripcion);
        contentPane.add(tfCodigo);
        contentPane.add(tfNombre);
        contentPane.add(tfPrecio);
        contentPane.add(chckbxLight);
        contentPane.add(tfEdulcorante);
        contentPane.add(tfDescripcion);
        contentPane.add(btnAgregar);

        chckbxLight.addActionListener(e -> {
            boolean seleccionado = chckbxLight.isSelected();

            lblEdulcorante.setVisible(seleccionado);
            tfEdulcorante.setVisible(seleccionado);
            lblDescripcion.setVisible(seleccionado);
            tfDescripcion.setVisible(seleccionado);

            contentPane.revalidate();
            contentPane.repaint();
        });

        btnAgregar.addActionListener(e -> {
            String codigo = tfCodigo.getText();
            String nombre = tfNombre.getText();
            String precioTxt = tfPrecio.getText();
            boolean esLight = chckbxLight.isSelected();
            String edulcorante = tfEdulcorante.getText();
            String descripcion = tfDescripcion.getText();

            controlador.altaPostre(codigo, nombre, precioTxt, esLight, edulcorante, descripcion);
        });
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
	
	

