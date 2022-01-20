package dev.cuteray.endonium.customitems;

import dev.cuteray.endonium.config.ModConfig;
import dev.cuteray.endonium.registry.ModItems;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EndoniumArmours implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * ModConfig.endoniumArmourDurabilityModifier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        PROTECTION_VALUES[0] = ModConfig.endoniumBootsProtection;
        PROTECTION_VALUES[1] = ModConfig.endoniumLeggingsProtection;
        PROTECTION_VALUES[2] = ModConfig.endoniumChestplateProtection;
        PROTECTION_VALUES[3] = ModConfig.endoniumHelmetProtection;
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return ModConfig.endoniumToolsEnchantibility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.ENDONIUM);
    }

    @Override
    public String getName() {
        return "endonium";
    }

    @Override
    public float getToughness() {
        return ModConfig.endoniumArmourToughness;
    }

    @Override
    public float getKnockbackResistance() {
        return ModConfig.endoniumArmourKnockbackResistance;
    }
}
