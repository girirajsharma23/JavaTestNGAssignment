/*
Project: RCBTeamSelections

Test case: To validate that team has only 4 Foreign Players

Author: Giriraj Sharma
*/

package teamselectiontestcases;


import org.json.JSONArray;

import org.testng.Assert;

import org.testng.annotations.Test;

import testdata.DataProviders;
import utils.JsonUtils;


public class ForeignPlayersValidation extends JsonUtils{

	@Test(dataProviderClass = DataProviders.class, dataProvider = "playersData")          //TestNG Test annotation with dataprovider class reference and name to fetch the data object

	public void validateFourForeignPlayers(String InputData) {							 // Method to verify there are only four foreign players in the team

		JSONArray getPlayersDetails = getJsonObject(InputData).getJSONArray("player");   // Converting JSON object data to JSONArray for further iteration of the data
		
		int playercount=0;																 // variable to collect the Wicket-keeper role count
		
		for (int i = 0; i < getPlayersDetails.length(); i++) 							 //For loop to iterate the players details array
			{
	
			String country= getPlayersDetails.getJSONObject(i).get("country").toString();//iterating on each element of JSON array using i variable as an index into getJSONObject method 
				
				if(!(country.equalsIgnoreCase("India"))) 
					{
					playercount++;	
					}
			}
		Assert.assertEquals(4, playercount);
		
	}
}
