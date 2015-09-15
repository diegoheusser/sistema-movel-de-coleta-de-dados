package br.udesc.ceavi.custodevida.base;

import br.udesc.ceavi.custodevida.model.Researcher;

public class AppContext {

    //When use emulator change localhost by 10.0.2.2
    public static final String SERVICE_URL = "http://10.0.2.2:8084/custovidawebservice";
    public static Researcher RESEARCHER = null;

}
