package service;

import entities.PlanningItem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelGenerator {

    public Workbook workBookCreator(){
        return new XSSFWorkbook();
    }

    public void setLayoutWorkbook(Workbook workbook, List<PlanningItem> planningItemList){
        Sheet sheet = workbook.createSheet("Sheet 1");





    }

}
