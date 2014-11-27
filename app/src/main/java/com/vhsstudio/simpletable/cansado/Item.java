package com.vhsstudio.simpletable.cansado;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class Item {
    private long itemId;
    private long tableId;
    private String itemName;
    private String itemDescription;
    private String itemIcon;
    private double itemValueEsperado;
    private double itemValueActual;

    public Item(){

    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemValueEsperado(double itemValueEsperado) {
        this.itemValueEsperado = itemValueEsperado;
    }

    public void setItemValueActual(double itemValueActual) {
        this.itemValueActual = itemValueActual;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getItemId() {
        return itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public double getItemValueEsperado() {
        return itemValueEsperado;
    }

    public double getItemValueActual() {
        return itemValueActual;
    }
}
