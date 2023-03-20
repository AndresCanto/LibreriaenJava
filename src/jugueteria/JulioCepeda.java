package jugueteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JulioCepeda
{
	private static List<Juguete> listaJuguetes = new ArrayList<Juguete>();

	public static void conectar() 
	{
		System.out.println("Concetado!");
	}
	public static void leerJuguetes() 
	{
		URL url = JulioCepeda.class.getResource("BasesDeDatos/juguetes.csv");
		if(url != null)
		{
			try 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
				String linea = null;
				while ((linea = br.readLine())!=null) 
				{
					String[] LActual = linea.split(",");
					int id = Integer.parseInt(LActual[0]);
					String nom = LActual[1];
					float pre = Float.parseFloat(LActual[2]);
					String marc = LActual[3];
					int cat = Integer.parseInt(LActual[4]);
					int stock = Integer.parseInt(LActual[5]);
					listaJuguetes.add(new Juguete(id,nom,pre,marc,cat,stock));
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Error! el archivo o ruta no existen!");
		}
	}
	public static Juguete getJuguete(int index) 
	{
		return listaJuguetes.get(index); 
	}
	public static int getInventarioSize()
	{
		return listaJuguetes.size();
	}
	public static int getIndexOf(Juguete b)
	{
		return listaJuguetes.indexOf(b);
	}
}

