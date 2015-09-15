package br.udesc.ceavi.custovida.dao.control;

import br.udesc.ceavi.custovida.dao.mysql.MysqlConnection;
import br.udesc.ceavi.custovida.model.Control;
import br.udesc.ceavi.custovida.model.Researcher;
import br.udesc.ceavi.custovida.model.Source;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public class MysqlControlDAO implements ControlDAO {

    @Override
    public List<Control> seekControlsByResearcher(int researcherId) throws Exception {
        Connection con = MysqlConnection.getConnection();
        String select = "SELECT * FROM pesquisacontrole as p "
                + "INNER JOIN fonte as f ON f.fonteid = p.fonteid "
                + "INNER JOIN usuario as u ON u.usuarioid = p.usuarioid "
                + "WHERE p.aberto = 1 AND u.usuarioid = " + researcherId + " ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        List<Control> controls = new ArrayList<>();
        
        while(rs.next()){
            
            Researcher r = new Researcher();
            r.setId(rs.getInt("usuarioid"));
            r.setName(rs.getString("nomecompleto"));
            r.setPassword(rs.getString("senha"));
            r.setUser(rs.getString("nick"));
            
            Source s = new Source();
            s.setId(rs.getInt("fonteid"));
            s.setDescription(rs.getString("descricao"));
            s.setLocalization(rs.getString("localizacao"));
            
            Control c = new Control();
            c.setId(rs.getInt("pesquisacontroleid"));
            c.setEmissionDate(rs.getDate("dataemissao"));
            c.setPercentage(0);
            c.setResearcher(r);
            c.setSource(s);
            
            controls.add(c);
            
        }
        
        rs.close();
        st.close();
        con.close();
        
        return controls;
        
    }

    @Override
    public void update(Date deliveryDate, int controlId) throws Exception {
        Connection con = MysqlConnection.getConnection();
        String update = "UPDATE pesquisacontrole SET dataentrega = ? WHERE pesquisacontroleid = ? ";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setDate(1, (java.sql.Date) deliveryDate);
        pst.setInt(2, controlId);
        pst.execute();
        pst.close();
        con.close();
    }
    
}
