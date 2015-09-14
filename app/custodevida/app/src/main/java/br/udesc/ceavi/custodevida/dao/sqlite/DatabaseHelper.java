package br.udesc.ceavi.custodevida.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.udesc.ceavi.custodevida.dao.core.DatabaseDefinitions;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE_ITEM =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_ITEM + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_ITEM[0] + " INTEGER PRIMARY KEY, " +
            DatabaseDefinitions.COLUMNS_NAMES_ITEM[1] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_ITEM[2] + " INTEGER NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_SOURCE =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_SOURCE + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_SOURCE[0] + " INTEGER PRIMARY KEY, " +
            DatabaseDefinitions.COLUMNS_NAMES_SOURCE[1] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SOURCE[2] + " TEXT NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_RESEARCHER =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_RESEARCHER + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[0] + " INTEGER PRIMARY KEY, " +
            DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[1] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[2] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[3] + " TEXT NOT NULL " +
            ") ";
    private static final String SQL_CREATE_TABLE_SOURCE_RESEARCHER =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_SOURCE_RESOURCE + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[0] + " INTEGER, " +
            DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[1] + " INTEGER, " +
            "PRIMARY KEY (" + DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[0] +
                    ", " + DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[1] + "), " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[0] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_SOURCE + "(" + DatabaseDefinitions.COLUMNS_NAMES_SOURCE[0] + "), " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_SOURCE_RESEARCHER[1] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_RESEARCHER + "(" + DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[0] + ")  " +
            ") ";
    private static final String SQL_CREATE_TABLE_CONTROL =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_CONTROL + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[0] + " INTEGER PRIMARY KEY, " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[1] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[2] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[3] + " INTEGER DEFAULT 0, " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[4] + " INTEGER NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_CONTROL[5] + " INTEGER NOT NULL, " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_CONTROL[4] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_SOURCE + "(" + DatabaseDefinitions.COLUMNS_NAMES_SOURCE[0] + "), " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_CONTROL[5] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_RESEARCHER + "(" + DatabaseDefinitions.COLUMNS_NAMES_RESEARCHER[0] + ") " +
            ") ";
    private static final String SQL_CREATE_TABLE_SEARCH =
            "CREATE TABLE " + DatabaseDefinitions.TABLE_NAME_SEARCH + " ( " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[0] + " INTEGER PRIMARY KEY, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[1] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[2] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[3] + " TEXT NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[4] + " REAL NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[5] + " TEXT, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[6] + " TEXT, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[7] + " TEXT, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[8] + " REAL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[9] + " INTEGER NOT NULL, " +
            DatabaseDefinitions.COLUMNS_NAMES_SEARCH[10] + " INTEGER NOT NULL, " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_SEARCH[9] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_ITEM + "(" + DatabaseDefinitions.COLUMNS_NAMES_ITEM[0] + "), " +
            "FOREIGN KEY(" + DatabaseDefinitions.COLUMNS_NAMES_SEARCH[10] + ") REFERENCES " +
                    DatabaseDefinitions.TABLE_NAME_CONTROL + "(" + DatabaseDefinitions.COLUMNS_NAMES_CONTROL[0] + ") " +
            ") ";
    private static final String SQL_DROP_TABLE_ITEM = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_ITEM;
    private static final String SQL_DROP_TABLE_SOURCE = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_SOURCE;
    private static final String SQL_DROP_TABLE_RESEARCHER = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_RESEARCHER;
    private static final String SQL_DROP_TABLE_SOURCE_RESEARCHER = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_SOURCE_RESOURCE;
    private static final String SQL_DROP_TABLE_CONTROL = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_CONTROL;
    private static final String SQL_DROP_TABLE_SEARCH = "DROP TABLE IF EXISTS " + DatabaseDefinitions.TABLE_NAME_SEARCH;
    private static final int DATABASE_VERSION = 7;
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
