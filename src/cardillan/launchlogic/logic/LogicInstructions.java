package cardillan.launchlogic.logic;

import mindustry.Vars;
import mindustry.logic.LExecutor;
import mindustry.logic.LVar;
import mindustry.type.Sector;
import mindustry.world.blocks.campaign.LandingPad;
import mindustry.world.blocks.logic.MessageBlock;

import static mindustry.Vars.state;

public class LogicInstructions {

    public static class RedirectI implements LExecutor.LInstruction {
        public LVar target;

        public RedirectI(LVar target) {
            this.target = target;
        }

        public RedirectI() {
        }

        @Override
        public final void run(LExecutor exec) {
            if(target.building() instanceof LandingPad.LandingPadBuild l && state.isCampaign() && l.config != null) {
                for(Sector sector : state.getPlanet().sectors){
                    if(sector.hasBase() && sector != state.getSector() && sector.info.destination != state.getSector() && sector.info.hasExport(l.config)){
                        sector.info.destination = state.getSector();
                        sector.saveInfo();
                    }
                }
                state.getSector().info.refreshImportRates(state.getPlanet());
            }
        }
    }
}
