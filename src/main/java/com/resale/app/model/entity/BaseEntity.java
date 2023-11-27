package com.resale.app.model.entity;



import java.io.Serializable;

import com.resale.database.helper.DbTableColumn;
import com.resale.database.helper.DbTableId;

public class BaseEntity implements Serializable {

    @DbTableId
    @DbTableColumn(name = "id", definition = "int")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}