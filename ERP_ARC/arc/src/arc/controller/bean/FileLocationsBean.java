package arc.controller.bean;

import com.sd.util.adf.ADFUtils;
import com.sd.util.db.DBUtil;

import gen.common.GenLib;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransactionImpl;
import oracle.jbo.server.ViewObjectImpl;

public class FileLocationsBean
  extends ArcBaseBean
{

  private RichDocument filelocations;

  public FileLocationsBean()
  {
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    {
      GenLib.filterByDepartmentAndSecurityLevels("HcmFileLocationDepartmentsViewIterator", "DEPARTMENTS_PK",
                                                 "DEPARTMENTS_PK");
    }
  }
  
  public void displayFilesLockersNameChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesLockersView2Iterator", "FilesLockersPk", "ArcFilesLockersTlView3Iterator", "FilesLockersName");
  }

  public void displayFilesLockersDescChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesLockersView2Iterator", "FilesLockersPk", "ArcFilesLockersTlView3Iterator", "FilesLockersDesc");
  }

  public void displayFilesLockersLocationChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesLockersView2Iterator", "FilesLockersPk", "ArcFilesLockersTlView3Iterator", "FilesLockersLocation");
  }
 
  public void displayFilesColumnsLockersNameChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesColumnsLockersView3Iterator", "FilesColumnsLockersPk", "ArcFilesColumnsLockersTlView3Iterator", "FilesColumnsLockersName");
  }
    

  public void commitArcFilesLockersTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFilesLockersView2Iterator");
  }

  public void cancelArcFilesLockersTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFilesLockersView2Iterator");
  }

  public void commitArcFilesColumnsLockersTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFilesColumnsLockersView3Iterator");
  }

  public void cancelArcFilesColumnsLockersTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFilesColumnsLockersView3Iterator");
  }
  
  public void commitArcFilesRowsColumnsLockersTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFilesRowsColumnsLockersView3Iterator");
  }

  public void cancelArcFilesRowsColumnsLockersTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFilesRowsColumnsLockersView3Iterator");
  }
  
  


  public void displayFileLocationDescChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesLocationView3Iterator", "FilesLocationPk", "ArcFilesLocationTlView3Iterator",
                             "FileLocationDesc");
  }

  public void displayFilesRowsColumnsLockerNameChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFilesRowsColumnsLockersView3Iterator", "FilesRowsColumnsLockersPk", "ArcFilesRowsColumnsLockersTlView3Iterator",
                             "FilesRowsColumnsLockerName");
  }

  

  public void commitArcFilesLocationTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFilesLocationView3Iterator");
  }

  public void cancelArcFilesLocationTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFilesLocationView3Iterator");
  }

  public void setFilelocations(RichDocument filelocations)
  {
    this.filelocations = filelocations;
  }

  public RichDocument getFilelocations()
  {
    return filelocations;
  }

  public void insertFileLocation(DialogEvent dialogEvent)
  {
    insertParent();
    ADFUtils.findIterator("ArcFilesLocationView3Iterator").executeQuery();
    ADFUtils.findIterator("ReportParametersRVO1Iterator").executeQuery();
    
  }

  public void cancelTranslation(PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFilesLocationView3Iterator");
    ADFUtils.findIterator("ReportParametersRVO1Iterator").executeQuery();
  }

  public void checkUniqukey(String FlStandardsName, BigDecimal FlStandardsFK, BigDecimal DepartmentsPk)
  {

    ViewObject ArcFilesLocationView = ADFUtils.getViewObjectFromAppModule("ArcFilesLocationView1");
    ViewObjectImpl ArcFlsLocationsVO =
      (ViewObjectImpl) ADFUtils.getDefaultApplicationModuleForDataControl().findViewObject("ArcFlsLocationsView1");
    ArcFlsLocationsVO.setWhereClause("FL_STANDARDS_FK = " + FlStandardsFK);
    ArcFilesLocationView.setWhereClause("DEPARTMENTS_FK = " + DepartmentsPk);
    ArcFlsLocationsVO.executeQuery();
    ArcFilesLocationView.executeQuery();
    int ArcFlsLocationsVOcount = (int) ArcFlsLocationsVO.getEstimatedRowCount();
    int ArcFilesLocationViewcount = (int) ArcFilesLocationView.getEstimatedRowCount();
    ArcFlsLocationsVO.first();
    ArcFilesLocationView.first();

    for (int i = 0; i < ArcFlsLocationsVOcount; i++)
    {
      for (int j = 0; j < ArcFilesLocationViewcount; j++)
      {
        if (ArcFlsLocationsVO.getCurrentRow().getAttribute("DisplayFileLocationDesc").equals(ArcFilesLocationView.getCurrentRow().getAttribute("DisplayFileLocationDesc")))
        {
          GenLib.showErrorMessage("error.DuplicateCode");
          throw new JboException("");
        }

        if (FlStandardsName.equals(ArcFilesLocationView.getCurrentRow().getAttribute("DisplayFileLocationDesc")))
        {
          GenLib.showErrorMessage("error.DuplicateCode");
          throw new JboException("");
        }
        ArcFilesLocationView.next();
      }
      ArcFlsLocationsVO.next();
    }
  }
  
  public void insertParent()
  {
    String StandardsName = "";
    String FlStandardsName = (String) ADFUtils.getAttribute("ReportParametersRVO1Iterator", "FlStandardsName");
    String DisplayEmployeesFk = (String) ADFUtils.getAttribute("ReportParametersRVO1Iterator", "DisplayEmployeesFk");
    
    if (FlStandardsName != null)
    {
      StandardsName = FlStandardsName;
    }
    else
    {
      StandardsName = DisplayEmployeesFk;
    }
    
    BigDecimal FilesLocationPk = (BigDecimal) ADFUtils.getAttributeInViewObject("ArcFilesLocationView1", "FilesLocationPk");
    BigDecimal FlStandardsFK = (BigDecimal) ADFUtils.getAttribute("ReportParametersRVO1Iterator", "FlStandardsFK");
    BigDecimal DepartmentsPk = (BigDecimal) ADFUtils.getAttribute("HcmFileLocationDepartmentsViewIterator", "DepartmentsPk");
    //checkUniqukey(StandardsName, FlStandardsFK, DepartmentsPk);
    ViewObject ArcFilesLocationView = ADFUtils.getViewObjectFromAppModule("ArcFilesLocationView1");
    Row ArcFilesLocationRow1 = ArcFilesLocationView.createRow();
    ArcFilesLocationRow1.setAttribute("DepartmentsFk", DepartmentsPk);
    ArcFilesLocationRow1.setAttribute("DisplayFileLocationDesc", StandardsName);
    ArcFilesLocationRow1.setAttribute("CreatedBy", GenLib.getUserPk());
    ArcFilesLocationRow1.setAttribute("CreationDate", GenLib.getCurrentDate());
    ArcFilesLocationView.insertRow(ArcFilesLocationRow1);
    ADFUtils.commitWithoutMessage();
    
    PreparedStatement parentStat = null;
    PreparedStatement insertStat = null;
    ResultSet parentRS = null;
    PreparedStatement parentTlStat = null;
    PreparedStatement insertTlStat = null;
    ResultSet parentTlRS = null;
    DBTransactionImpl dbTransaction = (DBTransactionImpl) ADFUtils.getDefaultDBTransaction();
    
    String parentSql = "select * from arc_fls_locations where main_location_fk is null and fl_standards_fk = " + FlStandardsFK;
    String insertSql = "INSERT INTO arc_files_location (files_location_pk, main_location_fk,departments_fk ," +
      "created_by,creation_date,user_department_fk,OPEN_FL)" +
      "VALUES (?,?,?,?,?,?,1) ";
    String insertTlSql = "INSERT INTO arc_files_location_tl (files_location_tl_pk, file_location_desc,LANGUAGES_FK ," +
      "FILES_LOCATION_FK ,created_by,creation_date,USER_DEPARTMENT_FK)" +
      "VALUES (?,?,?,?,?,?,?) ";
    try
    {
      parentStat = dbTransaction.createPreparedStatement(parentSql, 1);
      parentRS = parentStat.executeQuery();
      insertStat = dbTransaction.createPreparedStatement(insertSql, 1);
      while (parentRS.next())
      {
        BigDecimal fls_locations_pk = parentRS.getBigDecimal("fls_locations_pk");
        insertStat.setBigDecimal(1, null);
        insertStat.setBigDecimal(2, FilesLocationPk);
        insertStat.setBigDecimal(3, DepartmentsPk);
        insertStat.setBigDecimal(4, GenLib.getUserId());
        insertStat.setTimestamp(5, GenLib.getCurrentDate());
        insertStat.setBigDecimal(6, GenLib.getUserLoginDepartment());
        insertStat.executeUpdate();
        BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(dbTransaction, "ARC_FILES_LOCATION_SEQ");
        String parentTlSql = "select * from arc_fls_locations_tl where fls_locations_fk = " + fls_locations_pk;
        parentTlStat = dbTransaction.createPreparedStatement(parentTlSql, 1);
        parentTlRS = parentTlStat.executeQuery();
        insertTlStat = dbTransaction.createPreparedStatement(insertTlSql, 1);
        while (parentTlRS.next())
        {
          String FILE_LOCATION_DESC = parentTlRS.getString("FILE_LOCATION_DESC");
          BigDecimal LANGUAGES_FK = parentTlRS.getBigDecimal("LANGUAGES_FK");
          insertTlStat.setBigDecimal(1, null);
          insertTlStat.setString(2, FILE_LOCATION_DESC);
          insertTlStat.setBigDecimal(3, LANGUAGES_FK);
          insertTlStat.setBigDecimal(4, pk);
          insertTlStat.setBigDecimal(5, GenLib.getUserId());
          insertTlStat.setTimestamp(6, GenLib.getCurrentDate());
          insertTlStat.setBigDecimal(7, GenLib.getUserLoginDepartment());
          insertTlStat.executeUpdate();
        }
        insertChild(fls_locations_pk, pk, FlStandardsFK);
      }

      DBUtil.close(parentRS);
      DBUtil.close(parentTlRS);
    }
    catch (Exception e)
    {
      GenLib.handleException(e);
    }
    finally
    {
      DBUtil.close(parentRS);
      DBUtil.close(parentStat);
      DBUtil.close(insertStat);
      DBUtil.close(parentTlRS);
      DBUtil.close(parentTlStat);
      DBUtil.close(insertTlStat);
    }
    ADFUtils.commitWithoutMessage();
  }

  public void insertChild(BigDecimal p_main_location_fk, BigDecimal p_id, BigDecimal FlStandardsFK)
  {
    PreparedStatement childStat = null;
    PreparedStatement insertStat = null;
    ResultSet childRS = null;

    PreparedStatement childTlStat = null;
    PreparedStatement insertTlStat = null;
    ResultSet childTlRS = null;
    DBTransactionImpl dbTransaction = (DBTransactionImpl) ADFUtils.getDefaultDBTransaction();

    String childSql =
      "select   *   from arc_fls_locations where main_location_fk = " + p_main_location_fk +
      " and fl_standards_fk   = " + FlStandardsFK;

    String insertSql = "INSERT INTO arc_files_location (files_location_pk, main_location_fk,departments_fk," +
      "created_by,creation_date,user_department_fk,OPEN_FL)" +
      "VALUES (?,?,?,?,?,?,1) ";
    String insertTlSql = "INSERT INTO arc_files_location_tl (files_location_tl_pk, file_location_desc," +
      "LANGUAGES_FK ,FILES_LOCATION_FK ,created_by,creation_date,USER_DEPARTMENT_FK)" +
      "VALUES (?,?,?,?,?,?,?) ";

    try
    {
      childStat = dbTransaction.createPreparedStatement(childSql, 1);
      childRS = childStat.executeQuery();
      insertStat = dbTransaction.createPreparedStatement(insertSql, 1);
      while (childRS.next())
      {
        BigDecimal DepartmentsPk = (BigDecimal) ADFUtils.getAttribute("HcmFileLocationDepartmentsViewIterator", "DepartmentsPk");
        BigDecimal fls_locations_pk = childRS.getBigDecimal("fls_locations_pk");
        insertStat.setBigDecimal(1, null);
        insertStat.setBigDecimal(2, p_id);
        insertStat.setBigDecimal(3, DepartmentsPk);
        insertStat.setBigDecimal(4, GenLib.getUserId());
        insertStat.setTimestamp(5, GenLib.getCurrentDate());
        insertStat.setBigDecimal(6, GenLib.getUserLoginDepartment());
        insertStat.executeUpdate();
        
        BigDecimal pk = gen.common.GenLib.getPrimaryKeyValue(dbTransaction, "ARC_FILES_LOCATION_SEQ");
        String childTlSql = "select * from arc_fls_locations_tl where fls_locations_fk = " + fls_locations_pk;
        childTlStat = dbTransaction.createPreparedStatement(childTlSql, 1);
        childTlRS = childTlStat.executeQuery();
        insertTlStat = dbTransaction.createPreparedStatement(insertTlSql, 1);
      
        while (childTlRS.next())
        {
          String FILE_LOCATION_DESC = childTlRS.getString("FILE_LOCATION_DESC");
          BigDecimal LANGUAGES_FK = childTlRS.getBigDecimal("LANGUAGES_FK");
          insertTlStat.setBigDecimal(1, null);
          insertTlStat.setString(2, FILE_LOCATION_DESC);
          insertTlStat.setBigDecimal(3, LANGUAGES_FK);
          insertTlStat.setBigDecimal(4, pk);
          insertTlStat.setBigDecimal(5, GenLib.getUserId());
          insertTlStat.setTimestamp(6, GenLib.getCurrentDate());
          insertTlStat.setBigDecimal(7, GenLib.getUserLoginDepartment());
          insertTlStat.executeUpdate();
        }
        insertChild(fls_locations_pk, pk, FlStandardsFK);
      }
      DBUtil.close(childRS);
      DBUtil.close(childTlRS);
    }
    catch (Exception e)
    {
      GenLib.handleException(e);
    }
    finally
    {
      DBUtil.close(childRS);
      DBUtil.close(childStat);
      DBUtil.close(insertStat);
      DBUtil.close(childTlRS);
      DBUtil.close(childTlStat);
      DBUtil.close(insertTlStat);
    }
  }
  
  public String commitFile()
  {
    ADFUtils.commit();
    ADFUtils.findIterator("ArcFilesLocationView3Iterator").executeQuery();
    return null;
  }
}