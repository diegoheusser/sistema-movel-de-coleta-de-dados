package br.udesc.ceavi.sistemamoveldecoletadedados.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "SMCD";
	private static final int DATABASE_VERSION = 1;
	
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("SQLiteHelper", "Criando banco...");
		db.execSQL("CREATE TABLE pesquisador ( _id INTEGER PRIMARY KEY, nome TEXT NOT NULL, usuario TEXT NOT NULL, senha TEXT NOT NULL );");
		db.execSQL("INSERT INTO pesquisador ( _id, nome, usuario, senha ) VALUES ( 1, 'Pesquisador', 'root', 'root'); ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w("SQLiteHelper", "Atualizando da versão "+oldVersion+" para "
				+newVersion+". Todos os registros serão deletados.");
		db.execSQL("DROP TABLE IF EXISTS pesquisador");
		onCreate(db);
	}

}
