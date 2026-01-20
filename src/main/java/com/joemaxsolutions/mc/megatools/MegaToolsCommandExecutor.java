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

package com.joemaxsolutions.mc.megatools;

import static com.joemaxsolutions.mc.megatools.I18n.tl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import com.joemaxsolutions.mc.megatools.lib.MegaItems;
import org.jetbrains.annotations.NotNull;

public class MegaToolsCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        Player target;

        if (args.length < 1) {
            sender.sendMessage(tl("enoughArguments"));
            return false;
        }

        if (args[0].equalsIgnoreCase("me")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Invalid sender");
                return false;
            }
            target = (Player) sender;
        } else {
            target = (Bukkit.getServer().getPlayer(args[0]));
            if (target == null) {
                sender.sendMessage(tl("playerNoOnline", args[0]));
                return false;
            }
        }

        if (cmd.getName().equalsIgnoreCase("megasword"))
            return commandMegaSword(target, sender, cmd, label, args);

        else if (cmd.getName().equalsIgnoreCase("megaaxe"))
            return commandMegaAxe(target, sender, cmd, label, args);

        else if (cmd.getName().equalsIgnoreCase("megapickaxe"))
            return commandMegaPickaxe(target, sender, cmd, label, args);

        else if (cmd.getName().equalsIgnoreCase("ultimatepickaxe"))
            return commandUltimatePickaxe(target, sender, cmd, label, args);

        else if (cmd.getName().equalsIgnoreCase("megashovel"))
            return commandMegaShovel(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megahoe"))
            return commandMegaHoe(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megabow"))
            return commandMegaBow(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("ultimatebow"))
            return commandUltimateBow(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megacrossbow"))
            return commandMegaCrossbow(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megafns"))
            return commandMegaFlintAndSteel(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megashears"))
            return commandMegaShears(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megaarmor"))
            return commandMegaArmor(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megashield"))
            return commandMegaShield(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megatrident"))
            return commandMegaTrident(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("ultimatetrident"))
            return commandUltimateTrident(target, sender, label, args);

        else if (cmd.getName().equalsIgnoreCase("megafishingrod"))
            return commandMegaFishingRod(target, sender, label, args);

        return false;
    }

    private boolean commandMegaSword(Player target, CommandSender sender, Command cmd, String label, String[] args) {
        boolean fire = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        if (args.length == 2) {
            if (args[1].equals("fire")) fire = true;
            else if (args[1].equals("nofire")) fire = false;
            else {
                sender.sendMessage(tl("badArgumentN"));
                return false;
            }
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack sword = MegaItems.getMegaSword(fire);
        inventory.addItem(sword);
        target.sendMessage(tl("powerfulSword"));
        return true;
    }

    private boolean commandMegaAxe(Player target, CommandSender sender, Command cmd, String label, String[] args) {
        boolean fortune = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        if (args.length == 2) {
            if (args[1].equals("fortune")) fortune = true;
            else if (args[1].equals("silk")) fortune = false;
            else {
                sender.sendMessage(tl("badArgumentF"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack axe = MegaItems.getMegaAxe(fortune);
        inventory.addItem(axe);
        target.sendMessage(tl("powerfulAxe"));
        return true;
    }

    private boolean commandMegaPickaxe(Player target, CommandSender sender, Command cmd, String label, String[] args) {
        boolean fortune = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        if (args.length == 2) {
            if (args[1].equals("fortune")) fortune = true;
            else if (args[1].equals("silk")) fortune = false;
            else {
                sender.sendMessage(tl("badArgumentF"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack pickaxe = MegaItems.getMegaPickaxe(fortune);
        inventory.addItem(pickaxe);
        target.sendMessage(tl("powerfulPickaxe"));
        return true;
    }

    private boolean commandUltimatePickaxe(Player target, CommandSender sender, Command cmd, String label, String[] args) {
        boolean fortune = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        if (args.length == 2) {
            if (args[1].equals("fortune")) fortune = true;
            else if (args[1].equals("silk")) fortune = false;
            else {
                sender.sendMessage(tl("badArgumentF"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack pickaxe = MegaItems.getUltimatePickaxe(fortune);
        inventory.addItem(pickaxe);
        target.sendMessage(tl("powerfulPickaxe"));
        return true;
    }

    private boolean commandMegaShovel(Player target, CommandSender sender, String label, String[] args) {
        boolean fortune = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        if (args.length == 2) {
            if (args[1].equals("fortune")) fortune = true;
            else if (args[1].equals("silk")) fortune = false;
            else {
                sender.sendMessage(tl("badArgumentF"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack shovel = MegaItems.getMegaShovel(fortune);
        inventory.addItem(shovel);
        target.sendMessage(tl("powerfulShovel"));
        return true;
    }

    private boolean commandMegaHoe(Player target, CommandSender sender, String label, String[] args) {
        boolean fortune = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        if (args.length == 2) {
            if (args[1].equals("fortune")) fortune = true;
            else if (args[1].equals("silk")) fortune = false;
            else {
                sender.sendMessage(tl("badArgumentF"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack shovel = MegaItems.getMegaHoe(fortune);
        inventory.addItem(shovel);
        target.sendMessage(tl("powerfulHoe"));
        return true;
    }

    private boolean commandMegaBow(Player target, CommandSender sender, String label, String[] args) {
        boolean fire = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        if (args.length == 2) {
            if (args[1].equals("fire")) fire = true;
            else if (args[1].equals("nofire")) fire = false;
            else {
                sender.sendMessage(tl("badArgumentN"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack bow = MegaItems.getMegaBow(fire);
        inventory.addItem(bow);
        ItemStack arrow = new ItemStack(Material.ARROW);
        if (!(inventory.contains(arrow))) inventory.addItem(arrow);
        target.sendMessage(tl("powerfulBow"));
        return true;
    }

    private boolean commandUltimateBow(Player target, CommandSender sender, String label, String[] args) {
        boolean fire = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        if (args.length == 2) {
            if (args[1].equals("fire")) fire = true;
            else if (args[1].equals("nofire")) fire = false;
            else {
                sender.sendMessage(tl("badArgumentN"));
                return false;
            }
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack bow = MegaItems.getUltimateBow(fire);
        inventory.addItem(bow);
        ItemStack arrow = new ItemStack(Material.ARROW);
        if (!(inventory.contains(arrow))) inventory.addItem(arrow);
        target.sendMessage(tl("powerfulBow"));
        return true;
    }

    private boolean commandMegaCrossbow(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack crossbow = MegaItems.getMegaCrossbow();
        inventory.addItem(crossbow);
        ItemStack arrow = new ItemStack(Material.ARROW, 64);
        inventory.addItem(arrow);
        target.sendMessage(tl("powerfulCrossbow"));
        return true;
    }

    private boolean commandMegaFlintAndSteel(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack fns = MegaItems.getMegaFlintAndSteel();
        inventory.addItem(fns);
        target.sendMessage(tl("powerfulFnS"));
        return true;
    }

    private boolean commandMegaShears(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack shears = MegaItems.getMegaShears();
        inventory.addItem(shears);
        target.sendMessage(tl("powerfulShears"));
        return true;
    }

    private boolean commandMegaArmor(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        PlayerInventory inventory = target.getInventory();
        inventory.setHelmet(MegaItems.getMegaHelmet());
        inventory.setChestplate(MegaItems.getMegaChestPlate());
        inventory.setLeggings(MegaItems.getMegaLeggings());
        inventory.setBoots(MegaItems.getMegaBoots());
        target.sendMessage(tl("powerfulArmor"));
        return true;
    }


    private boolean commandMegaShield(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack shield = MegaItems.getMegaShield();
        inventory.addItem(shield);
        target.sendMessage(tl("powerfulShield"));
        return true;
    }

    private boolean commandMegaTrident(Player target, CommandSender sender, String label, String[] args) {
        boolean riptide = true;

        if (args.length > 2) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        if (args.length == 2) {
            if (args[1].equals("riptide")) riptide = true;
            else if (args[1].equals("channeling")) riptide = false;
            else {
                sender.sendMessage(tl("badArgumentN"));
                return false;
            }
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack trident = MegaItems.getMegaTrident(riptide);
        inventory.addItem(trident);
        target.sendMessage(tl("powerfulTrident"));
        return true;
    }

    private boolean commandUltimateTrident(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }
        PlayerInventory inventory = target.getInventory();
        ItemStack trident = MegaItems.getUltimateTrident();
        inventory.addItem(trident);
        target.sendMessage(tl("powerfulTrident"));
        return true;
    }

    private boolean commandMegaFishingRod(Player target, CommandSender sender, String label, String[] args) {
        if (args.length > 1) {
            sender.sendMessage(tl("tooArguments"));
            return false;
        }

        PlayerInventory inventory = target.getInventory();
        ItemStack trident = MegaItems.getMegaFishingRod();
        inventory.addItem(trident);
        target.sendMessage(tl("powerfulFishingRod"));
        return true;
    }
}