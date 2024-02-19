package dev.khaled.theta.helper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MapConverter implements AttributeConverter<Object, String> {

    public MapConverter(){}

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        StringBuilder sb = new StringBuilder();

        if (attribute != null) {
            sb.append(Utility.gson.toJson(attribute));
        }

        return sb.toString();
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }

        return Utility.gson.fromJson(dbData, Utility.typeMapOfStringObject);
    }
}
