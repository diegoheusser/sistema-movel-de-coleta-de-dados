package br.udesc.ceavi.custodevida.model;

import android.content.Context;

import java.util.Date;
import java.util.List;

import br.udesc.ceavi.custodevida.dao.control.ControlDAO;
import br.udesc.ceavi.custodevida.dao.core.Factory;

public class Control {

    private int id;
    private Date emissionDate;
    private Date deliveryDate;
    private int percentage;
    private Source source;
    private Researcher researcher;
    private List<Search> searches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    public static List<Control> seekAllByResearcher(Context context, int researcherId){
        ControlDAO dao = Factory.getInstance(context).getControlDAO();
        return dao.seekAllByResearcher(researcherId);
    }
}
