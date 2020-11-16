package moe.ally.vanityslots;

import dev.emi.trinkets.api.SlotGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import dev.emi.trinkets.api.TrinketSlots;

public class VanitySlots implements ModInitializer {

	public static final String MODID = "vanityslots";

	public static final Item GLOWING_LEATHER = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		RegisterItems.register();
		TrinketSlots.addSlot(SlotGroups.HEAD,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_head_vanity.png"));
		TrinketSlots.addSlot(SlotGroups.CHEST, "vanity", new Identifier(MODID, "textures/item/empty_trinket_slot_chest_vanity.png"));
		TrinketSlots.addSlot(SlotGroups.LEGS,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_legs_vanity.png"));
		TrinketSlots.addSlot(SlotGroups.FEET,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_feet_vanity.png"));
	}
}
