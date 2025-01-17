package arc.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Oct 09 19:47:50 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcFilesColumnsLockersImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    FilesColumnsLockersPk,
    FilesLockersFk,
    LockersYear,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    DisplayFilesColumnsLockersName,
    ArcFilesColumnsLockersTl,
    ArcFilesLockers,
    ArcFilesRowsColumnsLockers;
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


  public static final int FILESCOLUMNSLOCKERSPK = AttributesEnum.FilesColumnsLockersPk.index();
  public static final int FILESLOCKERSFK = AttributesEnum.FilesLockersFk.index();
  public static final int LOCKERSYEAR = AttributesEnum.LockersYear.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DISPLAYFILESCOLUMNSLOCKERSNAME = AttributesEnum.DisplayFilesColumnsLockersName.index();
  public static final int ARCFILESCOLUMNSLOCKERSTL = AttributesEnum.ArcFilesColumnsLockersTl.index();
  public static final int ARCFILESLOCKERS = AttributesEnum.ArcFilesLockers.index();
  public static final int ARCFILESROWSCOLUMNSLOCKERS = AttributesEnum.ArcFilesRowsColumnsLockers.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcFilesColumnsLockersImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("arc.model.eo.ArcFilesColumnsLockers");
  }


  /**
   * Gets the attribute value for FilesColumnsLockersPk, using the alias name FilesColumnsLockersPk.
   * @return the value of FilesColumnsLockersPk
   */
  public BigDecimal getFilesColumnsLockersPk()
  {
    return (BigDecimal) getAttributeInternal(FILESCOLUMNSLOCKERSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for FilesColumnsLockersPk.
   * @param value value to set the FilesColumnsLockersPk
   */
  public void setFilesColumnsLockersPk(BigDecimal value)
  {
    setAttributeInternal(FILESCOLUMNSLOCKERSPK, value);
  }

  /**
   * Gets the attribute value for FilesLockersFk, using the alias name FilesLockersFk.
   * @return the value of FilesLockersFk
   */
  public BigDecimal getFilesLockersFk()
  {
    return (BigDecimal) getAttributeInternal(FILESLOCKERSFK);
  }

  /**
   * Sets <code>value</code> as the attribute value for FilesLockersFk.
   * @param value value to set the FilesLockersFk
   */
  public void setFilesLockersFk(BigDecimal value)
  {
    setAttributeInternal(FILESLOCKERSFK, value);
  }

  /**
   * Gets the attribute value for LockersYear, using the alias name LockersYear.
   * @return the value of LockersYear
   */
  public BigDecimal getLockersYear()
  {
    return (BigDecimal) getAttributeInternal(LOCKERSYEAR);
  }

  /**
   * Sets <code>value</code> as the attribute value for LockersYear.
   * @param value value to set the LockersYear
   */
  public void setLockersYear(BigDecimal value)
  {
    setAttributeInternal(LOCKERSYEAR, value);
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
   * Gets the attribute value for DisplayFilesColumnsLockersName, using the alias name DisplayFilesColumnsLockersName.
   * @return the value of DisplayFilesColumnsLockersName
   */
  public String getDisplayFilesColumnsLockersName()
  {
    return (String) getAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayFilesColumnsLockersName.
   * @param value value to set the DisplayFilesColumnsLockersName
   */
  public void setDisplayFilesColumnsLockersName(String value)
  {
    setAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAME, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcFilesColumnsLockersTl()
  {
    return (RowIterator) getAttributeInternal(ARCFILESCOLUMNSLOCKERSTL);
  }

  /**
   * @return the associated entity ArcFilesLockersImpl.
   */
  public ArcFilesLockersImpl getArcFilesLockers()
  {
    return (ArcFilesLockersImpl) getAttributeInternal(ARCFILESLOCKERS);
  }

  /**
   * Sets <code>value</code> as the associated entity ArcFilesLockersImpl.
   */
  public void setArcFilesLockers(ArcFilesLockersImpl value)
  {
    setAttributeInternal(ARCFILESLOCKERS, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcFilesRowsColumnsLockers()
  {
    return (RowIterator) getAttributeInternal(ARCFILESROWSCOLUMNSLOCKERS);
  }


  /**
   * @param filesColumnsLockersPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal filesColumnsLockersPk)
  {
    return new Key(new Object[] { filesColumnsLockersPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "ARC_FILES_COLUMNS_LOCKERS_SEQ");
      setFilesColumnsLockersPk(pk);
      oracle.jbo.server.EntityDefImpl def = ArcFilesColumnsLockersTlImpl.getDefinitionObject();
      java.util.List<Integer> lang = gen.common.GenLib.getActiveDataLanguages(getDBTransaction());
      for (int i = 0; i < lang.size(); i++)
      {
        ArcFilesColumnsLockersTlImpl tl = (ArcFilesColumnsLockersTlImpl)def.createInstance2(getDBTransaction(), null);
        tl.setLanguagesFk(new BigDecimal(lang.get(i)));
        tl.setFilesColumnsLockersName(getDisplayFilesColumnsLockersName());
        tl.setFilesColumnsLockersFk(getFilesColumnsLockersPk());
      }
    }
  }


  public void remove()
  {
    gen.common.GenLib.removeTranlationRows(getArcFilesColumnsLockersTl());
    super.remove();
  }

}

