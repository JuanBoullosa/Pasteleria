package logica.colecciones;
import java.util.TreeMap;
import logica.negocio.Postre;

public class Postres {
	
	private TreeMap<String,Postre> arbolPostres;
	

	public Postres ()
	{
		arbolPostres= new TreeMap<String, Postre> ();
	}

	public boolean member(String codigo)
	{
		return arbolPostres.containsKey(codigo);
	}
	
	public Postre find (String codigo)
	{
		return arbolPostres.get(codigo);
	}
	
	public void insert (String codigo, Postre P)
	{
		arbolPostres.put(codigo, P);
	}
	
	public void detelet (String codigo)
	{
		arbolPostres.remove(codigo);
	}
	
}
