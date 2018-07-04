package lt.mrekev.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            String replace = imageReader.scanImage(fileName).replace("\n\n", "\n");
            System.out.println(replace);
            System.out.println("======\n\n\n=====");
            String[] x = replace.split("\n");
            System.out.println(Arrays.toString(x));
            List<Content> contents= new ArrayList<>();
            List<Entry> entries= new ArrayList<>();
            for (int i=0;i<x.length;i+=2){
                contents.add(new Content(x[i],x[i+1]));
            }
            for(Content content:contents){
                String nameLine = content.getNameLine();
                String name ="";
                if(nameLine.length() < 13){
                    name = nameLine;
                }else {
                    String namePos = nameLine.substring(0, 13);
                    if(!namePos.endsWith(" ")){
                        name = namePos.substring(0, namePos.lastIndexOf(" "));
                    }else{
                        name= namePos.substring(0,12);
                    }
                }
                String dataLine = content.getDataLine();
                String[] data = dataLine.split(" ");
                String might = data[0];
                String kills = data[data.length-1];
                long mightL = Long.parseLong(might.replace(",",""));
                long killsL = Long.parseLong(kills.replace(",",""));
                entries.add(new Entry(name,mightL,killsL));
            }

            System.out.println();
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
