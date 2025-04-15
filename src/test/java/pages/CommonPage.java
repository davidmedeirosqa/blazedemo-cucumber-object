package pages; // Define o pacote onde a classe está localizada (organização do projeto)

import org.openqa.selenium.WebDriver; // Importa o WebDriver para controlar o navegador

public class CommonPage { // Classe base com elementos e métodos comuns às páginas

    public WebDriver driver; // Instância do WebDriver para uso nas páginas

    // Construtor - Inicializa o driver recebido de fora
    public CommonPage(WebDriver driver) {
        this.driver = driver; // Atribui o driver externo à variável da classe
    }

    // Métodos utilitários comuns às páginas serão definidos aqui
}
