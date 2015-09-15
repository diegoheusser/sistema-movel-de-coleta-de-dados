package br.udesc.ceavi.custodevida.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.udesc.ceavi.custodevida.model.Control;

public class ControlResponse {

    @SerializedName("control")
    private List<Control> controlList;

    public List<Control> getControlList() {
        return controlList;
    }
}
