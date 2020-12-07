package TPsalledattente;

public class LivrePrio extends Livre implements AvecPrio {

	private int prio;
	
	public LivrePrio(String des, int q, double prix, int nbp, String isbn, int prio) {
		super(des, q, prix, nbp, isbn);
		this.prio=prio;
	}
	

	public LivrePrio(String des, int q, double prix, int nbp, String isbn) {
		super(des, q, prix, nbp, isbn);
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
