package page_objects;

import base.BasePage;
import org.openqa.selenium.By;

public class EsqueceuASenhaPage extends BasePage {

    private final By emailReset = By.id("password_reset_email");

    public void escreverEmailReset(String email){
       waitElementVisible(emailReset, 2);
        escreve(emailReset, email);
    }
}
