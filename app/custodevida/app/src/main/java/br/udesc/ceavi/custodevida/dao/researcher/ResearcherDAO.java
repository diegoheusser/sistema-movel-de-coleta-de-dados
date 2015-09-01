package br.udesc.ceavi.custodevida.dao.researcher;



import br.udesc.ceavi.custodevida.dao.standard.StandardDAO;
import br.udesc.ceavi.custodevida.model.Researcher;

public interface ResearcherDAO extends StandardDAO<Researcher> {

    Researcher seekResearcher(String user, String password);

}
