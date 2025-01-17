package arc.model.ro;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 04 10:04:52 GMT+03:00 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SsoUsersRVORowImpl
  extends ViewRowImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  protected enum AttributesEnum
  {
    UsersTlPk,
    DisplayCreatedBy,
    UsersFk,
    DisplayDisposedBy;
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


  public static final int USERSTLPK = AttributesEnum.UsersTlPk.index();
  public static final int DISPLAYCREATEDBY = AttributesEnum.DisplayCreatedBy.index();
  public static final int USERSFK = AttributesEnum.UsersFk.index();
  public static final int DISPLAYDISPOSEDBY = AttributesEnum.DisplayDisposedBy.index();

  /**
   * This is the default constructor (do not remove).
   */
  public SsoUsersRVORowImpl()
  {
  }
}

