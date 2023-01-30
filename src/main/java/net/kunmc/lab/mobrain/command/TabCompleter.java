package net.kunmc.lab.mobrain.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length == 1){
            String input = args[args.length-1];
            String[] target = {CommandConst.START, CommandConst.STOP, CommandConst.CONFIG_SHOW, CommandConst.CONFIG_RELOAD};
            completions.addAll(Arrays.asList(target).stream()
                    .filter(e -> e.startsWith(input)).collect(Collectors.toList()));
        }else if(args.length == 2 && args[0].equals(CommandConst.CONFIG_SET)){
            String input = args[args.length-1];
            String[] target = {CommandConst.CONFIG_RANGE, CommandConst.CONFIG_FREQUENCY, CommandConst.CONFIG_AMOUNT, CommandConst.CONFIG_PLAYER};
            completions.addAll(Arrays.asList(target).stream()
                    .filter(e -> e.startsWith(input)).collect(Collectors.toList()));
        }else if(args.length == 3 && args[0].equals(CommandConst.CONFIG_SET)){
            if(args[1].equals(CommandConst.CONFIG_RANGE)||args[1].equals(CommandConst.CONFIG_FREQUENCY)||args[1].equals(CommandConst.CONFIG_AMOUNT)){
                completions.add("<num>");
            }else if(args[1].equals(CommandConst.CONFIG_PLAYER)){
                return Bukkit.getOnlinePlayers().stream()
                        .map(Player::getName)
                        .filter(s -> s.startsWith(args[2]))
                        .collect(Collectors.toList());
            }
        }
        return completions;
    }
}
