import java.util.ArrayList;

/**
 * @author ：xueshanChen
 * @ClassName : Stack
 * @description：
 * @version: v1.0
 */

public class Stack {
    private int id;
    private ArrayList<Block> blocks;
    Stack(int id){
        id = this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }


}
