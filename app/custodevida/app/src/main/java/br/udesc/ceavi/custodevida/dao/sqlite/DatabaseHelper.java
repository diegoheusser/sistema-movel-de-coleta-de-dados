package br.udesc.ceavi.custodevida.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE_ITEM =
            "CREATE TABLE item ( " +
            "_id INTEGER PRIMARY KEY, " +
            "description TEXT NOT NULL, " +
            "identifier INTEGER NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_SOURCE =
            "CREATE TABLE source ( " +
            "_id INTEGER PRIMARY KEY, " +
            "description TEXT NOT NULL, " +
            "localization TEXT NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_RESEARCHER =
            "CREATE TABLE researcher ( " +
            "_id INTEGER PRIMARY KEY, " +
            "name TEXT NOT NULL, " +
            "user TEXT NOT NULL, " +
            "password TEXT NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_SOURCE_RESEARCHER =
            "CREATE TABLE source_researcher ( " +
            "source_id INTEGER, " +
            "researcher_id INTEGER, " +
            "PRIMARY KEY (source_id, researcher_id), " +
            "FOREIGN KEY(source_id) REFERENCES source(_id), " +
            "FOREIGN KEY(researcher_id) REFERENCES researcher(_id)  " +
            ") ";
    private static final String SQL_CREATE_TABLE_CONTROL =
            "CREATE TABLE control ( " +
            "_id INTEGER PRIMARY KEY, " +
            "emission_date TEXT NOT NULL, " +
            "percentage INTEGER DEFAULT 0, " +
            "source_id INTEGER NOT NULL, " +
            "researcher_id INTEGER NOT NULL, " +
            "FOREIGN KEY(source_id) REFERENCES source(_id), " +
            "FOREIGN KEY(researcher_id) REFERENCES researcher(_id) " +
            ") ";
    private static final String SQL_CREATE_TABLE_SEARCH =
            "CREATE TABLE search ( " +
            "_id INTEGER PRIMARY KEY, " +
            "old_date TEXT NOT NULL, " +
            "old_brand TEXT NOT NULL, " +
            "old_specification TEXT NOT NULL, " +
            "old_price REAL NOT NULL, " +
            "new_date TEXT, " +
            "new_brand TEXT, " +
            "new_specification TEXT, " +
            "new_price REAL, " +
            "item_id INTEGER NOT NULL, " +
            "control_id INTEGER NOT NULL, " +
            "FOREIGN KEY(item_id) REFERENCES item(_id), " +
            "FOREIGN KEY(control_id) REFERENCES control(_id) " +
            ") ";
    private static final String SQL_DROP_TABLE_ITEM = "DROP TABLE IF EXISTS item; ";
    private static final String SQL_DROP_TABLE_SOURCE = "DROP TABLE IF EXISTS source; ";
    private static final String SQL_DROP_TABLE_RESEARCHER = "DROP TABLE IF EXISTS researcher; ";
    private static final String SQL_DROP_TABLE_SOURCE_RESEARCHER = "DROP TABLE IF EXISTS source_researcher; ";
    private static final String SQL_DROP_TABLE_CONTROL = "DROP TABLE IF EXISTS control; ";
    private static final String SQL_DROP_TABLE_SEARCH = "DROP TABLE IF EXISTS search; ";
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "custodevida";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Database", "Creating database");
        db.execSQL(SQL_CREATE_TABLE_ITEM);
        db.execSQL(SQL_CREATE_TABLE_SOURCE);
        db.execSQL(SQL_CREATE_TABLE_RESEARCHER);
        db.execSQL(SQL_CREATE_TABLE_SOURCE_RESEARCHER);
        db.execSQL(SQL_CREATE_TABLE_CONTROL);
        db.execSQL(SQL_CREATE_TABLE_SEARCH);
        Log.i("Database", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Database", "Updating database");
        Log.i("Database", "Deleting database");
        db.execSQL(SQL_DROP_TABLE_SOURCE_RESEARCHER);
        db.execSQL(SQL_DROP_TABLE_SEARCH);
        db.execSQL(SQL_DROP_TABLE_CONTROL);
        db.execSQL(SQL_DROP_TABLE_RESEARCHER);
        db.execSQL(SQL_DROP_TABLE_SOURCE);
        db.execSQL(SQL_DROP_TABLE_ITEM);
        Log.i("Database", "Database deleted");
        Log.i("Database", "Updating database");
        onCreate(db);
        Log.i("Database", "Database updated");
    }
}
