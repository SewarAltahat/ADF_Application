package arc.model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 03 19:32:19 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcFlStandardsImpl
  extends AuditEntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    FlStandardsPk,
    FlStatusFl,
    CreatedBy,
    CreationDate,
    ModifiedBy,
    ModifiedDate,
    UserDepartmentFk,
    DisplayStandardDesc,
    DisplayNotes,
    ArcFlsLocations,
    ArcFlStandardsTl;
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


  public static final int FLSTANDARDSPK = AttributesEnum.FlStandardsPk.index();
  public static final int FLSTATUSFL = AttributesEnum.FlStatusFl.index();
  public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
  public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
  public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
  public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
  public static final int USERDEPARTMENTFK = AttributesEnum.UserDepartmentFk.index();
  public static final int DISPLAYSTANDARDDESC = AttributesEnum.DisplayStandardDesc.index();
  public static final int DISPLAYNOTES = AttributesEnum.DisplayNotes.index();
  public static final int ARCFLSLOCATIONS = AttributesEnum.ArcFlsLocations.index();
  public static final int ARCFLSTANDARDSTL = AttributesEnum.ArcFlStandardsTl.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcFlStandardsImpl()
  {
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("arc.model.eo.ArcFlStandards");
  }


  /**
   * Gets the attribute value for FlStandardsPk, using the alias name FlStandardsPk.
   * @return the value of FlStandardsPk
   */
  public BigDecimal getFlStandardsPk()
  {
    return (BigDecimal) getAttributeInternal(FLSTANDARDSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for FlStandardsPk.
   * @param value value to set the FlStandardsPk
   */
  public void setFlStandardsPk(BigDecimal value)
  {
    setAttributeInternal(FLSTANDARDSPK, value);
  }

  /**
   * Gets the attribute value for FlStatusFl, using the alias name FlStatusFl.
   * @return the value of FlStatusFl
   */
  public BigDecimal getFlStatusFl()
  {
    return (BigDecimal) getAttributeInternal(FLSTATUSFL);
  }

  /**
   * Sets <code>value</code> as the attribute value for FlStatusFl.
   * @param value value to set the FlStatusFl
   */
  public void setFlStatusFl(BigDecimal value)
  {
    setAttributeInternal(FLSTATUSFL, value);
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
   * Gets the attribute value for DisplayStandardDesc, using the alias name DisplayStandardDesc.
   * @return the value of DisplayStandardDesc
   */
  public String getDisplayStandardDesc()
  {
    return (String) getAttributeInternal(DISPLAYSTANDARDDESC);
  }

  /**
   * Sets <code>value</code> as the attribute value for DisplayStandardDesc.
   * @param value value to set the DisplayStandardDesc
   */
  public void setDisplayStandardDesc(String value)
  {
    setAttributeInternal(DISPLAYSTANDARDDESC, value);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcFlsLocations()
  {
    return (RowIterator) getAttributeInternal(ARCFLSLOCATIONS);
  }

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getArcFlStandardsTl()
  {
    return (RowIterator) getAttributeInternal(ARCFLSTANDARDSTL);
  }


  /**
   * @param flStandardsPk key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(BigDecimal flStandardsPk)
  {
    return new Key(new Object[] { flStandardsPk });
  }

  protected void doDML(int operation, oracle.jbo.server.TransactionEvent e)
  {
    super.doDML(operation, e);

    if ( operation == DML_INSERT )
    {
      BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(getDBTransaction(), "ARC_FL_STANDARDS_SEQ");
      setFlStandardsPk(pk);
      oracle.jbo.server.EntityDefImpl def = ArcFlStandardsTlImpl.getDefinitionObject();
      java.util.List<Integer> lang = gen.common.GenLib.getActiveDataLanguages(getDBTransaction());
      for (int i = 0; i < lang.size(); i++)
      {
        ArcFlStandardsTlImpl tl = (ArcFlStandardsTlImpl)def.createInstance2(getDBTransaction(), null);
        tl.setLanguagesFk(new BigDecimal(lang.get(i)));
        tl.setStandardDesc(getDisplayStandardDesc());
        tl.setFlStandardsFk(getFlStandardsPk());
        tl.setNotes(getDisplayNotes());
      }
    }
  }


  public void remove()
  {
    gen.common.GenLib.removeTranlationRows(getArcFlStandardsTl());
    super.remove();
  }
  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);
    setFlStatusFl(new BigDecimal(1));
  }
}
