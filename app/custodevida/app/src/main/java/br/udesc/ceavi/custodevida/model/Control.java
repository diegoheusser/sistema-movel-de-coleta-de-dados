package br.udesc.ceavi.custodevida.model;

import android.content.Context;

import java.util.Date;
import java.util.List;

import br.udesc.ceavi.custodevida.dao.control.ControlDAO;
import br.udesc.ceavi.custodevida.dao.core.Factory;

public class Control extends Model {

    private int id;
    private Date emissionDate;
    private Date deliveryDate;
    private int percentage;
    private Source source;
    private Researcher researcher;
    private List<Search> searches;

    @Override
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

    public void save(Context context){
        ControlDAO dao = Factory.getInstance(context).getControlDAO();
        dao.insert(this);
    }

    public void update(Context context){
        ControlDAO dao = Factory.getInstance(context).getControlDAO();
        dao.update(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Control control = (Control) o;

        if (id != control.id) return false;
        if (percentage != control.percentage) return false;
        if (emissionDate != null ? !emissionDate.equals(control.emissionDate) : control.emissionDate != null)
            return false;
        if (deliveryDate != null ? !deliveryDate.equals(control.deliveryDate) : control.deliveryDate != null)
            return false;
        if (source != null ? !source.equals(control.source) : control.source != null) return false;
        if (researcher != null ? !researcher.equals(control.researcher) : control.researcher != null)
            return false;
        return !(searches != null ? !searches.equals(control.searches) : control.searches != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (emissionDate != null ? emissionDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + percentage;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (researcher != null ? researcher.hashCode() : 0);
        result = 31 * result + (searches != null ? searches.hashCode() : 0);
        return result;
    }
}
