package moe.ally.vanityslots.mixin;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(LivingEntity.class)
public class MixinGetAttackDistanceScalingFactor {

    @Redirect(method = "getAttackDistanceScalingFactor", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getArmorVisibility()F"))
    private float injected(LivingEntity entity) {
        Iterable<ItemStack> iterable = entity.getArmorItems();

        List<ItemStack> visible_armor = new ArrayList<ItemStack>();
        int i = 0;
        for(Iterator var4 = iterable.iterator(); var4.hasNext(); ++i) {
            ItemStack itemStack = (ItemStack)var4.next();
            visible_armor.add(itemStack);
        }

        if (entity instanceof PlayerEntity) {
            TrinketComponent component = TrinketsApi.getTrinketComponent((PlayerEntity) entity);
            ItemStack vanity_item = component.getStack("feet:vanity");
            if (!vanity_item.isEmpty()) visible_armor.set(0,vanity_item);
            vanity_item = component.getStack("legs:vanity");
            if (!vanity_item.isEmpty()) visible_armor.set(1,vanity_item);
            vanity_item = component.getStack("chest:vanity");
            if (!vanity_item.isEmpty()) visible_armor.set(2,vanity_item);
            vanity_item = component.getStack("head:vanity");
            if (!vanity_item.isEmpty()) visible_armor.set(3,vanity_item);
        }

        int j = 0;
        for (ItemStack item : visible_armor) {
            if (!item.isEmpty()) {
                if (!item.getTranslationKey().startsWith("item.vanityslots.familiar_")) {
                    j++;
                }
            }
        }

        return i > 0 ? (float)j / (float)i : 0.0F;
    }
}