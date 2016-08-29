package edu.ap.be.examen.database;
import java.util.HashMap;
import java.util.Map;

import edu.ap.be.examen.model.Examen;

// Wij gaan dit gebruiken als onze database aangezien wij geen echte database gaan gebruiken 
// normaal maak je een echte JDBC connectie 

public class DatabaseClass {

	private static Map<Long, Examen> examen = new HashMap<>();
	
	
	public static Map<Long, Examen> getExamen() {
		return examen;
	}


	
}
