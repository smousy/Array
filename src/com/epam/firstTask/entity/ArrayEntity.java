package com.epam.firstTask.entity;

public class ArrayEntity {
    private String[] array;

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String getElement(int index) {
        return this.array[index];
    }

    public ArrayEntity(String[] array){
        this.array=array;
    }
}
