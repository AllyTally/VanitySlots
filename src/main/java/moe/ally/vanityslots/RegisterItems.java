package moe.ally.vanityslots;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final ArmorMaterial customArmorMaterial = new CustomArmorMaterial();
    public static final Item CUSTOM_MATERIAL = new Item(new Item.Settings().group(ItemGroup.COMBAT));
    // If you made a new material, this is where you would note it.
    public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(customArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(customArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(customArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(customArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("vanityslots", "familiar_wig"), CUSTOM_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("vanityslots", "familiar_shirt"), CUSTOM_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("vanityslots", "familiar_pants"), CUSTOM_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("vanityslots", "familiar_sneakers"), CUSTOM_MATERIAL_BOOTS);
    }
}