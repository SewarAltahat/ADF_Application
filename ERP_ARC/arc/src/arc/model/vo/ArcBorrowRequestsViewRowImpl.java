package arc.model.vo;

import arc.model.eo.ArcBorrowRequestsImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Aug 27 12:10:13 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcBorrowRequestsViewRowImpl
  extends ViewRowImpl
{


  public static final int ENTITY_ARCBORROWREQUESTS = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    BorrowRequestsPk,
    OldDocumentFk,
    RequestPeriod,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    RequestStatusFk,
    DisplayOldDocumentFk,
    DisplayOldDocumentFkSearch,
    DisplayRequestReason,
    DisplayRequestReasonSearch,
    DisplayNotes,
    DisplayNotesSearch,
    OldDocumentFkSearch,
    Processinstanceid,
    BpmTaskId,
    ReturnDate,
    TaskComment,
    DocumentSecurityFk,
    EmployeesFk,
    ArcBorrowRequestsTlView,
    ArcOldDocumentRVO;
    private static AttributesEnum[] vals = null;
    ;
    private static final int firstIndex = 0;

    protected int index()
    {
      return AttributesEnum.firstIndex() + ordinal();
    }

    protected static final int firstIndex()
    {
      return firstIndex;
    }

    protected static int count()
    {
      return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
    }

    protected static final AttributesEnum[] staticValues()
    {
      if (vals == null)
      {
        vals = AttributesEnum.values();
      }
      return vals;
    }
  }


  public static final int BORROWREQUESTSPK = AttributesEnum.BorrowRequestsPk.index();
  public static final int OLDDOCUMENTFK = AttributesEnum.OldDocumentFk.index();
  public static final int REQUESTPERIOD = AttributesEnum.RequestPeriod.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int REQUESTSTATUSFK = AttributesEnum.RequestStatusFk.index();
  public static final int DISPLAYOLDDOCUMENTFK = AttributesEnum.DisplayOldDocumentFk.index();
  public static final int DISPLAYOLDDOCUMENTFKSEARCH = AttributesEnum.DisplayOldDocumentFkSearch.index();
  public static final int DISPLAYREQUESTREASON = AttributesEnum.DisplayRequestReason.index();
  public static final int DISPLAYREQUESTREASONSEARCH = AttributesEnum.DisplayRequestReasonSearch.index();
  public static final int DISPLAYNOTES = AttributesEnum.DisplayNotes.index();
  public static final int DISPLAYNOTESSEARCH = AttributesEnum.DisplayNotesSearch.index();
  public static final int OLDDOCUMENTFKSEARCH = AttributesEnum.OldDocumentFkSearch.index();
  public static final int PROCESSINSTANCEID = AttributesEnum.Processinstanceid.index();
  public static final int BPMTASKID = AttributesEnum.BpmTaskId.index();
  public static final int RETURNDATE = AttributesEnum.ReturnDate.index();
  public static final int TASKCOMMENT = AttributesEnum.TaskComment.index();
  public static final int DOCUMENTSECURITYFK = AttributesEnum.DocumentSecurityFk.index();
  public static final int EMPLOYEESFK = AttributesEnum.EmployeesFk.index();
  public static final int ARCBORROWREQUESTSTLVIEW = AttributesEnum.ArcBorrowRequestsTlView.index();
  public static final int ARCOLDDOCUMENTRVO = AttributesEnum.ArcOldDocumentRVO.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcBorrowRequestsViewRowImpl()
  {
  }

  /**
   * Gets ArcBorrowRequests entity object.
   * @return the ArcBorrowRequests
   */
  public ArcBorrowRequestsImpl getArcBorrowRequests()
  {
    return (ArcBorrowRequestsImpl) getEntity(ENTITY_ARCBORROWREQUESTS);
  }

  /**
   * Gets the attribute value for BORROW_REQUESTS_PK using the alias name BorrowRequestsPk.
   * @return the BORROW_REQUESTS_PK
   */
  public BigDecimal getBorrowRequestsPk()
  {
    return (BigDecimal) getAttributeInternal(BORROWREQUESTSPK);
  }

  /**
   * Sets <code>value</code> as attribute value for BORROW_REQUESTS_PK using the alias name BorrowRequestsPk.
   * @param value value to set the BORROW_REQUESTS_PK
   */
  public void setBorrowRequestsPk(BigDecimal value)
  {
    setAttributeInternal(BORROWREQUESTSPK, value);
  }

  /**
   * Gets the attribute value for OLD_DOCUMENT_FK using the alias name OldDocumentFk.
   * @return the OLD_DOCUMENT_FK
   */
  public BigDecimal getOldDocumentFk()
  {
    return (BigDecimal) getAttributeInternal(OLDDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as attribute value for OLD_DOCUMENT_FK using the alias name OldDocumentFk.
   * @param value value to set the OLD_DOCUMENT_FK
   */
  public void setOldDocumentFk(BigDecimal value)
  {
    setAttributeInternal(OLDDOCUMENTFK, value);
  }

  /**
   * Gets the attribute value for REQUEST_PERIOD using the alias name RequestPeriod.
   * @return the REQUEST_PERIOD
   */
  public BigDecimal getRequestPeriod()
  {
    return (BigDecimal) getAttributeInternal(REQUESTPERIOD);
  }

  /**
   * Sets <code>value</code> as attribute value for REQUEST_PERIOD using the alias name RequestPeriod.
   * @param value value to set the REQUEST_PERIOD
   */
  public void setRequestPeriod(BigDecimal value)
  {
    setAttributeInternal(REQUESTPERIOD, value);
  }

  /**
   * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
   * @return the CREATED_BY
   */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
   * @param value value to set the CREATED_BY
   */
  public void setCreatedBy(BigDecimal value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
   * @return the CREATION_DATE
   */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for CREATION_DATE using the alias name CreationDate.
   * @param value value to set the CREATION_DATE
   */
  public void setCreationDate(Timestamp value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * Gets the attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @return the MODIFIED_BY
   */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_BY using the alias name ModifiedBy.
   * @param value value to set the MODIFIED_BY
   */
  public void setModifiedBy(BigDecimal value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * Gets the attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @return the MODIFIED_DATE
   */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for MODIFIED_DATE using the alias name ModifiedDate.
   * @param value value to set the MODIFIED_DATE
   */
  public void setModifiedDate(Timestamp value)
  {
    setAttributeInternal(MODIFIEDDATE, value);
  }

  /**
   * Gets the attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @return the USER_DEPARTMENT_FK
   */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as attribute value for USER_DEPARTMENT_FK using the alias name UserDepartmentFk.
   * @param value value to set the USER_DEPARTMENT_FK
   */
  public void setUserDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(USERDEPARTMENTFK, value);
  }

  /**
   * Gets the attribute value for REQUEST_STATUS_FK using the alias name RequestStatusFk.
   * @return the REQUEST_STATUS_FK
   */
  public BigDecimal getRequestStatusFk()
  {
    return (BigDecimal) getAttributeInternal(REQUESTSTATUSFK);
  }

  /**
   * Sets <code>value</code> as attribute value for REQUEST_STATUS_FK using the alias name RequestStatusFk.
   * @param value value to set the REQUEST_STATUS_FK
   */
  public void setRequestStatusFk(BigDecimal value)
  {
    setAttributeInternal(REQUESTSTATUSFK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayOldDocumentFk.
   * @return the DisplayOldDocumentFk
   */
  public String getDisplayOldDocumentFk()
  {
    return (String) getAttributeInternal(DISPLAYOLDDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayOldDocumentFk.
   * @param value value to set the  DisplayOldDocumentFk
   */
  public void setDisplayOldDocumentFk(String value)
  {
    setAttributeInternal(DISPLAYOLDDOCUMENTFK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayOldDocumentFkSearch.
   * @return the DisplayOldDocumentFkSearch
   */
  public String getDisplayOldDocumentFkSearch()
  {
    return (String) getAttributeInternal(DISPLAYOLDDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayOldDocumentFkSearch.
   * @param value value to set the  DisplayOldDocumentFkSearch
   */
  public void setDisplayOldDocumentFkSearch(String value)
  {
    setAttributeInternal(DISPLAYOLDDOCUMENTFKSEARCH, value);
  }

  /**
   * Gets the attribute value for DISPLAY_REQUEST_REASON using the alias name DisplayRequestReason.
   * @return the DISPLAY_REQUEST_REASON
   */
  public String getDisplayRequestReason()
  {
    return (String) getAttributeInternal(DISPLAYREQUESTREASON);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_REQUEST_REASON using the alias name DisplayRequestReason.
   * @param value value to set the DISPLAY_REQUEST_REASON
   */
  public void setDisplayRequestReason(String value)
  {
    setAttributeInternal(DISPLAYREQUESTREASON, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayRequestReasonSearch.
   * @return the DisplayRequestReasonSearch
   */
  public String getDisplayRequestReasonSearch()
  {
    return (String) getAttributeInternal(DISPLAYREQUESTREASON);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayRequestReasonSearch.
   * @param value value to set the  DisplayRequestReasonSearch
   */
  public void setDisplayRequestReasonSearch(String value)
  {
    setAttributeInternal(DISPLAYREQUESTREASONSEARCH, value);
  }

  /**
   * Gets the attribute value for DISPLAY_NOTES using the alias name DisplayNotes.
   * @return the DISPLAY_NOTES
   */
  public String getDisplayNotes()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_NOTES using the alias name DisplayNotes.
   * @param value value to set the DISPLAY_NOTES
   */
  public void setDisplayNotes(String value)
  {
    setAttributeInternal(DISPLAYNOTES, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayNotesSearch.
   * @return the DisplayNotesSearch
   */
  public String getDisplayNotesSearch()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayNotesSearch.
   * @param value value to set the  DisplayNotesSearch
   */
  public void setDisplayNotesSearch(String value)
  {
    setAttributeInternal(DISPLAYNOTESSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute OldDocumentFkSearch.
   * @return the OldDocumentFkSearch
   */
  public BigDecimal getOldDocumentFkSearch()
  {
    return (BigDecimal) getAttributeInternal(OLDDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute OldDocumentFkSearch.
   * @param value value to set the  OldDocumentFkSearch
   */
  public void setOldDocumentFkSearch(BigDecimal value)
  {
    setAttributeInternal(OLDDOCUMENTFKSEARCH, value);
  }

  /**
   * Gets the attribute value for PROCESSINSTANCEID using the alias name Processinstanceid.
   * @return the PROCESSINSTANCEID
   */
  public BigDecimal getProcessinstanceid()
  {
    return (BigDecimal) getAttributeInternal(PROCESSINSTANCEID);
  }

  /**
   * Sets <code>value</code> as attribute value for PROCESSINSTANCEID using the alias name Processinstanceid.
   * @param value value to set the PROCESSINSTANCEID
   */
  public void setProcessinstanceid(BigDecimal value)
  {
    setAttributeInternal(PROCESSINSTANCEID, value);
  }


  /**
   * Gets the attribute value for BPM_TASK_ID using the alias name BpmTaskId.
   * @return the BPM_TASK_ID
   */
  public BigDecimal getBpmTaskId()
  {
    return (BigDecimal) getAttributeInternal(BPMTASKID);
  }

  /**
   * Sets <code>value</code> as attribute value for BPM_TASK_ID using the alias name BpmTaskId.
   * @param value value to set the BPM_TASK_ID
   */
  public void setBpmTaskId(BigDecimal value)
  {
    setAttributeInternal(BPMTASKID, value);
  }

  /**
   * Gets the attribute value for RETURN_DATE using the alias name ReturnDate.
   * @return the RETURN_DATE
   */
  public Timestamp getReturnDate()
  {
    return (Timestamp) getAttributeInternal(RETURNDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for RETURN_DATE using the alias name ReturnDate.
   * @param value value to set the RETURN_DATE
   */
  public void setReturnDate(Timestamp value)
  {
    setAttributeInternal(RETURNDATE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute TaskComment.
   * @return the TaskComment
   */
  public String getTaskComment()
  {
    return (String) getAttributeInternal(TASKCOMMENT);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute TaskComment.
   * @param value value to set the  TaskComment
   */
  public void setTaskComment(String value)
  {
    setAttributeInternal(TASKCOMMENT, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DocumentSecurityFk.
   * @return the DocumentSecurityFk
   */
  public BigDecimal getDocumentSecurityFk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTSECURITYFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DocumentSecurityFk.
   * @param value value to set the  DocumentSecurityFk
   */
  public void setDocumentSecurityFk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTSECURITYFK, value);
  }

  /**
   * Gets the attribute value for EMPLOYEES_FK using the alias name EmployeesFk.
   * @return the EMPLOYEES_FK
   */
  public BigDecimal getEmployeesFk()
  {
    return (BigDecimal) getAttributeInternal(EMPLOYEESFK);
  }

  /**
   * Sets <code>value</code> as attribute value for EMPLOYEES_FK using the alias name EmployeesFk.
   * @param value value to set the EMPLOYEES_FK
   */
  public void setEmployeesFk(BigDecimal value)
  {
    setAttributeInternal(EMPLOYEESFK, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcBorrowRequestsTlView.
   */
  public RowIterator getArcBorrowRequestsTlView()
  {
    return (RowIterator) getAttributeInternal(ARCBORROWREQUESTSTLVIEW);
  }

  /**
   * Gets the view accessor <code>RowSet</code> ArcOldDocumentRVO.
   */
  public RowSet getArcOldDocumentRVO()
  {
    return (RowSet) getAttributeInternal(ARCOLDDOCUMENTRVO);
  }

}

