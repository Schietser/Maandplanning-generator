import com.aspose.cells.Workbook;
import service.ExcelGenerator;
import service.OpvoederService;
import service.PlanningService;

public class Main {

    public static void main(String[] args) throws Exception {

        PlanningService planningService = new PlanningService();
        OpvoederService opvoederService = new OpvoederService();

        ExcelGenerator excelGenerator = new ExcelGenerator();

        Workbook workbook = excelGenerator.formatWorkbook("jan-2025", opvoederService.getAllOpvoederNames(),planningService.fetchAllPlanningsItems());
        excelGenerator.storeExcel(workbook);



    }
}
