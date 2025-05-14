package pages;

import org.openqa.selenium.By; // Importa a classe By do Selenium para localizar elementos na página
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

    // Localiza o elemento <h3> na página e o associa à variável flightsHeader
    @FindBy(css = "h3")
    WebElement flightsHeader;

    // Retorna um localizador XPath para o botão de envio na linha especificada da tabela
    public By byOrder(int ordem_do_voo){
        return By.xpath("//table[@class='table']/tbody/tr[" + ordem_do_voo + "]//input[@type='submit']");
    }

    // ############################################################################################################

    // Ações com os elementos mapeados
    public String ler_Cabecalho_Voos(){
        return flightsHeader.getText();
     }

    // Clica no botão de envio correspondente à ordem do voo especificada
    public void clicar_Voo(int ordem_do_voo){
        driver.findElement(byOrder(ordem_do_voo)).click();
    }

}