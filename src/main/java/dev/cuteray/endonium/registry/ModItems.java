package dev.cuteray.endonium.registry;

import dev.cuteray.endonium.Endonium;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.cuteray.endonium.Endonium.MOD_PREFIX;

public class ModItems {

    public static Item ENDONIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).fireproof());
    public static Item ENITE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item MELTEDDIAMOND = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item MELTEDENITE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item ENDORY = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static void RegisterItems(){
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endonium"), ENDONIUM);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "enite"), ENITE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "melteddiamond"), MELTEDDIAMOND);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "meltedenite"), MELTEDENITE);
        Registry.register(Registry.ITEM, new Identifier(Endonium.MOD_ID, "endory"), ENDORY);
        System.out.println(MOD_PREFIX + " Items Loaded.");
    }
}
