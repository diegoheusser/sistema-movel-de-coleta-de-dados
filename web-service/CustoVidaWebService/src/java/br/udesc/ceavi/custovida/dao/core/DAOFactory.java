package br.udesc.ceavi.custovida.dao.core;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.item.ItemDAO;
import br.udesc.ceavi.custovida.dao.mysql.MysqlDAOFactory;
import br.udesc.ceavi.custovida.dao.researcher.ResearcherDAO;
import br.udesc.ceavi.custovida.dao.source.SourceDAO;

/**
 *
 * @author Diego Heusser
 */
public abstract class DAOFactory {
    
    public static DAOFactory getInstance(){
        return new MysqlDAOFactory();
    }
    
    public abstract ControlDAO getControlDAO();
    public abstract ResearcherDAO getResearcherDAO();
    public abstract ItemDAO getItemDAO();
    public abstract SourceDAO getSourceDAO();
    
    
}
