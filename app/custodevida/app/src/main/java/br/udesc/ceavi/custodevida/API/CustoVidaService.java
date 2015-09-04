package br.udesc.ceavi.custodevida.API;

import java.util.List;

import br.udesc.ceavi.custodevida.model.Researcher;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface CustoVidaService {

    @GET("/rest/researcher/{option}")
    void seekResearchers(@Path("option") String option, Callback<List<Researcher>> cb);

}
