package br.udesc.ceavi.custodevida.dao.researcher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.custodevida.dao.core.DatabaseDefinitions;
import br.udesc.ceavi.custodevida.dao.sqlite.DatabaseHelper;
import br.udesc.ceavi.custodevida.dao.standard.SQLiteStandardDAO;
import br.udesc.ceavi.custodevida.model.Researcher;

public class SQLiteResearcherDAO extends SQLiteStandardDAO<Researcher> implements ResearcherDAO {

    public SQLiteResearcherDAO(Context context) {
        super(context);
    }

    @Override
    public Researcher seekResearcher(String user, String password) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columnsNames = getColumnsNames();
        Cursor cursor = db.query(
                getTableName(),
                columnsNames,
                "user = ? AND password = ?",
                new String[]{user,password},
                null, null,null);
        cursor.moveToFirst();
        ContentValues values  = new ContentValues();
        Researcher r = new Researcher();
        r.setId(cursor.getInt(0));
        r.setName(cursor.getString(1));
        r.setUser(cursor.getString(2));
        r.setPassword(cursor.getString(3));
        cursor.close();
        db.close();
        dbHelper.close();

        return r;
    }

    @Override
    protected String getTableName() {
        return DatabaseDefinitions.TABLE_NAME_RESEARCHER;
    }

    @Override
    protected String[] getColumnsNames() {
        return DatabaseDefinitions.COLUMNS_NAMES_RESEARCHERS;
    }

    @Override
    protected List<Researcher> getList(Cursor c) {
        List<Researcher> list = new ArrayList<>();
        c.moveToFirst();
        do{
            Researcher r = new Researcher();
            r.setId(c.getInt(0));
            r.setName(c.getString(1));
            r.setUser(c.getString(2));
            r.setPassword(c.getString(3));
            list.add(r);
        } while(c.moveToNext());
        return list;
    }

    @Override
    protected ContentValues getContentValues(Researcher r) {
        ContentValues values = new ContentValues();
        values.put("_d", r.getId());
        values.put("name", r.getName());
        values.put("user", r.getUser());
        values.put("password", r.getPassword());
        return values;
    }

}
