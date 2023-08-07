package jugueteria;

public class Proveedor 
{
	int id_prov;
	String nom_prov;
	String dir_prov;
	int tel_prov;
	public Proveedor(int id_prov, String nom_prov, String dir_prov, int tel_prov) {
		super();
		this.id_prov = id_prov;
		this.nom_prov = nom_prov;
		this.dir_prov = dir_prov;
		this.tel_prov = tel_prov;
	}
//	no ponemos el setId para evitar que se cambie el valor del Id
	public int getId_prov() {
		return id_prov;
	}
	public String getNom_prov() {
		return nom_prov;
	}
	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}
	public String getDir_prov() {
		return dir_prov;
	}
	public void setDir_prov(String dir_prov) {
		this.dir_prov = dir_prov;
	}
	public int getTel_prov() {
		return tel_prov;
	}
	public void setTel_prov(int tel_prov) {
		this.tel_prov = tel_prov;
	}
}
