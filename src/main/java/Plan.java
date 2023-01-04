import java.util.ArrayList;

/**
 * @author ：xueshanChen
 * @ClassName : Plan
 * @description：
 * @version: v1.0
 */

public class Plan {
    private String name;
    private String precondition;
    private String postcondition;
    private ArrayList<Goal> goals;

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    private ArrayList<Action> actions;
    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }

    public String getPostcondition() {
        return postcondition;
    }

    public void setPostcondition(String postcondition) {
        this.postcondition = postcondition;
    }
}
