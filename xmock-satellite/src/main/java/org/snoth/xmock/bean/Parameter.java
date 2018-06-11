package org.snoth.xmock.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by robbie on 15/02/2018.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("optional")
    private boolean optional;

}
