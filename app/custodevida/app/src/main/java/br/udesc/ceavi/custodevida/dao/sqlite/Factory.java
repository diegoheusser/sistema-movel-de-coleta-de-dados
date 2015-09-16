package br.udesc.ceavi.custodevida.dao.sqlite;


import br.udesc.ceavi.custodevida.dao.control.ControlDAO;
import br.udesc.ceavi.custodevida.dao.control.SQLiteControlDAO;
import br.udesc.ceavi.custodevida.dao.researcher.ResearcherDAO;
import br.udesc.ceavi.custodevida.dao.researcher.SQLiteResearcherDAO;
import br.udesc.ceavi.custodevida.dao.source.SQLiteSourceDAO;
import br.udesc.ceavi.custodevida.dao.source.SourceDAO;

public class Factory extends br.udesc.ceavi.custodevida.dao.core.Factory {

    @Override
    public ResearcherDAO getResearcherDAO() {
        return new SQLiteResearcherDAO(super.context);
    }

    @Override
    public ControlDAO getControlDAO() {
        return new SQLiteControlDAO(super.context);
    }

    @Override
    public SourceDAO getSourceDAO() {
        return new SQLiteSourceDAO(super.context);
    }
}
