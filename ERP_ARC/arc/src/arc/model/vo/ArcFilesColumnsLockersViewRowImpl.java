package arc.model.vo;

import arc.model.eo.ArcFilesColumnsLockersImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 11 16:33:58 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcFilesColumnsLockersViewRowImpl
  extends ViewRowImpl
{

  public static final int ENTITY_ARCFILESCOLUMNSLOCKERS = 0;

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
    DisplayFilesColumnsLockersNameSearch,
    ArcFilesColumnsLockersTlView,
    ArcFilesRowsColumnsLockersView,
    ArcFilesColumnsLockPrivView;
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

  public static final int FILESCOLUMNSLOCKERSPK = AttributesEnum.FilesColumnsLockersPk.index();
  public static final int FILESLOCKERSFK = AttributesEnum.FilesLockersFk.index();
  public static final int LOCKERSYEAR = AttributesEnum.LockersYear.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DISPLAYFILESCOLUMNSLOCKERSNAME = AttributesEnum.DisplayFilesColumnsLockersName.index();
  public static final int DISPLAYFILESCOLUMNSLOCKERSNAMESEARCH =
    AttributesEnum.DisplayFilesColumnsLockersNameSearch.index();
  public static final int ARCFILESCOLUMNSLOCKERSTLVIEW = AttributesEnum.ArcFilesColumnsLockersTlView.index();
  public static final int ARCFILESROWSCOLUMNSLOCKERSVIEW = AttributesEnum.ArcFilesRowsColumnsLockersView.index();
  public static final int ARCFILESCOLUMNSLOCKPRIVVIEW = AttributesEnum.ArcFilesColumnsLockPrivView.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcFilesColumnsLockersViewRowImpl()
  {
  }

  /**
   * Gets ArcFilesColumnsLockers entity object.
   * @return the ArcFilesColumnsLockers
   */
  public ArcFilesColumnsLockersImpl getArcFilesColumnsLockers()
  {
    return (ArcFilesColumnsLockersImpl) getEntity(ENTITY_ARCFILESCOLUMNSLOCKERS);
  }

  /**
   * Gets the attribute value for FILES_COLUMNS_LOCKERS_PK using the alias name FilesColumnsLockersPk.
   * @return the FILES_COLUMNS_LOCKERS_PK
   */
  public BigDecimal getFilesColumnsLockersPk()
  {
    return (BigDecimal) getAttributeInternal(FILESCOLUMNSLOCKERSPK);
  }

  /**
   * Sets <code>value</code> as attribute value for FILES_COLUMNS_LOCKERS_PK using the alias name FilesColumnsLockersPk.
   * @param value value to set the FILES_COLUMNS_LOCKERS_PK
   */
  public void setFilesColumnsLockersPk(BigDecimal value)
  {
    setAttributeInternal(FILESCOLUMNSLOCKERSPK, value);
  }

  /**
   * Gets the attribute value for FILES_LOCKERS_FK using the alias name FilesLockersFk.
   * @return the FILES_LOCKERS_FK
   */
  public BigDecimal getFilesLockersFk()
  {
    return (BigDecimal) getAttributeInternal(FILESLOCKERSFK);
  }

  /**
   * Sets <code>value</code> as attribute value for FILES_LOCKERS_FK using the alias name FilesLockersFk.
   * @param value value to set the FILES_LOCKERS_FK
   */
  public void setFilesLockersFk(BigDecimal value)
  {
    setAttributeInternal(FILESLOCKERSFK, value);
  }

  /**
   * Gets the attribute value for LOCKERS_YEAR using the alias name LockersYear.
   * @return the LOCKERS_YEAR
   */
  public BigDecimal getLockersYear()
  {
    return (BigDecimal) getAttributeInternal(LOCKERSYEAR);
  }

  /**
   * Sets <code>value</code> as attribute value for LOCKERS_YEAR using the alias name LockersYear.
   * @param value value to set the LOCKERS_YEAR
   */
  public void setLockersYear(BigDecimal value)
  {
    setAttributeInternal(LOCKERSYEAR, value);
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
   * Gets the attribute value for DISPLAY_FILES_COLUMNS_LOCKERS_ using the alias name DisplayFilesColumnsLockersName.
   * @return the DISPLAY_FILES_COLUMNS_LOCKERS_
   */
  public String getDisplayFilesColumnsLockersName()
  {
    return (String) getAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for DISPLAY_FILES_COLUMNS_LOCKERS_ using the alias name DisplayFilesColumnsLockersName.
   * @param value value to set the DISPLAY_FILES_COLUMNS_LOCKERS_
   */
  public void setDisplayFilesColumnsLockersName(String value)
  {
    setAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayFilesColumnsLockersNameSearch.
   * @return the DisplayFilesColumnsLockersNameSearch
   */
  public String getDisplayFilesColumnsLockersNameSearch()
  {
    return (String) getAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayFilesColumnsLockersNameSearch.
   * @param value value to set the  DisplayFilesColumnsLockersNameSearch
   */
  public void setDisplayFilesColumnsLockersNameSearch(String value)
  {
    setAttributeInternal(DISPLAYFILESCOLUMNSLOCKERSNAMESEARCH, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesColumnsLockersTlView.
   */
  public RowIterator getArcFilesColumnsLockersTlView()
  {
    return (RowIterator) getAttributeInternal(ARCFILESCOLUMNSLOCKERSTLVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesRowsColumnsLockersView.
   */
  public RowIterator getArcFilesRowsColumnsLockersView()
  {
    return (RowIterator) getAttributeInternal(ARCFILESROWSCOLUMNSLOCKERSVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesColumnsLockPrivView.
   */
  public RowIterator getArcFilesColumnsLockPrivView()
  {
    return (RowIterator) getAttributeInternal(ARCFILESCOLUMNSLOCKPRIVVIEW);
  }
}

