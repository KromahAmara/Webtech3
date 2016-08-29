package edu.ap.be.examen.service;

import java.util.*;

import edu.ap.be.examen.database.DatabaseClass;
import edu.ap.be.examen.model.Examen;

public class ExamenService {
	
	static final String FILE = "C:/Users/Amara/Desktop/Cursussen AP/Examen.json";
	private Map<Long, Examen> examens = DatabaseClass.getExamen();			
	
	public ExamenService(){
	}

	public List<Examen> getAllExamen(){	
		
		return new ArrayList<Examen>(examens.values());
		
	}
	
	public Examen getExamen(long id){		
		return examens.get(id);			
	}
	
	public Examen addExamen(Examen examen){
		
		examen.setId(examens.size()+1);		
		examen.setCreated(examen.getDate());
		examens.put(examen.getId(), examen);		//Wij voegen het dan aan onze HashMap toe (key, value)
		return examen;								// wij geven het toegevoede bericht terug 
	}
	
	public Examen updateExamen(Examen examen){
		if(examen.getId() <= 0){
			return null;
		}
		
		examens.put(examen.getId(), examen);
		return examen;
	}
	
	public Examen removeMessage(long id){
		return examens.remove(id);				//geven de verwijderde bericht terug 
	}
}
