package pages; // Define o pacote onde a classe está localizada

import org.openqa.selenium.By; // Importa a classe By para localizar elementos na página
import org.openqa.selenium.WebDriver; // Importa o WebDriver para controle do navegador
import org.openqa.selenium.WebElement; // Importa a classe WebElement para representar elementos da página
import org.openqa.selenium.support.FindBy; // Importa a anotação FindBy para mapear elementos usando PageFactory
import org.openqa.selenium.support.PageFactory; // Importa o PageFactory para inicializar os elementos da página

// HomePage herda de CommonPage, ou seja, ela tem acesso aos atributos e métodos de CommonPage
public class HomePage extends CommonPage { 

    // Construtor - Inicializa a classe HomePage e os elementos da página com o WebDriver
    public HomePage(WebDriver driver) {
        super(driver); // Chama o construtor da classe pai (CommonPage) passando o driver
        PageFactory.initElements(driver, this); // Inicializa os elementos Web da página usando o PageFactory
    }

    // ############################################################################################################

    // Elementos mapeados
    public By byLocal(String local){
        return By.cssSelector("option[value=\"" + local + "\"]"); // Monta seletor dinâmico para opção do combo
    } 

    // @FindBy -> Pode ser usado para campos simples
    @FindBy(css = ".btn-primary") // Mapeia o botão com a classe CSS 'btn-primary'
    WebElement btn_FindFlight;   // Representa o botão "Find Flights" na página

    // ############################################################################################################

    // Ações com os elementos mapeados
    public void acessarHomePage(String url) { // Método para acessar a página inicial
        driver.get(url); // Abre a URL no navegador
    }

    public void selecionar_Origem_Destino(String byOrigem, String byDestino) { // Método para selecionar a origem e o destino
        driver.findElement(byLocal(byOrigem)).click(); // Clica na opção de origem com base no valor passado
        driver.findElement(byLocal(byDestino)).click(); // Clica na opção de destino com base no valor passado
    }

    public void clicar_Btn_FindFlights() { // Método para clicar no botão "Find Flights"
        btn_FindFlight.click(); // Aciona o clique no botão mapeado com @FindBy
    }
    
    public String ler_Nome_Guia() { // Método para ler o título da página
        return driver.getTitle(); // Retorna o título da página atual no navegador
    }    
}
