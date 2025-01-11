package net.caspian.tutorialmod;

import net.caspian.tutorialmod.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import net.caspian.tutorialmod.block.ModBlocks;
import net.caspian.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.regiterItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}