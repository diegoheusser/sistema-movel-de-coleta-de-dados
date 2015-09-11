package br.udesc.ceavi.custodevida.retrofit.service;

import br.udesc.ceavi.custodevida.retrofit.response.ResearcherResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ResearcherService {

    @GET("/rest/researcher/{option}")
    void seekResearchers(@Path("option") String option, Callback<ResearcherResponse> cb);

}
