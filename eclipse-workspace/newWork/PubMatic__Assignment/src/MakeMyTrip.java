import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		String user = System.getProperty("user.name");
		
	

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\"+user+"\\eclipse-workspace\\newWork\\PubMatic__Assignment\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")).click();

		// driver.findElement(By.xpath("//*[@class='landingSprite swipIcon']")).click();

		driver.findElement(By.xpath("//*[@class='lbl_input latoBold appendBottom10']")).click();

		while (!driver.findElement(By.xpath("//*[@class ='DayPicker-Caption']//div")).getText().contains("August")) {
			driver.findElement(By.xpath("//*[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}

		List<WebElement> results = driver.findElements(By.xpath("//*[@class='DayPicker-Day']//div"));
		int count = results.size();
		Thread.sleep(3000);

		HashMap<String, String> map = new HashMap<String, String>();

		String price = driver
				.findElement(By.xpath(
						"(//*[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[@class=' todayPrice'])[1]"))
				.getText();
		String Day = driver.findElement(By.xpath("(//*[@class='DayPicker-Day']//div[@class='dateInnerCell']//p)[1]"))
				.getText();
		System.out.println(" Price for Day " + Day + " is " + price);

		for (int i = 1; i <= 31; i++)

		{

			WebElement elementPrice = driver
					.findElements(By.xpath("//*[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[2]")).get(i);
			WebElement elementDay = driver
					.findElements(By.xpath("//*[@class='DayPicker-Day']//div[@class='dateInnerCell']//p[1]")).get(i);

			String currPrice = elementPrice.getText();
			String currDay = elementDay.getText();

			map.put(currDay, currPrice);
		}
		System.out.println("All Flight fair are -");
		System.out.println(map.entrySet());

		System.out.println("Flight with lowest fair -");

		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {

			list.add(entry.getValue());

		}

		Collections.sort(list);

		System.out.println(list.get(0));

		for (Map.Entry<String, String> entry : map.entrySet()) {

			if (entry.getValue() == list.get(0))
				System.out.println("on Day " + entry.getKey() + "th August 2020");

		}
	}

}
