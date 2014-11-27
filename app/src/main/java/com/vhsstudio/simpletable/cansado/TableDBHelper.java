package com.vhsstudio.simpletable.cansado;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vhsstudio.simpletable.cansado.TableContract.TableEntry;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class TableDBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "table.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " NUMBER";
    private static final String COMMA_SEP = ",";

    /*
        CREATE TABLE Persons
        (
        ID int ,
        LastName varchar(255) NOT NULL,
        FirstName varchar(255),
        Address varchar(255),
        City varchar(255),
        PRIMARY KEY (ID)
)
    * */

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TableEntry.TABLE_TAB + " ( " +
                    TableEntry.COLUMN_ID + " " + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                    TableEntry.COLUMN_NAME + " " + TEXT_TYPE + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TableEntry.TABLE_TAB;


    public TableDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("SQL_CREATE_ENTRIES");
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES); // Debugger --> That needs be removed
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}