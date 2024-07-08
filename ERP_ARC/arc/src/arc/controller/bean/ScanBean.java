package arc.controller.bean;


import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.WatermarkArtifact;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FontStyle;
import com.aspose.pdf.facades.FormattedText;

import com.aspose.pdf.SaveFormat;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenConstants;
import gen.common.GenLib;

import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.component.UIXEditableValue;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFPage;
import org.faceless.pdf2.PDFReader;
import org.faceless.pdf2.PDFStyle;
import org.faceless.pdf2.StandardFont;

public class ScanBean extends ArcBaseBean
{
  private RichDocument doc;
  private String fullFilePath; 


  public void uploadFileAttachment(ValueChangeEvent valueChangeEvent)
  {
    UploadedFile file = (UploadedFile) valueChangeEvent.getNewValue();
   String fileName = file.getFilename();
    System.out.println(fileName);
      int index = fileName.lastIndexOf('.');
         if(index > 0) {
           String extension = fileName.substring(index + 1);
           if (!extension.equals("pdf"))
           {
             GenLib.showErrorMessage("error.fileType");
             throw new JboException("");
           }
         }
    
    uploadFile(valueChangeEvent, "ReportParametersRVO1Iterator", "FilePath");
//    setFileName(GenLib.getSystemFullPath() +  getFullFilePath());
    ADFUtils.setAttribute("ReportParametersRVO1Iterator", "FileName", GenLib.getSystemFullPath() +  getFilePath()); 
    int noOfPDFFilePages = getNumberOfPDFFilePages(GenLib.getSystemFullPath() +  getFilePath());
    ADFUtils.setAttribute("ReportParametersRVO1Iterator", "NoOfPages", new BigDecimal(noOfPDFFilePages)); 
  }
  
  public void refreshFromScanner(ClientEvent clientEvent)
  {
    String mainFile = getFileName();
    String operationType = "";
    try
    {
      TimeUnit.SECONDS.sleep(8);
    }
    catch (Exception ie)
    {
      // TODO: Add catch code
      ie.printStackTrace();
    }
    String fileName = (String) clientEvent.getParameters().get("currentFileName");
    Row row = ADFUtils.findIterator("ReportParametersRVO1Iterator").getViewObject().getCurrentRow();
    String mainFilePath = "";
    
    if(row != null)
    {
      mainFilePath = (String)row.getAttribute("FilePath");
    }

    fileName = GenLib.getUploadPathSuffix() + fileName + ".pdf";
    row.setAttribute("FilePath", fileName); 
//    setFileName(GenLib.getSystemFullPath() +  fileName);
    ADFUtils.setAttribute("ReportParametersRVO1Iterator", "FileName", GenLib.getSystemFullPath() +  fileName); 
    
    if(JSFUtils.getFromSession("operationType") != null)
    {
      operationType = (String) JSFUtils.getFromSession("operationType");  
    }
     
    if(operationType != null && !operationType.equals("")
       && (mainFilePath != null && !mainFilePath.equals("")))
    {
      if(operationType.equals("AddAfter"))
      {
        addPDFFile(getPageIndex(), mainFile, getFileName());       
      }
       if(operationType.equals("AddBefore"))
      {
        addPDFFile(getPageIndex() - 1, mainFile, getFileName());
      }
      row.setAttribute("FilePath", mainFilePath); 
//      setFileName(mainFile);
      ADFUtils.setAttribute("ReportParametersRVO1Iterator", "FileName", mainFile); 
      
      JSFUtils.setExpressionValue("operationType", null);
    }
    int noOfPDFFilePages = getNumberOfPDFFilePages(GenLib.getSystemFullPath() +  getFilePath());
    ADFUtils.setAttribute("ReportParametersRVO1Iterator", "NoOfPages", new BigDecimal(noOfPDFFilePages)); 
    RequestContext.getCurrentInstance().addPartialTarget(ADFUtils.findComponentInRoot("pgl5"));
  }
  
  public void rotateClockwiseActionPerformed(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                             javax.faces.event.ActionEvent actionEvent)
  {
    
    if (getFilePath()==null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      throw new JboException("");

    }
    if(!validatePageNumber())
    {
      return;
    }
    rotatePage(90);
  }
  
  public void rotateAntiClockwiseActionPerformed(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                                 javax.faces.event.ActionEvent actionEvent)
  {
    if (getFilePath()==null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      throw new JboException("");

    }
    if(!validatePageNumber())
    {
      return;
    }
    rotatePage(-90);
  }

  public void rotatePage(int orientation)
  {
    rotatePage(getFileName(), getPageIndex() - 1, orientation);
  }
  
  public void deleteCurrentPageActionPerformed(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                               javax.faces.event.ActionEvent e)
  {
    if (getFilePath()==null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      throw new JboException("");

    }
    int pageIndex = 0;
    if(!validatePageNumber())
    {
      return;
    }
    try 
    { 
      pageIndex = getPageIndex() - 1;     
      boolean isOk = deletePage(getFileName(), pageIndex);

      if(!isOk)
      {
        return;
      }  
      
      int noOfPDFFilePages = getNumberOfPDFFilePages(GenLib.getSystemFullPath() +  getFilePath());
      ADFUtils.setAttribute("ReportParametersRVO1Iterator", "NoOfPages", new BigDecimal(noOfPDFFilePages)); 
      
    }
    catch (Exception ef)
    {
      ef.printStackTrace();
    }
  }
  
  public void reorderPage(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") ActionEvent actionEvent)
  {
    if (getFilePath()==null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      throw new JboException("");

    }
    if(!validatePageNumber())
    {
      return;
    }
    
    if(!validatePageOrderNumber())
    {
      return;
    }  
   
    int currentPageIndex = getPageIndex() - 1;
    int endRangPageIndex = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "OrderPageEndRange"), 0);    
    int newPageIndex = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "OrderPageNumber"), 0);   
    if (ADFUtils.getAttribute("ReportParametersRVO1Iterator", "OrderPageNumber")==null )
    {
      GenLib.showErrorMessage("error.OrderPageNumberRequired");
      throw new JboException("");
    }
    boolean isOk = false;
    newPageIndex = newPageIndex -1;
 
    PDFReader reader = null;
    FileInputStream in = null;
    
    try
    {
      System.out.println(getFileName());
      in = new FileInputStream(getFileName());
      reader = new PDFReader(in);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    PDF pdf = new PDF(reader);
    
    if(endRangPageIndex == 0)
    {       
      PDFPage page = pdf.getPage(currentPageIndex);
      isOk = deletePage(getFileName(), currentPageIndex);
      addPage(getFileName(), page, newPageIndex);
    }
    else
    {
      List <PDFPage> pages = new ArrayList <PDFPage>();

      for(int i = currentPageIndex; i < endRangPageIndex ; i++)
      { 
        pages.add(new PDFPage(pdf.getPage(i)));
        isOk = deletePage(getFileName(), i);
         if(!isOk)
         {
           return;
         }  
      }
      
      for(int x = pages.size() - 1 ; x >= 0; x--)
      {
        addPage(getFileName(), pages.get(x), newPageIndex);
      }                     
       
    }

  }
  
  public int getNumberOfPDFFilePages(String pdfPath)
  {
    FileInputStream in = null;
    try
    {
      in = new FileInputStream(pdfPath);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    PDFReader reader = null;
    try
    {
      reader = new PDFReader(in);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      in.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
    PDF pdf = new PDF(reader);
    
    return pdf.getNumberOfPages();
  }
  
  public Boolean validatePageNumber()
  {
    int pdfPageNumber = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "NoOfPages"), 0);
    
    if(getPageIndex() > pdfPageNumber)
    {
      GenLib.showErrorMessage("error.PageRangeSize");
      return false;
    }   
    return true;
  }
  
  public Boolean validatePageOrderNumber()
  {
    int pdfPageNumber = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "NoOfPages"), 0);
    int pageOrderNumber = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "OrderPageNumber"), 0); 
    if(pageOrderNumber > pdfPageNumber)
    {
      GenLib.showErrorMessage("error.PageRangeSize");
      return false;
    }   
    return true;
  }

  @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")
  private static void addPDFFile(int pageIndex, String mainFile, String newFile)
  {
    FileInputStream inMain = null;
    FileInputStream inNew = null;
    PDF mainPDF = null;
    PDF newPDF = null;

    try
    {
      TimeUnit.SECONDS.sleep(5);
      inMain = new FileInputStream(mainFile);
      PDFReader reader = new PDFReader(inMain);
      mainPDF = new PDF(reader);
          
      inNew = new FileInputStream(newFile);
      PDFReader reader1 = new PDFReader(inNew);
      newPDF = new PDF(reader1);
      
      mainPDF.getPages().addAll(pageIndex, newPDF.getPages());  
      mainPDF.getForm().getElements().putAll(newPDF.getForm().getElements());
      mainPDF.render(new FileOutputStream(mainFile));
      
      inMain.close();
      inNew.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        mainPDF.close();
        newPDF.close();
      }
      catch (Exception e)
      {
        // TODO: Add catch code
        e.printStackTrace();
      }
    }
  }

  @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")
  public void splitPdf(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") ActionEvent actionEvent ) 
  {
    Row row = ADFUtils.findIterator("ReportParametersRVO1Iterator").getViewObject().getCurrentRow();
    String mainFilePath = "";
    String newFilePath = "";
    ViewObject vo = ADFUtils.findIterator("ArcClassificationPVO1Iterator").getViewObject();
    Row currentRow = vo.last();
    int endPage = 0;
    int filePages = 0;
    if(vo.getRowCount() == 0)
    {
      GenLib.showErrorMessage("error.noSplitDetails");
      return;
    }
    if(currentRow != null)
    {
      endPage = DBUtil.nvl(currentRow.getAttribute("EndPage"), 0);
    }

    if(row.getAttribute("FilePath") != null)
    {
      mainFilePath = (String)row.getAttribute("FilePath");
      filePages = DBUtil.nvl(row.getAttribute("NoOfPages"), 0);
    }
    else 
    {
      GenLib.showErrorMessage("error.noFileSelected");
      return;
    }
    
    if(endPage < filePages || endPage > filePages)
    {
      GenLib.showErrorMessage("error.splitIndexRange");
      return;
    }
    
    String pdfPath = getFileName();
    int startIndex = 0;
    int endIndex = 0;
    FileInputStream in = null;
    PDFReader reader = null;
    PDF mainPDF = null;
    
    try
    {
      in = new FileInputStream(getFileName());
      reader = new PDFReader(in);
      mainPDF = new PDF(reader);
          
      vo.setRangeSize(-1);
      Row[] rows = vo.getAllRowsInRange();
      PDF[] files = new PDF[rows.length];
  
      for(int i = 0; i < rows.length ; i++)
      {
        files[i] = new PDF();
        startIndex = DBUtil.nvl(rows[i].getAttribute("StartPage"), 0);
        endIndex = DBUtil.nvl(rows[i].getAttribute("EndPage"), 0);

        
        if (rows[i].getAttribute("StartPage")==null )
        {
          GenLib.showErrorMessage("error.StartPageRequired");
          throw new JboException("");
        }
        if (rows[i].getAttribute("EndPage")==null )
        {
          GenLib.showErrorMessage("error.EndPageRequired");
          throw new JboException("");
        }
        for(int j = startIndex - 1 ; j <  endIndex ; j++)
        {       
          files[i].getPages().add(mainPDF.getPage(j));
        }
        
        files[i].getForm().getElements().putAll(mainPDF.getForm().getElements()); 
        files[i].render(new FileOutputStream(pdfPath.substring(0, pdfPath.indexOf(".")) + (i + 1) + ".pdf"));
        files[i].close();
        newFilePath = mainFilePath.substring(0, mainFilePath.indexOf(".")) + (i + 1) + ".pdf";
        insertArcOldDocument(rows[i], newFilePath);
    
      }
          
     ADFUtils.commit();
      
      ViewObject vo1 = ADFUtils.findIterator("ArcClassificationPVO1Iterator").getViewObject();
      vo1.setRangeSize(-1);
      Row[] rows1 = vo1.getAllRowsInRange();
      
      for(int i = 0; i < rows1.length ; i++)
      {
        rows1[i].remove();  
        
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      mainPDF.close();
      try
      {
        in.close();
      }
      catch (IOException e)
      {
        System.err.println(e);
      }
    }
  }
  
  public void insertClassificationRow(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                      ActionEvent actionEvent)
  {  
    Row fileRow = ADFUtils.findIterator("ReportParametersRVO1Iterator").getViewObject().getCurrentRow();
    ViewObject vo = ADFUtils.findIterator("ArcClassificationPVO1Iterator").getViewObject();
    Row currentRow = vo.last();
    
    int endPage = 0;
    int filePages = 0;
    if(fileRow.getAttribute("FilePath") == null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      return;
    }
    if(currentRow != null)
    {
      currentRow.setAttribute("RowUpdateFl", new BigDecimal(0));
      endPage = DBUtil.nvl(currentRow.getAttribute("EndPage"), 0);
      filePages = DBUtil.nvl(fileRow.getAttribute("NoOfPages"), 0);
    }
    
    int currentIndex = vo.getRangeIndexOf(currentRow);  
    Row row = vo.createRow();
    if(currentRow != null)
    {
      if(endPage >=  filePages)
      {
        GenLib.showErrorMessage("error.lastPageIndex");
        return;
      }
      row.setAttribute("StartPage", new BigDecimal(endPage+1));
    }
    else
    {
      row.setAttribute("StartPage", new BigDecimal(1));
    }
    row.setAttribute("RowUpdateFl", new BigDecimal(1));
    vo.insertRowAtRangeIndex(currentIndex+1, row);
  }

  private void insertArcOldDocument(Row row, String newFilePath)
  {
    
    if (row.getAttribute("DisplayDocumentSubject")==null )
    {
      GenLib.showErrorMessage("error.DisplayDocumentSubjectRequired");
      throw new JboException("");
    }
    if (row.getAttribute("DocReceiveDate")==null )
    {
      GenLib.showErrorMessage("error.DocReceiveDateRequired");
      throw new JboException("");
    }
    if (row.getAttribute("DocumentSecurityFk")==null )
    {
      GenLib.showErrorMessage("error.DocumentSecurityFkRequired");
      throw new JboException("");
    }
    if (row.getAttribute("DocumentTypeFk")==null )
    {
      GenLib.showErrorMessage("error.DocumentTypeFkRequired");
      throw new JboException("");
    }
    if (row.getAttribute("DocumentAttachTypeFk")==null )
    {
      GenLib.showErrorMessage("error.DocumentAttachTypeFkRequired");
      throw new JboException("");
    }
    
    ViewObject oldDocumentView = ADFUtils.getViewObjectFromAppModule("ArcOldDocumentView1");
    ViewObject attachView = ADFUtils.getViewObjectFromAppModule("ArcDocumentAttachmentView2");
    Row oldDocumentRow = oldDocumentView.createRow();
    oldDocumentRow.setAttribute("DisplayDocumentSubject", row.getAttribute("DisplayDocumentSubject"));
    oldDocumentRow.setAttribute("DocReceiveDate", row.getAttribute("DocReceiveDate"));
    oldDocumentRow.setAttribute("DocumentSecurityFk", row.getAttribute("DocumentSecurityFk"));
    oldDocumentRow.setAttribute("DocumentTypeFk", row.getAttribute("DocumentTypeFk"));
    oldDocumentRow.setAttribute("DocumentNumber", row.getAttribute("DocumentNumber"));
    oldDocumentRow.setAttribute("EmployeesFk", row.getAttribute("EmployeesFk"));
    oldDocumentRow.setAttribute("FilesLocationFk", row.getAttribute("FileLocation"));


    oldDocumentView.insertRow(oldDocumentRow);
    ADFUtils.commitWithoutMessage();
    Row attachRow = attachView.createRow();
    attachRow.setAttribute("FilePath", newFilePath);
    attachRow.setAttribute("DocumentSecurityFk", row.getAttribute("DocumentSecurityFk"));
    attachRow.setAttribute("DocumentAttachTypeFk", row.getAttribute("DocumentAttachTypeFk"));

    attachView.insertRow(attachRow);
  }
  
  public static boolean deletePage(String pdfPath, int pageIndex) 
  {
    FileInputStream in = null;
    try
    {
      in = new FileInputStream(pdfPath);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    PDFReader reader = null;
    try
    {
      reader = new PDFReader(in);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    try
    {
      in.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
    PDF pdf = new PDF(reader); 
    
    if ( pdf.getPages() != null && pdf.getPages().size() > pageIndex )
    {
      pdf.getPages().remove(pageIndex);
    }
    else
    {
      return true;
    }
    try
    {
      OutputStream out = new FileOutputStream(pdfPath);
      pdf.render(out);
      pdf.close();
      out.close();
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }
  
  public static void rotatePage(String pdfPath, int pageIndex, int orientation) 
  {
    FileInputStream in = null;
    
    try
    {
      in = new FileInputStream(pdfPath);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return;
    }
    
    PDFReader reader = null;
    
    try
    {
      reader = new PDFReader(in);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    PDF pdf = new PDF(reader); 
    PDFPage page = pdf.getPage(pageIndex);
    page.setPageOrientation(page.getPageOrientation() + orientation);
    
    try{
    OutputStream out = new FileOutputStream(pdfPath);
    pdf.render(out);
    pdf.close();
    out.close();
    in.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("oracle.jdeveloper.java.unchecked-conversion-or-cast")
  public static void addPage( String pdfPath, PDFPage page, int pageIndex)
  {
    FileInputStream in = null;
    PDFReader reader = null;
    try
    {
      in = new FileInputStream(pdfPath);
      reader = new PDFReader(in);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    PDF pdf = new PDF(reader);   
    pdf.getPages().add(pageIndex, page);
    
    try
    {
      pdf.render(new FileOutputStream(pdfPath));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public int getPageIndex()
  {
    if(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "PageNumber") != null)
    {
      return DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "PageNumber"), 0);       
    }
      if(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "PageNumber") == null)
 
    {
      GenLib.showErrorMessage("error.PageNumberRequired");
      throw new JboException("");
    }
    
    return 0;  
  }
  
  public void setDoc(RichDocument doc)
  {
    this.doc = doc;
  }

  public RichDocument getDoc()
  {
    return doc;
  }

  public void setFullFilePath(String fullFilePath)
  {
    this.fullFilePath = fullFilePath;
  }

  public String getFilePath()
  {
    return (String)ADFUtils.getAttribute("ReportParametersRVO1Iterator", "FilePath");
  }

  public String getFileName()
  {
    return (String)ADFUtils.getAttribute("ReportParametersRVO1Iterator", "FileName");
  }

  public void ClassificationChanged(ValueChangeEvent valueChangeEvent)
  {
    int filePages = DBUtil.nvl(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "NoOfPages"), 0);
    int newValue = DBUtil.nvl(valueChangeEvent.getNewValue(), 0);
    if(newValue > filePages)
    {
      ((UIXEditableValue)valueChangeEvent.getComponent()).resetValue();
      valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
      GenLib.showErrorMessage("error.lastPageIndex");
      RequestContext.getCurrentInstance().addPartialTarget(ADFUtils.findComponentInRoot("it4"));
    }
    
  }

  public void reverseOrder(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") ActionEvent actionEvent)
  {
    if (getFilePath()==null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      throw new JboException("");

    }
    PDFReader reader = null;
    FileInputStream in = null;
    boolean isOk = false;
    
    try
    {
      in = new FileInputStream(getFileName());
      reader = new PDFReader(in);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    PDF pdf = new PDF(reader);

    List <PDFPage> pages = new ArrayList <PDFPage>();
    for(int i = 0; i < pdf.getPages().size() ; i++)
    { 
      pages.add(new PDFPage(pdf.getPage(i)));
    }
    int lastIndex = pdf.getPages().size();
    int lastNewIndex = lastIndex + pages.size();
    int j = pages.size() - 1;

    for(int x = lastIndex  ; x < lastNewIndex; x++)
    {      
      addPage(getFileName(), pages.get(j), x);
      j--;
    }   
    for(int i = 0; i < pdf.getPages().size() ; i++)
    { 
      isOk = deletePage(getFileName(), 0);
      if(!isOk)
      {
        return;
      }  
    }
  }
  
  public String getOCR()
  {
    if (getFilePath() == null)
    {
      GenLib.showErrorMessage("error.noFileSelected");
      return null;
    }
    
    String langIsoCode = GenConstants.ARABIC_ISO_CODE;
    
    if(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "LangISOCode") != null)
    {
      langIsoCode = ADFUtils.getAttribute("ReportParametersRVO1Iterator", "LangISOCode").toString();
    }
    if(ADFUtils.getAttribute("ReportParametersRVO1Iterator", "LangISOCode") == null)
    {
      GenLib.showErrorMessage("error.LangISOCode");
      return null;
    }

    try 
    {
      File imageFile = new File(getFileName());  
      ITesseract instance = new Tesseract();  // JNA Interface Mapping
      instance.setLanguage(langIsoCode);
      instance.setDatapath(GenLib.getOCRConfigFilePath()); // path to tessdata directory
      String result = "";
      result = instance.doOCR(imageFile);
      ADFUtils.setAttribute("ReportParametersRVO1Iterator", "OCRText", result);
    } 
    catch (Exception e) 
    {
      //System.err.println(e.getMessage());
      GenLib.handleException(e);
    }
    return null;  
  }
  
  public String addWaterMark() 
  {
    //for test only
    Document doc = new Document(getFileName());
    FormattedText formattedText = new FormattedText("Mostafa Shaker", Color.red,FontStyle.CourierOblique, EncodingType.Cp1252, true, 40.0F);
    formattedText.addNewLineText("        ");
    WatermarkArtifact artifact = new WatermarkArtifact();        
    artifact.setText(formattedText);   
    artifact.setArtifactHorizontalAlignment (HorizontalAlignment.Center);
    artifact.setArtifactVerticalAlignment (VerticalAlignment.Center);
    artifact.setRotation (45);
    artifact.setOpacity (0.5);

    int pageNo = doc.getPages().size();
    for(int i = 1; i <= pageNo; i++)
    {
      doc.getPages().get_Item(i).getArtifacts().add(artifact);
    }
    
    doc.save("C:\\erp\\test2.pdf");
      
    return null;
  }
  
  public String otherWaterMark()
  {
    FileInputStream in = null;
    PDFReader reader = null; 
    try
    {
      in = new FileInputStream(getFileName());
      reader = new PDFReader(in);
      PDF pdf = new PDF(reader); 
      int pdfSize = pdf.getPages().size();
      PDFStyle style = new PDFStyle();
      style.setFillColor(new Color(0xCCCCCC, false));
      style.setFont(new StandardFont(StandardFont.HELVETICA), 40);
      style.setTextAlign(PDFStyle.TEXTALIGN_CENTER);
      style.setBlendMode("Multiply");
      for(int i = 0; i < pdfSize; i++)
      {
        PDFPage page = pdf.getPage(i);
        page.save();
        page.setStyle(style);
        float x = page.getWidth() / 2;
        float y = page.getHeight() / 2;
        page.rotate(x, y, 20);
        page.drawText(GenLib.getWaterMarkText(), x, y);
        page.restore();
      }
      OutputStream out = new FileOutputStream(getFileName());
      pdf.render(out);
      pdf.close();
      out.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
    return null;
  }
  
  public void updateFilesLocationFk(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") DialogEvent dialogEvent)
  {
    Object FilesLocationPk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "FilesLocationPk");
    Object DisplayFilesLocationFk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "DisplayFileLocationDesc");
    
    ADFUtils.setAttribute("ArcClassificationPVO1Iterator", "FileLocation", FilesLocationPk);
    ADFUtils.setAttribute("ArcClassificationPVO1Iterator", "DisplayFileLocation", DisplayFilesLocationFk); 
  }
  
  public void cancelTranslation(PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcClassificationPVO1Iterator");
  }

  public void rollback(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter") ActionEvent actionEvent)
  {
    ViewObject vo1 = ADFUtils.findIterator("ArcClassificationPVO1Iterator").getViewObject();
    vo1.setRangeSize(-1);
    Row[] rows1 = vo1.getAllRowsInRange();
    
    for(int i = 0; i < rows1.length ; i++)
    {
      rows1[i].remove();     
    }
  }
  
  public static void main(String[] args)
  throws Exception
  {
    //deletePage("d:\\a.pdf", 14);
    //addPDFFile(14, "d:\\b.pdf", "d:\\fin.pdf");
    //File imageFile = new File("D:\\mytemp\\p.pdf");  
    //ITesseract instance = new Tesseract();  // JNA Interface Mapping
    //instance.setLanguage(GenConstants.ARABIC_ISO_CODE);
    //instance.setDatapath(GenLib.getOCRConfigFilePath()); // path to tessdata directory
    //String result = instance.doOCR(imageFile);
    //System.out.println(result);
    
    Document document = new Document("D:\\mytemp\\a.pdf");
    document.save("D:\\mytemp\\a.docx", SaveFormat.DocX);
  }
}