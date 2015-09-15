package br.udesc.ceavi.custovida.model;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Control {

    private int id;
    private Date emissionDate;
    private Date deliveryDate;
    private int percentage;
    private Source source;
    private Researcher researcher;
    private List<Search> searches;
    
    public static List<Control> seekControlsByResearcher(int researcherId) throws Exception{
        ControlDAO dao = DAOFactory.getInstance().getControlDAO();
        return dao.seekControlsByResearcher(researcherId);
    }
    
    public void update() throws Exception {
        ControlDAO dao = DAOFactory.getInstance().getControlDAO();
        dao.update(deliveryDate, id);
    }

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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }
    
}
