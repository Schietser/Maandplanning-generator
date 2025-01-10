package service;

import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import entities.PlanningItem;

import java.util.List;
import java.util.Set;

public class ExcelGenerator {

    private static final int ROW_INDEX_DATES = 1;



    public Workbook formatWorkbook(String maand, Set<String> opvoeders, List<PlanningItem> planningItems){

        PlanningService planningService = new PlanningService();
        List<String> dates = planningService.listOfDatesInOldPlanning();
        int columnIndex = 1;
        int rowIndexOpvoeders = 3;

        Workbook workbook = new Workbook();

        Worksheet worksheet = workbook.getWorksheets().get(0);
        Cells cells = worksheet.getCells();

        cells.get("A1").setValue("Planning maand :");
        cells.get("B1").setValue(maand);

        for (String date : dates){
            cells.get(ROW_INDEX_DATES,columnIndex).setValue(date);
            columnIndex++;
        }

        for (String opvoeder : opvoeders){
            cells.get(rowIndexOpvoeders,0).setValue(opvoeder);
            rowIndexOpvoeders++;
        }

        for (int row = 4; row < opvoeders.size()+4; row++) {
            for (int column = 1; column < dates.size()+1; column++) {
                for (PlanningItem planningItem : planningItems){
                    if (cells.get("A"+row).getStringValue().trim().equals(planningItem.getOpvoeder()) && cells.get(1,column).getStringValue().trim().equals(planningItem.getDate())){
                        cells.get(row-1,column).setValue(planningItem.getUurRegeling());
                    }
                }
            }
        }



        return workbook;

    }

    public void storeExcel(Workbook workbook) throws Exception {

            String path = "C:\\Users\\ruben\\Documents\\test.xlsx";

            workbook.save(path);
    }





}
