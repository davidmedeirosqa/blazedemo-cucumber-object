package pages;

import org.openqa.selenium.WebDriver; // Importa o WebDriver para controlar o navegador
import org.openqa.selenium.WebElement; // Importa o WebElement para representar elementos da página
import org.openqa.selenium.support.FindBy; // Importa o @FindBy para mapear elementos com PageFactory
import org.openqa.selenium.support.PageFactory; // Importa o PageFactory para inicializar os elementos mapeados

public class ReservePage extends CommonPage{

    // Construtor - Inicializa a classe HomePage e os elementos da página com o WebDriver
    public ReservePage(WebDriver driver) {
        super(driver); // Chama o construtor da classe pai (CommonPage) passando o driver
        PageFactory.initElements(driver, this); // Inicializa os elementos Web da página usando o PageFactory
    }
    
    // ############################################################################################################

    // Elementos mapeados
    @FindBy(css = "h3")
    WebElement flightsHeader;

    // ############################################################################################################

    // Ações com os elementos mapeados
    public String ler_Cabecalho_Voos(){
        return flightsHeader.getText();
     }
}