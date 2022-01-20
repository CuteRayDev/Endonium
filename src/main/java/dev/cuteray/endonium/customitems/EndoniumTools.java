package dev.cuteray.endonium.customitems;

import dev.cuteray.endonium.config.ModConfig;
import dev.cuteray.endonium.registry.ModItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EndoniumTools implements ToolMaterial {

    @Override
    public int getDurability() {
        return ModConfig.endoniumToolsDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return ModConfig.endoniumToolsMiningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return 5.0f;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.NETHERITE;
    }

    @Override
    public int getEnchantability() {
        return ModConfig.endoniumToolsEnchantibility;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.ENDONIUM);
    }
}
