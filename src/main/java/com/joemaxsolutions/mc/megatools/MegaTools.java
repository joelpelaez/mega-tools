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
import org.bukkit.command.CommandExecutor;
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

        configureCommand("megasword", executor);
        configureCommand("megaaxe", executor);
        configureCommand("megapickaxe", executor);
        configureCommand("ultimatepickaxe", executor);
        configureCommand("megashovel", executor);
        configureCommand("megahoe", executor);
        configureCommand("megabow", executor);
        configureCommand("ultimatebow", executor);
        configureCommand("megafns", executor);
        configureCommand("megashears", executor);
        configureCommand("megaarmor", executor);
        configureCommand("megacrossbow", executor);
        configureCommand("megashield", executor);
        configureCommand("megatrident", executor);
        configureCommand("ultimatetrident", executor);
        configureCommand("megafishingrod", executor);

        getLogger().info("Enabled MegeTools Beta");
    }

    private void configureCommand(String commandName, CommandExecutor executor) {
        Objects.requireNonNull(getCommand(commandName)).setExecutor(executor);
    }

    @Override
    public void onDisable() {
        i18n.onDisable();
        getLogger().info("Disabled MegaTools Beta");
    }
}
