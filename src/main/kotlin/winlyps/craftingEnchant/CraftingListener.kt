package winlyps.craftingEnchant

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent

class CraftingListener(private val plugin: CraftingEnchant) : Listener {

    @EventHandler
    fun onCraftItem(event: CraftItemEvent) {
        val craftedItem = event.recipe.result ?: return

        if (EnchantmentManager.canBeEnchanted(craftedItem)) {
            val (randomEnchantment, randomLevel) = EnchantmentManager.getRandomEnchantment() ?: return
            craftedItem.addUnsafeEnchantment(randomEnchantment, randomLevel)
            event.currentItem = craftedItem
        }
    }
}