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
        for (int i = 0; i < 4; i++){
            stacks.add(new ItemStack(Items.AIR));
        }
        stacks.add(new ItemStack(ModItems.ENDONIUM_SWORD));
        stacks.add(new ItemStack(ModItems.ENDONIUM_SHOVEL));
        stacks.add(new ItemStack(ModItems.ENDONIUM_PICKAXE));
        stacks.add(new ItemStack(ModItems.ENDONIUM_AXE));
        stacks.add(new ItemStack(ModItems.ENDONIUM_HOE));
        stacks.add(new ItemStack(ModItems.ENITE_FINDER));
        for (int i = 0; i < 3; i++){
            stacks.add(new ItemStack(Items.AIR));
        }
        stacks.add(new ItemStack(ModItems.ENDONIUM_HELMET));
        stacks.add(new ItemStack(ModItems.ENDONIUM_CHESTPLATE));
        stacks.add(new ItemStack(ModItems.ENDONIUM_LEGGINGS));
        stacks.add(new ItemStack(ModItems.ENDONIUM_BOOTS));
        for (int i = 0; i < 5; i++){
            stacks.add(new ItemStack(Items.AIR));
        }
        stacks.add(new ItemStack(ModItems.ENITE_ORE));
        stacks.add(new ItemStack(ModItems.ENDONIUM_BLOCK));
    }).build();

    public static void RegisterItemGroups(){
        new ModItemGroups();
        SendDebugMessage("Item Group Loaded.");
    }

}
