package com.example.app.control;

import java.io.IOException;
import java.util.List;

import javax.persistence.EnumType;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Media;
import com.example.app.entity.Planfinanciere;
import com.example.app.entity.User;
import com.example.app.service.MediaService;
import com.example.app.service.PlanfinancierService;

@RestController
public class PlanFinanciereController {
	@Autowired
	PlanfinancierService planfinservice;
	@Autowired
	MediaService mediaser;
	@PostMapping("/importfinancialplan")
	public Planfinanciere exceltosql(@RequestParam("file") MultipartFile Excel) throws IOException{
        float dr=0;
        float ip=0;
        float van=0;
        float tri=0;
        float faza=0;
        int annees =0;
         float montant=180000;
         float taux=(float) 0.13;
        Planfinanciere pf= new Planfinanciere();
	    XSSFWorkbook workbook = new XSSFWorkbook(Excel.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(1);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {                   
	        XSSFRow row = worksheet.getRow(i);	            
	       
	       if(montant<row.getCell(2).getNumericCellValue())
	       {   
	    	   float ab=(float) (worksheet.getRow(i+1).getCell(2).getNumericCellValue()-row.getCell(2).getNumericCellValue());
	    	   dr=(float) (row.getCell(0).getNumericCellValue()+(float) ((montant-row.getCell(2).getNumericCellValue())/ab));
	       }
           van+=Math.pow(row.getCell(1).getNumericCellValue(),i);
   	    pf.setDr(dr);
   	    pf.setTri(tri);
   	    pf.setVan(van);
        planfinservice.Adddocument(pf);
	    }
		
	return pf;
	}
	@PutMapping("/Updatefinancialplan")  																																																																																																																																												
	public  void update(@RequestBody Planfinanciere pf)
	{
	   planfinservice.Updateplan(pf);
	}
	@GetMapping("/Getfinancialplan/{iduser}")
	public Planfinanciere getfinancialplanuser(User u)
	{
		Planfinanciere pf=new Planfinanciere();
		pf=planfinservice.getPlanfinanciereByuser(u);
		return pf;
	}
	@GetMapping("/Getallfinancialplan")
	public List<Planfinanciere> getAll()
	{
		return planfinservice.retriveAlldocs();
	}
	
}


