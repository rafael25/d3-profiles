package com.r1code.d3profile.json.d3profile;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rafael on 2/06/15.
 */
public class Profile {

    @JsonProperty("battleTag")
    private String battleTag;

    @JsonProperty("paragonLevel")
    private int paragonLevel;

    @JsonProperty("paragonLevelHardcore")
    private int paragonLevelHardcore;

    @JsonProperty("kills")
    private Profile.Kills kills;

    @JsonProperty("heroes")
    private List<SimpleHero> heroes = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("battleTag")
    public String getBattleTag() {
        return battleTag;
    }

    @JsonProperty("battleTag")
    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    @JsonProperty("paragonLevel")
    public int getParagonLevel() {
        return paragonLevel;
    }

    @JsonProperty("paragonLevel")
    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    @JsonProperty("paragonLevelHardcore")
    public int getParagonLevelHardcore() {
        return paragonLevelHardcore;
    }

    @JsonProperty("paragonLevelHardcore")
    public void setParagonLevelHardcore(int paragonLevelHardcore) {
        this.paragonLevelHardcore = paragonLevelHardcore;
    }

    @JsonProperty("kills")
    public Profile.Kills getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(Profile.Kills kills) {
        this.kills = kills;
    }

    @JsonProperty("heroes")
    public List<SimpleHero> getHeroes() {
        return heroes;
    }

    @JsonProperty("heroes")
    public void setHeroes(List<SimpleHero> heroes) {
        this.heroes = heroes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class Kills {

        @JsonProperty("monsters")
        private long monsters;

        @JsonProperty("elites")
        private long elites;

        @JsonProperty("hardcoreMonsters")
        private long hardcoreMonsters;

        public Kills() {}

        @JsonProperty("monsters")
        public long getMonsters() {
            return monsters;
        }

        @JsonProperty("monsters")
        public void setMonsters(int monsters) {
            this.monsters = monsters;
        }

        @JsonProperty("elites")
        public long getElites() {
            return elites;
        }

        @JsonProperty("elites")
        public void setElites(int elites) {
            this.elites = elites;
        }

        @JsonProperty("hardcoreMonsters")
        public long getHardcoreMonsters() {
            return hardcoreMonsters;
        }

        @JsonProperty("hardcoreMonsters")
        public void setHardcoreMonsters(int hardcoreMonsters) {
            this.hardcoreMonsters = hardcoreMonsters;
        }
    }
}
