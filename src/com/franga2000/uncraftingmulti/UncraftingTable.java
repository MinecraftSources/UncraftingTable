package com.franga2000.uncraftingmulti;

import com.franga2000.uncraftingmulti.EventListener;

import org.bukkit.plugin.java.JavaPlugin;

public class UncraftingTable extends JavaPlugin{

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
	
	public void onDisable() {
		
	}
}
