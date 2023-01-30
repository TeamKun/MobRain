package net.kunmc.lab.mobrain.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandController {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equals(CommandConst.MAIN)){
            if(args.length==2){
                if(args[1].equals(CommandConst.START)){
                    //ゲームの開始処理
                }else if(args[1].equals(CommandConst.STOP)){
                    //ゲームの終了処理
                }else{
                    //例外処理
                }
            }
        }
    }


    }
}
