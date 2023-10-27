package page_objects;

import base.BasePage;
import org.openqa.selenium.By;

public class CriarPranchaPage extends BasePage {
    private final By botaoCriarPrancha = By.xpath("//a[@class='button-box']/i[@class='fa fa-plus-circle']");
    private final By nomePrancha = By.id("spreadsheet_name");

    private final By MsgSucessPrancha = By.id("notice");

    public void criarPrancha(){
        clicar(botaoCriarPrancha);
    }

    public void escreverNomePrancha(String nome){
        waitElementVisible(nomePrancha, 2);
        escreve(nomePrancha, nome);
    }

    public String msgSucessoPrancha(){
        return obterValorPorTexto(MsgSucessPrancha);
    }

}
