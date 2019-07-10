import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://addisfortune.net/");
        WebElement element = driver.findElement(By.className("span6"));
        fileWriter(element.getAttribute("innerHTML") + "$body");
        driver.close();
    }
    private  void fileWriter(String bodyelements)
    {
        String fileName = "index.html";
        String htmlString = fileReader().replace("$body", bodyelements);
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(htmlString);
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    private  String fileReader()
    {
        String fileName = "index.html";
        String line;
        String htmlTemplateFile = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                htmlTemplateFile += line;
            }
            bufferedReader.close();
        }
        catch(Exception ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        return  htmlTemplateFile;
    }
}
