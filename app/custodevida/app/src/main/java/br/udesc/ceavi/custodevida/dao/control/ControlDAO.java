package br.udesc.ceavi.custodevida.dao.control;

import java.util.List;

import br.udesc.ceavi.custodevida.dao.standard.StandardDAO;
import br.udesc.ceavi.custodevida.model.Control;

public interface ControlDAO extends StandardDAO<Control> {

    List<Control> seekAllByResearcher(int researcherID);

}
