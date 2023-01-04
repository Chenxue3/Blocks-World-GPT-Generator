/**
 * @author ：xueshanChen
 * @ClassName : Block
 * @description：
 * @version: v1.0
 */

public class Block {
    private String name;
    private int stack;
    private int level;
    Block(String name, int level, int stack){
        this.level = level;
        this.name = name;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Block{" +
                "name='" + name + '\'' +
                ", stack=" + stack +
                ", level=" + level +
                '}';
    }
}
