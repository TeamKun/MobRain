package net.kunmc.lab.mobrain.command;

import net.kunmc.lab.mobrain.MobRain;
import net.kunmc.lab.mobrain.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandController implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals(CommandConst.MAIN)){
            //start,stop,reloadConfig
            if(args.length == 1){
                //start
                if(args[0].equals(CommandConst.START)){
                    if(!MobRain.game){
                        //ゲームの開始処理
                        MobRain.game = true;
                        sender.sendMessage(ChatColor.GREEN + "ゲームを開始しました");
                    }else{
                        sender.sendMessage(ChatColor.RED + "ゲームはすでに開始されています");
                    }
                }
                //stop
                else if(args[0].equals(CommandConst.STOP)){
                    if(MobRain.game){
                        //ゲームの終了処理
                        MobRain.game = false;
                        sender.sendMessage(ChatColor.GREEN + "ゲームを停止しました");
                    }else{
                        sender.sendMessage(ChatColor.RED + "ゲームはすでに停止されています");
                    }
                }
                //reloadConfig
                else if(args[0].equals(CommandConst.CONFIG_RELOAD)){
                    ConfigManager.loadConfig(true);
                    sender.sendMessage(ChatColor.GREEN + "configをリロードしました");
                }
                //showConfig
                else if(args[0].equals(CommandConst.CONFIG_SHOW)){
                    ConfigManager.loadConfig(true);
                    sender.sendMessage(ChatColor.GREEN + "configを表示します");
                    sender.sendMessage(ChatColor.AQUA + "------config一覧------");
                    sender.sendMessage("range(範囲)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE));
                    sender.sendMessage("frequency(頻度)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY));
                    sender.sendMessage("amount(量)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT));
                    sender.sendMessage("player(中心のプレイヤー)：" + ConfigManager.stringConfig.get(CommandConst.CONFIG_PLAYER));
                    sender.sendMessage(ChatColor.AQUA + "------config一覧------");
                }
                //例外
                else{
                    sender.sendMessage(ChatColor.RED + "コマンドの形式が異なります。");
                }
            }
            //setConfig
            else if(args.length == 3){
                if(args[0].equals(CommandConst.CONFIG_SET)){
                    if(args[1].equals(CommandConst.CONFIG_RANGE)){
                        if(Integer.parseInt(args[1]) > 0){
                            ConfigManager.setConfig(CommandConst.CONFIG_RANGE);
                            ConfigManager.loadConfig(true);
                            sender.sendMessage(ChatColor.GREEN + "range(範囲)：" + args[2] + "に設定しました");
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_FREQUENCY)){
                        if(Integer.parseInt(args[1]) > 0){
                            ConfigManager.setConfig(CommandConst.CONFIG_FREQUENCY);
                            ConfigManager.loadConfig(true);
                            sender.sendMessage(ChatColor.GREEN + "frequency(頻度)：" + args[2] + "に設定しました");
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_AMOUNT)){
                        if(Integer.parseInt(args[1]) > 0){
                            ConfigManager.setConfig(CommandConst.CONFIG_AMOUNT);
                            ConfigManager.loadConfig(true);
                            sender.sendMessage(ChatColor.GREEN + "amount(量)：" + args[2] + "に設定しました");
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_PLAYER)){
                        ConfigManager.setConfig(CommandConst.CONFIG_PLAYER);
                        ConfigManager.loadConfig(true);
                        sender.sendMessage(ChatColor.GREEN + "player(中心のプレイヤー)：" + args[2] + "に設定しました");
                    }else{
                        sender.sendMessage(ChatColor.RED + "コマンドの形式が異なります。");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "コマンドの形式が異なります。");
                }
            }
        }
        return false;
    }


}

