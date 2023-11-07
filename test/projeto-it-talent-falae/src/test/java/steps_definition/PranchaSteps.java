package steps_definition;

import base.BaseSteps;
import io.cucumber.java.pt.*;
import page_objects.PranchaPage;

public class PranchaSteps extends BaseSteps {

    private PranchaPage page = new PranchaPage();

    @Quando("o usuario clicar na prancha")
    public void o_usuario_clicar_na_prancha() {
       page.selecionarPrancha();
    }
    @Quando("o ususario confirmar a exclusao")
    public void o_ususario_confirmar_a_exclusao() {
     page.confirmarApagar();
    }

    @Quando("o usuario clicar no botao {string} da prancha")
    public void o_usuario_clicar_no_botao_da_prancha(String string) {
        page.selecionarApagarPrancha();
    }

}
