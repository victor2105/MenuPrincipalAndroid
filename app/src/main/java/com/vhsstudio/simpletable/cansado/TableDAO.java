package com.vhsstudio.simpletable.cansado;


import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class TableDAO {
    private SQLiteDatabase sqLiteDatabase;
    private TableDBHelper tableDBHelper;
    private String[] allColumns = {TableContract.TableEntry.COLUMN_ID, TableContract.TableEntry.COLUMN_NAME};

    public TableDAO(Context context){
        tableDBHelper = new TableDBHelper(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = tableDBHelper.getWritableDatabase();
    }

    public void close() throws SQLException {
        sqLiteDatabase.close();
    }

    public Table createTable (String name){
        ContentValues values = new ContentValues();

        values.put(TableContract.TableEntry.COLUMN_NAME, name);

        long insertId = sqLiteDatabase.insert(TableContract.TableEntry.TABLE_TAB, null,
                values);

        //cursor.moveToFirst();
        Table newTable = new Table();
        newTable.setId(insertId);

        //cursor.close();

        return newTable;
    }

    public void deleteTable(Table table){
        long id = table.getId();
        System.out.println("Comment delete with id:" + id);
        sqLiteDatabase.delete(TableContract.TableEntry.TABLE_TAB, TableContract.TableEntry.COLUMN_ID + " = " + id, null);
    }

    public List<Table> getAllComments(){
        List<Table> tables = new ArrayList<Table>();

        Cursor cursor = sqLiteDatabase.query(TableContract.TableEntry.TABLE_TAB, allColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Table table = cursorToTable(cursor);
            tables.add(table);
            cursor.moveToNext();
        }

        cursor.close();
        return tables;
    }

    private Table cursorToTable(Cursor cursor){
        Table table = new Table();
        table.setId(cursor.getLong(0));
        table.setName(cursor.getString(1));
        return table;
    }

    public void deleteTable(){
        tableDBHelper.onUpgrade(sqLiteDatabase, 0, 1);
    }
}


