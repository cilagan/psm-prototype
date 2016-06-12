package gov.nsf.research.document.service.dao.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.nsf.research.document.service.DocumentServiceApplication;
import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DocumentServiceApplication.class)
public class DocumentServiceDaoImpl_UnitTest {

    @Autowired
    DocumentServiceDao docServiceDao;
    
    private static String tempPropId = "1234567";
    private static SectionType sectionType = SectionType.DATA_MANAGEMENT_PLAN;
    private static String filePath = "C://Apps//mongo_result_1.pdf";
    
    @Test
    public void testSaveDocument(){

            InputStream is = null;
            
            try {
                is = new BufferedInputStream(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            DocumentMetaData docMetaData = docServiceDao.saveDocument(is, tempPropId, sectionType);
            assertNotNull(docMetaData);
    }

     @Test
     public void testIsDocumentExists(){
         String tempPropId = "1234567";
         assertTrue(docServiceDao.isDocumentExists(tempPropId, sectionType, 0));
     }
     
     @Test
     public void testDeleteDocument(){
         String tempPropId = "1234567";
         docServiceDao.deleteDocument(tempPropId, sectionType, 0);
     }
     
     private static byte[] readContentIntoByteArray(File file)
       {
          FileInputStream fileInputStream = null;
          byte[] bFile = new byte[(int) file.length()];
          try
          {
             //convert file into array of bytes
             fileInputStream = new FileInputStream(file);
             fileInputStream.read(bFile);
             fileInputStream.close();
             for (int i = 0; i < bFile.length; i++)
             {
                System.out.print((char) bFile[i]);
             }
          }
          catch (Exception e)
          {
             e.printStackTrace();
          }
          return bFile;
       }
     
}

