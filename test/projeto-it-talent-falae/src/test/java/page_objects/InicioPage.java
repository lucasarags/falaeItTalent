package page_objects;

import base.BasePage;

public class InicioPage extends BasePage {
    private String url ="http://localhost:3000/about";

    public void abrirNavegador(){
        getDriver().get(url);
    }


}
