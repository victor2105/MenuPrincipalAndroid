package com.vhsstudio.simpletable.cansado;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by VictorHS on 10/26/2014.
 */

public class ItemDAO {
    private SQLiteDatabase sqLiteDatabase;
    private ItemDBHelper itemDBHelper;
    private String[] allColumns = {ItemContract.ItemEntry.COLUMN_ID,
            ItemContract.ItemEntry.COLUMN_ID_TABLE, ItemContract.ItemEntry.COLUMN_NAME,
            ItemContract.ItemEntry.COLUMN_DESCRIPTION, ItemContract.ItemEntry.COLUMN_VALUE,
            ItemContract.ItemEntry.COLUMN_IMAGE_NAME};

    public ItemDAO(Context context){
        itemDBHelper = new ItemDBHelper(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = itemDBHelper.getWritableDatabase();
    }

    public void close() throws SQLException {
        sqLiteDatabase.close();
    }

    public Item createItem (int idTable, String name, String description,
                            double value, String image_name){
        ContentValues values = new ContentValues();

        values.put(ItemContract.ItemEntry.COLUMN_NAME, name);
        values.put(ItemContract.ItemEntry.COLUMN_DESCRIPTION, description);
        values.put(ItemContract.ItemEntry.COLUMN_VALUE, value);
        values.put(ItemContract.ItemEntry.COLUMN_IMAGE_NAME, image_name);
        values.put(ItemContract.ItemEntry.COLUMN_ID_TABLE, idTable);

        long insertId = sqLiteDatabase.insert(ItemContract.ItemEntry.TABLE_ITEM, null,
                values);

        //Cursor cursor = sqLiteDatabase.query(ItemContract.ItemEntry.TABLE_ITEM,
        //        allColumns, ItemContract.ItemEntry.COLUMN_ID + " = " + insertId, null,
        //        null, null, null);

        //cursor.moveToFirst();
        Item newItem = new Item();
        newItem.setItemId(insertId);

        //cursor.close();
        return newItem;
    }

    public void deleteItem(Item item){
        long id = item.getItemId();
        System.out.println("Comment delete with id:" + id);
        sqLiteDatabase.delete(ItemContract.ItemEntry.TABLE_ITEM, ItemContract.ItemEntry.COLUMN_ID + " = " + id, null);
    }

    public List<Item> getAllComments(){
        List<Item> items = new ArrayList<Item>();

        Cursor cursor = sqLiteDatabase.query(ItemContract.ItemEntry.TABLE_ITEM, allColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Item item = cursorToItem(cursor);
            items.add(item);
            cursor.moveToNext();
        }

        cursor.close();
        return items;
    }

    private Item cursorToItem(Cursor cursor){
        Item item = new Item();
        item.setTableId(cursor.getLong(0));
        item.setItemId(cursor.getLong(1));
        item.setItemName(cursor.getString(2));
        item.setItemDescription(cursor.getString(3));

        return item;
    }

    public void deleteTable(){
        itemDBHelper.onUpgrade(sqLiteDatabase, 0, 1);
    }
}


