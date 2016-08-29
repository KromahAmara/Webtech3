package edu.ap.be.examen.esources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.ap.be.examen.database.DatabaseClass;
import edu.ap.be.examen.model.Examen;
import edu.ap.be.examen.service.ExamenService;



@Path("/examen")	
@Consumes(MediaType.APPLICATION_JSON)			
@Produces(MediaType.APPLICATION_JSON)			
public class ExamenResource {
	
	ExamenService examenService  = new ExamenService();
	private Map<Long, Examen> examens = DatabaseClass.getExamen();
	
	
	@Produces({"text/html"})
	@GET 																								
	public String getAllExamen(){	
		
		List<Examen> array =  examenService.getAllExamen();
		
		String htmlString = "<html><body>";
		for(int i=0; i<array.size(); i++){
		
			htmlString += "<b>Name : " +  array.get(i).getName()+ "</b><br>";
			htmlString += "ID : " +array.get(i).getId()  + "<br>";
			htmlString += "Examen : " +array.get(i).getExamen()  + "<br>";
			htmlString += "Reason : " +array.get(i).getReason()  + "<br>";
			htmlString += "Created At : " +array.get(i).getCreated()  + "<br>";
			htmlString += "<br><br>";		
		}
			return htmlString;		
	}
	
	// post (create)
	
	@POST

	public Examen addExamen(Examen examen){		// Dit zal alles van de post opvangen en in deze parameter steken (dus de actuele data niet de parametetrs)
		return examenService.addExamen(examen);
	}
	
	
	@GET 
	@Path("/{messageId}")				//elke path die volg wordt aan onze "/messages" toegevoegd de {} is een regex 
	public Examen getExamen(@PathParam("messageId") long id){
		
		
		return examenService.getExamen( id);
	}
	 
}


/*
 * 
 * 		String htmlString = "<html><body>";
		try {
				for(int i=0; i<examen.size(); i++){
			
				htmlString += "<b>Name : " +  examen.get(i).getName()+ "</b><br>";
				htmlString += "ID : " +examen.get(i).getId()  + "<br>";
				htmlString += "Examen : " +examen.get(i).getExamen()  + "<br>";
				htmlString += "Reason : " +examen.get(i).getReason()  + "<br>";
				htmlString += "Created At : " +examen.get(i).getCreated()  + "<br>";
				htmlString += "<br><br>";
				
				}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			htmlString = "<html><body>" + ex.getMessage();
		}
		return htmlString;
 */

/*
 * @Produces(MediaType.APPLICATION_XML) als je XML wil terug geven
 * @Produces(MediaType.TEXT_PLAIN)		ls je een gewone text wil teruggeven
 * 
 * test(@PathParam("messageId") String id)
	 * path parameter ("message/../../ => alle / zijn de parameter)opvangen en converteren naar een methode parameter die 
	 * we vervolgens kunnen gebruiken in onze klasse 
 * 
 *  List<Message> getMessages(@QueryParam("year") int year){	} 
 * 	QueryParam haalt alle waarde uit de query uit (message/../?..? => ? is de queryParam 
 */


/*
 * Bij een POST verzoek (in postman )moet je u header in vullen wanneer je raw data wil meegeven 
 * bv. HEADER = Content-Type VALUE = application/Json 
 * 
 */
