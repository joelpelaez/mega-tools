/**
 * Mega Tools
 * Copyright (C) 2014-2025  Joe Max Solutions
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.joemaxsolutions.mc.megatools.lib;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.ItemLore;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class MegaItems {
    private static int UNSAFE_ENCHANTMENT_LEVEL = 50;

    /**
     * Set to <code>item</code> a <code>enchantment</code> with the max level
     *
     * @param item        A {@link ItemStack} object
     * @param enchantment A {@link Enchantment} to apply the item
     */
    protected static void setMaxEnchantment(ItemStack item, Enchantment enchantment) {
        item.addEnchantment(enchantment, enchantment.getMaxLevel());
    }

    /**
     * Set to <code>item</code> a <code>enchantment</code> with an over-level
     *
     * @param item        A {@link ItemStack} object
     * @param enchantment A {@link Enchantment} to apply the item
     */
    protected static void setUltimateEnchantment(ItemStack item, Enchantment enchantment) {
        item.addUnsafeEnchantment(enchantment, UNSAFE_ENCHANTMENT_LEVEL);
    }

    /**
     * Create a new {@link Material#NETHERITE_SWORD Netherite Sword}
     * {@link ItemStack item} and enchant it.
     *
     * @param fire If set true the Bow will be enchanted with
     *             {@link Enchantment#FIRE_ASPECT Fire Aspect} or false to will
     *             be skipped.
     * @return A new {@link ItemStack Netherite Sword}
     */
    public static ItemStack getMegaSword(boolean fire) {
        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        setMaxEnchantment(stack, Enchantment.BANE_OF_ARTHROPODS);
        setMaxEnchantment(stack, Enchantment.KNOCKBACK);
        setMaxEnchantment(stack, Enchantment.LOOTING);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.SHARPNESS);
        setMaxEnchantment(stack, Enchantment.SMITE);
        setMaxEnchantment(stack, Enchantment.SWEEPING_EDGE);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (fire) setMaxEnchantment(stack, Enchantment.FIRE_ASPECT);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_AXE Netherite Axe} {@link ItemStack
     * item} and enchant it.
     *
     * @param looting If set true the Axe will be enchanted with
     *                {@link Enchantment#FORTUNE Fortune} or false to will
     *                be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
     * @return A new {@link ItemStack Netherite Axe}
     */
    public static ItemStack getMegaAxe(boolean looting) {
        ItemStack stack = new ItemStack(Material.NETHERITE_AXE);
        setMaxEnchantment(stack, Enchantment.BANE_OF_ARTHROPODS);
        setMaxEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.SHARPNESS);
        setMaxEnchantment(stack, Enchantment.SMITE);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (looting) setMaxEnchantment(stack, Enchantment.FORTUNE);
        else setMaxEnchantment(stack, Enchantment.SILK_TOUCH);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_PICKAXE Netherite Pickaxe}
     * {@link ItemStack item} and enchant it.
     *
     * @param looting If set true the Pickaxe will be enchanted with
     *                {@link Enchantment#FORTUNE Fortune} or false to will
     *                be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
     * @return A new {@link ItemStack Netherite Pickaxe}
     */
    public static ItemStack getMegaPickaxe(boolean looting) {
        ItemStack stack = new ItemStack(Material.NETHERITE_PICKAXE);
        setMaxEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (looting) setMaxEnchantment(stack, Enchantment.FORTUNE);
        else setMaxEnchantment(stack, Enchantment.SILK_TOUCH);
        return stack;
    }

    /**
     * Create a new Ultimate {@link Material#NETHERITE_PICKAXE Netherite Pickaxe}
     * {@link ItemStack item} and enchant it.
     *
     * @param looting If set true the Pickaxe will be enchanted with
     *                {@link Enchantment#FORTUNE Fortune} or false to will
     *                be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
     * @return A new {@link ItemStack Netherite Pickaxe}
     */
    @SuppressWarnings("UnstableApiUsage")
    public static ItemStack getUltimatePickaxe(boolean looting) {
        ItemStack stack = new ItemStack(Material.NETHERITE_PICKAXE);
        setUltimateEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (looting) setUltimateEnchantment(stack, Enchantment.FORTUNE);
        else setMaxEnchantment(stack, Enchantment.SILK_TOUCH);

        // Add custom name
        stack.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Ultimate Pickaxe"));

        // Add lore
        ItemLore lore = ItemLore
                .lore()
                .addLine(Component.text("The Ultimate Pickaxe!"))
                .addLine(Component.text("It can blend the reality (mine stone blocks) too fast"))
                .addLine(Component.text("Use it!"))
                .build();
        stack.setData(DataComponentTypes.LORE, lore);

        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_SHOVEL Netherite Shovel}
     * {@link ItemStack item} and enchant it.
     *
     * @param looting If set true the Shovel will be enchanted with
     *                {@link Enchantment#FORTUNE Fortune} or false to will
     *                be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
     * @return A new {@link ItemStack Netherite Shovel}
     */
    public static ItemStack getMegaShovel(boolean looting) {
        ItemStack stack = new ItemStack(Material.NETHERITE_SHOVEL);
        setMaxEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (looting) setMaxEnchantment(stack, Enchantment.FORTUNE);
        else setMaxEnchantment(stack, Enchantment.SILK_TOUCH);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_HOE Netherite hoe}
     * {@link ItemStack item} and enchant it.
     *
     * @param looting If set true the Hoe will be enchanted with
     *                {@link Enchantment#FORTUNE Fortune} or false to will
     *                be enchanted with {@link Enchantment#SILK_TOUCH Silk Touch}
     * @return A new {@link ItemStack Netherite hoe}
     */
    public static ItemStack getMegaHoe(boolean looting) {
        ItemStack stack = new ItemStack(Material.NETHERITE_HOE);
        setMaxEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (looting) setMaxEnchantment(stack, Enchantment.FORTUNE);
        else setMaxEnchantment(stack, Enchantment.SILK_TOUCH);
        return stack;
    }

    /**
     * Create a new {@link Material#BOW Bow}
     * {@link ItemStack item} and enchant it.
     *
     * @param fire If set true the Bow will be enchanted with
     *             {@link Enchantment#FIRE_ASPECT Fire} or false to will be
     *             skipped.
     * @return A new {@link ItemStack Bow}
     */
    public static ItemStack getMegaBow(boolean fire) {
        ItemStack stack = new ItemStack(Material.BOW);
        setMaxEnchantment(stack, Enchantment.INFINITY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.POWER);
        setMaxEnchantment(stack, Enchantment.PUNCH);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (fire) setMaxEnchantment(stack, Enchantment.FLAME);
        return stack;
    }

    /**
     * Create a new Ultimate {@link Material#BOW Bow}
     * {@link ItemStack item} and enchant it.
     *
     * @param fire If set true the Bow will be enchanted with
     *             {@link Enchantment#FIRE_ASPECT Fire} or false to will be
     *             skipped.
     * @return A new {@link ItemStack Bow}
     */
    @SuppressWarnings("UnstableApiUsage")
    public static ItemStack getUltimateBow(boolean fire) {
        ItemStack stack = new ItemStack(Material.BOW);
        setMaxEnchantment(stack, Enchantment.INFINITY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setUltimateEnchantment(stack, Enchantment.POWER);
        setUltimateEnchantment(stack, Enchantment.PUNCH);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (fire) setMaxEnchantment(stack, Enchantment.FLAME);

        // Add custom name
        stack.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Ultimate Bow"));

        // Add lore
        ItemLore lore = ItemLore
                .lore()
                .addLine(Component.text("The Ultimate Bow!"))
                .addLine(Component.text("Shoot to your enemies and throw them too far"))
                .addLine(Component.text("Use it!"))
                .build();
        stack.setData(DataComponentTypes.LORE, lore);

        return stack;
    }

    /**
     * Create a new {@link Material#CROSSBOW Crossbow}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Crossbow}
     */
    public static ItemStack getMegaCrossbow() {
        ItemStack stack = new ItemStack(Material.CROSSBOW);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.MULTISHOT);
        setMaxEnchantment(stack, Enchantment.PIERCING);
        setMaxEnchantment(stack, Enchantment.QUICK_CHARGE);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_HELMET Netherite Helmet}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Netherite Helmet}
     */
    public static ItemStack getMegaHelmet() {
        ItemStack stack = new ItemStack(Material.NETHERITE_HELMET);
        setMaxEnchantment(stack, Enchantment.AQUA_AFFINITY);
        setMaxEnchantment(stack, Enchantment.BLAST_PROTECTION);
        setMaxEnchantment(stack, Enchantment.FIRE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.PROJECTILE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.PROTECTION);
        setMaxEnchantment(stack, Enchantment.RESPIRATION);
        setMaxEnchantment(stack, Enchantment.THORNS);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_CHESTPLATE Netherite Chest plate}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Netherite Chest plate}
     */
    public static ItemStack getMegaChestPlate() {
        ItemStack stack = new ItemStack(Material.NETHERITE_CHESTPLATE);
        setMaxEnchantment(stack, Enchantment.BLAST_PROTECTION);
        setMaxEnchantment(stack, Enchantment.FIRE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.PROJECTILE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.PROTECTION);
        setMaxEnchantment(stack, Enchantment.THORNS);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_LEGGINGS Netherite Leggings}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Netherite Leggings}
     */
    public static ItemStack getMegaLeggings() {
        ItemStack stack = new ItemStack(Material.NETHERITE_LEGGINGS);
        setMaxEnchantment(stack, Enchantment.BLAST_PROTECTION);
        setMaxEnchantment(stack, Enchantment.FIRE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.PROJECTILE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.PROTECTION);
        setMaxEnchantment(stack, Enchantment.THORNS);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#NETHERITE_BOOTS Netherite Boots}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Netherite Boots}
     */
    public static ItemStack getMegaBoots() {
        ItemStack stack = new ItemStack(Material.NETHERITE_BOOTS);
        setMaxEnchantment(stack, Enchantment.BLAST_PROTECTION);
        setMaxEnchantment(stack, Enchantment.DEPTH_STRIDER);
        setMaxEnchantment(stack, Enchantment.FEATHER_FALLING);
        setMaxEnchantment(stack, Enchantment.FROST_WALKER);
        setMaxEnchantment(stack, Enchantment.FIRE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.PROJECTILE_PROTECTION);
        setMaxEnchantment(stack, Enchantment.PROTECTION);
        setMaxEnchantment(stack, Enchantment.SOUL_SPEED);
        setMaxEnchantment(stack, Enchantment.THORNS);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#FLINT_AND_STEEL Flint and Steel}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Flint and Steel}
     */
    public static ItemStack getMegaFlintAndSteel() {
        ItemStack stack = new ItemStack(Material.FLINT_AND_STEEL);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#SHEARS Shears}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Shears}
     */
    public static ItemStack getMegaShears() {
        ItemStack stack = new ItemStack(Material.SHEARS);
        setMaxEnchantment(stack, Enchantment.EFFICIENCY);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#SHIELD Shield}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Shield}
     */
    public static ItemStack getMegaShield() {
        ItemStack stack = new ItemStack(Material.SHIELD);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }

    /**
     * Create a new {@link Material#SHIELD Shield}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Shield}
     */
    public static ItemStack getMegaTrident(boolean riptide) {
        ItemStack stack = new ItemStack(Material.TRIDENT);
        setMaxEnchantment(stack, Enchantment.IMPALING);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        if (riptide) {
            setMaxEnchantment(stack, Enchantment.RIPTIDE);
        } else {
            setMaxEnchantment(stack, Enchantment.LOYALTY);
            setMaxEnchantment(stack, Enchantment.CHANNELING);
        }
        return stack;
    }

    /**
     * Create a new Ultimate {@link Material#TRIDENT Trident}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Trident}
     */
    @SuppressWarnings("UnstableApiUsage")
    public static ItemStack getUltimateTrident() {
        ItemStack stack = new ItemStack(Material.TRIDENT);
        setUltimateEnchantment(stack, Enchantment.IMPALING);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        setMaxEnchantment(stack, Enchantment.LOYALTY);
        setMaxEnchantment(stack, Enchantment.CHANNELING);

        // Add custom name
        stack.setData(DataComponentTypes.CUSTOM_NAME, Component.text("Ultimate Trident"));

        // Add lore
        ItemLore lore = ItemLore
                .lore()
                .addLine(Component.text("The Ultimate Trient!"))
                .addLine(Component.text("Impale to your enemies and throw them to sea (or river)"))
                .addLine(Component.text("Use it!"))
                .build();
        stack.setData(DataComponentTypes.LORE, lore);

        // Modify base damage
        stack.setData(DataComponentTypes.DAMAGE, 100);

        return stack;
    }

    /**
     * Create a new {@link Material#FISHING_ROD Fishing Rod}
     * {@link ItemStack item} and enchant it.
     *
     * @return A new {@link ItemStack Fishing Rod}
     */
    public static ItemStack getMegaFishingRod() {
        ItemStack stack = new ItemStack(Material.FISHING_ROD);
        setMaxEnchantment(stack, Enchantment.LUCK_OF_THE_SEA);
        setMaxEnchantment(stack, Enchantment.LURE);
        setMaxEnchantment(stack, Enchantment.MENDING);
        setMaxEnchantment(stack, Enchantment.UNBREAKING);
        setMaxEnchantment(stack, Enchantment.VANISHING_CURSE);
        return stack;
    }
}
