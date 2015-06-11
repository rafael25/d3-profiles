package com.r1code.d3profile.json.d3hero;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafael on 10/06/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseItem {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("displayColor")
    private String displayColor;
    @JsonProperty("tooltipParams")
    private String tooltipParams;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("displayColor")
    public String getDisplayColor() {
        return displayColor;
    }

    @JsonProperty("displayColor")
    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    @JsonProperty("tooltipParams")
    public String getTooltipParams() {
        return tooltipParams;
    }

    @JsonProperty("tooltipParams")
    public void setTooltipParams(String tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", displayColor='" + displayColor + '\'' +
                '}';
    }
}
