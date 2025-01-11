package net.caspian.tutorialmod.item;

import net.caspian.tutorialmod.TutorialMod;
import net.caspian.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModBlocks.RUBY_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PLATINUM_BLOCK);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RUBY_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                    })

                    .build());

    public static final ItemGroup ALL_MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "all_mod_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.all_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.CLASSIC_GLOCK);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.CHISEL);
                    })

                    .build());

    public static void regiterItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
