package ErrorProducts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Error {

	@Test
	public void find() throws EncryptedDocumentException, IOException {
		FileInputStream filein = new FileInputStream("D:\\javanew\\Shopfy.Styletribute\\target\\Styletribute.xlsx");
		Workbook book = WorkbookFactory.create(filein);

		int row1=0;
		int row2=0;
		int row3=0;
		String allp=null;
		String createdp=null;

		ArrayList<String> createdlist = new ArrayList<String>();
		for(int i=1; i<=4210; i++) {

			Cell created = book.getSheet("Sheet7").getRow(row1).getCell(0);
			createdp = created.getStringCellValue();
			createdlist.add(createdp);
			row1++;
		}
		
		for(int j=1; j<=3971; j++) {
			Cell all = book.getSheet("Sheet7").getRow(row2).getCell(2);
			allp = all.getStringCellValue();
			if(createdlist.contains(allp)) {
				//System.out.println(createdlist.contains(allp)+" - "+allp);
			}
			else {
			System.out.println(allp);
			}
			row2++;
		}
	}
}