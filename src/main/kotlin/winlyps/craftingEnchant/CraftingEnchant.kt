package winlyps.craftingEnchant

import org.bukkit.plugin.java.JavaPlugin

class CraftingEnchant : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(CraftingListener(this), this)
        logger.info("CraftingEnchant plugin has been enabled.")
    }

    override fun onDisable() {
        logger.info("CraftingEnchant plugin has been disabled.")
    }
}