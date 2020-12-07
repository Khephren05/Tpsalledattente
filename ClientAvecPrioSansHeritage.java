package TPsalledattente;
import salle.attente.AvecPrio;

public class ClientAvecPrioSansHeritage extends Client implements AvecPrio
{
	private String nom ;

	public String getNom()
	{	return nom;	}
	public void setNom(String nom)
	{	this.nom = nom;	}

	private int prio ;

	@Override
	public int getPrio()
	{	return prio;	}
	public void setPrio(int prio)
	{	this.prio = prio; 	}

	public ClientAvecPrioSansHeritage(String nom, int prio)
	{
		super(nom);
		this.prio = prio;
	}

	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }
}
