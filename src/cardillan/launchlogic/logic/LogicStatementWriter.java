package cardillan.launchlogic.logic;

public class LogicStatementWriter {
    public static final String SEPARATOR = " ";

    private StringBuilder builder;

    public void start(StringBuilder builder){
        this.builder = builder;
    }

    public void end(){
        // remove the last space
        builder.deleteCharAt(builder.length() - 1);
    }

    public LogicStatementWriter write(Object obj) {
        return write(String.valueOf(obj)).write(SEPARATOR);
    }

    public LogicStatementWriter write(String str) {
        builder.append(str).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(StringBuffer sb) {
        builder.append(sb).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(CharSequence s) {
        builder.append(s).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(CharSequence s, int start, int end) {
        builder.append(s, start, end).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(char[] str) {
        builder.append(str).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(char[] str, int offset, int len) {
        builder.append(str, offset, len).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(boolean b) {
        builder.append(b).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(char c) {
        builder.append(c).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(int i) {
        builder.append(i).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(long lng) {
        builder.append(lng).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(float f) {
        builder.append(f).append(SEPARATOR);
        return this;
    }

    public LogicStatementWriter write(double d) {
        builder.append(d).append(SEPARATOR);
        return this;
    }
}
