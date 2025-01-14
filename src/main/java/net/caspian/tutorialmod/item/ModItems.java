package net.caspian.tutorialmod.item;

import net.caspian.tutorialmod.item.custom.ChiselItem;
import net.caspian.tutorialmod.item.custom.GlockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.caspian.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item CLASSIC_GLOCK = registerItem("classic_glock", new GlockItem(new Item.Settings()));
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(64)));

    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(ModFoodComponents.BANANA)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.banana.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item PETROL = registerItem("petrol", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(CLASSIC_GLOCK);
            entries.add(RAW_PINK_GARNET);
            entries.add(RUBY);
            entries.add(BANANA);

        });
    }
}