package com.antonio32a.titlecustomizer.mixins;

import com.antonio32a.titlecustomizer.TitleCustomizer;
import com.antonio32a.titlecustomizer.core.Config;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(GuiIngameForge.class)
public abstract class GuiIngameForgeMixin {
    private final Config config = TitleCustomizer.getInstance().getConfig();
    private static final String sizeTarget = "Lnet/minecraft/client/renderer/GlStateManager;scale(FFF)V";
    private static final String locationTarget = "Lnet/minecraft/client/gui/FontRenderer;drawString(Ljava/lang/String;FFIZ)I";

    @ModifyArgs(at = @At(value = "INVOKE", target = sizeTarget, ordinal = 0), method = "renderTitle")
    public void changeTitleSize(Args args) {
        if (!config.enabled) return;
        for (int i = 0; i < 3; i++)
            args.set(i, (float) config.titleSize);
    }

    @ModifyArgs(at = @At(value = "INVOKE", target = locationTarget, ordinal = 0), method = "renderTitle")
    public void changeTitleLocation(Args args) {
        if (!config.enabled) return;
        args.set(1, (float) config.titleX);
        args.set(2, (float) config.titleY);
    }

    @ModifyArgs(at = @At(value = "INVOKE", target = sizeTarget, ordinal = 1), method = "renderTitle")
    public void changeSubtitleSize(Args args) {
        if (!config.enabled) return;
        for (int i = 0; i < 3; i++)
            args.set(i, (float) config.subtitleSize);
    }

    @ModifyArgs(at = @At(value = "INVOKE", target = locationTarget, ordinal = 1), method = "renderTitle")
    public void changeSubtitleLocation(Args args) {
        if (!config.enabled) return;
        args.set(1, (float) config.subtitleX);
        args.set(2, (float) config.subtitleY);
    }

    @ModifyArgs(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V"
        ),
        method = "renderTitle"
    )
    public void disableTranslate(Args args) {
        args.set(0, 0F);
        args.set(1, 0F);
    }
}