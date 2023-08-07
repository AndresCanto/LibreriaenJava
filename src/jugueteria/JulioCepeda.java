package jugueteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JulioCepeda
{
	public static List<Juguete> listaJuguetes = new ArrayList<Juguete>();
	static Connection con;
	private static void conectar() 
	{
		String server = "jdbc:mysql://localhost/jugueteriajc";
		String user = "root";
		String password = "qwerty123456";
		
		try {
			con = DriverManager.getConnection(server, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
		{
			System.out.println("Conexion exitosa!!");
		}
	}
	public static void leerJuguetes() 
	{
		conectar();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM juguetes;";
		
		try {
			pstm= con.prepareStatement(query);
			rs=pstm.executeQuery();
		
			while(rs.next())
			{
				listaJuguetes.add(new Juguete(rs.getInt("id_jug"),rs.getString("nom_jug"),
						rs.getFloat("pre_jug"),rs.getString("marc_jug"),rs.getInt("cat_jug"),
						rs.getInt("stock_jug")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
		desconectar();
	}
	private static void desconectar() 
	{
		try 
		{
			if(con != null) con.close();
		} 
		catch (Exception e2) 
		{
			// TODO: handle exception
		}
	}
//	public static void leerJuguetes() 
//	{
//		URL url = JulioCepeda.class.getResource("BasesDeDatos/juguetes.csv");
//		if(url != null)
//		{
//			try 
//			{
//				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
//				String linea = null;
//				while ((linea = br.readLine())!=null) 
//				{
//					String[] LActual = linea.split(",");
//					int id = Integer.parseInt(LActual[0]);
//					String nom = LActual[1];
//					float pre = Float.parseFloat(LActual[2]);
//					String marc = LActual[3];
//					int cat = Integer.parseInt(LActual[4]);
//					int stock = Integer.parseInt(LActual[5]);
//					listaJuguetes.add(new Juguete(id,nom,pre,marc,cat,stock));
//				}
//				br.close();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//		}
//		else
//		{
//			System.out.println("Error! el archivo o ruta no existen!");
//		}
//	}
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

