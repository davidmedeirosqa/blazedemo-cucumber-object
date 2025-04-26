import java.time.Duration; // Importa a classe Duration para definir tempos de espera

import org.openqa.selenium.chrome.ChromeDriver; // Importa o ChromeDriver para controle do navegador Chrome

import io.cucumber.java.Before; // Importa a anotação @Before do Cucumber para executar ações antes dos testes
import io.cucumber.java.After; // Importa a anotação @After do Cucumber para executar ações após os testes
import io.github.bonigarcia.wdm.WebDriverManager; // Importa o WebDriverManager para gerenciar automaticamente os drivers dos navegadores
import pages.Base; // Importa a classe Base que contém o WebDriver

public class Hooks { // Classe que contém os métodos de configuração e finalização dos testes
    Base base; // Instância da classe Base para acessar o WebDriver

    // Construtor que recebe a instância de Base
    public Hooks(Base base) {
        this.base = base; // Atribui a instância recebida à variável local
    }

    @Before // Método executado antes de cada cenário de teste
    public void iniciar() {
        WebDriverManager.chromedriver().setup(); // Configura automaticamente o ChromeDriver
        base.driver = new ChromeDriver(); // Inicializa o ChromeDriver e atribui ao driver da Base
        // Define o tempo de espera implícito para 60 segundos
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
        base.driver.manage().window().maximize(); // Maximiza a janela do navegador
    }

    @After // Método executado após cada cenário de teste
    public void encerrar() {
        base.driver.quit(); // Encerra o navegador e finaliza a sessão do WebDriver
    }
}