package br.udesc.ceavi.custodevida.retrofit.service;

import br.udesc.ceavi.custodevida.retrofit.response.ResearcherResponse;
import retrofit.Callback;
import retrofit.http.GET;

public interface ResearcherService {

    @GET("/rest/researcher/seekall")
    void seekResearchers(Callback<ResearcherResponse> cb);

}
