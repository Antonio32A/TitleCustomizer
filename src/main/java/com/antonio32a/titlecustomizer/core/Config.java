package com.antonio32a.titlecustomizer.core;


import com.antonio32a.titlecustomizer.TitleCustomizer;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {
    @Property(
        type = PropertyType.SWITCH,
        name = "Enabled",
        category = "Main"
    )
    public boolean enabled = false;

    @Property(
        type = PropertyType.SLIDER,
        name = "Size",
        category = "Title",
        max = 10
    )
    public int titleSize = 4;

    @Property(
        type = PropertyType.NUMBER,
        name = "X",
        description = "X coordinate of the title. Hold SHIFT while changing values to increase them by 5.",
        category = "Title",
        max = 3840
    )
    public int titleX = 4;

    @Property(
        type = PropertyType.NUMBER,
        name = "Y",
        description = "Y coordinate of the title. Hold SHIFT while changing values to increase them by 5.",
        category = "Title",
        max = 2160
    )
    public int titleY = 4;

    @Property(
        type = PropertyType.SLIDER,
        name = "Size",
        category = "Subtitle",
        max = 10
    )
    public int subtitleSize = 2;

    @Property(
        type = PropertyType.NUMBER,
        name = "X",
        description = "X coordinate of the subtitle. Hold SHIFT while changing values to increase them by 5.",
        category = "Subtitle",
        max = 3840
    )
    public int subtitleX = 4;

    @Property(
        type = PropertyType.NUMBER,
        name = "Y",
        description = "Y coordinate of the subtitle. Hold SHIFT while changing values to increase them by 5.",
        category = "Subtitle",
        max = 2160
    )
    public int subtitleY = 39;

    public Config() {
        super(new File(TitleCustomizer.configLocation));
        initialize();
    }
}