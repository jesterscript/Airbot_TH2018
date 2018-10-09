package agodaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReservationOperation {
	
	@Parameters("ReservationType")
	@Test
	public void reservationtype()
	{
		// Click Room or Flight depend on input parameter
	}
	
	@Parameters({"Place","Date","Room","Adult","Child","FamilyRoom","ChildAge"})
	@Test
	public void searchRoom()
	{
		//Select given paremeters and click search
	}
	
	@Parameters({"MaxPrice","Star","Location",""})
	@Test
	public void specsOfRoom()
	{
		//Select given paremeters and click search
	}
	

}
