package br.udesc.ceavi.custodevida.dao.sqlite;


import br.udesc.ceavi.custodevida.dao.researcher.ResearcherDAO;
import br.udesc.ceavi.custodevida.dao.researcher.SQLiteResearcherDAO;

public class Factory extends br.udesc.ceavi.custodevida.dao.core.Factory {

    @Override
    public ResearcherDAO getResearcherDAO() {
        return new SQLiteResearcherDAO(super.context);
    }
}
