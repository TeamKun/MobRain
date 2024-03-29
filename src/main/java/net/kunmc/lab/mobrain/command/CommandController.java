package net.kunmc.lab.mobrain.command;

import net.kunmc.lab.mobrain.MobRain;
import net.kunmc.lab.mobrain.config.ConfigManager;
import net.kunmc.lab.mobrain.game.MainGameTask;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandController implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if(command.getName().equals(CommandConst.MAIN)){
            //start,stop,reloadConfig
            if(args.length == 1){
                //start
                if(args[0].equals(CommandConst.START)){
                    if(!MobRain.game){
                        //ゲームの開始処理
                        MobRain.game = true;
                        MainGameTask.mainTask();
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
                    MainGameTask.cnf = false;
                    MainGameTask.mainTask();
                    sender.sendMessage(ChatColor.GREEN + "configをリロードしました");
                }
                //showConfig
                else if(args[0].equals(CommandConst.CONFIG_SHOW)){
                    ConfigManager.loadConfig(false);
                    sender.sendMessage(ChatColor.GREEN + "configを表示します");
                    sender.sendMessage(ChatColor.AQUA + "------config一覧------");
                    sender.sendMessage("range(範囲)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE));
                    sender.sendMessage("frequency(頻度)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY));
                    sender.sendMessage("amount(量)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT));
                    sender.sendMessage("speed(落下速度)：" + ConfigManager.integerConfig.get(CommandConst.CONFIG_SPEED));
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
                        if(args[2].matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(args[2])>0){
                            if(Integer.parseInt(args[2]) > 2147483646){
                                sender.sendMessage(ChatColor.RED + "引数には2147483646以下の値を入れてください");
                            }else{
                                ConfigManager.integerConfig.put(CommandConst.CONFIG_RANGE,Integer.parseInt(args[2]));
                                ConfigManager.setConfig(CommandConst.CONFIG_RANGE);
                                ConfigManager.loadConfig(false);
                                MainGameTask.cnf = false;
                                MainGameTask.mainTask();
                                sender.sendMessage(ChatColor.GREEN + "範囲を" + args[2] + "に設定しました");
                            }
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_FREQUENCY)){
                        if(args[2].matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(args[2])>0){
                            if(Integer.parseInt(args[2]) > 2147483646){
                                sender.sendMessage(ChatColor.RED + "引数には2147483646以下の値を入れてください");
                            }else {
                                ConfigManager.integerConfig.put(CommandConst.CONFIG_FREQUENCY,Integer.parseInt(args[2]));
                                ConfigManager.setConfig(CommandConst.CONFIG_FREQUENCY);
                                ConfigManager.loadConfig(false);
                                MainGameTask.cnf = false;
                                MainGameTask.mainTask();
                                sender.sendMessage(ChatColor.GREEN + "出現頻度[tick]を" + args[2] + "に設定しました");
                            }
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_AMOUNT)){
                        if(args[2].matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(args[2])>0){
                            if(Integer.parseInt(args[2]) > 2147483646){
                                sender.sendMessage(ChatColor.RED + "引数には2147483646以下の値を入れてください");
                            }else{
                                ConfigManager.integerConfig.put(CommandConst.CONFIG_AMOUNT,Integer.parseInt(args[2]));
                                ConfigManager.setConfig(CommandConst.CONFIG_AMOUNT);
                                ConfigManager.loadConfig(false);
                                MainGameTask.cnf = false;
                                MainGameTask.mainTask();
                                sender.sendMessage(ChatColor.GREEN + "1度に涌くMobの量を" + args[2] + "に設定しました");
                            }
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_SPEED)){
                        if(args[2].matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(args[2])>0){
                            if(Integer.parseInt(args[2]) > 2147483646){
                                sender.sendMessage(ChatColor.RED + "引数には2147483646以下の値を入れてください");
                            }else {
                                ConfigManager.integerConfig.put(CommandConst.CONFIG_SPEED,Integer.parseInt(args[2]));
                                ConfigManager.setConfig(CommandConst.CONFIG_SPEED);
                                ConfigManager.loadConfig(false);
                                MainGameTask.cnf = false;
                                MainGameTask.mainTask();
                                sender.sendMessage(ChatColor.GREEN + "落下速度を" + args[2] + "に設定しました");
                            }
                        }else{
                            sender.sendMessage(ChatColor.RED + "引数には自然数を入れてください");
                        }
                    }else if(args[1].equals(CommandConst.CONFIG_PLAYER)){
                        ConfigManager.stringConfig.put(CommandConst.CONFIG_PLAYER,args[2]);
                        ConfigManager.setConfig(CommandConst.CONFIG_PLAYER);
                        ConfigManager.loadConfig(false);
                        MainGameTask.cnf = false;
                        MainGameTask.mainTask();
                        sender.sendMessage(ChatColor.GREEN + "中心のプレイヤーを" + args[2] + "に設定しました");
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

