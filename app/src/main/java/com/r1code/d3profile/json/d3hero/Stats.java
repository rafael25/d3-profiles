package com.r1code.d3profile.json.d3hero;

/**
 * Created by rafael on 9/06/15.
 */
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stats {

    @JsonProperty("life")
    private int life;
    @JsonProperty("damage")
    private int damage;
    @JsonProperty("toughness")
    private int toughness;
    @JsonProperty("healing")
    private int healing;
    @JsonProperty("attackSpeed")
    private double attackSpeed;
    @JsonProperty("armor")
    private int armor;
    @JsonProperty("strength")
    private int strength;
    @JsonProperty("dexterity")
    private int dexterity;
    @JsonProperty("vitality")
    private int vitality;
    @JsonProperty("intelligence")
    private int intelligence;
    @JsonProperty("physicalResist")
    private int physicalResist;
    @JsonProperty("fireResist")
    private int fireResist;
    @JsonProperty("coldResist")
    private int coldResist;
    @JsonProperty("lightningResist")
    private int lightningResist;
    @JsonProperty("poisonResist")
    private int poisonResist;
    @JsonProperty("arcaneResist")
    private int arcaneResist;
    @JsonProperty("critDamage")
    private double critDamage;
    @JsonProperty("blockChance")
    private int blockChance;
    @JsonProperty("blockAmountMin")
    private int blockAmountMin;
    @JsonProperty("blockAmountMax")
    private int blockAmountMax;
    @JsonProperty("damageIncrease")
    private int damageIncrease;
    @JsonProperty("critChance")
    private double critChance;
    @JsonProperty("damageReduction")
    private int damageReduction;
    @JsonProperty("thorns")
    private int thorns;
    @JsonProperty("lifeSteal")
    private int lifeSteal;
    @JsonProperty("lifePerKill")
    private int lifePerKill;
    @JsonProperty("goldFind")
    private int goldFind;
    @JsonProperty("magicFind")
    private int magicFind;
    @JsonProperty("lifeOnHit")
    private int lifeOnHit;
    @JsonProperty("primaryResource")
    private int primaryResource;
    @JsonProperty("secondaryResource")
    private int secondaryResource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("life")
    public int getLife() {
        return life;
    }

    @JsonProperty("life")
    public void setLife(int life) {
        this.life = life;
    }

    @JsonProperty("damage")
    public int getDamage() {
        return damage;
    }

    @JsonProperty("damage")
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @JsonProperty("toughness")
    public int getToughness() {
        return toughness;
    }

    @JsonProperty("toughness")
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    @JsonProperty("healing")
    public int getHealing() {
        return healing;
    }

    @JsonProperty("healing")
    public void setHealing(int healing) {
        this.healing = healing;
    }

    @JsonProperty("attackSpeed")
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @JsonProperty("attackSpeed")
    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @JsonProperty("armor")
    public int getArmor() {
        return armor;
    }

    @JsonProperty("armor")
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @JsonProperty("strength")
    public int getStrength() {
        return strength;
    }

    @JsonProperty("strength")
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @JsonProperty("dexterity")
    public int getDexterity() {
        return dexterity;
    }

    @JsonProperty("dexterity")
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @JsonProperty("vitality")
    public int getVitality() {
        return vitality;
    }

    @JsonProperty("vitality")
    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    @JsonProperty("intelligence")
    public int getIntelligence() {
        return intelligence;
    }

    @JsonProperty("intelligence")
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @JsonProperty("physicalResist")
    public int getPhysicalResist() {
        return physicalResist;
    }

    @JsonProperty("physicalResist")
    public void setPhysicalResist(int physicalResist) {
        this.physicalResist = physicalResist;
    }

    @JsonProperty("fireResist")
    public int getFireResist() {
        return fireResist;
    }

    @JsonProperty("fireResist")
    public void setFireResist(int fireResist) {
        this.fireResist = fireResist;
    }

    @JsonProperty("coldResist")
    public int getColdResist() {
        return coldResist;
    }

    @JsonProperty("coldResist")
    public void setColdResist(int coldResist) {
        this.coldResist = coldResist;
    }

    @JsonProperty("lightningResist")
    public int getLightningResist() {
        return lightningResist;
    }

    @JsonProperty("lightningResist")
    public void setLightningResist(int lightningResist) {
        this.lightningResist = lightningResist;
    }

    @JsonProperty("poisonResist")
    public int getPoisonResist() {
        return poisonResist;
    }

    @JsonProperty("poisonResist")
    public void setPoisonResist(int poisonResist) {
        this.poisonResist = poisonResist;
    }

    @JsonProperty("arcaneResist")
    public int getArcaneResist() {
        return arcaneResist;
    }

    @JsonProperty("arcaneResist")
    public void setArcaneResist(int arcaneResist) {
        this.arcaneResist = arcaneResist;
    }

    @JsonProperty("critDamage")
    public double getCritDamage() {
        return critDamage;
    }

    @JsonProperty("critDamage")
    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    @JsonProperty("blockChance")
    public int getBlockChance() {
        return blockChance;
    }

    @JsonProperty("blockChance")
    public void setBlockChance(int blockChance) {
        this.blockChance = blockChance;
    }

    @JsonProperty("blockAmountMin")
    public int getBlockAmountMin() {
        return blockAmountMin;
    }

    @JsonProperty("blockAmountMin")
    public void setBlockAmountMin(int blockAmountMin) {
        this.blockAmountMin = blockAmountMin;
    }

    @JsonProperty("blockAmountMax")
    public int getBlockAmountMax() {
        return blockAmountMax;
    }

    @JsonProperty("blockAmountMax")
    public void setBlockAmountMax(int blockAmountMax) {
        this.blockAmountMax = blockAmountMax;
    }

    @JsonProperty("damageIncrease")
    public int getDamageIncrease() {
        return damageIncrease;
    }

    @JsonProperty("damageIncrease")
    public void setDamageIncrease(int damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    @JsonProperty("critChance")
    public double getCritChance() {
        return critChance;
    }

    @JsonProperty("critChance")
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    @JsonProperty("damageReduction")
    public int getDamageReduction() {
        return damageReduction;
    }

    @JsonProperty("damageReduction")
    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    @JsonProperty("thorns")
    public int getThorns() {
        return thorns;
    }

    @JsonProperty("thorns")
    public void setThorns(int thorns) {
        this.thorns = thorns;
    }

    @JsonProperty("lifeSteal")
    public int getLifeSteal() {
        return lifeSteal;
    }

    @JsonProperty("lifeSteal")
    public void setLifeSteal(int lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    @JsonProperty("lifePerKill")
    public int getLifePerKill() {
        return lifePerKill;
    }

    @JsonProperty("lifePerKill")
    public void setLifePerKill(int lifePerKill) {
        this.lifePerKill = lifePerKill;
    }

    @JsonProperty("goldFind")
    public int getGoldFind() {
        return goldFind;
    }

    @JsonProperty("goldFind")
    public void setGoldFind(int goldFind) {
        this.goldFind = goldFind;
    }

    @JsonProperty("magicFind")
    public int getMagicFind() {
        return magicFind;
    }

    @JsonProperty("magicFind")
    public void setMagicFind(int magicFind) {
        this.magicFind = magicFind;
    }

    @JsonProperty("lifeOnHit")
    public int getLifeOnHit() {
        return lifeOnHit;
    }

    @JsonProperty("lifeOnHit")
    public void setLifeOnHit(int lifeOnHit) {
        this.lifeOnHit = lifeOnHit;
    }

    @JsonProperty("primaryResource")
    public int getPrimaryResource() {
        return primaryResource;
    }

    @JsonProperty("primaryResource")
    public void setPrimaryResource(int primaryResource) {
        this.primaryResource = primaryResource;
    }

    @JsonProperty("secondaryResource")
    public int getSecondaryResource() {
        return secondaryResource;
    }

    @JsonProperty("secondaryResource")
    public void setSecondaryResource(int secondaryResource) {
        this.secondaryResource = secondaryResource;
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
