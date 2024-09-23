package winlyps.craftingEnchant

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import java.util.*

object EnchantmentManager {

    private val enchantments = Enchantment.values().filter { it.canEnchantItem(ItemStack(Material.DIAMOND_SWORD)) }

    fun canBeEnchanted(item: ItemStack): Boolean {
        return enchantments.any { it.canEnchantItem(item) }
    }

    fun getRandomEnchantment(): Pair<Enchantment, Int>? {
        val enchantment = enchantments.randomOrNull() ?: return null
        val randomLevel = (1..enchantment.maxLevel).random()
        return Pair(enchantment, randomLevel)
    }
}