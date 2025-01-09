import entities.Opvoeder;
import entities.PlanningItem;
import org.apache.poi.ss.usermodel.Sheet;
import service.OpvoederService;
import service.PlanningService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        PlanningService planningService = new PlanningService();

        for (PlanningItem planningItem : planningService.fetchAllPlanningsItems()){
            System.out.println(planningItem);
        }




    }
}
