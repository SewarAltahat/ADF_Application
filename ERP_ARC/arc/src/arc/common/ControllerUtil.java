package arc.common;

import com.sd.util.adf.ADFUtils;

import gen.common.GenLib;

import oracle.jbo.ViewObject;

public class ControllerUtil
{
  public static void filterArcSecurityLevelsAndDepartments(String iteratorName)
  {
    ViewObject vo = ADFUtils.findIterator(iteratorName).getViewObject();

    String securityLevelWhereClause = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("DOCUMENT_SECURITY_FK");
    String fromDepartmentWhereClause = GenLib.getFilterByDepartmentWhereClause("FROM_DEPARTMENT_FK");
    String toDepartmentWhereClause = GenLib.getFilterByDepartmentWhereClause("TO_DEPARTMENT_FK");
    
    String whereClause = securityLevelWhereClause + " AND " +
            " ( (" + fromDepartmentWhereClause + ") OR (" + toDepartmentWhereClause + " ) )";
    vo.setWhereClause(whereClause);
    vo.executeQuery();
  }
  
  
  
  public static void filterArcSecurityLevelsAndDepartmentsAndDisposedFl(String iteratorName)
  {
    ViewObject vo = ADFUtils.findIterator(iteratorName).getViewObject();
    
    String securityLevelWhereClause = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("DOCUMENT_SECURITY_FK");
    String fromDepartmentWhereClause = GenLib.getFilterByDepartmentWhereClause("FROM_DEPARTMENT_FK");
    String toDepartmentWhereClause = GenLib.getFilterByDepartmentWhereClause("TO_DEPARTMENT_FK");
    String DisposedFl = "(ORIGINAL_DOCUMENT_DISPOSED_FL IS NULL  OR ORIGINAL_DOCUMENT_DISPOSED_FL = 0 )";
    String DocExpiryDate = "(Doc_Expiry_Date IS NOT NULL )";

   
    String whereClause = " ( " +securityLevelWhereClause + " AND " +
            " ( (" + fromDepartmentWhereClause +") OR ("+ toDepartmentWhereClause + " ) ))" + " AND " + DisposedFl+ " AND "+DocExpiryDate;
    vo.setWhereClause(whereClause);
    vo.executeQuery();
  }
}