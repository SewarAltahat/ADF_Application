package arc.model.ro;

import java.math.BigDecimal;

import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Aug 07 16:06:54 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HcmDepartmentsVwViewRowImpl
  extends ViewRowImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    DepartmentsPk,
    DisplayDepartmentsPk,
    DisplayDepartmentsPkSearch,
    ArcFilesLocationView,
    ArcFilesLockersView,
    ArcFilesLocationDepartmentMasterRVO;
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


  public static final int DEPARTMENTSPK = AttributesEnum.DepartmentsPk.index();
  public static final int DISPLAYDEPARTMENTSPK = AttributesEnum.DisplayDepartmentsPk.index();
  public static final int DISPLAYDEPARTMENTSPKSEARCH = AttributesEnum.DisplayDepartmentsPkSearch.index();
  public static final int ARCFILESLOCATIONVIEW = AttributesEnum.ArcFilesLocationView.index();
  public static final int ARCFILESLOCKERSVIEW = AttributesEnum.ArcFilesLockersView.index();
  public static final int ARCFILESLOCATIONDEPARTMENTMASTERRVO =
    AttributesEnum.ArcFilesLocationDepartmentMasterRVO.index();

  /**
   * This is the default constructor (do not remove).
   */
  public HcmDepartmentsVwViewRowImpl()
  {
  }

  /**
   * Gets the attribute value for the calculated attribute DepartmentsPk.
   * @return the DepartmentsPk
   */
  public BigDecimal getDepartmentsPk()
  {
    return (BigDecimal) getAttributeInternal(DEPARTMENTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DepartmentsPk.
   * @param value value to set the  DepartmentsPk
   */
  public void setDepartmentsPk(BigDecimal value)
  {
    setAttributeInternal(DEPARTMENTSPK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDepartmentsPk.
   * @return the DisplayDepartmentsPk
   */
  public String getDisplayDepartmentsPk()
  {
    return (String) getAttributeInternal(DISPLAYDEPARTMENTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDepartmentsPk.
   * @param value value to set the  DisplayDepartmentsPk
   */
  public void setDisplayDepartmentsPk(String value)
  {
    setAttributeInternal(DISPLAYDEPARTMENTSPK, value);
  }

  /**
   * Gets the attribute value for the calculated attribute DisplayDepartmentsPkSearch.
   * @return the DisplayDepartmentsPkSearch
   */
  public String getDisplayDepartmentsPkSearch()
  {
    return (String) getAttributeInternal(DISPLAYDEPARTMENTSPK);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute DisplayDepartmentsPkSearch.
   * @param value value to set the  DisplayDepartmentsPkSearch
   */
  public void setDisplayDepartmentsPkSearch(String value)
  {
    setAttributeInternal(DISPLAYDEPARTMENTSPKSEARCH, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesLocationView.
   */
  public RowIterator getArcFilesLocationView()
  {
    return (RowIterator) getAttributeInternal(ARCFILESLOCATIONVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesLockersView.
   */
  public RowIterator getArcFilesLockersView()
  {
    return (RowIterator) getAttributeInternal(ARCFILESLOCKERSVIEW);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link ArcFilesLocationDepartmentMasterRVO.
   */
  public RowIterator getArcFilesLocationDepartmentMasterRVO()
  {
    return (RowIterator) getAttributeInternal(ARCFILESLOCATIONDEPARTMENTMASTERRVO);
  }
}

