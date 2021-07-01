package com.antonio32a.titlecustomizer.commands;

import club.sk1er.mods.core.ModCore;
import com.antonio32a.titlecustomizer.TitleCustomizer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class TitleCustomizerCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "titlecustomizer";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/titlecustomizer";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ModCore.getInstance().getGuiHandler().open(TitleCustomizer.getInstance().getConfig().gui());
    }
}