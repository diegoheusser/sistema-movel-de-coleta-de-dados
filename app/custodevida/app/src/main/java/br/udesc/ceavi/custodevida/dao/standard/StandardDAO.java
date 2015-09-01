package br.udesc.ceavi.custodevida.dao.standard;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

public interface StandardDAO<T> {

    public void insert(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    public List<T> seekAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException;

}
