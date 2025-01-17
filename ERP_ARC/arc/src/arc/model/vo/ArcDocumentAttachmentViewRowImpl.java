package arc.model.vo;

import arc.model.eo.ArcDocumentAttachmentImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jan 19 14:07:19 EET 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcDocumentAttachmentViewRowImpl
  extends ViewRowImpl
{


  public static final int ENTITY_ARCDOCUMENTATTACHMENT = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    DocumentAttachmentPk,
    DocumentAttachTypeFk,
    OldDocumentFk,
    FilePath,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    DocumentSecurityFk,
    DisplayDocumentAttachTypeFk,
    DisplayDocumentSecurityFk,
    DisplayDocumentAttachDescription,
    DisplayDocumentAttachDescriptionSearch,
    DisplayDocumentAttachTypeFkSearch,
    DisplayDocumentSecurityFkSearch,
    DocumentAttachTypeFkSearch,
    DocumentSecurityFkSearch,
    WaterMarkFl,
    FileText,
    ArcDocumentAttachmentTlView,
    SsoActiveLookupValuesVwView1,
    SsoActiveLookupValuesVwView2;
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


  public static final int DOCUMENTATTACHMENTPK = AttributesEnum.DocumentAttachmentPk.index();
  public static final int DOCUMENTATTACHTYPEFK = AttributesEnum.DocumentAttachTypeFk.index();
  public static final int OLDDOCUMENTFK = AttributesEnum.OldDocumentFk.index();
  public static final int FILEPATH = AttributesEnum.FilePath.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DOCUMENTSECURITYFK = AttributesEnum.DocumentSecurityFk.index();
  public static final int DISPLAYDOCUMENTATTACHTYPEFK = AttributesEnum.DisplayDocumentAttachTypeFk.index();
  public static final int DISPLAYDOCUMENTSECURITYFK = AttributesEnum.DisplayDocumentSecurityFk.index();
  public static final int DISPLAYDOCUMENTATTACHDESCRIPTION = AttributesEnum.DisplayDocumentAttachDescription.index();
  public static final int DISPLAYDOCUMENTATTACHDESCRIPTIONSEARCH =
    AttributesEnum.DisplayDocumentAttachDescriptionSearch.index();
  public static final int DISPLAYDOCUMENTATTACHTYPEFKSEARCH = AttributesEnum.DisplayDocumentAttachTypeFkSearch.index();
  public static final int DISPLAYDOCUMENTSECURITYFKSEARCH = AttributesEnum.DisplayDocumentSecurityFkSearch.index();
  public static final int DOCUMENTATTACHTYPEFKSEARCH = AttributesEnum.DocumentAttachTypeFkSearch.index();
  public static final int DOCUMENTSECURITYFKSEARCH = AttributesEnum.DocumentSecurityFkSearch.index();
  public static final int WATERMARKFL = AttributesEnum.WaterMarkFl.index();
  public static final int FILETEXT = AttributesEnum.FileText.index();
  public static final int ARCDOCUMENTATTACHMENTTLVIEW = AttributesEnum.ArcDocumentAttachmentTlView.index();
  public static final int SSOACTIVELOOKUPVALUESVWVIEW1 = AttributesEnum.SsoActiveLookupValuesVwView1.index();
  public static final int SSOACTIVELOOKUPVALUESVWVIEW2 = AttributesEnum.SsoActiveLookupValuesVwView2.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcDocumentAttachmentViewRowImpl()
  {
  }

  /**
   * Gets ArcDocumentAttachment entity object.
   * @return the ArcDocumentAttachment
   */
  public ArcDocumentAttachmentImpl getArcDocumentAttachment()
  {
    return (ArcDocumentAttachmentImpl) getEntity(ENTITY_ARCDOCUMENTATTACHMENT);
  }

  /**
   * Gets the attribute value for DOCUMENT_ATTACHMENT_PK using the alias name DocumentAttachmentPk.
   * @return the DOCUMENT_ATTACHMENT_PK
   */
  public BigDecimal getDocumentAttachmentPk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTATTACHMENTPK);
  }

  /**
   * Sets <code>value</code> as attribute value for DOCUMENT_ATTACHMENT_PK using the alias name DocumentAttachmentPk.
   * @param value value to set the DOCUMENT_ATTACHMENT_PK
   */
  public void setDocumentAttachmentPk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTATTACHMENTPK, value);
  }

  /**
   * Gets the attribute value for DOCUMENT_ATTACH_TYPE_FK using the alias name DocumentAttachTypeFk.
   * @return the DOCUMENT_ATTACH_TYPE_FK
   */
  public BigDecimal getDocumentAttachTypeFk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTATTACHTYPEFK);
  }

  /**
   * Sets <code>value</code> as attribute value for DOCUMENT_ATTACH_TYPE_FK using the alias name DocumentAttachTypeFk.
   * @param value value to set the DOCUMENT_ATTACH_TYPE_FK
   */
  public void setDocumentAttachTypeFk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTATTACHTYPEFK, value);
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
   * Gets the attribute value for FILE_PATH using the alias name FilePath.
   * @return the FILE_PATH
   */
  public String getFilePath()
  {
    return (String) getAttributeInternal(FILEPATH);
  }

  /**
   * Sets <code>value</code> as attribute value for FILE_PATH using the alias name FilePath.
   * @param value value to set the FILE_PATH
   */
  public void setFilePath(String value)
  {
    setAttributeInternal(FILEPATH, value);
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
   * Gets the attribute value for DOCUMENT_SECURITY_FK using the alias name DocumentSecurityFk.
   * @return the DOCUMENT_SECURITY_FK
   */
  public BigDecimal getDocumentSecurityFk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTSECURITYFK);
  }

  /**
   * Sets <code>value</code> as attribute value for DOCUMENT_SECURITY_FK using the alias name DocumentSecurityFk.
   * @param value value to set the DOCUMENT_SECURITY_FK
   */
  public void setDocumentSecurityFk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTSECURITYFK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDocumentAttachTypeFk.
   * @return the DisplayDocumentAttachTypeFk
   */
  public String getDisplayDocumentAttachTypeFk()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTATTACHTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDocumentAttachTypeFk.
   * @param value value to set the  DisplayDocumentAttachTypeFk
   */
  public void setDisplayDocumentAttachTypeFk(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTATTACHTYPEFK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDocumentSecurityFk.
   * @return the DisplayDocumentSecurityFk
   */
  public String getDisplayDocumentSecurityFk()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTSECURITYFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDocumentSecurityFk.
   * @param value value to set the  DisplayDocumentSecurityFk
   */
  public void setDisplayDocumentSecurityFk(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTSECURITYFK, value);
  }

  /**
   * Gets the attribute value for DISPLAY_DOCUMENT_ATTACH_DESCRI using the alias name DisplayDocumentAttachDescription.
   * @return the DISPLAY_DOCUMENT_ATTACH_DESCRI
   */
  public String getDisplayDocumentAttachDescription()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTION);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_DOCUMENT_ATTACH_DESCRI using the alias name DisplayDocumentAttachDescription.
   * @param value value to set the DISPLAY_DOCUMENT_ATTACH_DESCRI
   */
  public void setDisplayDocumentAttachDescription(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTION, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDocumentAttachDescriptionSearch.
   * @return the DisplayDocumentAttachDescriptionSearch
   */
  public String getDisplayDocumentAttachDescriptionSearch()
  {
    
    return (String) getAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTION);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDocumentAttachDescriptionSearch.
   * @param value value to set the  DisplayDocumentAttachDescriptionSearch
   */
  public void setDisplayDocumentAttachDescriptionSearch(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTIONSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDocumentAttachTypeFkSearch.
   * @return the DisplayDocumentAttachTypeFkSearch
   */
  public String getDisplayDocumentAttachTypeFkSearch()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTATTACHTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDocumentAttachTypeFkSearch.
   * @param value value to set the  DisplayDocumentAttachTypeFkSearch
   */
  public void setDisplayDocumentAttachTypeFkSearch(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTATTACHTYPEFKSEARCH, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDocumentSecurityFkSearch.
   * @return the DisplayDocumentSecurityFkSearch
   */
  public String getDisplayDocumentSecurityFkSearch()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTSECURITYFK);
  }

  /**
   * Gets the attribute value for the calculated attribute DocumentAttachTypeFkSearch.
   * @return the DocumentAttachTypeFkSearch
   */
  public BigDecimal getDocumentAttachTypeFkSearch()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTATTACHTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DocumentAttachTypeFkSearch.
   * @param value value to set the  DocumentAttachTypeFkSearch
   */
  public void setDocumentAttachTypeFkSearch(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTATTACHTYPEFKSEARCH, value);
  }


  /**
   * Gets the attribute value for the calculated attribute DocumentSecurityFkSearch.
   * @return the DocumentSecurityFkSearch
   */
  public BigDecimal getDocumentSecurityFkSearch()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTSECURITYFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DocumentSecurityFkSearch.
   * @param value value to set the  DocumentSecurityFkSearch
   */
  public void setDocumentSecurityFkSearch(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTSECURITYFKSEARCH, value);
  }

  /**
   * Gets the attribute value for WATER_MARK_FL using the alias name WaterMarkFl.
   * @return the WATER_MARK_FL
   */
  public BigDecimal getWaterMarkFl()
  {
    return (BigDecimal) getAttributeInternal(WATERMARKFL);
  }

  /**
   * Sets <code>value</code> as attribute value for WATER_MARK_FL using the alias name WaterMarkFl.
   * @param value value to set the WATER_MARK_FL
   */
  public void setWaterMarkFl(BigDecimal value)
  {
    setAttributeInternal(WATERMARKFL, value);
  }

  /**
   * Gets the attribute value for FILE_TEXT using the alias name FileText.
   * @return the FILE_TEXT
   */
  public String getFileText()
  {
    return (String) getAttributeInternal(FILETEXT);
  }

  /**
   * Sets <code>value</code> as attribute value for FILE_TEXT using the alias name FileText.
   * @param value value to set the FILE_TEXT
   */
  public void setFileText(String value)
  {
    setAttributeInternal(FILETEXT, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcDocumentAttachmentTlView.
   */
  public RowIterator getArcDocumentAttachmentTlView()
  {
    return (RowIterator) getAttributeInternal(ARCDOCUMENTATTACHMENTTLVIEW);
  }

  /**
   * Gets the view accessor <code>RowSet</code> SsoActiveLookupValuesVwView1.
   */
  public RowSet getSsoActiveLookupValuesVwView1()
  {
    return (RowSet) getAttributeInternal(SSOACTIVELOOKUPVALUESVWVIEW1);
  }

  /**
   * Gets the view accessor <code>RowSet</code> SsoActiveLookupValuesVwView2.
   */
  public RowSet getSsoActiveLookupValuesVwView2()
  {
    return (RowSet) getAttributeInternal(SSOACTIVELOOKUPVALUESVWVIEW2);
  }
}

