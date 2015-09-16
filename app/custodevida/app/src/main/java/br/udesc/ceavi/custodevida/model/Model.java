package br.udesc.ceavi.custodevida.model;


import java.util.List;

public abstract class Model {

    public abstract int getId();

    public boolean onTheList(List list) {
        for(Model m : (List<Model>) list){
            if(this.getId()==m.getId()){
                return true;
            }
        }
        return false;
    }
}
