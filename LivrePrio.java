package TPsalledattente;

public class LivrePrio extends Livre implements AvecPrio {

	private int prio;
	
	public LivrePrio(String des, int q, double prix, int nbp, String isbn ) {
		super(des, q, prix, nbp, isbn);
		if (q-(STOCK_MINIMAL+STOCK_MINIMAL/2)>0) {
			this.prio=0;
		}
		else {
			this.prio=(STOCK_MINIMAL+STOCK_MINIMAL/2)-q;
		}
	}
	



	@Override
	public int getPrio() {
		// TODO Auto-generated method stub
		
		if (getQuantite()-(STOCK_MINIMAL+STOCK_MINIMAL/2)>0) {
			this.prio=0;
		}
		else {
			this.prio=(STOCK_MINIMAL+STOCK_MINIMAL/2)-getQuantite();}
		
		return prio;
	}
	
	public void setPrio(int priorite) {
		prio=priorite;
	}
	
	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }

}
