package br.udesc.ceavi.custovida.dao.mysql;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.control.MysqlControlDAO;
import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.researcher.MysqlResearcherDAO;
import br.udesc.ceavi.custovida.dao.researcher.ResearcherDAO;

/**
 *
 * @author diego
 */
public class MysqlDAOFactory extends DAOFactory {

    @Override
    public ControlDAO getControlDAO() {
        return new MysqlControlDAO();
    }

    @Override
    public ResearcherDAO getResearcherDAO() {
        return new MysqlResearcherDAO();
    }
    
}
