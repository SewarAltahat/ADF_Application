package arc.controller.bean;

import gen.common.BaseMenuBean;

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class MenuBean extends BaseMenuBean
{
  public boolean isArcDocumentVisible()
  {
    return getUserScreenPrivilege("arcDocument");
  }
}
