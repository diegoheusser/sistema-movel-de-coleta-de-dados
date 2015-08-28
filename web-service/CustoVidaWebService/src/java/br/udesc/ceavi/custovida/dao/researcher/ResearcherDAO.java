package br.udesc.ceavi.custovida.dao.researcher;

import br.udesc.ceavi.custovida.model.Researcher;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ResearcherDAO {

    public void update(Researcher r) throws Exception;
    
    public List<Researcher> seekResearchersValid() throws Exception;
    
}
