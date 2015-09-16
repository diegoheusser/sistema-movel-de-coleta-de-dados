package br.udesc.ceavi.custodevida.dao.core;

import android.content.Context;

import br.udesc.ceavi.custodevida.dao.control.ControlDAO;
import br.udesc.ceavi.custodevida.dao.researcher.ResearcherDAO;
import br.udesc.ceavi.custodevida.dao.source.SQLiteSourceDAO;
import br.udesc.ceavi.custodevida.dao.source.SourceDAO;

public abstract class Factory {

    protected static Context context;

    public static Factory getInstance(Context context){
        Factory.context = context;
        return new br.udesc.ceavi.custodevida.dao.sqlite.Factory();
    }

    public abstract ResearcherDAO getResearcherDAO();

    public abstract ControlDAO getControlDAO();

    public abstract SourceDAO getSourceDAO();

}
