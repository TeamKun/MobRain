package net.kunmc.lab.mobrain.command;

public class CommandConst {
    public static final String MAIN = "mr";
    public static final String START = "start";
    public static final String STOP = "stop";

    public static final String CONFIG_SET = "setConfig";
    public static final String CONFIG_RELOAD = "reloadConfig";
    public static final String CONFIG_SHOW = "showConfig";

    public static final String CONFIG_RANGE = "range";  //範囲、デフォルト:64
    public static final String CONFIG_FREQUENCY = "frequency";  //周期、デフォルト:20
    public static final String CONFIG_AMOUNT = "amount";  //一回に発生する量、デフォルト:8
    public static final String CONFIG_SPEED = "speed";  //落下速度、デフォルト:10
    public static final String CONFIG_PLAYER = "player";  //中心のプレイヤー、デフォルト:roadhog_kun
}
