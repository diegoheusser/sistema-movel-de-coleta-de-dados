package br.udesc.ceavi.custodevida.model;


import android.content.Context;

import java.util.List;

import br.udesc.ceavi.custodevida.dao.core.Factory;
import br.udesc.ceavi.custodevida.dao.researcher.ResearcherDAO;

public class Researcher {

    private int id;
    private String name;
    private String user;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save(Context context){
        ResearcherDAO dao = Factory.getInstance(context).getResearcherDAO();
        dao.insert(this);
    }

    public List<Researcher> seekAll(Context context){
        ResearcherDAO dao = Factory.getInstance(context).getResearcherDAO();
        return dao.seekAll();
    }

    @Override
    public String toString() {
        return "Researcher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
