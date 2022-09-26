
/*
Project: RCBTeamSelections

Test case: To validate that there is atleast one wicket keeper

Author: Giriraj Sharma
*/


package teamselectiontestcases;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import testdata.DataProviders;
import utils.JsonUtils;

public class AtleastOneWicketKeeperValidation extends JsonUtils {

	
																				
	@Test(dataProviderClass = DataProviders.class, dataProvider = "playersData")        //TestNG Test annotation with dataprovider class reference and name to fetch the data object

	public void validateAtleastOneWicketKeeper(String InputData) { 						// Method to verify that there is atleast one wicket keeper in the team
		
		JSONArray getPlayersDetails = getJsonObject(InputData).getJSONArray("player");  // Converting JSON object data to JSONArray for further iteration of the data
		int wicketkeeperCount=0; 														// variable to collect the Wicket-keeper role count 
		for (int i = 0; i < getPlayersDetails.length(); i++) 							//For loop to iterate the players details array
			{
			String role= getPlayersDetails.getJSONObject(i).get("role").toString(); 	//iterating on each element of JSON array using i variable as an index into getJSONObject method 
			
				if(role.equalsIgnoreCase("Wicket-keeper")) 								//validating if the Role of the player is matching as Wicket-keeper or not
						{
						wicketkeeperCount++;											//Incrementing the count when the play role matches to Wicket-keeper
						}
			}
		Assert.assertFalse(wicketkeeperCount<1);  										//Asserting if the wicket keeper role count is atleast one, testcase get failed if the count is less than 1
		
	}
}
