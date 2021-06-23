package afraidmonster.mod.example.Armour;

import afraidmonster.mod.example.mod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TitaniumArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {15, 17, 18, 13};
    private static final int[] PROTECTION_VALUES = new int[] {5, 8, 10, 5};


    @Override
    public int getDurability(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return BASE_DURABILITY[slot.getEntitySlotId()] *45;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        // TODO Auto-generated method stub
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        // TODO Auto-generated method stub
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(mod.TITANIUM_INGOT);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "titanium";
    }

    @Override
    public float getToughness() {
        // TODO Auto-generated method stub
        return 7.0F;
    }

    @Override
    public float getKnockbackResistance() {
        // TODO Auto-generated method stub
        return 0.2F;
    }
    
}
