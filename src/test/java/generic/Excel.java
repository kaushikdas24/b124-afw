package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String xlpath,String sheet,int row,int col)
	{
		String value="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlpath));
			value = wb.getSheet(sheet).getRow(row).getCell(col).toString();
			wb.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return value;
	}
}
