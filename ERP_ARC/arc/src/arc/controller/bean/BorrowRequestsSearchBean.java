package arc.controller.bean;

import arc.common.ControllerUtil;

import com.sd.util.adf.ADFUtils;

import gen.common.GenLib;

import java.math.BigDecimal;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;


public class BorrowRequestsSearchBean extends ArcBaseBean
{
  private RichDocument borrowsearch;

  public BorrowRequestsSearchBean()
  {
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    {
      GenLib.filterByDepartmentsHierarchy("ArcBorrowRequestsView1Iterator",
       "USER_DEPARTMENT_FK");


    }
  }
  public void viewHistory(ActionEvent actionEvent)
  {
    BigDecimal taskId = (BigDecimal) ADFUtils.getAttribute(
     "ArcBorrowRequestsView1Iterator", "BpmTaskId");
    ViewObject vo = ADFUtils.getViewObjectFromAppModule("BPMProcessTaskRVO2");
    vo.setWhereClause("PROCESSINSTANCEID = " +
     "(select PROCESSINSTANCEID from task where id = " + taskId + ")");
    vo.executeQuery();
    ADFUtils.showPopup("page1:RequestHistoryPopup");
  }

  public void setBorrowsearch(RichDocument borrowsearch)
  {
    this.borrowsearch = borrowsearch;
  }

  public RichDocument getBorrowsearch()
  {
    return borrowsearch;
  }
}
