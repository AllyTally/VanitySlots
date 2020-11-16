package moe.ally.vanityslots.mixin.client;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ArmorFeatureRenderer.class)
public class MixinArmorFeatureRenderer<T extends LivingEntity> {

    @Redirect(method = "renderArmor", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getEquippedStack(Lnet/minecraft/entity/EquipmentSlot;)Lnet/minecraft/item/ItemStack;"))
    public ItemStack vanityslots$getOverlayArmor(T entity, EquipmentSlot slot) {
        if (!(entity instanceof PlayerEntity))
            return entity.getEquippedStack(slot);

        TrinketComponent component = TrinketsApi.getTrinketComponent((PlayerEntity) entity);
        String slotToCheck = "";
        switch (slot) {
            case HEAD:
                slotToCheck = "head:vanity";
                break;
            case CHEST:
                slotToCheck = "chest:vanity";
                break;
            case LEGS:
                slotToCheck = "legs:vanity";
                break;
            case FEET:
                slotToCheck = "feet:vanity";
                break;
        }

        ItemStack vanity_item = component.getStack(slotToCheck);
        if (vanity_item.isEmpty()) {
            return entity.getEquippedStack(slot);
        } else {
            return vanity_item;
        }
    }
}