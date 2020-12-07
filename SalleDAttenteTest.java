package TPsalledattente;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import salle.attente.* ;

class SalleDAttenteTest
{
	private SalleDAttente<ClientAvecPrio> sallePAPS ;
	private SalleDAttentePrio sallePrio ;

	@BeforeEach
	public void setUp() throws Exception
	{
		sallePAPS = new SalleDAttentePAPS<> (5) ;
		sallePrio = new SalleDAttentePrio(5, 3) ;
	}

	@Test
	public void testUnElement()
	{
		ClientAvecPrio c = new ClientAvecPrio("un client", 1) ;
		testUnElement(sallePAPS, c) ;
		testUnElement(sallePrio, c) ;
	}

	private void testUnElement(SalleDAttente s, ClientAvecPrio c)
	{
		assertTrue("La salle doit être vide", s.estVide()) ;
		s.entrer(c); ;
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit être de taille 1") ;
		assertSame(c, s.getProchain(), "Le prochain à sortir doit être le premier entré") ;
		s.sortir();
		assertTrue("La salle doit être vide", s.estVide()) ;		
	}
	
}
