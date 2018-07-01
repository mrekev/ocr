package lt.mrekev.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    private static final String FILE_NAME = "S!F.xlsx";

    public static void main(String[] args) throws IOException {

        TesseractApi tesseractApi = new TesseractApi();
        ImageReader imageReader = new ImageReader(tesseractApi);

        DirectoryImageFileReader directoryImageFileReader = new DirectoryImageFileReader();
        List<String> strings = directoryImageFileReader.listImageFiles(".");
        strings.stream().forEach(System.out::println);
        for (String fileName:strings){
            System.out.println("=======line=======");
            System.out.println(imageReader.scanImage(fileName));
        }
//        try {
//
//            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
//            Workbook workbook = new XSSFWorkbook(excelFile);
//            Sheet datatypeSheet = workbook.getSheetAt(2);
//            Iterator<Row> iterator = datatypeSheet.iterator();
//            boolean skipFirst = true;
//            while (iterator.hasNext()) {
//            	Row currentRow = iterator.next();
//                Iterator<Cell> cellIterator = currentRow.iterator();
//
//            	if(skipFirst) {
//            		skipFirst = false;	
//            	}else {
//            		
//            		boolean skipFirstColl = true;
//            		boolean skipSecondColl = true;
//                while (cellIterator.hasNext()) {
//                	
//                    Cell currentCell = cellIterator.next();
//                    if(skipFirstColl) {
//                    	skipFirstColl = false;
//                    	continue;
//                    }
//                    if(skipSecondColl) {
//                    	skipSecondColl = false;
//                    	continue;
//                    }
//                    //getCellTypeEnum shown as deprecated for version 3.15
//                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "--");
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "--");
//                    }
//
//                }
//                System.out.println();
//            	}
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
