package com.resale.utils;

import org.apache.commons.beanutils.Converter;
import com.resale.app.model.entity.ItemType;

public class ItemTypeConverter implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (type == ItemType.class) {
            if (value instanceof String) {
                String TypeString = (String) value;
                return type.cast(ItemType.valueOf(TypeString));
            }
        }
        return null;
    }
}
