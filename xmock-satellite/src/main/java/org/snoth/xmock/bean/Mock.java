package org.snoth.xmock.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by robbie on 12/02/2018.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mock {

    @JsonProperty("name")
    private String name;

    @JsonProperty("port")
    private int port;

    @JsonProperty("path")
    private String path;

    @JsonProperty("method")
    private String method;

    @JsonProperty("startAction")
    private String startAction;

    @JsonProperty("stopAction")
    private String stopAction;

    @JsonProperty("path")
    private Parameter requestParameter;

    @JsonProperty("autostart")
    private boolean autoStart;

    @JsonIgnore
    private boolean started;

    public void start() {
        this.setStarted(true);
    }

    public void stop() {
        this.setStarted(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mock mock = (Mock) o;

        if (port != mock.port) return false;
        if (name != null ? !name.equals(mock.name) : mock.name != null) return false;
        if (path != null ? !path.equals(mock.path) : mock.path != null) return false;
        return !(method != null ? !method.equals(mock.method) : mock.method != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + port;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }
}
