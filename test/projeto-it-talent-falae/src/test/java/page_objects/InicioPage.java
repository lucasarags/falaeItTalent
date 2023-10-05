package page_objects;

import base.BasePage;

public class InicioPage extends BasePage {
    private String url ="https://www.falaeapp.org/about";

    public void abrirNavegador(){
        getDriver().get(url);
    }


}
