package steps_definition;

import base.BaseSteps;
import io.cucumber.java.pt.Quando;
import page_objects.EsqueceuASenhaPage;

public class EsqueceuASenhaSteps extends BaseSteps {
    private EsqueceuASenhaPage page = new EsqueceuASenhaPage();

    @Quando("o usuario preencher o campo email do esqueceu a senha")
    public void o_usuario_preencher_o_campo_email_do_esqueceu_a_senha() {
       page.escreverEmailReset("testesfalae@gmail.com");
    }

    @Quando("o usuario preencher o campo email do esqueceu a senha com um email invalido")
    public void o_usuario_preencher_o_campo_email_do_esqueceu_a_senha_com_um_email_invalido() {
       page.escreverEmailReset("teste");
    }

    @Quando("o usuario não preencher o campo email do esqueceu a senha")
    public void o_usuario_não_preencher_o_campo_email_do_esqueceu_a_senha() {
        page.escreverEmailReset("");
    }

}
