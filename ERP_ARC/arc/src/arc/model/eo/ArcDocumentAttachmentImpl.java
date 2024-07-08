package arc.model.eo;

import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.Clob;
import java.sql.Timestamp;

import java.util.List;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 14 19:02:53 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcDocumentAttachmentImpl
  extends AuditEntityImpl
{
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
    DisplayDocumentAttachDescription,
    WaterMarkFl,
    FileText,
    ArcDocumentAttachmentTl,
    ArcOldDocument;
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

  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);
    setWaterMarkFl(new BigDecimal(0));
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
  public static final int DISPLAYDOCUMENTATTACHDESCRIPTION = AttributesEnum.DisplayDocumentAttachDescription.index();
  public static final int WATERMARKFL = AttributesEnum.WaterMarkFl.index();
  public static final int FILETEXT = AttributesEnum.FileText.index();
  public static final int ARCDOCUMENTATTACHMENTTL = AttributesEnum.ArcDocumentAttachmentTl.index();
  public static final int ARCOLDDOCUMENT = AttributesEnum.ArcOldDocument.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcDocumentAttachmentImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("arc.model.eo.ArcDocumentAttachment");
  }


  /**
   * Gets the attribute value for DocumentAttachmentPk, using the alias name DocumentAttachmentPk.
   * @return the value of DocumentAttachmentPk
   */
  public BigDecimal getDocumentAttachmentPk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTATTACHMENTPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DocumentAttachmentPk.
   * @param value value to set the DocumentAttachmentPk
   */
  public void setDocumentAttachmentPk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTATTACHMENTPK, value);
  }

  /**
   * Gets the attribute value for DocumentAttachTypeFk, using the alias name DocumentAttachTypeFk.
   * @return the value of DocumentAttachTypeFk
   */
  public BigDecimal getDocumentAttachTypeFk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTATTACHTYPEFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DocumentAttachTypeFk.
   * @param value value to set the DocumentAttachTypeFk
   */
  public void setDocumentAttachTypeFk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTATTACHTYPEFK, value);
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
   * Gets the attribute value for FilePath, using the alias name FilePath.
   * @return the value of FilePath
   */
  public String getFilePath()
  {
    return (String) getAttributeInternal(FILEPATH);
  }

  /**
   * Sets <code>value</code> as the attribute value for FilePath.
   * @param value value to set the FilePath
   */
  public void setFilePath(String value)
  {
    setAttributeInternal(FILEPATH, value);
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
   * Gets the attribute value for DocumentSecurityFk, using the alias name DocumentSecurityFk.
   * @return the value of DocumentSecurityFk
   */
  public BigDecimal getDocumentSecurityFk()
  {
    return (BigDecimal) getAttributeInternal(DOCUMENTSECURITYFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for DocumentSecurityFk.
   * @param value value to set the DocumentSecurityFk
   */
  public void setDocumentSecurityFk(BigDecimal value)
  {
    setAttributeInternal(DOCUMENTSECURITYFK, value);
  }

  /**
   * Gets the attribute value for DisplayDocumentAttachDescription, using the alias name DisplayDocumentAttachDescription.
   * @return the value of DisplayDocumentAttachDescription
   */
  public String getDisplayDocumentAttachDescription()
  {
    return (String) getAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTION);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayDocumentAttachDescription.
   * @param value value to set the DisplayDocumentAttachDescription
   */
  public void setDisplayDocumentAttachDescription(String value)
  {
    setAttributeInternal(DISPLAYDOCUMENTATTACHDESCRIPTION, value);
  }

  /**
   * Gets the attribute value for WaterMarkFl, using the alias name WaterMarkFl.
   * @return the value of WaterMarkFl
   */
  public BigDecimal getWaterMarkFl()
  {
    return (BigDecimal) getAttributeInternal(WATERMARKFL);
  }

  /**
   * Sets <code>value</code> as the attribute value for WaterMarkFl.
   * @param value value to set the WaterMarkFl
   */
  public void setWaterMarkFl(BigDecimal value)
  {
    setAttributeInternal(WATERMARKFL, value);
  }

  /**
   * Gets the attribute value for FileText, using the alias name FileText.
   * @return the value of FileText
   */
  public String getFileText()
  {
    return (String) getAttributeInternal(FILETEXT);
  }

  /**
   * Sets <code>value</code> as the attribute value for FileText.
   * @param value value to set the FileText
   */
  public void setFileText(String value)
  {
    setAttributeInternal(FILETEXT, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcDocumentAttachmentTl()
  {
    return (RowIterator) getAttributeInternal(ARCDOCUMENTATTACHMENTTL);
  }

  /**
   * @return the associated entity ArcOldDocumentImpl.
   */
  public ArcOldDocumentImpl getArcOldDocument()
  {
    return (ArcOldDocumentImpl) getAttributeInternal(ARCOLDDOCUMENT);
  }

  /**
   * Sets <code>value</code> as the associated entity ArcOldDocumentImpl.
   */
  public void setArcOldDocument(ArcOldDocumentImpl value)
  {
    setAttributeInternal(ARCOLDDOCUMENT, value);
  }


  /**
   * @param documentAttachmentPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal documentAttachmentPk)
  {
    return new Key(new Object[] { documentAttachmentPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  { 
    if ( operation == DML_UPDATE )
    {
    }
    if ( operation != DML_DELETE )
    {
    }
    
    super.doDML(operation, e);
  
    if ( operation == DML_INSERT )
    {
      BigDecimal pk = GenLib.getPrimaryKeyValue(getDBTransaction(), "ARC_DOCUMENT_ATTACHMENT_SEQ");
      setDocumentAttachmentPk(pk);
      EntityDefImpl def = ArcDocumentAttachmentTlImpl.getDefinitionObject();
      
      try
      {
        List<Integer> lang = GenLib.getActiveDataLanguages(getDBTransaction());
        
        for (int i = 0; i < lang.size(); i++)
        {
          ArcDocumentAttachmentTlImpl tl = (ArcDocumentAttachmentTlImpl)def.createInstance2(getDBTransaction(), null);
          tl.setDocumentAttachmentFk(getDocumentAttachmentPk());
          tl.setLanguagesFk(new BigDecimal(lang.get(i)));
          tl.setDocumentAttachDescription(getDisplayDocumentAttachDescription());
        }
      }
      catch (Exception f)
      {
        f.printStackTrace();
      }
    }
  }
  
  @Override
  public void remove()
  {
    GenLib.removeTranlationRows(getArcDocumentAttachmentTl());  
    super.remove();
  }
}

