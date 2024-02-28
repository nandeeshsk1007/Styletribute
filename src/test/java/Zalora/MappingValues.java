package Zalora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MappingValues {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String[] people = new String[10];
		String[] people1 = new String[10];
		String[] people2 = new String[10];
		FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Zalora\\New Microsoft Office Excel Worksheet.xlsx");
		Workbook book = WorkbookFactory.create(filein);
		for(int j=0; j<10; j++) {
			Cell name = book.getSheet("Sheet2").getRow(j).getCell(0);
			String materialname = name.getStringCellValue();
			people[j]=materialname;
		}
		for(int i=0; i<10; i++) {

			Cell value = book.getSheet("Sheet2").getRow(i).getCell(1);
			String materialvalue = value.getStringCellValue();
			people1[i]=materialvalue;
			//System.out.println(materialname+" = "+materialvalue);
		}
		for(int k=0; k<10; k++) {

			Cell value = book.getSheet("Sheet2").getRow(k).getCell(2);
			String materialvalue1 = value.getStringCellValue();
			people2[k]=materialvalue1;

		}
		//for(people2)
		//System.out.println(materialname+" = "+materialvalue);
	}
}

