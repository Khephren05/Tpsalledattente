package TPsalledattente;



public class ArticlePrio extends Article implements AvecPrio {
	
	private int prio;

	public ArticlePrio(String designation, int quantite, double prixHT) {
		super(designation, quantite, prixHT);
		if (quantite-STOCK_MINIMAL>0) {
			this.prio=0;
		}
		else {
			this.prio=STOCK_MINIMAL-quantite;
		}	
	}
	
	

	public ArticlePrio(String des, double prix) {
		super(des, prix);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int getPrio() {
		if (this.getQuantite()-STOCK_MINIMAL>0) {
			this.prio=0;
		}
		else {
			this.prio=STOCK_MINIMAL-this.getQuantite();
		}	
		return prio;
	}
	
//	public void setPrio(int priorite) {
//		prio=priorite;
//	}
	
	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }

}
