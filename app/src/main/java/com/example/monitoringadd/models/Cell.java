package com.example.monitoringadd.models;

public class Cell {

    int id;
    String cellNumber, cellData, cellImage;

    public Cell(int id, String cellNumber, String cellData) {
        this.id = id;
        this.cellNumber = cellNumber;
        this.cellData = cellData;
        //this.cellImage = cellImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getCellData() {
        return cellData;
    }

    public void setCellData(String cellData) {
        this.cellData = cellData;
    }

    public String getCellImage() {
        return cellImage;
    }

    public void setCellImage(String cellImage) {
        this.cellImage = cellImage;
    }
}
