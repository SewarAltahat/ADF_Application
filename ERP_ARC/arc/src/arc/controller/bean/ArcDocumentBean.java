package arc.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;

import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.context.RequestContext;

public class ArcDocumentBean extends ArcBaseBean
{
  private RichDocument doc;
  private RichOutputText displayFileLocation;

  public ArcDocumentBean()
  {
    BigDecimal OldDocumentPk = (BigDecimal) ADFUtils.getAttribute("ArcOldDocumentView1Iterator", "OldDocumentPk");
    
    if (OldDocumentPk != null)
    {
      if (!AdfFacesContext.getCurrentInstance().isPostback())
      {
        GenLib.filterDocumentsBySecurityLevels("ArcDocumentAttachmentView1Iterator");
      }
    }
  }
  
  public void displayDocumentSubjectChanged(ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcOldDocumentView1Iterator", "OldDocumentPk", "ArcOldDocumentTlView1Iterator",
                             "DocumentSubject");
  }
  
  public void displayDocumentDescriptionChanged(ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcOldDocumentView1Iterator", "OldDocumentPk", "ArcOldDocumentTlView1Iterator",
                             "DocumentDescription");
  }
  
  public void displayDocumentCommentChanged(ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcOldDocumentView1Iterator", "OldDocumentPk", "ArcOldDocumentTlView1Iterator",
                             "DocumentComment");
  }
  
  public void displayDocumentAttachDescriptionChanged(ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcDocumentAttachmentView1Iterator", "DocumentAttachmentPk",
                             "ArcDocumentAttachmentTlView3Iterator", "DocumentAttachDescription");
  }
  
  public void commitTranslation(DialogEvent de)
  {
    commitTranslationWithRowKey(de, "ArcOldDocumentView1Iterator", ADFUtils.findIterator("ArcOldDocumentView1Iterator").getCurrentRow().getAttribute("OldDocumentPk")+"");
  }
  
  public void commitTranslation1(DialogEvent de)
  {
    commitTranslation(de, "ArcDocumentAttachmentView1Iterator");
  }
  
  public String  originalDocumentDisposedFlChanged()
  {
    //vce.getComponent().processUpdates(FacesContext.getCurrentInstance());

    BigDecimal originalDocumentDisposedFl =
      (BigDecimal) ADFUtils.getAttribute("ArcOldDocumentView1Iterator", "OriginalDocumentDisposedFl");
    
    if (originalDocumentDisposedFl != null && originalDocumentDisposedFl.intValue() == 1)
    {
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisposedBy", GenLib.getUserPk());
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisplayDisposedBy", GenLib.getUserFullName());
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisposalDate", GenLib.getCurrentDate());
    }
    else
    {
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisposedBy", null);
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisplayDisposedBy", null);
      ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisposalDate", null);
    }
    return null ; 
  }
  
  public String rollbackAction()
  {
    ADFUtils.rollback();
    ADFUtils.executeOperator("CreateInsert1");
    
    return null;
  }
  
  public void downloadDocumentAttachment(FacesContext context, OutputStream os)
  {
    downloadFile(context, os, "ArcDocumentAttachmentView1Iterator", "FilePath");
  }
  
  public void uploadDocumentAttachment(ValueChangeEvent valueChangeEvent)
  {
    uploadFile(valueChangeEvent, "ArcDocumentAttachmentView1Iterator", "FilePath");
  }
  
  public void deleteDocDialogListener(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                      DialogEvent dialogEvent)
  {
    //deleteDialogListener(dialogEvent);
    //rollbackAction();
    String key = ADFUtils.findIterator("ArcOldDocumentView1Iterator").getCurrentRowWithKeyValue();
    ADFUtils.executeOperator("Delete1");
    JSFUtils.storeOnSession("isDeleted", "Y");

    try
    {
      ADFUtils.commit();
      ADFUtils.executeOperator("CreateInsert1");
    }
    catch (Exception e)
    {
      ADFUtils.rollback();
      GenLib.showErrorMessage("label.noDeleteReference");
      ADFUtils.findIterator("ArcOldDocumentView1Iterator").setCurrentRowWithKey(key);
      ADFUtils.hidePopup("page1:deleteDocPopup");
      return;
    }
  }
  
  public void showConfirmDelete(ActionEvent ae)
  {
    showPopup("deleteDocPopup");
  }
  
  public void refreshFromScanner(ClientEvent clientEvent)
  {
    String fileName = (String) clientEvent.getParameters().get("currentFileName");
    fileName = GenLib.getUploadPathSuffix() + fileName + ".pdf";
    Row row = ADFUtils.findIterator("ArcDocumentAttachmentView1Iterator").getViewObject().getCurrentRow();
   
    if(row == null)
    {
      GenLib.showErrorMessage("error.insertAttachment");
      return; 
    }
    row.setAttribute("FilePath", fileName); 
    RequestContext.getCurrentInstance().addPartialTarget(ADFUtils.findComponentInRoot("ArcDocumentAttachment1"));
  }
  
  public void setDoc(RichDocument doc)
  {
    this.doc = doc;
  }

  public RichDocument getDoc()
  {
    return doc;
  }
  
  public void cancelTranslation(PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcOldDocumentView1Iterator");
  }
  
  public void cancelTranslationAttachment(PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcDocumentAttachmentView1Iterator");
  }

  public void updateFilesLocationFk(DialogEvent dialogEvent)
  {
    Object FilesLocationPk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "FilesLocationPk");
    Object DisplayFilesLocationFk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "DisplayFileLocationDesc");

    ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "FilesLocationFk", FilesLocationPk);
    ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisplayFilesLocationFk", DisplayFilesLocationFk); 
  }
}
