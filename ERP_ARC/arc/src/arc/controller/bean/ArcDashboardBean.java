package arc.controller.bean;

import com.sd.util.adf.ADFUtils;

import gen.common.GenLib;

import java.sql.Timestamp;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;


public class ArcDashboardBean extends ArcBaseBean
{

  private RichDocument arcDash;

  public String GetData()
  {
    java.util.Date AddOneDayToDate= null  ; 
    Timestamp DateTo = (Timestamp) ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DateTo");
    if (DateTo != null)
    {
     AddOneDayToDate = addDays(DateTo, 1);
    }
    ViewObjectImpl ArcOldDocumentDashboard =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("ArcOldDocumentDashboardRVO");
    ViewObjectImpl ArcFileLocationWithNoDocument =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("ArcFileLocationWithNoDocumentRVO");

    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_doc_year", ADFUtils.getAttribute("ReportParametersRVO1Iterator","YearFrom"));
    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_user_department_fk", ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DepartmentFrom"));
    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_employees_fk",ADFUtils.getAttribute("ReportParametersRVO1Iterator", "EmployeesFk"));
    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_files_location_fk", ADFUtils.getAttribute("ReportParametersRVO1Iterator","FilesLocationFk"));
    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_doc_receive_date_from",ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DateFrom"));
    ArcOldDocumentDashboard.setNamedWhereClauseParam("p_doc_receive_date_to",AddOneDayToDate );
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_doc_year", ADFUtils.getAttribute("ReportParametersRVO1Iterator","YearFrom"));
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_user_department_fk", ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DepartmentFrom"));
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_employees_fk",ADFUtils.getAttribute("ReportParametersRVO1Iterator", "EmployeesFk"));
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_files_location_fk", ADFUtils.getAttribute("ReportParametersRVO1Iterator","FilesLocationFk"));
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_doc_receive_date_from",ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DateFrom"));
    ArcFileLocationWithNoDocument.setNamedWhereClauseParam("p_doc_receive_date_to",AddOneDayToDate );
    ArcOldDocumentDashboard.executeQuery();
    ArcFileLocationWithNoDocument.executeQuery();

    return null;
  }

  public void setArcDash(RichDocument arcDash)
  {
    this.arcDash = arcDash;
  }

  public RichDocument getArcDash()
  {
    return arcDash;
  }
}
