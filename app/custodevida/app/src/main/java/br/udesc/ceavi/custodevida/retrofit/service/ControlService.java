package br.udesc.ceavi.custodevida.retrofit.service;


import br.udesc.ceavi.custodevida.retrofit.response.ControlResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ControlService {

    @GET("/rest/control/{option}/{researcherid}")
    void seekControlsByResearcher(@Path("option") String option, @Path("researcherid") int researcherid, Callback<ControlResponse> cb);

}
