package dev.cuteray.endonium.registry;

import dev.cuteray.endonium.Endonium;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import static dev.cuteray.endonium.Endonium.*;

public class ModItemGroups {

    public final ItemGroup ENDONIUMMENU = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "modmenu")).icon(() -> new ItemStack(ModItems.ENDONIUM)).appendItems(stacks -> {
        stacks.add(new ItemStack(ModItems.ENDONIUM));
        stacks.add(new ItemStack(ModItems.ENITE));
        stacks.add(new ItemStack(ModItems.MELTEDDIAMOND));
        stacks.add(new ItemStack(ModItems.MELTEDENITE));
        stacks.add(new ItemStack(ModItems.ENDORY));
    }).build();

    public static void RegisterItemGroups(){
        new ModItemGroups();
        SendDebugMessage("Item Group Loaded.");
    }
}
