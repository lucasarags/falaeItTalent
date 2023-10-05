package steps_definition;

import base.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import page_objects.CadastroDeUsuarioPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastroDeUsuarioSteps  extends BaseSteps {
    private CadastroDeUsuarioPage page = new CadastroDeUsuarioPage();

    private String aleatorio = (new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss")).format(new Date());
    private String email = "teste" + aleatorio+"@teste.com";



    @Dado("o usuario clicar no link {string}")
    public void o_usuario_clicar_no_link(String string) {
        page.clicarCadastrar(string);
    }

    @Quando("o usuario preencher o campo nome")
    public void o_usuario_preencher_o_campo_nome() {
        page.escreverNome("TesteFalae");
    }

    @Quando("o usuario preencher o campo sobrenome")
    public void o_usuario_preencher_o_campo_sobrenome() {
        page.escreverSobrenome("HP");
    }

    @Quando("o usuario selecionar o idioma {string}")
    public void o_usuario_selecionar_o_idioma(String string) {
        screenshot();
    }

    @Quando("o usuario preencher o campo email")
    public void o_usuario_preencher_o_campo_email() {
        page.escreverEmail(email);
    }

    @Quando("o usuario preencher o campo confirmar email")
    public void o_usuario_preencher_o_campo_confirmar_email() {
        page.escreverCofirmEmail(email);
    }

    @Quando("o usuario preencher o campo senha")
    public void o_usuario_preencher_o_campo_senha() {
        page.escreverSenha("123456");
    }

    @Quando("o usuario preencher o campo confirmar senha")
    public void o_usuario_preencher_o_campo_confirmar_senha() {
        page.escreverConfirmSenha("123456");
    }

    @Quando("o usuario clicar no botao {string}")
    public void o_usuario_clicar_no_botao(String string) {
        screenshot();
        page.botaoCriar();
    }

    @Então("o sistema exibe uma mensagem: {string}")
    public void o_sistema_exibe_uma_mensagem(String mensagem) {
        Assert.assertEquals(page.MensagemDeSucesso(), mensagem);
        screenshot();
    }

    @Quando("o usuario não preencher o campo nome")
    public void o_usuario_não_preencher_o_campo_nome() {
        page.escreverNome("");
    }

    @Então("o sistema exibe uma mensagem de erro: {string}")
    public void o_sistema_exibe_uma_mensagem_de_erro(String msgErro) {
        Assert.assertEquals(page.msgErro(), msgErro);
        screenshot();
    }

    @Quando("o usuario não preencher o campo sobrenome")
    public void o_usuario_não_preencher_o_campo_sobrenome() {
       page.escreverSobrenome("");
    }



}
