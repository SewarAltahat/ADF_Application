package arc.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;

import gen.common.GenLib;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.event.DialogEvent;


public class BorrowRequestsBean extends ArcBaseBean
{

  private RichDocument doc1;


  public void displayRequestReasonChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcBorrowRequestsView1Iterator", "BorrowRequestsPk", "ArcBorrowRequestsTlView2Iterator", "RequestReason");
  }

  public void displayNotesChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcBorrowRequestsView1Iterator", "BorrowRequestsPk", "ArcBorrowRequestsTlView2Iterator", "Notes");
  }

  public void commitArcBorrowRequestsTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcBorrowRequestsView1Iterator");
  }

  public void cancelArcBorrowRequestsTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcBorrowRequestsView1Iterator");
  }
    
  public String rollbackAction()
  {
    ADFUtils.rollback();
    ADFUtils.executeOperator("CreateInsert1");
    
    return null;
  }

  public void deleteDocDialogListener(@SuppressWarnings("oracle.jdeveloper.java.unused-parameter")
                                      DialogEvent dialogEvent)
  {
    String key = ADFUtils.findIterator("ArcBorrowRequestsView1Iterator").getCurrentRowWithKeyValue();
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
      ADFUtils.findIterator("ArcBorrowRequestsView1Iterator").setCurrentRowWithKey(key);
      ADFUtils.hidePopup("page1:deleteDocPopup");
      return;
    }
  }

  public void showConfirmDelete(@SuppressWarnings("unused") ActionEvent ae)
  {
    showPopup("deleteDocPopup");
  }
  
  public String sendAction()
  {
   JSFUtils.refreshPage(); 
    return null;
  }
  
  @Override
  public void completeProcess(ActionEvent actionEvent)
  {
    // TODO Implement this method
    super.completeProcess(actionEvent);
    Boolean finalStep = (Boolean)JSFUtils.getFromSession("v_final_step");
    String Status  = (String)JSFUtils.getFromSession("approveStatus");
    if(Status == null)
    {
      System.err.println("Approve Status Null");   
    }
    else
    {
    Boolean approveStatus = new Boolean(Status);
    if(finalStep != null && finalStep.equals(true))
    {
      if(approveStatus != null && approveStatus.equals(true))
      {
        System.err.println("Final Step Business approved : Implement Youe Code");
        System.err.println("Final Step Business approved : Implement Youe Code");
        System.err.println("Final Step Business approved : Implement Youe Code");
      }
      else
      {
        System.err.println("Final Step Business reject : Implement Youe Code");
        System.err.println("Final Step Business reject : Implement Youe Code");
        System.err.println("Final Step Business reject : Implement Youe Code");
      }
    } 
    }
  }
  
  public void setDoc1(RichDocument doc1)
  {
    this.doc1 = doc1;
  }

  public RichDocument getDoc1()
  {
    return doc1;
  }

}
