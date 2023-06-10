import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

public class Testy {
	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
		    DevTools devT =	((HasDevTools) driver).getDevTools();
		    devT.createSession();
		    
		    HashMap<String, Object> map = new HashMap<String, Object>();
		     
		    map.put("latitude", 40);
		    map.put("langitude", 3);
		    map.put("accuracy", 1);
		    
		    ((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", map);
		    
		    ((ChromiumDriver) driver).get("https://www.google.co.in/");
		    ((ChromiumDriver) driver).findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		    driver.findElement(By.xpath("(//div[@class = 'yuRUbf']/a)[1]")).click();
		    
		 
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
			System.out.println(e.getMessage());
		}
		   
	}

}
