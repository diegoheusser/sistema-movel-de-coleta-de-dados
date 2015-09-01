package br.udesc.ceavi.custodevida.dao.core;

import android.content.Context;

import br.udesc.ceavi.custodevida.dao.researcher.ResearcherDAO;

public abstract class Factory {

    protected Context context;

    public static Factory getInstance(){
        return new br.udesc.ceavi.custodevida.dao.sqlite.Factory();
    }

    public abstract ResearcherDAO getResearcherDAO();

}
