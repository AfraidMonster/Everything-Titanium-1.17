package afraidmonster.mod.example.Tools;

import afraidmonster.mod.example.mod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TitaniumToolMaterial implements ToolMaterial {

    public static final TitaniumToolMaterial INSTANCE = new TitaniumToolMaterial();

    @Override
    public int getDurability() {
        // TODO Auto-generated method stub
        return 5314;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 16;
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 7;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(mod.TITANIUM_INGOT);
    }
    
}
