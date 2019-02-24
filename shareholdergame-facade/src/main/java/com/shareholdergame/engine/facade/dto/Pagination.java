package com.shareholdergame.engine.facade.dto;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class Pagination {

    private int itemsCount = 0;

    private int offset = 0;

    private int itemsPerPage = 10;

    private Pagination() {
    }

    public static Pagination of(int itemsCount, int offset, int itemsPerPage) {
        Pagination p = new Pagination();
        p.itemsCount = itemsCount;
        p.offset = offset;
        p.itemsPerPage = itemsPerPage;
        return p;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public int getOffset() {
        return offset;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }
}
