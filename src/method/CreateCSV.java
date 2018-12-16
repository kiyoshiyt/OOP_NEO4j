package method;

import java.io.IOException;

import CreateRelationship.MatchLocationOrganization;
import CreateRelationship.MatchPersonEvent;
import CreateRelationship.MatchPersonOrganization;
import CreateRelationship.PersonToCountry;
import CreateRelationship.matchEventTime;
import createNode.CreateCountry;
import createNode.CreateEvent;
import createNode.CreateLocation;
import createNode.CreateOrganization;
import createNode.CreatePerson;
import createNode.CreateTime;

public class CreateCSV {
	private int maxPerson;
	private int maxOrganization;
	private int maxEvent;
	private int maxCountry;
	private int maxLocation;
	private int maxTime;
	
	private CreateCountry country;
	private CreateEvent event;
	private CreateLocation location;
	private CreateOrganization organiation;
	private CreatePerson person;
	private CreateTime time;
	
	private matchEventTime eventTime ;
	private MatchLocationOrganization locationOrganization ;
	private MatchPersonEvent personEven ;
	private MatchPersonOrganization personOrganization ;
	private PersonToCountry personCountry ;

	
	
	public CreateCSV(int maxPerson, int maxOrganization,int maxEvent,int maxCountry,int maxLocation,int maxTime){
		this.maxPerson= maxPerson;
		this.maxOrganization= maxOrganization;
		this.maxEvent =maxEvent;
		this.maxCountry = maxCountry;
		this.maxLocation = maxLocation;
		this.maxTime = maxTime;
	}
	
	public void CreateDBtoCSV(int numEvenToTime,int numLocationToOrganization, int numPersonToEven, int numPersonToOrganization , int numPersonToCountry){
		country =new CreateCountry(maxCountry); 
		event = new CreateEvent(maxEvent);
		location = new CreateLocation(maxLocation);
		organiation = new CreateOrganization(maxOrganization);
		person = new CreatePerson(maxPerson);
		time =new CreateTime(maxTime);
		
		country.createToCSV("src/database/CreateCountries.csv");
		event.createToCSV("src/database/CreateEvent.csv");
		location.createToCSV("src/database/CreateLocation.csv");
		person.createToCSV("src/database/CreatePerson.csv");
		organiation.createToCSV("src/database/CreateOrganization.csv");
		time.createToCSV("src/database/CreateTime.csv");
		
		try {
			eventTime =new matchEventTime(maxEvent, maxTime);
			eventTime.CreateRelationship(numEvenToTime);
			
			personEven = new MatchPersonEvent(maxPerson, maxEvent);
			personEven.CreateRelationship(numPersonToEven);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		locationOrganization = new MatchLocationOrganization(maxLocation, maxOrganization);
		locationOrganization.CreateRelationship(numLocationToOrganization);
		
		personOrganization =new MatchPersonOrganization(maxPerson, maxOrganization);
		personOrganization.CreateRelationship(numPersonToOrganization);
		
		personCountry =new PersonToCountry(maxPerson, maxCountry);
		personCountry.CreateRelationship(numPersonToCountry);
	}
	
	public static void main(String[] args) {
		CreateCSV csv =new CreateCSV(50, 20, 10, 2, 10, 8);
		csv.CreateDBtoCSV(30, 30, 50, 50, 40);
				
	}
	
	
}
