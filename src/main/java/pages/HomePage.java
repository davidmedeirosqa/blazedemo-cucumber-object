package pages; // Define o pacote onde a classe está localizada

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Importa o WebDriver para controle do navegador
import org.openqa.selenium.support.PageFactory; // Importa o PageFactory para inicializar os elementos da página

// HomePage herda de CommonPage, ou seja, ela tem acesso aos atributos e métodos de CommonPage
public class HomePage extends CommonPage { 

    // Construtor - Inicializa a classe HomePage e os elementos da página com o WebDriver
    public HomePage(WebDriver driver) {
        super(driver); // Chama o construtor da classe pai (CommonPage) passando o driver
        PageFactory.initElements(driver, this); // Inicializa os elementos Web da página usando o PageFactory
    }

    // Elementos mapeados
    public By byLocal(String local){
        return By.cssSelector("option[value=\"" + local + "\"]");
    }


    // Ações com os elementos mapeados
}
