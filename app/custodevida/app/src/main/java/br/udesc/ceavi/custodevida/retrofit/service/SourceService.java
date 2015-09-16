package br.udesc.ceavi.custodevida.retrofit.service;

import br.udesc.ceavi.custodevida.retrofit.response.SourceResponse;
import retrofit.Callback;
import retrofit.http.GET;

public interface SourceService {

    @GET("/rest/source/seekall")
    void seekAll(Callback<SourceResponse> cb);

}
