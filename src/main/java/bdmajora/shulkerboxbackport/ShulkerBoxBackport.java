package bdmajora.shulkerboxbackport;

import net.minecraft.core.Global;
import net.minecraft.server.net.handler.NetServerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;

public class ShulkerBoxBackport implements GameStartEntrypoint {
    public static final String MOD_ID = "shulkerboxbackport";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static int GUI_LABEL_COLOR = 0x404040;
    public static int GUI_BACKPACK_ID;
    public static boolean ENABLE_BACKPACKS;
    public static int itemID;
    static {
        Properties prop = new Properties();
        prop.setProperty("starting_item_id","21370");
        prop.setProperty("gui_backpack_id","10");
        prop.setProperty("enable_backpacks", "true");
        ConfigHandler config = new ConfigHandler(MOD_ID,prop);
        itemID = config.getInt("starting_item_id");

        config.updateConfig();
        ENABLE_BACKPACKS = config.getBoolean("enable_backpacks");
        GUI_BACKPACK_ID = config.getInt("gui_backpack_id");
    }
    public static void Log(String message){
        if (Global.isServer && NetServerHandler.logger != null){
            NetServerHandler.logger.info(message);
        } else {
            LOGGER.info(message);
        }
    }

    @Override
    public void beforeGameStart() {
        ModItems.init();
    }

    @Override
    public void afterGameStart() {

    }
}