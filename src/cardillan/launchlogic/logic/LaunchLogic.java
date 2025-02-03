package cardillan.launchlogic.logic;

import arc.graphics.Color;
import mindustry.gen.Icon;
import mindustry.logic.LCategory;

public class LaunchLogic {
    public static LCategory launchCategory;

    public static void init(){
        launchCategory = new LCategory("landingpads", new Color(0x806b00ff), Icon.planetSmall);
        LogicStatements.register();
    }
}
