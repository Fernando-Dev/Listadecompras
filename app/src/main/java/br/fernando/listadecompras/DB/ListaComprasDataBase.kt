package br.fernando.listadecompras.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ListaComprasDataBase(context: Context) :
    SQLiteOpenHelper(context, "listaCompras.db", null, 1) {

    private val CRIA_BANCO: String = "create table produtos(id integer primary key autoincrement," +
            "nome text, quantidade integer, valor real, foto blob);"

    /**
     * criando metodo singleton
     * para chamada do banco pelo metodo estatico
     */
    companion object {
        private var instance: ListaComprasDataBase? = null

        @Synchronized
        fun getInstance(ctx: Context): ListaComprasDataBase {
            if (instance == null) {
                instance =
                    ListaComprasDataBase(ctx.applicationContext)
            }
            return instance!!
        }

    }

    override fun onCreate(db: SQLiteDatabase) {
        //criacao do banco
        db.execSQL(CRIA_BANCO)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //atualiacao do banco


    }
    /**
     * acessando a propriedade pelo contexto
     */
    val Context.database: ListaComprasDataBase
    get() = getInstance(
        applicationContext
    )

}
