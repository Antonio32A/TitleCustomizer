package com.antonio32a.titlecustomizer;

import com.antonio32a.titlecustomizer.commands.TitleCustomizerCommand;
import com.antonio32a.titlecustomizer.core.Config;
import com.antonio32a.titlecustomizer.core.ModCoreInstaller;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
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
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);
        config.preload();
        ClientCommandHandler.instance.registerCommand(new TitleCustomizerCommand());
        this.logger.info("TitleCustomizer loaded.");
    }
}