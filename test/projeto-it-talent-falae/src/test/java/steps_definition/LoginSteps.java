package steps_definition;

import base.BaseSteps;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import page_objects.CadastroDeUsuarioPage;
import page_objects.LoginPage;

public class LoginSteps extends BaseSteps {
    private CadastroDeUsuarioPage page = new CadastroDeUsuarioPage();
    private LoginPage loginPage = new LoginPage();

    @Quando("o usuario preencher o campo email do login")
    public void o_usuario_preencher_o_campo_email_do_login() {
        page.escreverEmail("testesfalae@gmail.com");
    }
    @Quando("o usuario preencher o campo senha do login")
    public void o_usuario_preencher_o_campo_senha_do_login() {
        page.escreverSenha("123456");
    }
    @Então("o sistema direciona o usuario logado para pagina inicial")
    public void o_sistema_direciona_o_usuario_logado_para_pagina_inicial() {
        Assert.assertTrue(loginPage.welcome("Bem-vindo"));
        screenshot();
    }

    @Então("o sistema exibe uma mensagem no login: {string}")
    public void o_sistema_exibe_uma_mensagem_no_login(String erro) {
        Assert.assertEquals(erro, loginPage.msgDeErroLogin());
        screenshot();
    }

    @Quando("o usuario preencher o campo senha com uma senha invalida")
    public void o_usuario_preencher_o_campo_senha_com_uma_senha_invalida() {
        page.escreverSenha("12345");
    }

    @Quando("o usuario preencher o campo email do login um email não ativo")
    public void o_usuario_preencher_o_campo_email_do_login_um_email_não_ativo() {
       page.escreverEmail("teste@teste.com");
    }

    @Então("o sistema exibe uma mensagem de ativacao no login: {string}")
    public void o_sistema_exibe_uma_mensagem_de_ativacao_no_login(String msg) {
        Assert.assertEquals(msg, loginPage.msgDeAtivacaoLogin());
        screenshot();
    }
}
