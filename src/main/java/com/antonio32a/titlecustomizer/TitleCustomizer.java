package com.antonio32a.titlecustomizer;

import com.antonio32a.titlecustomizer.commands.TitleCustomizerCommand;
import com.antonio32a.titlecustomizer.core.Config;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = TitleCustomizer.MODID,
    version =  TitleCustomizer.VERSION,
    name = TitleCustomizer.NAME,
    clientSideOnly = true
)
public class TitleCustomizer {
    public static final String NAME = "TitleCustomizer";
    public static final String MODID = "titlecustomizer";
    public static final String VERSION = "1.0";
    public static final String configLocation = "./config/titlecustomizer.toml";

    @Getter @Setter private GuiScreen gui;
    @Getter private static TitleCustomizer instance;
    @Getter private final Logger logger;
    @Getter private final Config config;

    public TitleCustomizer() {
        instance = this;
        logger = LogManager.getLogger();
        config = new Config();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        config.preload();
        ClientCommandHandler.instance.registerCommand(new TitleCustomizerCommand());
        this.logger.info("TitleCustomizer loaded.");
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (gui != null) {
            try {
                Minecraft.getMinecraft().displayGuiScreen(gui);
            } catch (Exception error) {
                error.printStackTrace();
            }
            gui = null;
        }
    }
}