package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

//import fachada.LocalDate;
import logica.valueobjects.*;
import logica.excepciones.*;

public interface IFachada extends Remote {

	//AGREGAR TODOS LOS METODOS 
	
	// Requerimiento 1 Alta Postre ok 
    public void registrarPostre(VOPostre voP) throws RemoteException, AlfanumericoException, PostreException, PrecioException;

    // Requerimiento 2 Listado General de Postres 
    public ArrayList<VOPostre> ListadoGeneralPostre() throws RemoteException;

    // Requerimiento 3 Detalles de Un Postre
    public VOPostreDetallado ListarPostreDetallado(String codigo) throws RemoteException, AlfanumericoException, PostreException;

    //Requerimiento 4 Nueva Venta
    public void nuevaVenta(VOVentaIngreso vovi) throws RemoteException, FechaException;
    
    //Requerimiento 5 Agregar Postre a una venta
    public void agregarPostreEnVenta (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException, LimiteUnidadesException,IngresoCantidadException, RemoteException;
    
    //Requerimiento 6
    public void eliminarOBorrarPostreEs_Vendidos (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException, RemoteException, NumberFormatException;
    
  	//REQUERIMIENTO 7
    public float finalizarVenta (int numVenta,String indicacion) throws ExisteVentaException,IndicacionException, FinalizadaException, RemoteException;
  		
  	// Requerimiento 8 
    public LinkedList <VOVenta> ListadoVentasxEstado(String Estado) throws EstadoVentaException, RemoteException;
  	
  	// Requerimiento 9 
	public ArrayList<VOPostreCantidad> ListadoPostresVenta(int numero) throws NroVentaException, RemoteException, NoPoseePostreException;
  	
  	// Requerimiento 10
	public VORecaudado recaudacionXPostreXfecha(String codigo, LocalDate fecha ) throws AlfanumericoException,FechaException,PostreException, RemoteException;

 	//requerimiento 11
  	public void respaldar() throws RespaldoException, RemoteException;
 	
 	//Requerimiento 12
  	public void recuperar() throws RecuperarException, RemoteException ;
 	
}