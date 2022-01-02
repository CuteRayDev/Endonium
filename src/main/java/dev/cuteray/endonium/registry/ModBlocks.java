package dev.cuteray.endonium.registry;

import dev.cuteray.endonium.Endonium;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.fabric.impl.object.builder.FabricBlockInternals;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.cuteray.endonium.Endonium.SendDebugMessage;


public class ModBlocks {

    public static Block ENITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(40, 1400).breakByTool(FabricToolTags.PICKAXES, MiningLevels.DIAMOND));
    public static Block ENDONIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE).strength(60, 1400).breakByTool(FabricToolTags.PICKAXES, MiningLevels.DIAMOND));

    public static void RegisterBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Endonium.MOD_ID, "enite_ore"), ENITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Endonium.MOD_ID, "endonium_block"), ENDONIUM_BLOCK);
        SendDebugMessage("Blocks Loaded.");
    }
}
