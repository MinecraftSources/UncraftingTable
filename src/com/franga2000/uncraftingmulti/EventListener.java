package com.franga2000.uncraftingmulti;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener{

	@EventHandler
	public void onInventoryInteract(InventoryInteractEvent e) {
		System.out.println("InventoryInteractEvent");
		
		//Check if it's a crafting table on top of a gold block
		if(e.getInventory().getType() != InventoryType.WORKBENCH) return;
		if(((Block) e.getInventory()).getLocation().subtract(0, 1, 0).getBlock().getType() != Material.GOLD_BLOCK) return;
		
		//The "UNCRAFT" ender pearl
		ItemStack uncraft = new ItemStack(Material.ENDER_PEARL, 1);
		ItemMeta meta = uncraft.getItemMeta();
		meta.setDisplayName("UNCRAFT");
		meta.setLore(Arrays.asList("Costs 10 levels!"));
		uncraft.setItemMeta(meta);
		
		//Convert to CraftingInventory and change the result (Not working)
		((CraftingInventory) e.getInventory()).setResult(uncraft);
		
		e.setCancelled(true);
		e.setResult(Result.DENY);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		System.out.println("InventoryClickEvent");
	}
}
