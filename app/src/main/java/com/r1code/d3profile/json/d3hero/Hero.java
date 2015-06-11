package com.r1code.d3profile.json.d3hero;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafael on 5/06/15.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hero {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("gender")
    private int gender;
    @JsonProperty("level")
    private int level;
    @JsonProperty("paragonLevel")
    private int paragonLevel;
    @JsonProperty("hardcore")
    private boolean hardcore;
    @JsonProperty("seasonal")
    private boolean seasonal;
    @JsonProperty("seasonCreated")
    private int seasonCreated;
    @JsonProperty("dead")
    private boolean dead;
    @JsonProperty("last-updated")
    private long lastUpdated;

    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("items")
    private Items items;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
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

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("gender")
    public int getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(int gender) {
        this.gender = gender;
    }

    @JsonProperty("level")
    public int getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JsonProperty("paragonLevel")
    public int getParagonLevel() {
        return paragonLevel;
    }

    @JsonProperty("paragonLevel")
    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    @JsonProperty("hardcore")
    public boolean isHardcore() {
        return hardcore;
    }

    @JsonProperty("hardcore")
    public void setHardcore(boolean hardcore) {
        this.hardcore = hardcore;
    }

    @JsonProperty("seasonal")
    public boolean isSeasonal() {
        return seasonal;
    }

    @JsonProperty("seasonal")
    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    @JsonProperty("seasonCreated")
    public int getSeasonCreated() {
        return seasonCreated;
    }

    @JsonProperty("seasonCreated")
    public void setSeasonCreated(int seasonCreated) {
        this.seasonCreated = seasonCreated;
    }

    @JsonProperty("dead")
    public boolean isDead() {
        return dead;
    }

    @JsonProperty("dead")
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @JsonProperty("last-updated")
    public long getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last-updated")
    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("items")
    public Items getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items items) {
        this.items = items;
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
