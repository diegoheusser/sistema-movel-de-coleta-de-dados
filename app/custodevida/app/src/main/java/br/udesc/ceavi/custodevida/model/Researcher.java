package br.udesc.ceavi.custodevida.model;


import android.content.Context;

import java.util.List;

import br.udesc.ceavi.custodevida.SplashActivity;
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

    public static List<Researcher> seekAll(Context context){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Researcher that = (Researcher) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public boolean onTheList(List<Researcher> list) {
        for(Researcher r : list){
            if(id==r.getId()){
                return true;
            }
        }
        return false;
    }

    public void update(Context context) {
        ResearcherDAO dao = Factory.getInstance(context).getResearcherDAO();
        dao.update(this);
    }

    public static Researcher seekResearcher(Context context, String user, String password){
        ResearcherDAO dao = Factory.getInstance(context).getResearcherDAO();
        return dao.seekResearcher(user, password);
    }
}
