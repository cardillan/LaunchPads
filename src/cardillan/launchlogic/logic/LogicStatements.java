package cardillan.launchlogic.logic;

import arc.func.Func;
import arc.func.Prov;
import arc.scene.ui.layout.Table;
import mindustry.gen.LogicIO;
import mindustry.logic.LAssembler;
import mindustry.logic.LCategory;
import mindustry.logic.LExecutor;
import mindustry.logic.LStatement;

public class LogicStatements {
    private static final LogicStatementWriter writer = new LogicStatementWriter();

    public static void register() {
        register(LandingpadRedirect::new, LandingpadRedirect.opcode, LandingpadRedirect::read);
    }

    private static void register(Prov<LStatement> prov, String opcode, Func<String[], LStatement> parser) {
        LogicIO.allStatements.add(prov);
        LAssembler.customParsers.put(opcode, parser);
    }

    private static abstract class LogicStatement extends LStatement {
        final String name;

        public LogicStatement(String name) {
            this.name = name;
        }

        @Override
        public String name() {
            return name;
        }
    }

    private static class LandingpadRedirect extends LogicStatement {
        public static final String opcode = "redirect";
        public String target = "pad1";

        public LandingpadRedirect() {
            super("Redirect");
        }

        @Override
        public LCategory category() {
            return LaunchLogic.launchCategory;
        }

        @Override
        public void build(Table table) {
            table.add(" pad ");
            field(table, target, str -> target = str);
        }

        @Override
        public LExecutor.LInstruction build(LAssembler builder) {
            return new LogicInstructions.RedirectI(builder.var(target));
        }

        @Override
        public void write(StringBuilder builder) {
            writer.start(builder);
            writer.write(opcode);
            writer.write(target);
            writer.end();
        }

        public static LStatement read(String[] tokens) {
            LandingpadRedirect stmt = new LandingpadRedirect();
            int i = 1;
            if (tokens.length > i) stmt.target = tokens[i++];
            return stmt;
        }
    }
}
