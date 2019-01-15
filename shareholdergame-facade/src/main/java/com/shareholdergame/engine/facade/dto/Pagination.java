package com.shareholdergame.engine.facade.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class Pagination {

    private int itemsCount = 0;

    private int offset = 0;

    private int itemsPerPage = 10;

    @JsonCreator
    public Pagination(@JsonProperty("itemsCount") int itemsCount,
                      @JsonProperty("offset") int offset,
                      @JsonProperty("itemsPerPage") int itemsPerPage) {
        this.itemsCount = itemsCount;
        this.offset = offset;
        this.itemsPerPage = itemsPerPage;
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
