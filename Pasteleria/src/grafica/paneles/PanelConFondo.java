package grafica.paneles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image imagen;
	
	public PanelConFondo (String ruta ) {
		imagen = new ImageIcon(ruta).getImage();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    int panelWidth = getWidth();
	    int panelHeight = getHeight();

	    int imgWidth = imagen.getWidth(this);
	    int imgHeight = imagen.getHeight(this);

	    double panelRatio = (double) panelWidth / panelHeight;
	    double imgRatio = (double) imgWidth / imgHeight;

	    int newWidth;
	    int newHeight;

	    if (panelRatio > imgRatio) {
	        newWidth = panelWidth;
	        newHeight = (int) (panelWidth / imgRatio);
	    } else {
	        newHeight = panelHeight;
	        newWidth = (int) (panelHeight * imgRatio);
	    }

	    int x = (panelWidth - newWidth) / 2;
	    int y = (panelHeight - newHeight) / 2;

	    g.drawImage(imagen, x, y, newWidth, newHeight, this);
	}

}
