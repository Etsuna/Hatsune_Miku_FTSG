import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class ReadXLS {

    public ReadXLS(int sheetpage, String difficulty, ArrayList song, float comboBoxmini, float comboBoxmaxi) throws IOException {
        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File("./classes/MusicList.xls"));

        // Get the workbook instance for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(sheetpage);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row

            DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
            Cell cell = row.getCell(2);
            String sizestring = formatter.formatCellValue(cell);
            float size = Float.valueOf(sizestring.trim()).floatValue();
            if (size >= comboBoxmini && size <= comboBoxmaxi) {

                song.add(row.getCell(0) + " | " + row.getCell(1) + " | Difficulté : " + difficulty + " | Niveau : " + row.getCell(2));
                System.out.println("");
            }
        }
        System.out.println("song : "+ song );
    }

}