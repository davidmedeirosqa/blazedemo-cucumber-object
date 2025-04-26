
// Importa o método assertEquals para realizar asserções nos testes
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

    public String origem; // Armazena o valor da cidade de origem
    public String destino; // Armazena o valor da cidade de destino

    // Construtor
    public ComprarPassagemPO(Base base) { // Construtor da classe ComprarPassagemPO recebendo a Base
        this.driver = base.driver; // Atribui o driver da classe Base ao driver local
    }

    // As anotações @Before e @After ficam em uma classe separada chamada Hooks.java

    @Given("que acesso o site {string}") // Passo para acessar a URL informada
    public void que_acesso_o_site(String url) {
        homePage = new HomePage(driver); // Instancia a HomePage com o driver

        homePage.acessarHomePage(url); // Acessa a URL informada no navegador

        // Validar se a página está correta através do nome da guia "Blazedemo"
        assertEquals("Blazedemo", homePage.ler_Nome_Guia());
    }

    @When("seleciono a {string} e {string}") // Passo para selecionar origem e destino
    public void seleciono_a_e(String origem, String destino) {
        this.origem = origem; // Atribui o valor recebido à variável origem
        this.destino = destino; // Atribui o valor recebido à variável destino

        homePage.selecionar_Origem_Destino(origem, destino); // Seleciona a cidade de origem e destino informadas
    }

    @When("clico no botao Find Flights") // Passo para clicar no botão "Find Flights"
    public void clico_no_botao_find_flights() {
        homePage.clicar_Btn_FindFlights(); // Clica no botão "Find Flights"

        reservePage = new ReservePage(driver); // Instancia a ReservePage com o driver
    }

    @Then("visualiza a lista de voos") // Passo para validar a exibição da lista de voos
    public void visualiza_a_lista_de_voos() {

        // Valida se o título da página de reserva está correto
        assertEquals("BlazeDemo - reserve", reservePage.ler_Nome_Guia());
        
         // Valida se o cabeçalho da página exibe corretamente origem e destino
        assertEquals("Flights from " + origem + " to " + destino + ":", reservePage.ler_Cabecalho_Voos());

    }
}