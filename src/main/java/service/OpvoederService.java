package service;

import entities.PlanningItem;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OpvoederService {

    PlanningService planningService = new PlanningService();

    public Set<String> getAllOpvoederNames(){
        return planningService.fetchValuesSpecificColumn("E");
    }

    public Map<String, PlanningItem> createPlanningItemMapForEachOpvoeder (Set<String> Opvoeders){

        return null;
    }



}
