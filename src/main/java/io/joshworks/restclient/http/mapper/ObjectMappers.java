package io.joshworks.restclient.http.mapper;

import io.joshworks.restclient.http.MediaType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectMappers {

    private static final Map<MediaType, ObjectMapper> mappers = new HashMap<>();

    private ObjectMappers() {
    }

    public static void register(MediaType mediaType, ObjectMapper mapper) {
        Objects.requireNonNull(mediaType, "MediaType cannot be null");
        Objects.requireNonNull(mapper, "ObjectMapper must provided");
        mappers.put(mediaType, mapper);
    }

    public static void clear() {
        mappers.clear();
    }

    public static ObjectMapper getMapper(MediaType type) {
        if(mappers.isEmpty()) {
            synchronized (mappers) {
                if(mappers.isEmpty()) {
                    //default mappers
                    ObjectMappers.register(MediaType.TEXT_PLAIN_TYPE, new TextPlainMapper());
                    ObjectMappers.register(MediaType.APPLICATION_JSON_TYPE, new JsonMapper());
                }
            }
        }
        return mappers.get(type);
    }

}
