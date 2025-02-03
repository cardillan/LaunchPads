package cardillan.launchlogic;

import cardillan.launchlogic.logic.LaunchLogic;
import mindustry.mod.Mod;

public class Main extends Mod {

    @Override
    public void init(){
        super.init();

        LaunchLogic.init();
    }
}
