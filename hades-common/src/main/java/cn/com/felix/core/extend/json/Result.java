package cn.com.felix.core.extend.json;

import cn.com.felix.core.enums.ResultEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    private static final String JSON_FLAG_STATUS = "status";
    private static final String JSON_FLAG_PATH = "path";
    private static final String JSON_FLAG_MESSAGE = "message";
    private static final String JSON_FLAG_ERROR = "error";
    private static final String JSON_FLAG_DATA = "data";
    private static final String JSON_FLAG_TIMESTAMP = "timestamp";


    private int status;
    private String message = "";
    private StringBuffer path = new StringBuffer();
    private Date timestamp = new Date();
    private Object error = "";
    private Object data = "";


    public Result() {
        put(JSON_FLAG_STATUS, ResultEnum.SUCCESS.getStatus());
        put(JSON_FLAG_MESSAGE, ResultEnum.SUCCESS.getMessage());
        put(JSON_FLAG_TIMESTAMP, new Date());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        put(JSON_FLAG_STATUS, this.status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        put(JSON_FLAG_MESSAGE, message);
    }

    public StringBuffer getPath() {
        return path;
    }

    public void setPath(StringBuffer path) {
        this.path = path;
        put(JSON_FLAG_PATH, this.path);
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
        put(JSON_FLAG_ERROR, this.error);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        put(JSON_FLAG_TIMESTAMP, this.timestamp);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        put(JSON_FLAG_DATA, this.data);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("message", message)
                .append("path", path)
                .append("timestamp", timestamp)
                .append("error", error)
                .append("data", data)
                .toString();
    }
}
