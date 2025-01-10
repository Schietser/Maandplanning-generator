package service;

import entities.PlanningItem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class PlanningService {

    Workbook workbook;

    private Workbook fetchWorkBook() {

        try (FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\ruben\\Quarkus apps\\Maandplanning-generator\\src\\main\\resources\\240425 planning begeleiding juni 24 - draft v3.xlsx"))) {
            workbook = WorkbookFactory.create(fileInputStream);
            return workbook;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to fetch a workbook");
        }

    }

    private Sheet fetchSheet() {
        return fetchWorkBook().getSheetAt(0);
    }

    public Set<String> fetchValuesSpecificColumn(String column) {
        Sheet sheet = fetchSheet();

        int columnIndex = CellReference.convertColStringToIndex(column);

        Set<String> columnValues = new HashSet<>();

        for (int i = 1; i < 88; i++) {
            Cell cell = sheet.getRow(i).getCell(columnIndex);
            if (cell != null) {
                String cellValue = getCellValueAsString(cell);
                if (cellValue != null) {
                    columnValues.add(cellValue);
                }
            }

        }

        return columnValues;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        CellType cellType = cell.getCellType();

        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    java.util.Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                    return sdf.format(date);
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case FORMULA:
                // Handle formula cells
                try {
                    // Try to get the cached numeric value if the formula results in a number
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                        return sdf.format(date);
                    } else {
                        double numericValue = cell.getNumericCellValue();
                        return String.valueOf(numericValue);
                    }
                } catch (IllegalStateException e) {
                    // If the formula doesn't evaluate to a number, get the formula string
                    return cell.getCellFormula();
                }
            default:
                return null; // Default case for anything that's NOT String or Numeric
        }
    }

    public List<PlanningItem> fetchAllPlanningsItems() {
        Sheet sheet = fetchSheet(); // Fetch the Excel sheet
        List<PlanningItem> planningItems = new ArrayList<>();

        // Start iterating rows from the second row (index 1)
        for (int rowIndex = 1; rowIndex < 88; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) continue; // Skip empty rows
            if (row.getCell(0).getCellType() == CellType.BLANK) continue;

            PlanningItem planningItem = new PlanningItem();

            // Iterate through columns (0 to 5 for your required fields)
            for (int colIndex = 0; colIndex <= 5; colIndex++) {
                Cell cell = row.getCell(colIndex); // Fetch the cell
                if (cell != null) {
                    String cellValue = getCellValueAsString(cell); // Convert cell to string
                    if (cellValue != null) {
                        // Assign cell value to the corresponding field
                        switch (colIndex) {
                            case 0 -> planningItem.setDayOfWeek(cellValue);
                            case 1 -> planningItem.setDate(cellValue);
                            case 2 -> planningItem.setShift(cellValue);
                            case 3 -> planningItem.setUurRegeling(cellValue);
                            case 4 -> planningItem.setOpvoeder(cellValue);
                            case 5 -> planningItem.setAmountOfHours(cellValue);
                        }
                    }
                }
            }

            planningItems.add(planningItem); // Add the completed PlanningItem
        }

        return planningItems;
    }

    public List<String> listOfDatesInOldPlanning(){

        Set<String> datesInPlanningItems = new HashSet<>();
        fetchAllPlanningsItems()
                .forEach(planningItem -> datesInPlanningItems.add(planningItem.getDate()));

        return datesInPlanningItems.stream()
                .sorted(Comparator.comparingInt(dateStr -> Integer.parseInt(dateStr.split("-")[0])))
                .collect(Collectors.toList());

    }


}
