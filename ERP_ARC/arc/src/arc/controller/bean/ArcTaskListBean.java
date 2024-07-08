package arc.controller.bean;


import com.sd.util.adf.ADFUtils;
import com.sd.util.adf.JSFUtils;

import gen.common.GenLib;

import gen.jbpm.JbpmConstants;

import java.math.BigDecimal;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.context.RequestContext;

public class ArcTaskListBean extends ArcBaseBean
{
  public ArcTaskListBean()
  {
    if ( !AdfFacesContext.getCurrentInstance().isPostback() )
    {
      String refreshBPMIterator = (String)JSFUtils.getFromSession("refreshBPMIterator");
      System.err.println("refreshBPMIterator : "+ refreshBPMIterator);
      ViewObject vo = ADFUtils.getViewObjectFromAppModule("BPMProcessTaskRVO1");
      String departmentFilterClause = GenLib.getFilterByDepartmentWhereClause("REQUEST_DEPARTMENTS_FK");
      System.err.println("departmentFilterClause : "+departmentFilterClause);
      String categoriesFilterClause = GenLib.getFilterByCategoryWhereClause("REQUEST_CATEGORIES_FK");
      String securityLevelFilterClause = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("REQUEST_SECURITY_FK");
      String statusClause = "STATUS != '" + JbpmConstants.COMPLETED_STATUS  + "'";
      String privilegesActorClause = " ENTITY_ID IN (SELECT GET_ACTOR_ID(PROCESS_ACTOR_FK) " +     
                                     "  FROM BPM_PROCESS_PRIVILEGES WHERE GROUPS_FK IN (SELECT GROUPS_PK FROM SSO_USER_PRIVIGE_GROUPS_VW WHERE USERS_PK = "+ GenLib.getUserPk() +" )  )";
    
      String deptManagerClause = "";
      BigDecimal employeesPk = GenLib.getEmployeesPk();
      if(employeesPk == null)
      {
        deptManagerClause = "1 != 1";
      }
      else
      {
        deptManagerClause = 
         " (" + GenLib.getEmployeesPk() + " = (select DEPT_MANAGER_FK " +
         " from HCM_DEPARTMENTS " + 
         " where DEPARTMENTS_PK = REQUEST_DEPARTMENTS_FK and DEPT_STATUS_FL = 1) " + 
         " and  ENTITY_ID in( select ACTORS_FK  FROM BPM_PROCESS_ACTORS " +
         "       WHERE DEPT_MANAGER_FL = 1 and PROCESSES_FK = PROCESSID))";
      }
  
      System.err.println("privilegesActorClause : "+privilegesActorClause);
      String whereClause = statusClause + 
                           " and (" + privilegesActorClause +
                           " or " + deptManagerClause + " )" +
                           " and (" + departmentFilterClause + ") " +
                           " and (" + categoriesFilterClause + ") " +
                           " and (" + securityLevelFilterClause + ")";
      if(refreshBPMIterator != null && refreshBPMIterator.equals("true"))
      {
        System.err.println("refreshBPMIterator1 : "+refreshBPMIterator);
        setEmptyTaskFlow();
        //DynamicRegionBean.taskFlowId = "/WEB-INF/NoDataTF.xml#NoDataTF";
        vo.setWhereClause(whereClause);
        vo.executeQuery();
        //ADFUtils.findIterator("BPMProcessTaskRVO1Iterator").executeQuery();     
        JSFUtils.storeOnSession("refreshBPMIterator", null);
        RequestContext.getCurrentInstance().addPartialTarget(ADFUtils.findComponentInRoot("t1"));
      }
      if (!AdfFacesContext.getCurrentInstance().isPostback())
      {
        System.err.println("refreshBPMIterator2 : "+refreshBPMIterator);
     
        // changed in genlib
        vo.setWhereClause(whereClause);
        vo.executeQuery();
        setEmptyTaskFlow();
        //DynamicRegionBean.taskFlowId = "/WEB-INF/NoDataTF.xml#NoDataTF";
      }
    }
  }

  private RichDocument doc1;

//  public void viewRequestHistory(ActionEvent actionEvent)
//  {
//
//    BigDecimal perocessInstanceId = (BigDecimal) 
//     ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator","Processinstanceid");
//    ViewObject vo = ADFUtils.getViewObjectFromAppModule("BPMProcessTaskRVO2");
//    vo.setWhereClause("PROCESSINSTANCEID = " + perocessInstanceId);
//    vo.executeQuery();
//    ADFUtils.showPopup("page1:RequestHistoryPopup");
//  }

  public void setDoc1(RichDocument doc1)
  {
    this.doc1 = doc1;
  }

//  public void inboxSelectionLSNR(SelectionEvent selectionEvent)
//  {
//    System.err.println("inboxSelectionLSNR bean");
//    Util.invokeMethod("#{bindings.BPMProcessTaskRVO1." +
//     "collectionModel.makeCurrent}", null,
//     new Class[] {SelectionEvent.class}, 
//     new Object[] {selectionEvent});
//    Object currentPk = (Object) JSFUtils.getFromSession("BPMRequestsPk");
//    Object borrowRequestsPk = (Object)
//     ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator",
//     "RequestPk");
//    JSFUtils.storeOnSession("Processinstanceid", ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator",
//     "Processinstanceid"));
//    System.err.println("inboxSelectionLSNR : bean");
//    if(currentPk != null && currentPk.equals(borrowRequestsPk))
//    {
//      return;
//    }
//
//     JSFUtils.storeOnSession("BPMRequestsPk", 
//      borrowRequestsPk.toString());
//     JSFUtils.storeOnSession("BPMUserName", 
//      ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator",
//      "EntityId"));      
//     JSFUtils.storeOnSession("TaskId", ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator", "TaskId"));
//     String taskFlowId = (String) 
//      ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator",
//      "TaskflowId");
//     super.taskFlowId = "/WEB-INF/" + taskFlowId + ".xml#" + taskFlowId;
////     DynamicRegionBean.taskFlowId = "/WEB-INF/" + taskFlowId + ".xml#" + taskFlowId;         
//     viewRequest(
//      (String) ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator", "Processid"), 
//      (String) ADFUtils.getAttribute("BPMProcessTaskRVO1Iterator", "TaskName"));
//  }

  public RichDocument getDoc1()
  {
    return doc1;
  }

}
