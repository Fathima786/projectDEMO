package testpkg;

import java.time.Duration;

import org.testng.annotations.Test;

import basepkg.Setup;
import pagepkg.Projectpage;
import utilities.Excelutils;

public class Projecttest extends Setup{
	
	@Test
	public void loginvalid() throws InterruptedException
	{
		
		Projectpage p1=new Projectpage(driver);
		String x1="C:\\Users\\user\\Documents\\SOFTWARE TESTING\\testdata2.xlsx";
		String sheet="Sheet1";
		int rowcount=Excelutils.getRowCount(x1, sheet);
		
		for(int i=1;i<=rowcount;i++)
		{
			String email=Excelutils.getCellValue(x1, sheet, i, 0);
			String password=Excelutils.getCellValue(x1, sheet, i, 1);
			p1.setvalues(email, password);
			p1.click();
			p1.checkvalid();
			String val=p1.checkvalid();
			System.out.println(val);
			if(val.equals("VALID CREDENTIALS"))
			{
				p1.addtocart();
				p1.fillinfo();
			}
			
			
		}
	}

}
