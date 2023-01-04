import java.util.ArrayList;

/**
 * @author ：xueshanChen
 * @ClassName : Goal
 * @description：
 * @version: v1.0
 */

public class Goal {
    private String name;
    private String goalcondition;
    private ArrayList<Plan> plans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoalcondition() {
        return goalcondition;
    }

    public void setGoalcondition(String goalcondition) {
        this.goalcondition = goalcondition;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }
}
