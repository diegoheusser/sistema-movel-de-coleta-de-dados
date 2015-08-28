package br.udesc.ceavi.custovida.dao.search;

import br.udesc.ceavi.custovida.dao.mysql.MysqlConnection;
import br.udesc.ceavi.custovida.model.Search;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author diego
 */
public class MysqlSearchDAO implements SearchDAO {

    @Override
    public void save(Search s) throws Exception {
        Connection con = MysqlConnection.getConnection();
        String insert = "INSERT INTO pesquisa "
                + "(ano, data, especificacao, marca, mes, mudoumarca, semana, "
                + "valorlido, fonteid, itemid, usuarioid) VALUES (?,?,?,?,?,?,"
                + "?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(insert);
        DateTime dt = new DateTime(s.getNewDate());
        boolean changedBrand = !s.getOldBrand().equals(s.getNewBrand());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(s.getNewDate());
        pst.setInt(1, dt.getYear());
        pst.setDate(2, (Date) s.getNewDate());
        pst.setString(3, s.getNewSpecification());
        pst.setString(4, s.getNewBrand());
        pst.setInt(5, dt.getMonthOfYear());
        pst.setBoolean(6, changedBrand);
        pst.setInt(7, calendar.get(Calendar.WEEK_OF_MONTH));
        pst.setDouble(8, s.getNewPrice());
        pst.setInt(9, s.getControl().getSource().getId());
        pst.setInt(10, s.getItem().getId());
        pst.setInt(11, s.getControl().getResearcher().getId());
        pst.execute();
        pst.close();
        con.close();
    }

    @Override
    public List<Search> seekLastSearchesOfTheSource(int sourceId, int week, int month, int year) throws Exception {
        Connection con = MysqlConnection.getConnection();
        String select = "SELECT * FROM pesquisa as p "
                + "WHERE p.fonteid = ? AND p.semana = ? AND p.mes = ? AND p.ano = ?";
        PreparedStatement pst = con.prepareStatement(select);
        pst.setInt(1, sourceId);
        pst.setInt(2, week);
        pst.setInt(3, month);
        pst.setInt(4, year);
        ResultSet rs = pst.executeQuery();
        List<Search> searches = new ArrayList<>();
        while(rs.next()){
            Search s = new Search();
            s.setId(rs.getInt("pesquisaid"));
            searches.add(s);
        }
        rs.close();
        pst.close();
        con.close();
        return searches;
    }
    
}
