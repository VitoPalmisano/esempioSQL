package it.ploito.tdp.esempioSQL.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BabsDAO {
	
	public List<Station> listStation(){
		
		// I metodi del DAO lavorano ad oggetti:
		// ricevono oggetti e restituiscono oggetti
		// Se il DAO restituisse una stringa, sarebbe sbagliato,
		// perche' staremmo dando al DAO, che ha come responsabilita'
		// quella di accedere ai dati, anche la responsabilita'
		// di formattere il risultao, ed e' sbagliato, perche' questo e'
		// un lavoro che deve fare la parte di vista, il controllore,
		// quella piu' vicina all'interfaccia utente.
		// Il DAO fa il lavoro sporco di estrarre i dati e di convertirli.
		// Il Controller spacchetta gli oggetti ed estrae le stringhe.
		// Al Model resta la parte "intelligente" del lavoro.
		
		List<Station> result = new ArrayList<>();
		
		String sql = "SELECT STATION_ID, NAME, DOCKCOUNT, LANDMARK FROM STATION ORDER BY name";
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		
		try {
			Connection conn = DBConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"),
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark"));
				
				result.add(s);
			}
			st.close();
			
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return null;	
	}
	
	public List<Station> listStationByLandmark(String landmark){
		
		List<Station> result = new ArrayList<>();
		
		String sql = "SELECT STATION_ID, NAME, DOCKCOUNT, LANDMARK FROM STATION WHERE LANDMARK=? ORDER BY NAME";
				
		try {
			Connection conn = DBConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, landmark);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"),
						res.getString("name"),
						res.getInt("dockcount"),
						res.getString("landmark"));
				
				result.add(s);
			}
			st.close();
			
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		return null;
	}
}
