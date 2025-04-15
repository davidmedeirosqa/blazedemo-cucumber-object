import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver; // Importa o WebDriver para controle do navegador

import io.cucumber.java.en.Given; // Importa a anotação @Given do Cucumber (pré-condição)
import io.cucumber.java.en.Then; // Importa a anotação @Then do Cucumber (validação)
import io.cucumber.java.en.When; // Importa a anotação @When do Cucumber (ação)

import pages.Base; // Importa a classe Base
import pages.HomePage; // Importa a classe HomePage
import pages.ReservePage; // Importa a classe ReservePage

public class ComprarPassagemPO { // Classe de definição dos passos com Page Object

    // Atributos
    final WebDriver driver; // Driver para controle do navegador
    private HomePage homePage; // Representa a página inicial
    private ReservePage reservePage; // Representa a página de reserva

    // Construtor
    public ComprarPassagemPO(Base base) { // Construtor da classe ComprarPassagemPO recebendo a Base
        this.driver = base.driver; // Atribui o driver da classe Base ao driver local
    }

    // As anotações @Before e @After ficam em uma classe separada chamada Hooks.java

    @Given("que acesso o site {string}") // Passo para acessar a URL informada
    public void que_acesso_o_site(String url) {
        homePage = new HomePage(driver); // Instancia a HomePage com o driver
        homePage.acessarHomePage(url); // Acessa a URL informada no navegador
        
        // Validar se a página está correta através do nome da guia
        assertEquals("Blazedemo", homePage.ler_Nome_Guia());
    }

    @When("seleciono a {string} e {string}") // Passo para selecionar origem e destino
    public void seleciono_a_e(String string, String string2) {

    }

    @When("clico no botao Find Flights") // Passo para clicar no botão "Find Flights"
    public void clico_no_botao_find_flights() {

    }

    @Then("visualiza a lista de voos") // Passo para validar a exibição da lista de voos
    public void visualiza_a_lista_de_voos() {

    }
}