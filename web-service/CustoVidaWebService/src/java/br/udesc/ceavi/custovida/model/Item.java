package br.udesc.ceavi.custovida.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

    private int id;
    private String description;
    private int identifier;

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

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
}