package arc.model.vo;

import arc.model.eo.ArcBorrowRequestsTlImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Aug 27 15:40:40 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcBorrowRequestsTlViewRowImpl
  extends ViewRowImpl
{
  public static final int ENTITY_ARCBORROWREQUESTSTL = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    BorrowRequestsTlPk,
    RequestReason,
    Notes,
    LanguagesFk,
    BorrowRequestsFk,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    RequestReasonSearch,
    NotesSearch,
    SsoLanguagesVwView1;
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
  public static final int BORROWREQUESTSTLPK = AttributesEnum.BorrowRequestsTlPk.index();
  public static final int REQUESTREASON = AttributesEnum.RequestReason.index();
  public static final int NOTES = AttributesEnum.Notes.index();
  public static final int LANGUAGESFK = AttributesEnum.LanguagesFk.index();
  public static final int BORROWREQUESTSFK = AttributesEnum.BorrowRequestsFk.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int REQUESTREASONSEARCH = AttributesEnum.RequestReasonSearch.index();
  public static final int NOTESSEARCH = AttributesEnum.NotesSearch.index();
  public static final int SSOLANGUAGESVWVIEW1 = AttributesEnum.SsoLanguagesVwView1.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcBorrowRequestsTlViewRowImpl()
  {
  }

  /**
   * Gets ArcBorrowRequestsTl entity object.
   * @return the ArcBorrowRequestsTl
   */
  public ArcBorrowRequestsTlImpl getArcBorrowRequestsTl()
  {
    return (ArcBorrowRequestsTlImpl) getEntity(ENTITY_ARCBORROWREQUESTSTL);
  }

  /**
   * Gets the attribute value for BORROW_REQUESTS_TL_PK using the alias name BorrowRequestsTlPk.
   * @return the BORROW_REQUESTS_TL_PK
   */
  public BigDecimal getBorrowRequestsTlPk()
  {
    return (BigDecimal) getAttributeInternal(BORROWREQUESTSTLPK);
  }

  /**
   * Sets <code>value</code> as attribute value for BORROW_REQUESTS_TL_PK using the alias name BorrowRequestsTlPk.
   * @param value value to set the BORROW_REQUESTS_TL_PK
   */
  public void setBorrowRequestsTlPk(BigDecimal value)
  {
    setAttributeInternal(BORROWREQUESTSTLPK, value);
  }

  /**
   * Gets the attribute value for REQUEST_REASON using the alias name RequestReason.
   * @return the REQUEST_REASON
   */
  public String getRequestReason()
  {
    return (String) getAttributeInternal(REQUESTREASON);
  }

  /**
   * Sets <code>value</code> as attribute value for REQUEST_REASON using the alias name RequestReason.
   * @param value value to set the REQUEST_REASON
   */
  public void setRequestReason(String value)
  {
    setAttributeInternal(REQUESTREASON, value);
  }

  /**
   * Gets the attribute value for NOTES using the alias name Notes.
   * @return the NOTES
   */
  public String getNotes()
  {
    return (String) getAttributeInternal(NOTES);
  }

  /**
   * Sets <code>value</code> as attribute value for NOTES using the alias name Notes.
   * @param value value to set the NOTES
   */
  public void setNotes(String value)
  {
    setAttributeInternal(NOTES, value);
  }

  /**
   * Gets the attribute value for LANGUAGES_FK using the alias name LanguagesFk.
   * @return the LANGUAGES_FK
   */
  public BigDecimal getLanguagesFk()
  {
    return (BigDecimal) getAttributeInternal(LANGUAGESFK);
  }

  /**
   * Sets <code>value</code> as attribute value for LANGUAGES_FK using the alias name LanguagesFk.
   * @param value value to set the LANGUAGES_FK
   */
  public void setLanguagesFk(BigDecimal value)
  {
    setAttributeInternal(LANGUAGESFK, value);
  }

  /**
   * Gets the attribute value for BORROW_REQUESTS_FK using the alias name BorrowRequestsFk.
   * @return the BORROW_REQUESTS_FK
   */
  public BigDecimal getBorrowRequestsFk()
  {
    return (BigDecimal) getAttributeInternal(BORROWREQUESTSFK);
  }

  /**
   * Sets <code>value</code> as attribute value for BORROW_REQUESTS_FK using the alias name BorrowRequestsFk.
   * @param value value to set the BORROW_REQUESTS_FK
   */
  public void setBorrowRequestsFk(BigDecimal value)
  {
    setAttributeInternal(BORROWREQUESTSFK, value);
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
   * Gets the attribute value for the calculated attribute RequestReasonSearch.
   * @return the RequestReasonSearch
   */
  public String getRequestReasonSearch()
  {
    return (String) getAttributeInternal(REQUESTREASON);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute RequestReasonSearch.
   * @param value value to set the  RequestReasonSearch
   */
  public void setRequestReasonSearch(String value)
  {
    setAttributeInternal(REQUESTREASONSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute NotesSearch.
   * @return the NotesSearch
   */
  public String getNotesSearch()
  {
    return (String) getAttributeInternal(NOTES);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute NotesSearch.
   * @param value value to set the  NotesSearch
   */
  public void setNotesSearch(String value)
  {
    setAttributeInternal(NOTESSEARCH, value);
  }

  /**
   * Gets the view accessor <code>RowSet</code> SsoLanguagesVwView1.
   */
  public RowSet getSsoLanguagesVwView1()
  {
    return (RowSet) getAttributeInternal(SSOLANGUAGESVWVIEW1);
  }
}
