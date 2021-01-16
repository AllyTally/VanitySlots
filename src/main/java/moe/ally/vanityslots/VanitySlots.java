/*
    VanitySlots
    Copyright (C) 2020  Alexandra Tildea

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
package moe.ally.vanityslots;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Trinket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
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
		TrinketSlots.addSlot(SlotGroups.HEAD,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_head_vanity.png"), (slot, stack) -> {
			slot.disableQuickMove = true;
			if (!(stack.getItem() instanceof Trinket)) {
				if (stack.getItem() instanceof ArmorItem) {
					return ((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.HEAD;
				}
			}
			return false;
		});
		TrinketSlots.addSlot(SlotGroups.CHEST, "vanity", new Identifier(MODID, "textures/item/empty_trinket_slot_chest_vanity.png"), (slot, stack) -> {
			slot.disableQuickMove = true;
			if (!(stack.getItem() instanceof Trinket)) {
				if (stack.getItem() instanceof ArmorItem) {
					return ((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.CHEST;
				}
			}
			return false;
		});
		TrinketSlots.addSlot(SlotGroups.LEGS,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_legs_vanity.png"), (slot, stack) -> {
			slot.disableQuickMove = true;
			if (!(stack.getItem() instanceof Trinket)) {
				if (stack.getItem() instanceof ArmorItem) {
					return ((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.LEGS;
				}
			}
			return false;
		});
		TrinketSlots.addSlot(SlotGroups.FEET,  "vanity",  new Identifier(MODID, "textures/item/empty_trinket_slot_feet_vanity.png"), (slot, stack) -> {
			slot.disableQuickMove = true;
			if (!(stack.getItem() instanceof Trinket)) {
				if (stack.getItem() instanceof ArmorItem) {
					return ((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.FEET;
				}
			}
			return false;
		});
	}
}
