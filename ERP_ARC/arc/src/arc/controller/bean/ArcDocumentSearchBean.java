package arc.controller.bean;

import arc.common.ControllerUtil;

import com.sd.util.adf.JSFUtils;

import gen.common.GenLib;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;


public class ArcDocumentSearchBean
  extends ArcBaseBean
{
  private RichDocument doc;

  public ArcDocumentSearchBean()
  {
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    {
      ControllerUtil.filterArcSecurityLevelsAndDepartments("ArcOldDocumentView1Iterator");
      GenLib.filterDocumentsBySecurityLevels("ArcDocumentAttachmentView1Iterator");
    }
  }

  public void downloadDocumentAttachment(FacesContext context, OutputStream os)
  {
    //downloadFileWithWaterMarks(context, os, (String)JSFUtils.getFromSession("fullPath"));
    String fullPath = (String)JSFUtils.getFromSession("fullPath");
    System.err.println("downloadDocumentAttachment fullPath : "+fullPath);
    downloadFileWithWaterMarks(context, os, fullPath);
  }

  public void setDoc(RichDocument doc)
  {
    this.doc = doc;
  }

  public RichDocument getDoc()
  {
    return doc;
  }


}
