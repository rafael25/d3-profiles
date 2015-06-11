package com.r1code.d3profile.json.d3hero;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rafael on 11/06/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    @JsonIgnore
    private Map<String, BaseItem> items = new HashMap<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("head")
    public BaseItem getHead() {
        return items.get("head");
    }

    @JsonProperty("head")
    public void setHead(BaseItem head) {
        this.items.put("head", head);
    }

    @JsonProperty("torso")
    public BaseItem getTorso() {
        return items.get("torso");
    }

    @JsonProperty("torso")
    public void setTorso(BaseItem torso) {
        this.items.put("torso", torso);
    }

    @JsonProperty("feet")
    public BaseItem getFeet() {
        return items.get("feet");
    }

    @JsonProperty("feet")
    public void setFeet(BaseItem feet) {
        this.items.put("feet", feet);
    }

    @JsonProperty("hands")
    public BaseItem getHands() {
        return items.get("hands");
    }

    @JsonProperty("hands")
    public void setHands(BaseItem hands) {
        this.items.put("hands", hands);
    }

    @JsonProperty("shoulders")
    public BaseItem getShoulders() {
        return items.get("shoulders");
    }

    @JsonProperty("shoulders")
    public void setShoulders(BaseItem shoulders) {
        this.items.put("shoulders", shoulders);
    }

    @JsonProperty("legs")
    public BaseItem getLegs() {
        return items.get("legs");
    }

    @JsonProperty("legs")
    public void setLegs(BaseItem legs) {
        this.items.put("legs", legs);
    }

    @JsonProperty("bracers")
    public BaseItem getBracers() {
        return items.get("bracers");
    }

    @JsonProperty("bracers")
    public void setBracers(BaseItem bracers) {
        this.items.put("bracers", bracers);
    }

    @JsonProperty("mainHand")
    public BaseItem getMainHand() {
        return items.get("mainHand");
    }

    @JsonProperty("mainHand")
    public void setMainHand(BaseItem mainHand) {
        this.items.put("mainHand", mainHand);
    }

    @JsonProperty("offHand")
    public BaseItem getOffHand() {
        return items.get("offHand");
    }

    @JsonProperty("offHand")
    public void setOffHand(BaseItem offHand) {
        this.items.put("offHand", offHand);
    }

    @JsonProperty("waist")
    public BaseItem getWaist() {
        return items.get("waist");
    }

    @JsonProperty("waist")
    public void setWaist(BaseItem waist) {
        this.items.put("waist", waist);
    }

    @JsonProperty("rightFinger")
    public BaseItem getRightFinger() {
        return items.get("rightFinger");
    }

    @JsonProperty("rightFinger")
    public void setRightFinger(BaseItem rightFinger) {
        this.items.put("rightFinger", rightFinger);
    }

    @JsonProperty("leftFinger")
    public BaseItem getLeftFinger() {
        return items.get("leftFinger");
    }

    @JsonProperty("leftFinger")
    public void setLeftFinger(BaseItem leftFinger) {
        this.items.put("leftFinger", leftFinger);
    }

    @JsonProperty("neck")
    public BaseItem getNeck() {
        return items.get("neck");
    }

    @JsonProperty("neck")
    public void setNeck(BaseItem neck) {
        this.items.put("neck", neck);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonIgnore
    public Map<String, BaseItem> getItems() {
        return items;
    }

    @JsonIgnore
    public void setItems(Map<String, BaseItem> items) {
        this.items = items;
    }

    @JsonIgnore
    public int size() {
        return this.items.size();
    }

    @JsonIgnore
    public BaseItem getItem(int position) {
        switch (position) {
            case 0:
                return this.items.get("head");
            case 1:
                return this.items.get("torso");
            case 2:
                return this.items.get("feet");
            case 3:
                return this.items.get("hands");
            case 4:
                return this.items.get("shoulders");
            case 5:
                return this.items.get("legs");
            case 6:
                return this.items.get("bracers");
            case 7:
                return this.items.get("mainHand");
            case 8:
                if (this.items.get("offHand") == null) return this.items.get("waist");
                return this.items.get("offHand");
            case 9:
                if (this.items.get("offHand") == null) return this.items.get("rightFinger");
                return this.items.get("waist");
            case 10:
                if (this.items.get("offHand") == null) return this.items.get("leftFinger");
                return this.items.get("rightFinger");
            case 11:
                if (this.items.get("offHand") == null) return this.items.get("neck");
                return this.items.get("leftFinger");
            case 12:
                return this.items.get("neck");
        }

        return this.items.get("head");
    }
}
