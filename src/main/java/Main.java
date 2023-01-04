import java.util.ArrayList;

/**
 * @author ：xueshanChen
 * @ClassName : Main
 * @description：
 * @version: v1.0
 */

public class Main {
    public static ArrayList<Stack> EVE = new ArrayList<>();
    public static Block TABLE  = new Block("TABLE",-1,-1);
    public static void main(String[] args){

        ArrayList<Goal> forest = new ArrayList<>();
        ArrayList<Plan> plans = new ArrayList<>();
        ArrayList<Action> actions = new ArrayList<>();
        Generator generator = new Generator();
        //the initial state
        int goal_num = 1;
        for (int i = 0; i < goal_num; i++) {
            Goal goal = new Goal();
            goal.setName("G"+i);
            goal.setGoalcondition("on(x,y)");
            goal.setPlans(generator.createPlan());
            forest.add(goal);
        }
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.CreateXML(forest,"test.xml");
    }
    public static boolean tower(Block...blocks){

        for(int i = 0; i< blocks.length-2; i++){
            if (!on(blocks[i],blocks[i+1])){
                System.out.println(blocks[i].getName() + " is not on " +blocks[i+1].getName());
                return false;
            }
        }
        return true;
    }
    public static boolean on(Block x, Block y){
        //if x is table
        if((x.getStack() == -1)){
            return false;
        }

        //if y is table
        if(y.getStack() == -1){
            if(x.getLevel() == 0){
                return true;
            }
            else {
                return false;
            }
        }

        if(x.getStack() == y.getStack()){
            if((y.getLevel() - x.getLevel()) == 1){
                return true;
            }
        }
        return false;
    }

    public static boolean clear(Block x){
        if(x.getLevel() == ((EVE.get(x.getStack()).getBlocks().size())-1)){
            return true;
        }
        else {
            return false;
        }
    }
    public static void moveTo(Block x, Block y){
        if(!clear(x)){
            System.out.println("There are block(s) on "+ x.getName()+ " can not move to " +y.getName());
            return ;
        }
        if(x.getLevel() == -1){
            System.out.println("x is table, table can not be moved");
            return ;
        }

        //move x to table
        if(y.getLevel() == -1 && clear(x)){
            //x move to a new place
            Stack xNewStack = new Stack(EVE.size());
            ArrayList<Block> newBlocks = new ArrayList<>();
            //change the original stack
            EVE.get(x.getStack()).getBlocks().remove(x.getLevel()-1);
            x.setLevel(0);
            x.setStack(EVE.size());
            newBlocks.add(x);
            xNewStack.setBlocks(newBlocks);
            EVE.add(xNewStack);
            System.out.println( x.getName() +"->" + y.getName());
            return ;
        }

        //move x to y
        if(clear(x) && y.getStack()!=-1){
            EVE.get(x.getStack()).getBlocks().remove(x.getLevel());
            x.setLevel(y.getLevel()+1);
            x.setStack(y.getStack());
            EVE.get(y.getStack()).getBlocks().add(x);
        }
        System.out.println( x.getName() +"->" + y.getName());
        return;
    }

    public static void move(Block x, Block y){
        //plan0
        if(on(x,y)){
            return;
        }
        //plan1
        if(clear(x)&& clear(y) && y.getStack()!=-1){
            moveTo(x,y);
        }
        //plan2
        if(!clear(x) && clear(y)){
            int i;
            for(i=EVE.get(x.getStack()).getBlocks().size()-1; i>=x.getLevel();i--){
                moveTo(EVE.get(x.getStack()).getBlocks().get(i),TABLE);
            }
            moveTo(x, y);
        }

        //plan3
        if(!clear(y) && clear(x)){
            for(Block block:EVE.get(y.getStack()).getBlocks()){
                if(block.getLevel() > y.getLevel()) {
                    moveTo(block, TABLE);
                }
            }
            moveTo(x,y);
        }
        //plan 4
        if(clear(x) && (y.getStack() == -1)){
            return;
        }

    }
    public static void printEve(){
        for(Stack stack: EVE){

            if(stack.getBlocks().size() != 0){
                System.out.println("================");
            }
            for(int i = stack.getBlocks().size()-1; i>=0; i--){
                System.out.println("|     [ "+stack.getBlocks().get(i).getName()+" ]     |" );
            }
            if(stack.getBlocks().size() != 0){
                System.out.println("================");
            }
        }
    }
}
