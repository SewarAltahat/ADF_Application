package arc.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Aug 19 11:25:45 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcBorrowRequestsImpl
  extends AuditEntityImpl
{
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
    DisplayRequestReason,
    DisplayNotes,
    Processinstanceid,
    BpmTaskId,
    ReturnDate,
    EmployeesFk,
    ArcBorrowRequestsTl;
    private static AttributesEnum[] vals = null;
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
  public static final int DISPLAYREQUESTREASON = AttributesEnum.DisplayRequestReason.index();
  public static final int DISPLAYNOTES = AttributesEnum.DisplayNotes.index();
  public static final int PROCESSINSTANCEID = AttributesEnum.Processinstanceid.index();
  public static final int BPMTASKID = AttributesEnum.BpmTaskId.index();
  public static final int RETURNDATE = AttributesEnum.ReturnDate.index();
  public static final int EMPLOYEESFK = AttributesEnum.EmployeesFk.index();
  public static final int ARCBORROWREQUESTSTL = AttributesEnum.ArcBorrowRequestsTl.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcBorrowRequestsImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("arc.model.eo.ArcBorrowRequests");
  }


  /**
   * Gets the attribute value for BorrowRequestsPk, using the alias name BorrowRequestsPk.
   * @return the value of BorrowRequestsPk
   */
  public BigDecimal getBorrowRequestsPk()
  {
    return (BigDecimal) getAttributeInternal(BORROWREQUESTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for BorrowRequestsPk.
   * @param value value to set the BorrowRequestsPk
   */
  public void setBorrowRequestsPk(BigDecimal value)
  {
    setAttributeInternal(BORROWREQUESTSPK, value);
  }

  /**
   * Gets the attribute value for OldDocumentFk, using the alias name OldDocumentFk.
   * @return the value of OldDocumentFk
   */
  public BigDecimal getOldDocumentFk()
  {
    return (BigDecimal) getAttributeInternal(OLDDOCUMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for OldDocumentFk.
   * @param value value to set the OldDocumentFk
   */
  public void setOldDocumentFk(BigDecimal value)
  {
    setAttributeInternal(OLDDOCUMENTFK, value);
  }

  /**
   * Gets the attribute value for RequestPeriod, using the alias name RequestPeriod.
   * @return the value of RequestPeriod
   */
  public BigDecimal getRequestPeriod()
  {
    return (BigDecimal) getAttributeInternal(REQUESTPERIOD);
  }

  /**
   * Sets <code>value</code> as the attribute value for RequestPeriod.
   * @param value value to set the RequestPeriod
   */
  public void setRequestPeriod(BigDecimal value)
  {
    setAttributeInternal(REQUESTPERIOD, value);
  }

  /**
   * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
   * @return the value of CreatedBy
   */
  public BigDecimal getCreatedBy()
  {
    return (BigDecimal) getAttributeInternal(CREATEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for CreatedBy.
   * @param value value to set the CreatedBy
   */
  public void setCreatedBy(BigDecimal value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * Gets the attribute value for CreationDate, using the alias name CreationDate.
   * @return the value of CreationDate
   */
  public Timestamp getCreationDate()
  {
    return (Timestamp) getAttributeInternal(CREATIONDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for CreationDate.
   * @param value value to set the CreationDate
   */
  public void setCreationDate(Timestamp value)
  {
    setAttributeInternal(CREATIONDATE, value);
  }

  /**
   * Gets the attribute value for ModifiedBy, using the alias name ModifiedBy.
   * @return the value of ModifiedBy
   */
  public BigDecimal getModifiedBy()
  {
    return (BigDecimal) getAttributeInternal(MODIFIEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for ModifiedBy.
   * @param value value to set the ModifiedBy
   */
  public void setModifiedBy(BigDecimal value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
   * @return the value of ModifiedDate
   */
  public Timestamp getModifiedDate()
  {
    return (Timestamp) getAttributeInternal(MODIFIEDDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for ModifiedDate.
   * @param value value to set the ModifiedDate
   */
  public void setModifiedDate(Timestamp value)
  {
    setAttributeInternal(MODIFIEDDATE, value);
  }

  /**
   * Gets the attribute value for UserDepartmentFk, using the alias name UserDepartmentFk.
   * @return the value of UserDepartmentFk
   */
  public BigDecimal getUserDepartmentFk()
  {
    return (BigDecimal) getAttributeInternal(USERDEPARTMENTFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for UserDepartmentFk.
   * @param value value to set the UserDepartmentFk
   */
  public void setUserDepartmentFk(BigDecimal value)
  {
    setAttributeInternal(USERDEPARTMENTFK, value);
  }

  /**
   * Gets the attribute value for RequestStatusFk, using the alias name RequestStatusFk.
   * @return the value of RequestStatusFk
   */
  public BigDecimal getRequestStatusFk()
  {
    return (BigDecimal) getAttributeInternal(REQUESTSTATUSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for RequestStatusFk.
   * @param value value to set the RequestStatusFk
   */
  public void setRequestStatusFk(BigDecimal value)
  {
    setAttributeInternal(REQUESTSTATUSFK, value);
  }

  /**
   * Gets the attribute value for DisplayRequestReason, using the alias name DisplayRequestReason.
   * @return the value of DisplayRequestReason
   */
  public String getDisplayRequestReason()
  {
    return (String) getAttributeInternal(DISPLAYREQUESTREASON);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayRequestReason.
   * @param value value to set the DisplayRequestReason
   */
  public void setDisplayRequestReason(String value)
  {
    setAttributeInternal(DISPLAYREQUESTREASON, value);
  }

  /**
   * Gets the attribute value for DisplayNotes, using the alias name DisplayNotes.
   * @return the value of DisplayNotes
   */
  public String getDisplayNotes()
  {
    return (String) getAttributeInternal(DISPLAYNOTES);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayNotes.
   * @param value value to set the DisplayNotes
   */
  public void setDisplayNotes(String value)
  {
    setAttributeInternal(DISPLAYNOTES, value);
  }

  /**
   * Gets the attribute value for Processinstanceid, using the alias name Processinstanceid.
   * @return the value of Processinstanceid
   */
  public BigDecimal getProcessinstanceid()
  {
    return (BigDecimal) getAttributeInternal(PROCESSINSTANCEID);
  }

  /**
   * Sets <code>value</code> as the attribute value for Processinstanceid.
   * @param value value to set the Processinstanceid
   */
  public void setProcessinstanceid(BigDecimal value)
  {
    setAttributeInternal(PROCESSINSTANCEID, value);
  }


  /**
   * Gets the attribute value for BpmTaskId, using the alias name BpmTaskId.
   * @return the value of BpmTaskId
   */
  public BigDecimal getBpmTaskId()
  {
    return (BigDecimal) getAttributeInternal(BPMTASKID);
  }

  /**
   * Sets <code>value</code> as the attribute value for BpmTaskId.
   * @param value value to set the BpmTaskId
   */
  public void setBpmTaskId(BigDecimal value)
  {
    setAttributeInternal(BPMTASKID, value);
  }

  /**
   * Gets the attribute value for ReturnDate, using the alias name ReturnDate.
   * @return the value of ReturnDate
   */
  public Timestamp getReturnDate()
  {
    return (Timestamp) getAttributeInternal(RETURNDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for ReturnDate.
   * @param value value to set the ReturnDate
   */
  public void setReturnDate(Timestamp value)
  {
    setAttributeInternal(RETURNDATE, value);
  }

  /**
   * Gets the attribute value for EmployeesFk, using the alias name EmployeesFk.
   * @return the value of EmployeesFk
   */
  public BigDecimal getEmployeesFk()
  {
    return (BigDecimal) getAttributeInternal(EMPLOYEESFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for EmployeesFk.
   * @param value value to set the EmployeesFk
   */
  public void setEmployeesFk(BigDecimal value)
  {
    setAttributeInternal(EMPLOYEESFK, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcBorrowRequestsTl()
  {
    return (RowIterator) getAttributeInternal(ARCBORROWREQUESTSTL);
  }


  /**
   * @param borrowRequestsPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal borrowRequestsPk)
  {
    return new Key(new Object[] { borrowRequestsPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "ARC_BORROW_REQUESTS_SEQ");
      setBorrowRequestsPk(pk);
      oracle.jbo.server.EntityDefImpl def = ArcBorrowRequestsTlImpl.getDefinitionObject();
      java.util.List<Integer> lang = gen.common.GenLib.getActiveDataLanguages(getDBTransaction());
      for (int i = 0; i < lang.size(); i++)
      {
        ArcBorrowRequestsTlImpl tl = (ArcBorrowRequestsTlImpl)def.createInstance2(getDBTransaction(), null);
        tl.setLanguagesFk(new BigDecimal(lang.get(i)));
        tl.setRequestReason(getDisplayRequestReason());
        tl.setNotes(getDisplayNotes());
        tl.setBorrowRequestsFk(getBorrowRequestsPk());
      }
    }
  }


  public void remove()
  {
    gen.common.GenLib.removeTranlationRows(getArcBorrowRequestsTl());
    super.remove();
  }

}
