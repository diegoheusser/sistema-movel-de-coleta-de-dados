package br.udesc.ceavi.custodevida.API;

import java.util.List;

import br.udesc.ceavi.custodevida.model.Researcher;
import retrofit.http.GET;
import retrofit.http.Path;

public interface CustoVidaService {

    @GET("/rest/researchers")
    List<Researcher> listResearchers(@Path("researcher") String param);

}
