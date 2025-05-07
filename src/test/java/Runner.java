import org.junit.runner.RunWith; // Importa a anotação @RunWith do JUnit
import io.cucumber.junit.Cucumber; // Importa a classe Cucumber do Cucumber JUnit
import io.cucumber.junit.CucumberOptions; // Importa a anotação @CucumberOptions do Cucumber JUnit

@RunWith(Cucumber.class) // Especifica que a classe de teste será executada com o runner do Cucumber
@CucumberOptions(
    features = {"src/test/resources/features"}, // Define o caminho para os arquivos de features
    glue = {""}, // Especifica o pacote onde estão as definições dos passos (step definitions)
    dryRun = false,    // Executa todos os testes (false) ou apenas verifica sintaxe sem executar (true)
    monochrome = true  // Exibe saída do console sem cores (melhor para logs/CI)
)
public class Runner {
    // Classe de execução dos testes do Cucumber com JUnit
}
