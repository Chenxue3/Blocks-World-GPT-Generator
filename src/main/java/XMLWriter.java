import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jdom2.Document;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author ：xueshanChen
 * @ClassName : XMLWriter
 * @description：
 * @version: v1.0
 */

public class XMLWriter {
    XMLWriter(){}

    void CreateXML(ArrayList<Goal> goals, String path) {
        try
        {
            Element forest = new Element("Forest");
            Document document = new Document(forest);
            // write each top-level goals
            for (Goal gl : goals) {
                writeGoal(gl, forest);
            }
            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(document, new FileWriter(path));
            System.out.println("XML File was created successfully!");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void writeGoal(Goal gl, Element parent)
    {
        Element goal = new Element("Goal");
        goal.setAttribute(new Attribute("name", gl.getName()));
        goal.setAttribute(new Attribute("Goal-condition",gl.getGoalcondition()));

        for(int i = 0; i < gl.getPlans().size(); i++)
        {
            Plan pl = gl.getPlans().get(i);
            writePlan(pl, goal,i);
        }
        parent.addContent(goal);
    }

    private void writePlan(Plan pl, Element parent, int m){
        Element plan = new Element("Plan");
        plan.setAttribute(new Attribute("name", pl.getName()));
        plan.setAttribute(new Attribute("precondition", pl.getPrecondition()));

        // write all actions, subgoals and parallel compositions it contains
        for(int i = 0; i < pl.getActions().size(); i++)
        {
            Action ac = pl.getActions().get(i);
            writeAction(ac,plan,i+m);
        }
        parent.addContent(plan);
    }

    private void writeAction(Action act, Element parent, int i)
    {
        Element action = new Element("Action");
        String s = "A" + i;
        action.setAttribute(new Attribute("name", s));
        action.setAttribute(new Attribute("precondition", act.getPrecondition()));
        action.setAttribute(new Attribute("recursion", act.getRecursion()));
        action.setAttribute((new Attribute("post-consition",act.getPostcondition())));
        parent.addContent(action);
    }
}
