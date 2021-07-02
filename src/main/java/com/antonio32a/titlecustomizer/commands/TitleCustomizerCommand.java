package com.antonio32a.titlecustomizer.commands;

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
        TitleCustomizer.getInstance().setGui(TitleCustomizer.getInstance().getConfig().gui());
    }
}