package com.r1code.d3profile.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafael on 2/06/15.
 */
public class Hero {

    @JsonProperty("paragonLevel")
    private long paragonLevel;

    @JsonProperty("seasonal")
    private boolean seasonal;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;

    @JsonProperty("level")
    private long level;

    @JsonProperty("hardcore")
    private boolean hardcore;

    @JsonProperty("last-updated")
    private long lastUpdated;

    @JsonProperty("gender")
    private int gender;

    @JsonProperty("dead")
    private boolean dead;

    @JsonProperty("class")
    private String _class;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Hero() {}

    @JsonProperty("paragonLevel")
    public long getParagonLevel() {
        return paragonLevel;
    }

    @JsonProperty("paragonLevel")
    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    @JsonProperty("seasonal")
    public boolean isSeasonal() {
        return seasonal;
    }

    @JsonProperty("seasonal")
    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("level")
    public long getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JsonProperty("hardcore")
    public boolean isHardcore() {
        return hardcore;
    }

    @JsonProperty("hardcore")
    public void setHardcore(boolean hardcore) {
        this.hardcore = hardcore;
    }

    @JsonProperty("last-updated")
    public long getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last-updated")
    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("gender")
    public int getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(int gender) {
        this.gender = gender;
    }

    @JsonProperty("dead")
    public boolean isDead() {
        return dead;
    }

    @JsonProperty("dead")
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
