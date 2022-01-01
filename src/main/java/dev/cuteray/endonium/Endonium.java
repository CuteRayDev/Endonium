package dev.cuteray.endonium;

import dev.cuteray.endonium.registry.ModItemGroups;
import dev.cuteray.endonium.registry.ModItems;
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
		System.out.println(MOD_PREFIX + " Mod Initializing Load...");
		ModItems.RegisterItems();
		ModItemGroups.RegisterItemGroups();
		System.out.println(MOD_PREFIX + " Mod Successfully Loaded!");
	}
}
