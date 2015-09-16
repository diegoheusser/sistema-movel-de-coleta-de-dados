package br.udesc.ceavi.custovida.dao.mysql;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.control.MysqlControlDAO;
import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.item.ItemDAO;
import br.udesc.ceavi.custovida.dao.item.MysqlItemDAO;
import br.udesc.ceavi.custovida.dao.researcher.MysqlResearcherDAO;
import br.udesc.ceavi.custovida.dao.researcher.ResearcherDAO;
import br.udesc.ceavi.custovida.dao.source.MysqlSourceDAO;
import br.udesc.ceavi.custovida.dao.source.SourceDAO;

/**
 *
 * @author Diego Heusser
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

    @Override
    public ItemDAO getItemDAO() {
        return new MysqlItemDAO();
    }

    @Override
    public SourceDAO getSourceDAO() {
        return new MysqlSourceDAO();
    }
    
}
