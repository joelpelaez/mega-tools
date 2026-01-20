/**
 * Mega Tools
 * Copyright (C) 2014-2025  Joe Max Solutions
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.joemaxsolutions.mc.megatools;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import java.util.Locale;
import java.util.Objects;

@SuppressWarnings("unused") // Class referenced on plugin.yml
public class MegaTools extends JavaPlugin implements Listener {
    private I18n i18n;
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        i18n = new I18n();
        i18n.onEnable();

        /* Only support spanish translations. */
        if (Locale.getDefault().getLanguage().equals("es"))
            i18n.updateLocale("es");

        MegaToolsCommandExecutor executor = new MegaToolsCommandExecutor();

        Objects.requireNonNull(getCommand("megasword")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megaaxe")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megapickaxe")).setExecutor(executor);
        Objects.requireNonNull(getCommand("ultimatepickaxe")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megashovel")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megahoe")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megabow")).setExecutor(executor);
        Objects.requireNonNull(getCommand("ultimatebow")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megafns")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megashears")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megaarmor")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megacrossbow")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megashield")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megatrident")).setExecutor(executor);
        Objects.requireNonNull(getCommand("ultimatetrident")).setExecutor(executor);
        Objects.requireNonNull(getCommand("megafishingrod")).setExecutor(executor);

        getLogger().info("Enabled MegeTools Beta");
    }

    @Override
    public void onDisable() {
        i18n.onDisable();
        getLogger().info("Disabled MegaTools Beta");
    }
}
