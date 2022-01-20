package dev.cuteray.endonium.config;

import com.mojang.datafixers.util.Pair;
import dev.cuteray.endonium.Endonium;
import dev.cuteray.endonium.customitems.NewToolMaterial;

public class ModConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static float endoniumToolsMiningSpeed;
    public static int endoniumToolsDurability;
    public static int endoniumToolsEnchantibility;

    public static int endoniumSwordAtk;
    public static float endoniumAxeAtk;
    public static int endoniumPickaxeAtk;
    public static float endoniumShovelAtk;
    public static int endoniumHoeAtk;

    public static float endoniumSwordAtkSpeed;
    public static float endoniumAxeAtkSpeed;
    public static float endoniumPickaxeAtkSpeed;
    public static float endoniumShovelAtkSpeed;
    public static float endoniumHoeAtkSpeed;

    public static int endoniumArmourDurabilityModifier;
    public static int endoniumArmourEnchantability;
    public static float endoniumArmourToughness;
    public static float endoniumArmourKnockbackResistance;
    public static int endoniumHelmetProtection;
    public static int endoniumChestplateProtection;
    public static int endoniumLeggingsProtection;
    public static int endoniumBootsProtection;

    public static void registerConfigs() {

        //Creates File
        configs = new ModConfigProvider();
        createConfigs();

        //Set File Name
        CONFIG = SimpleConfig.of(Endonium.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {

        configs.addKeyValuePair(new Pair<>("endonium.tools.durability", 2561), "int");
        configs.addKeyValuePair(new Pair<>("endonium.tools.miningspeed", 10.0f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.tools.enchantability", 20), "int");

        configs.addKeyValuePair(new Pair<>("endonium.sword.atkdamage", 14f), "int");
        configs.addKeyValuePair(new Pair<>("endonium.shovel.atkdamage", 7.5f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.pickaxe.atkdamage", 8f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.axe.atkdamage", 11f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.hoe.atkdamage", 1f), "float");

        configs.addKeyValuePair(new Pair<>("endonium.sword.atkspeed", 1.6f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.shovel.atkspeed", 1f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.pickaxe.atkspeed", 1.2f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.axe.atkspeed", 1f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.hoe.atkspeed", 4f), "float");

        configs.addKeyValuePair(new Pair<>("endonium.armour.durabilitymodifier", 41), "int");
        configs.addKeyValuePair(new Pair<>("endonium.armour.enchantability", 20), "int");
        configs.addKeyValuePair(new Pair<>("endonium.armour.toughness", 3.0f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.armour.knockbackresistance", 0.1f), "float");
        configs.addKeyValuePair(new Pair<>("endonium.helmet.protection", 4), "int");
        configs.addKeyValuePair(new Pair<>("endonium.chestplate.protection", 9), "int");
        configs.addKeyValuePair(new Pair<>("endonium.leggings.protection", 7), "int");
        configs.addKeyValuePair(new Pair<>("endonium.boots.protection", 4), "int");
    }

    private static void assignConfigs() {

        AssignToolsAttackSettings();
        AssignToolsSpdSettings();
        AssignGeneralToolSettings();
        AssignArmourSettings();

        Endonium.SendDebugMessage("All " + configs.getConfigsList().size() + " have been set properly");
    }

    static void AssignToolsAttackSettings()
    {
        endoniumSwordAtk = CONFIG.getOrDefault("endonium.sword.atkdamage", 14);
        endoniumSwordAtk = endoniumSwordAtk - 1 - (int) NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumShovelAtk = (float) CONFIG.getOrDefault("endonium.shovel.atkdamage", 7.5f);
        endoniumShovelAtk = endoniumShovelAtk - 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumPickaxeAtk = CONFIG.getOrDefault("endonium.pickaxe.atkdamage", 8);
        endoniumPickaxeAtk = endoniumPickaxeAtk - 1 - (int) NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumAxeAtk = (float) CONFIG.getOrDefault("endonium.axe.atkdamage", 11f);
        endoniumAxeAtk = endoniumAxeAtk - 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumHoeAtk = CONFIG.getOrDefault("endonium.hoe.atkdamage", 1);
        endoniumHoeAtk = endoniumHoeAtk - 1 - (int) NewToolMaterial.ENDONIUM.getAttackDamage();
    }

    static void AssignToolsSpdSettings(){
        endoniumSwordAtkSpeed = (float) CONFIG.getOrDefault("endonium.sword.atkspeed", 1.6f);
        endoniumSwordAtkSpeed = endoniumSwordAtkSpeed + 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumShovelAtkSpeed = (float) CONFIG.getOrDefault("endonium.shovel.atkspeed", 1f);
        endoniumShovelAtkSpeed = endoniumShovelAtkSpeed + 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumPickaxeAtkSpeed = (float) CONFIG.getOrDefault("endonium.pickaxe.atkspeed", 1.2f);
        endoniumPickaxeAtkSpeed= endoniumPickaxeAtkSpeed + 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumAxeAtkSpeed = (float) CONFIG.getOrDefault("endonium.axe.atkspeed", 1f);
        endoniumAxeAtkSpeed = endoniumAxeAtkSpeed + 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
        endoniumHoeAtkSpeed = (float) CONFIG.getOrDefault("endonium.hoe.atkspeed", 4f);
        endoniumHoeAtkSpeed = endoniumHoeAtkSpeed + 1 - NewToolMaterial.ENDONIUM.getAttackDamage();
    }
    static void AssignGeneralToolSettings()
    {
        endoniumToolsDurability = CONFIG.getOrDefault("endonium.tools.durability", 2561);
        endoniumToolsEnchantibility = CONFIG.getOrDefault("endonium.tools.enchantability", 20);
        endoniumToolsMiningSpeed = (float) CONFIG.getOrDefault("endonium.tools.miningspeed", 10.0f);
    }

    static void AssignArmourSettings()
    {
        endoniumArmourDurabilityModifier = CONFIG.getOrDefault("endonium.armour.durabilitymodifier", 41);
        endoniumArmourEnchantability = CONFIG.getOrDefault("endonium.armour.enchantability", 20);
        endoniumArmourToughness = (float) CONFIG.getOrDefault("endonium.armour.toughness", 3.0f);
        endoniumArmourKnockbackResistance = (float) CONFIG.getOrDefault("endonium.armour.knockbackresistance", 0.1f);
        endoniumHelmetProtection = CONFIG.getOrDefault("endonium.helmet.protection", 4);
        endoniumChestplateProtection = CONFIG.getOrDefault("endonium.chestplate.protection", 9);
        endoniumLeggingsProtection = CONFIG.getOrDefault("endonium.leggings.protection", 7);
        endoniumBootsProtection = CONFIG.getOrDefault("endonium.boots.protection", 4);
    }
}
