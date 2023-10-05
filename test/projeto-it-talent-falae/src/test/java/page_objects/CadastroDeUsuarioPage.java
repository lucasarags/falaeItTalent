package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CadastroDeUsuarioPage extends BasePage {
    private final By nomeLocator = By.id("user_name");
    private final By sobrenomeLocator = By.id("user_last_name");
    private final By emailLocator = By.id("user_email");
    private final By confirmEmailLocator = By.id("user_email_confirmation");
    private final By senhaLocator = By.id("user_password");
    private final By confirmSenhaLocator = By.id("user_password_confirmation");
    private final By botaoCriar = By.cssSelector("input[type=submit]");

    private final By MensagemDeSucesso = By.xpath("//*[@class='flash warning']");

    private final By MensagemdeErros = By.xpath("//div[@class='error-wrapper']");

    public void clicarCadastrar(String link){
        clicar(By.linkText(link));
    }

    public void escreverNome(String nome){
        waitElementVisible(nomeLocator,2);
        escreve(nomeLocator, nome);
    }

    public void escreverSobrenome(String sobrenome){
        escreve(sobrenomeLocator, sobrenome);
    }

    public void escreverEmail(String email){
        escreve(emailLocator, email);
    }
    public void escreverCofirmEmail(String confirmarEmail){
        escreve(confirmEmailLocator, confirmarEmail);
    }

    public void escreverSenha(String senha){
        escreve(senhaLocator, senha);
    }
    public void escreverConfirmSenha(String confirmarSenha){
        escreve(confirmSenhaLocator, confirmarSenha);
    }

    public void botaoCriar(){
        clicar(botaoCriar);
    }

    public String MensagemDeSucesso(){
        return obterValorPorTexto(MensagemDeSucesso);
    }

    public String msgErro(){
        return posicaoTexto(obterValorPorTexto(MensagemdeErros), "\n", 1);
    }

}
