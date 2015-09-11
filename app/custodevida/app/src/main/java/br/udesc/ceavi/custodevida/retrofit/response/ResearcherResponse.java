package br.udesc.ceavi.custodevida.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.udesc.ceavi.custodevida.model.Researcher;

public class ResearcherResponse {

    @SerializedName("researcher")
    private List<Researcher> researcherList;

    public List<Researcher> getResearcherList() {
        return researcherList;
    }
}
