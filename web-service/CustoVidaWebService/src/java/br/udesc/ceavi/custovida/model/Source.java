package br.udesc.ceavi.custovida.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Source {

    private int id;
    private String description;
    private String localization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }
}
