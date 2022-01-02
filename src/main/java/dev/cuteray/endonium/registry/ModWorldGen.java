package dev.cuteray.endonium.registry;

import dev.cuteray.endonium.Endonium;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;


public class ModWorldGen {

    public static ConfiguredFeature<?, ?> ENITE_ORE_FEATURE = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),ModBlocks.ENITE_ORE.getDefaultState(), 4));
    public static PlacedFeature ENITE_ORE_PLACED_FEATURE = ENITE_ORE_FEATURE.withPlacement(CountPlacementModifier.of(7), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40)));

    public static void RegisterWorldGen()
    {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("endonium", "end_enite_ore"), ENITE_ORE_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("endonium", "end_enite_ore"), ENITE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("endonium", "end_enite_ore")));
        Endonium.SendDebugMessage("World Gen Loaded!");
    }
}
