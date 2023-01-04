/**
 * @author ：xueshanChen
 * @ClassName : Action
 * @description：
 * @version: v1.0
 */

public class Action {
    private String name;
    private String precondition;
    private String postcondition;
    private String recursion;

    public String getRecursion() {
        return recursion;
    }

    public void setRecursion(String recursion) {
        this.recursion = recursion;
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
