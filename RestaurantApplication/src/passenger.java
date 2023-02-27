package cs1810_Restaurants;

import java.util.HashMap;//

import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class passenger {
	

	
	public static HashMap<String, Integer>  passengerinfo(){
	
	HashMap<String, Integer>passenger_details = new HashMap<String, Integer>(); //creates an hashmap to store the passengers name and the ticket number. 
	
	passenger_details.put("Aaron Samuels", 83746578);//initialising/ adding some passengers name and ticket numbers.
	passenger_details.put("Regina George", 27475839);
	passenger_details.put("Cady Heron", 95738494);
	passenger_details.put("John",  29485432);
	passenger_details.put("Rob",   49130349);
	
	
	
	return passenger_details;  //returns the hashmap (Aaron Samuels, 83746578) with their key and value pairs. 
	
	
}
	
	
	 public static  boolean validatePassengerDetails() {
		 HashMap<String, Integer>passenger_details = passengerinfo(); //calls the hashmap 
		//	String fullName = magic.passengerName.getText();
			
		 String fullName = restaurantGUI.passengerName.getText(); //gets the full name entered by the user in the textbox stores it in the variable fullName .It gets the textbox text from the restaurant GUI class. 
		 
			int ticketNumber = 0; 
			while(true) {
			try {
			 ticketNumber = Integer.parseInt(restaurantGUI.ticketNo.getText()); //gets the ticketNo entered by the user in the Textbox stores it in the variable ticketnumber and parses the ticketNumber to integer..It gets the textbox text from the restaurant GUI class.  
			 break; //if the conditon is true it will break out of the while loop and continue. 
			}
			catch (NumberFormatException e){// if the value entered by the user is not a integer it will execute the catch block.
				JOptionPane.showMessageDialog(null, "Invalid ticket number. Ticket Number can only be numerical and 12 digits long. ", "Error", JOptionPane.ERROR_MESSAGE);
				break; //gets out of the while loop
				
			}
			}
		
				 for(Entry<String, Integer> entry:passenger_details.entrySet()) {//iterates through the hashmap 
						
						if (entry.getKey().equals(fullName) && entry.getValue()==ticketNumber) {//checks the hashmap if the fullname entered by the user matches the key in the hashmap and the ticketnumber entered by the user matches the value associated with that key.,
							  
							  return true;   //if the passenger name and  ticket number are valid it will return true if the user enters incorrect ticketnumber or passenger name it will return false
						   
						}
						
					}
			
			return false;//if the name and ticket number entered by the user are incorrect it will return false

					}
	

}
