package TPsalledattente;

public class Client
{
	private String nom ;

	public Client(String nom)
	{	
		super() ;
		this.nom = nom;	}

	public String getNom()
	{	return nom;	}
	
	public void setNom(String nom)
	{	this.nom = nom;	}

	@Override
	public String toString()
	{	return this.getNom() ; }
	
}
