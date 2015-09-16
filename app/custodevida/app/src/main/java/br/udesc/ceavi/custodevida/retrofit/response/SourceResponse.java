package br.udesc.ceavi.custodevida.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.udesc.ceavi.custodevida.model.Source;

public class SourceResponse {

    @SerializedName("source")
    private List<Source> sourceList;

    public List<Source> getSourceList() {
        return sourceList;
    }
}
