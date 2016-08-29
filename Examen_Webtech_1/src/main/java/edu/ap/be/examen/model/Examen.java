package edu.ap.be.examen.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class Examen {
	
	private long id;
	private String name;
	private String examen;
	private String created;
	private String reason;
	
	// Dit moet altijd omdat XML een JSON een instantie van het model moet kunnen aanmaken 
	public Examen(){		
	}
	
	public Examen(long id, String name, String examen, String reason) {
		this.id = id;
		this.name = name;
		this.examen = examen;
		this.reason = reason;
		this.created = getDate();
	}

	
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getExamen() {
		return examen;
	}

	public String getCreated() {
		return created;
	}

	public String getReason() {
		return reason;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	


	
}
