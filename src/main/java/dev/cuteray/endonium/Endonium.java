package dev.cuteray.endonium;

import dev.cuteray.endonium.config.ModConfig;
import dev.cuteray.endonium.registry.ModBlocks;
import dev.cuteray.endonium.registry.ModItemGroups;
import dev.cuteray.endonium.registry.ModItems;
import dev.cuteray.endonium.registry.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Endonium implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("endonium");
	public static final String MOD_ID = "endonium";
	public static final String MOD_PREFIX = "[Endonium Mod]";

	@Override
	public void onInitialize() {
		SendDebugMessage("Mod Initializing Load...");
		ModConfig.registerConfigs();
		ModItems.RegisterItems();
		ModBlocks.RegisterBlocks();
		ModItemGroups.RegisterItemGroups();
		ModWorldGen.RegisterWorldGen();
		SendDebugMessage("Mod Successfully Loaded!");
	}

	public static void SendDebugMessage(String text)
	{
	Endonium.LOGGER.info(MOD_PREFIX + " " + text);
	}
}
