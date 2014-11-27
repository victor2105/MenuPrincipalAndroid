package com.vhsstudio.simpletable.cansado;


/**
 * Created by VictorHS on 10/26/2014.
 */
public class ItemContract {

    public ItemContract(){

    }

    public static abstract class ItemEntry {

        public static final String TABLE_ITEM = "item";
        public static final String COLUMN_ID = "idItem";
        public static final String COLUMN_ID_TABLE = "tableId"; //Add em ItemDAO e ItemDBHelper
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGE_NAME = "image_name";
        public static final String COLUMN_VALUE = "value";

    }

}
