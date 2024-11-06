// 1 - bibliotecas e pacotes
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


// 2 - classes
public class InternetProject142 {
// 2.1 - Atributos
private WebDriver driver;
// Funções e métodos
@BeforeEach
public void setUp() {
    driver = new ChromeDriver();

} 

@AfterEach
public void tearDown() {
    driver.quit();

}

@Test
public void LoginComSucesso() {
    String mensagemEsperada = "You logged into a secure area!";

    driver.get("https://the-internet.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(15520,840));
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in")).click();

    // Usei o assertTrue e o contains, ao inves do assertEquals, pois a mensagem que retorna compara a frase mais o ícone de fechamento 'x' da janela

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera o tempo que foi configurado
    WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))); // Espera até o elemento aparecer na tela
    String mensagemRetorno = mensagem.getText().trim(); // o trim ignora os espaços em branco
    Assertions.assertTrue(mensagemRetorno.contains(mensagemEsperada));

}

@Test
public void LoginUsuarioIncorreto() {
    String mensagemEsperada = "Your username is invalid!";

    driver.get("https://the-internet.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(15520, 840));
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("Tomsmith"); //senha incorreta
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement mensagem  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
    String mensagemRetorno = mensagem.getText().trim();
    Assertions.assertTrue(mensagemRetorno.contains(mensagemEsperada));
}

//LoginSenhaIncorreta
//LoginUsuarioESenhaIncorretos
//LoginUsuarioEmBranco
//LoginSenhaEmBranco
//LoginUsuarioESenhaEmBranco
//LoginEspacoEmBrancoUsuario
//LoginEspacoEmBrancoSenha



}
