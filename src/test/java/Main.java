import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        // Configura o WebDriverManager para baixar e configurar o ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Inicializa o WebDriver com o ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Agora você pode usar o driver para abrir páginas
        driver.get("https://www.google.com");
        
        // Finaliza o driver
        driver.quit();
    }
}
