import java.util.ArrayList;

/**
 * @author ：xueshanChen
 * @ClassName : Generator
 * @description：
 * @version: v1.0
 */

public class Generator {
    private ArrayList EV;

    Generator() {

    }

    private ArrayList initPre() {
        ArrayList<String> preC = new ArrayList<>();
        String preC0 = "on(x,y)";
        String preC1 = "clear(x) && clear(y) && y!=table";
        String preC2 = "on(z,x) && clear(y)";
        String preC3 = "on(z,y) && clear(x)";
        String preC4 = "clear(x) && (y == table)";
        preC.add(preC0);
        preC.add(preC1);
        preC.add(preC2);
        preC.add(preC3);
        preC.add(preC4);
        return preC;
    }

    public ArrayList createPlan() {
        ArrayList<String> preC = new ArrayList<>();
        preC = this.initPre();
        ArrayList<Plan> plans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Plan p = new Plan();
            p.setPrecondition(preC.get(i));
            p.setActions(createAction(i));
            p.setPostcondition("on(x,y)");
            p.setName("P"+i);
            plans.add(p);
        }
        return plans;
    }

    public ArrayList createAction(int i){

        ArrayList<Action> actions = new ArrayList<>();
        if(i == 0){
            Action action = new Action();
            action.setPrecondition("on(x,y)");
            action.setRecursion("NULL");
            action.setPostcondition("on(x,y)");
            actions.add(action);
        }
        if(i == 1){
            Action action = new Action();
            action.setPrecondition("clear(x) && clear(y) && y!=table");
            action.setRecursion("move(x,y)");
            action.setPostcondition("on(x,y)");
            actions.add(action);
        }
        if(i == 2){
            Action action1 = new Action();
            action1.setPrecondition("on(z,x) && clear(y)");
            action1.setRecursion("move(z,table)");
            action1.setPostcondition("on(z, table)");
            actions.add(action1);
            Action action2 = new Action();
            action2.setPrecondition("on(z,x) && clear(y)");
            action2.setRecursion("move(x,y)");
            action2.setPostcondition("on(x,y)");
            actions.add(action2);
        }
        if(i == 3){
            Action action1 = new Action();
            action1.setPrecondition("on(z,y) && clear(x)");
            action1.setRecursion("move(z,table)");
            action1.setPostcondition("on(z, table)");
            actions.add(action1);
            Action action2 = new Action();
            action2.setPrecondition("on(z,y) && clear(z)");
            action2.setRecursion("move(x,y)");
            action2.setPostcondition("on(x,y)");
            actions.add(action2);
        }
        if(i == 4){
            Action action = new Action();
            action.setPrecondition("clear(x) && (y == table)");
            action.setRecursion("NULL");
            action.setPostcondition("on(x,y)");
            actions.add(action);
        }

        return actions;
    }
}
