package arc.controller.bean;

import arc.common.ControllerUtil;

import com.sd.util.adf.ADFUtils;

import com.sd.util.adf.JSFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenLib;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;


public class DisposedDocumentsBean
  extends ArcBaseBean
{
  private RichDocument arc;

  public DisposedDocumentsBean()
  {
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    {
      ControllerUtil.filterArcSecurityLevelsAndDepartmentsAndDisposedFl("ArcOldDocumentView2Iterator");
      GenLib.filterDocumentsBySecurityLevels("ArcDocumentAttachmentView1Iterator");

    }
  }

  public void disposedDocumentsUpdate(DialogEvent dialogEvent)
  {

    Row[] ArcOldDocumentRows = ADFUtils.findIterator("ArcOldDocumentView2Iterator").getAllRowsInRange();
    for (int i = 0; i < ArcOldDocumentRows.length; i++)
    {
      Object DisposedFl = DBUtil.nvl(ArcOldDocumentRows[i].getAttribute("DisposedFl"), 0);
      if (DisposedFl.equals(1))
      {
        String  disposedCommitteMembers =   (String)ADFUtils.getAttribute("ArcOldDocumentView2Iterator", "DisplaydisposedCommitteMembers");
        System.out.println(disposedCommitteMembers);
        BigDecimal  disposedDecisionNo =   (BigDecimal)ADFUtils.getAttribute("ArcOldDocumentView2Iterator", "DisplaydisposedDecisionNo");
        Timestamp  disposedDecisionDateG =   (Timestamp)ADFUtils.getAttribute("ArcOldDocumentView2Iterator", "DisplaydisposedDecisionDateG");

        ArcOldDocumentRows[i].setAttribute("DisposedCommitteMembers", disposedCommitteMembers);
        ArcOldDocumentRows[i].setAttribute("DisposedDecisionNo", disposedDecisionNo);
        ArcOldDocumentRows[i].setAttribute("DisposedDecisionDateG", disposedDecisionDateG);
        ArcOldDocumentRows[i].setAttribute("DisposalDate", GenLib.getCurrentDate());
        ArcOldDocumentRows[i].setAttribute("DisposedBy", GenLib.getUserPk());
        ArcOldDocumentRows[i].setAttribute("OriginalDocumentDisposedFl", new BigDecimal(1));
        
        if (disposedDecisionDateG!=null && GenLib.getCurrentDate()!=null)
        {
          if (disposedDecisionDateG.compareTo(GenLib.getCurrentDate())==1)
          {
            GenLib.showErrorMessage("error.CurrentDate");
            throw new JboException("");

          }
        }
      }
    }
    ADFUtils.commitWithoutMessage();
    ADFUtils.findIterator("ArcOldDocumentView2Iterator").executeQuery();
  }
  
  
  
  public void cancelTranslation(PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcOldDocumentView2Iterator");
  }
  
  public void downloadDocumentAttachment(FacesContext context, OutputStream os)
  {
    downloadFile(context, os, "ArcDocumentAttachmentView1Iterator", "FilePath");
  }

  public void setArc(RichDocument arc)
  {
    this.arc = arc;
  }

  public RichDocument getArc()
  {
    return arc;
  }

}
