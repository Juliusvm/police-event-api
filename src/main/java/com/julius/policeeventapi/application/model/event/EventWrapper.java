package com.julius.policeeventapi.application.model.event;
import com.julius.policeeventapi.util.JsonUtil;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "events")
@Data
public class EventWrapper {
    public String _id;
    public List<Event> events;

    @Override
    public String toString(){
        return JsonUtil.toJsonString(this);
    }
}
