import org.apache.poi.ss.usermodel.Sheet;
import service.PlanningService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PlanningService planningService = new PlanningService();

        List<String> namesOfOpvoeders = new ArrayList<>();

        namesOfOpvoeders = planningService.fetchValuesSpecificColumn("E");

        for (String names : namesOfOpvoeders){
            System.out.println(names);
        }

    }
}
