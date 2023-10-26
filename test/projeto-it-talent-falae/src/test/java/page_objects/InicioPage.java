package page_objects;

import base.BasePage;

public class InicioPage extends BasePage {
    private String urlDev ="http://localhost:3000/about";
    private String urlProd = "https://www.falaeapp.org/about";

    public void abrirNavegador(){
        getDriver().get(urlProd);
    }


}
