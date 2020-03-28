package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.ploito.tdp.esempioSQL.DB.BabsDAO;
import it.ploito.tdp.esempioSQL.DB.Station;

public class LeggiBabs {
	
	public void run() {
		
		BabsDAO dao = new BabsDAO();
		
		List<Station> tutte = dao.listStation();
		
		for(Station s : tutte) {
			System.out.println(s.getName());
		}
		
		System.out.println("--------");
		
		List<Station> paloAlto = dao.listStationByLandmark("Palo Alto");
		
		for(Station s : paloAlto) {
			System.out.println(s.getName());
		}
		
		/*
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		
		// Tutte le volte che scriviamo codici che implicano l'accesso a risorse esterne, 
		// dobbiamo aspettarci delle eccezioni
		try {
			Connection conn = DriverManager.getConnection(jdbcURL); // Immaginimao la connection, 
			// come un tubo che collega il mio programma al database
			
			// Metodo PERICOLOSO, e POCO EFFICIENTE (vedere lezione 11 primi 10 minuti
			
			Statement st = conn.createStatement(); // Immaginiamo lo statement come una navetta, 
			// che contine le mie istruzioni, che viaggia all'interno della connection, da un capo all'altro
			
			String sql = "SELECT NAME FROM station WHERE landmark='" + inserimentoUtente + "'"; // PERICOLO
			
			ResultSet res = st.executeQuery(sql); // ResultSet contiene il modo per accedere al risultato
			
			
			String sql = "SELECT NAME FROM station WHERE landmark = ?";
			
			PreparedStatement st = conn.prepareStatement(sql); // Immaginiamo lo statement come una navetta, 
			// che contine le mie istruzioni, che viaggia all'interno della connection, da un capo all'altro
			
			st.setString(1, "Palo Alto");
			
			ResultSet res = st.executeQuery(); // ResultSet contiene il modo per accedere al risultato
			
			while(res.next()) {
				String nomeStazione = res.getString("name");
				
				System.out.println(nomeStazione);
			}
			st.close(); // Se all'interno della stessa connessione devo far viaggiare piu' statement, 
			// mi conviene chiudere  quelli di cui non ho piu' bisogno
			
			Statement st2 = conn.createStatement();
			
			conn.close(); // ricordarsi di chiudere sempre la connessione
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// Pattern di programmazione di tipo FACTORY
		// FACTORY: creazione dell'oggetto di una classe senza sapere il tipo della classe ( NON posso usaren NEW)
		// Uso un metodo fornito da un'altra classe (il DriverManager), che internamente fara' new e riconoscera'
		// il tipo di classe effettivo
		
		*/
	}
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
}
