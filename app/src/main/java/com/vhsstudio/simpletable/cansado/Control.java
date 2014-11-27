package com.vhsstudio.simpletable.cansado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VictorHS on 11/11/2014.
 */
public class Control {

    private ArrayList<Table> tables;
    private ArrayList<Item> items;

    private Control(){
        tables = new ArrayList<Table>();
    }

    public Table get(int i){
        Table table = null;
        try{
            tables.get(i);
        }catch (Exception e){

        }
        return table;
    }

    public Table createTable (String name, String dateI, String dateF){
        Table table = new Table();
        table.setId(tables.size()+1);
        table.setName(name);
        //tables.add(table);
        return table;
    }

    public List<Table> getAllComments(){
        return tables;
    }

    public Item createItem (Long idTable, String name, String description, double valorExperado, double valorAtual) {
        Item item = new Item();
        item.setTableId(idTable);
        item.setItemId(items.size()+1);
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemValueEsperado(valorExperado);
        item.setItemValueActual(valorAtual);
        return item;
    }

    public List<Item> findByTableId(Long id){
        ArrayList<Item> itemList = new ArrayList<Item>();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if(item.getTableId() == id){
                itemList.add(item);
            }
        }
        return itemList;
    }

    private static Control INSTANCE = new Control();

    public static Control getInstance() {
        return INSTANCE;
    }
}
