package br.udesc.ceavi.custovida.dao.core;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.mysql.MysqlDAOFactory;
import br.udesc.ceavi.custovida.dao.researcher.ResearcherDAO;

/**
 *
 * @author diego
 */
public abstract class DAOFactory {
    
    public static DAOFactory getInstance(){
        return new MysqlDAOFactory();
    }
    
    public abstract ControlDAO getControlDAO();
    public abstract ResearcherDAO getResearcherDAO();
    
    
}
