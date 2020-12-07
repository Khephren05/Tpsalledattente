package TPsalledattente;

import java.util.*;

public class SalleDAttentePrio<TC extends AvecPrio> implements SalleDAttente<TC> {
	
	
	// variables d'instances 
	private HashMap <Integer,SalleDAttentePAPS<TC>> salle;
	private int capaMax,maxPrio; 
	
	// Constructeur 
	public SalleDAttentePrio(int taille,int priomax) {
		capaMax=taille;
		maxPrio =priomax; 
		 this.salle = new HashMap<Integer,SalleDAttentePAPS<TC>>();
		
		// Production des clef et file de prio, une itération de boucle correspond à la production d'une file d'attente de priorité de niveau  x 
		for (int x=0; x<=maxPrio; x++) {
			salle.put(x, new SalleDAttentePAPS<TC>(capaMax));
		}
		
	}
	
	@Override
	public int getCapacite() {
		// TODO Auto-generated method stub
		return capaMax;
	}

	@Override
	public int getNbClients() {
		// on cherche a donner le nombre de clients dans la salle à l'instant T, pour ce faire on fait la somme de la taille de chaque file d'attente 
		
		int res=0;
		for(int i=0;i<=maxPrio;i++) { // max prio permet d'avancer jusqu'a la valeur max de priorité. 
			res += salle.get(i).getNbClients(); // on fait un get sur la salle d'indice i (correspondant a 1 niveau de priorité) ce qui rend l'ArrayList puis on prend la size de ce get. 
		}
		
		return res;	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return getNbClients()==0;
	}

	@Override
	public boolean estPleine() {
		// TODO Auto-generated method stub
		return getNbClients()==capaMax;
	}

	@Override
	 public void entrer(TC client) {
        int prio=client.getPrio();
        if(!(this.estPleine())) {
            if (prio>maxPrio) {salle.get(maxPrio).entrer(client);}
            else if(prio<0) {salle.get(0).entrer(client);}
            else {salle.get(prio).entrer(client);}   
        }
    }

	@Override
	public TC getProchain() {
		// Cette méthode consiste a récupérer le client prochain sur la file d'attente la plus prioritaire
		// On parcours donc la Hashmap de la fin au début ( ordre de priorité), si la taille de l'ArrayList correspondant a la clef i 
		// est supérieur a 0, le client prioritaire est dedans. On return donc le client a l'indice 0 de l'ArrayList. 
		for (int i=maxPrio;i>=0;i--) {
			if (salle.get(i).getNbClients()>0) {
				return salle.get(i).getProchain();
			}
		}
		return null;
	}

	@Override
	public void sortir() {
		// La méthode correspond a la sortie du client, on s'assure que la salle ne soit pas déjà vide
		// on déclare un next de type TC dans le quel on fait un getProchain() afin d'avoir le client a faire sortir 
		// Afin de savoir dans quelle file il faut retirer le client (quel priorité) on fait un getPrio() la partie gauche 
		// de l'expression correspond donc à la récupération de l'ArrayList dans la Hashmap, le remove correspond à 
		// La suppression de l'objet next dans L'ArrayList récupéré (test de correspondance de next avec le contenus de l'ArrayList) 
		if (!(estVide())) {
			TC next=getProchain(); // on récupère le prochain 
			salle.get(next.getPrio()).sortir(); // antinomie de entrée
			
		}
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public int getPrio() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
