package com.julius.policeeventapi.model;
import com.julius.policeeventapi.util.JsonUtil;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "events")
public class EventWrapper {
    public String _id;
    public List<Event> events;

    @Override
    public String toString(){
        return JsonUtil.toJsonString(this);
    }
}
