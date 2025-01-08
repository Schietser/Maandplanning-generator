package service;

import org.apache.commons.lang3.stream.Streams;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class PlanningService {

    Workbook workbook;

    private Workbook fetchWorkBook() {

        try(FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\ruben\\Quarkus apps\\Maandplanning-generator\\src\\main\\resources\\240425 planning begeleiding juni 24 - draft v3.xlsx"))) {
            workbook = WorkbookFactory.create(fileInputStream);
            return workbook;
        } catch (IOException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Failed to fetch a workbook");
        }

    }

    private Sheet fetchSheet() {
        return fetchWorkBook().getSheetAt(0);
    }

    public List<String> fetchValuesSpecificColumn(String column){
        Sheet sheet = fetchSheet();

        int columnIndex = CellReference.convertColStringToIndex(column);

        List<String> columnValues = new ArrayList<>();

        for (Row row : sheet){
            Cell cell = row.getCell(columnIndex);
            if (cell != null){
                String cellValue = getCellValueAsString(cell);
                if (cellValue != null){
                    columnValues.add(cellValue);
                }
            }

        }

        return columnValues;
    }

    private String getCellValueAsString(Cell cell){
        if (Objects.requireNonNull(cell.getCellType()) == CellType.STRING) {
            return cell.getStringCellValue();
        }
        return null;
    }

}
