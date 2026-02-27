package logica.monitor;

public class Monitor {

	private int cantLectores;
	private boolean escribiendo;
	
	
		public Monitor() {
	        cantLectores = 0;
	        escribiendo = false;
		    }
	    // COMIENZO LECTURA
		//Si hay un escritor trabajando, el lector espera
	    public synchronized void comienzoLectura() {
	        try {
	            while (escribiendo == true) {
	                wait();
	            }
	            cantLectores = cantLectores + 1;

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // TERMINO LECTURA
	    //Si era el ultimo lector, despierta a los escritores que estaban esperando
	    public synchronized void terminoLectura() {
	        
	    	cantLectores = cantLectores - 1;
	        if (cantLectores == 0) {
	            notifyAll();
	        }
	    }

	    // COMIENZO ESCRITURA
	    //si alguien esta escribiendo, espera
	    public synchronized void comienzoEscritura() {
	        try {
	        	//Si alguien esta escribiendo el lector espera
	            while (escribiendo == true || cantLectores > 0) {
	                wait();
	            }

	            escribiendo = true;

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    // TERMINO ESCRITURA
	    //Avisa que no esta escribiendo, avisa al resto que pueden entrar a leer o escribir
	    public synchronized void terminoEscritura() {

	        escribiendo = false;
	        notifyAll();
	    }

	
	
}
