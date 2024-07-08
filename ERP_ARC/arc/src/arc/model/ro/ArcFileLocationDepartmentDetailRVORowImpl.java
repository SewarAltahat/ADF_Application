package arc.model.ro;

import java.math.BigDecimal;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 19 17:14:54 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ArcFileLocationDepartmentDetailRVORowImpl
  extends ViewRowImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    FilesLocationPk,
    DisplayFilesLocationPk,
    MainLocationFk,
    DepartmentsFk,
    FilesLocationPkArcFileLocationDepartmentDetailRVO;
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


  public static final int FILESLOCATIONPK = AttributesEnum.FilesLocationPk.index();
  public static final int DISPLAYFILESLOCATIONPK = AttributesEnum.DisplayFilesLocationPk.index();
  public static final int MAINLOCATIONFK = AttributesEnum.MainLocationFk.index();
  public static final int DEPARTMENTSFK = AttributesEnum.DepartmentsFk.index();
  public static final int FILESLOCATIONPKARCFILELOCATIONDEPARTMENTDETAILRVO =
    AttributesEnum.FilesLocationPkArcFileLocationDepartmentDetailRVO.index();

  /**
   * This is the default constructor (do not remove).
   */
  public ArcFileLocationDepartmentDetailRVORowImpl()
  {
  }
}

