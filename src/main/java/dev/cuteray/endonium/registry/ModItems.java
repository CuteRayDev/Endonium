package dev.cuteray.endonium.registry;

import dev.cuteray.endonium.Endonium;
import dev.cuteray.endonium.customitems.NewToolMaterial;
import dev.cuteray.endonium.customitems.tools.CustomAxe;
import dev.cuteray.endonium.customitems.tools.CustomHoe;
import dev.cuteray.endonium.customitems.tools.CustomPickaxe;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.cuteray.endonium.Endonium.MOD_PREFIX;
import static dev.cuteray.endonium.Endonium.SendDebugMessage;

public class ModItems {

    public static Item ENDONIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).fireproof());
    public static Item ENITE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item MELTEDDIAMOND = new Item(new Item.Settings().group(ItemGroup.MATERIALS).food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.POISON, 9999),225).hunger(0).saturationModifier(0f).alwaysEdible().build()));
    public static Item MELTEDENITE = new Item(new Item.Settings().group(ItemGroup.MATERIALS).food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.POISON, 9999),225).hunger(0).saturationModifier(0f).alwaysEdible().build()));
    public static Item ENDORY = new Item(new Item.Settings().group(ItemGroup.MATERIALS).fireproof());

    public static Item ENDONIUM_SWORD = new SwordItem(NewToolMaterial.ENDONIUM, 10, 1.6f, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static Item ENDONIUM_AXE = new CustomAxe(NewToolMaterial.ENDONIUM,11, 1f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static Item ENDONIUM_PICKAXE = new CustomPickaxe(NewToolMaterial.ENDONIUM,7, 1.2f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static Item ENDONIUM_SHOVEL = new ShovelItem(NewToolMaterial.ENDONIUM,7.5f, 1f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());
    public static Item ENDONIUM_HOE = new CustomHoe(NewToolMaterial.ENDONIUM,1, 4f, new Item.Settings().group(ItemGroup.TOOLS).fireproof());

    public static void RegisterItems(){
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium"), ENDONIUM);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "enite"), ENITE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "melteddiamond"), MELTEDDIAMOND);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "meltedenite"), MELTEDENITE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endory"), ENDORY);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium_sword"), ENDONIUM_SWORD);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium_axe"), ENDONIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium_pickaxe"), ENDONIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium_shovel"), ENDONIUM_SHOVEL);
    Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium_hoe"), ENDONIUM_HOE);
        SendDebugMessage("Items Loaded.");
    }
}
