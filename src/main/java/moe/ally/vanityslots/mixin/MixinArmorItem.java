package moe.ally.vanityslots.mixin;

import dev.emi.trinkets.api.Trinket;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ArmorItem.class)
public class MixinArmorItem implements Trinket {

    @Shadow
    @Final
    protected EquipmentSlot slot;

    @Override
    public boolean canWearInSlot(String group, String slot) {
        if (this.slot.getName() != group) return false;
        if (group != "head" && group != "chest" && group != "legs" && group != "feet") return false;
        return "vanity".equals(slot);
    }
}