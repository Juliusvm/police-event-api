package com.julius.policeeventapi.model;
import com.julius.policeeventapi.util.JsonUtil;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class Event {

    public String id;
    public String datetime;
    public String name;
    public String summary;
    public String url;
    public String type;
    public Location location;
    public String locationName;


    @Override
    public String toString(){
        return JsonUtil.toJsonString(this);
    }
}