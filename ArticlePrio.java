package TPsalledattente;



public class ArticlePrio extends Article implements AvecPrio {
	
	private int prio;

	public ArticlePrio(String designation, int quantite, double prixHT, int prio) {
		super(designation, quantite, prixHT);
		this.prio=prio;
		
		
	}
	

	public ArticlePrio(String designation, int quantite, double prixHT) {
		super(designation, quantite, prixHT);
		// TODO Auto-generated constructor stub
	}
	


	public ArticlePrio(String des, double prix) {
		super(des, prix);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int getPrio() {
		// TODO Auto-generated method stub
		return prio;
	}
	
	public void setPrio(int priorite) {
		prio=priorite;
	}
	
	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }

}
