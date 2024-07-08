package arc.controller.bean;

import com.sd.util.adf.ADFUtils;

import com.sd.util.adf.JSFUtils;

import com.sd.util.common.Util;
import gen.common.GenLib;

import java.io.OutputStream;

import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import java.math.BigDecimal;

public class ArcDocumentViewBean extends ArcBaseBean
{

  private RichDocument arcDocumentsView;

  public ArcDocumentViewBean()
  {
    if (!AdfFacesContext.getCurrentInstance().isPostback())
    { 
//      ViewObject vo = ADFUtils.findIterator("ArcOldDocumentView3Iterator").getViewObject();
//      vo.setWhereClause("1=2");
//      vo.executeQuery();
      
      GenLib.filterByDepartmentAndSecurityLevels("HcmDepartmentsVwDocumentViewIterator", "DEPARTMENTS_PK",
                                                 "DEPARTMENTS_PK");
      GenLib.filterDocumentsBySecurityLevels("ArcOldDocumentView3Iterator");
    }
  }

  public void downloadDocumentAttachment(FacesContext context, OutputStream os)
  {
    downloadFileWithWaterMarks(context, os, (String)JSFUtils.getFromSession("fullPath"));
  }

  public void selectFileLocation(SelectionEvent selectionEvent)
    {
      String adfSelectionListener = "#{bindings.ArcFilesLocationDepartmentMasterRVO.treeModel.makeCurrent}";
      FacesContext fctx = FacesContext.getCurrentInstance();
      Application application = fctx.getApplication();
      ELContext elCtx = fctx.getELContext();
      ExpressionFactory exprFactory = application.getExpressionFactory();

      MethodExpression me = null;
      me =
        exprFactory.createMethodExpression(elCtx, adfSelectionListener, Object.class,
                                           new Class[] { SelectionEvent.class });
      me.invoke(elCtx, new Object[] { selectionEvent });

      RichTree tree = (RichTree) selectionEvent.getSource();

      //get selected nodes
      RowKeySet rowKeySet = selectionEvent.getAddedSet();
      Iterator<Object> rksIterator = rowKeySet.iterator();
      //for single select configurations,this only is called once
      while (rksIterator.hasNext())
      {
        @SuppressWarnings("unchecked")
        List<Object> key = (List<Object>) rksIterator.next();
        JUCtrlHierBinding treeBinding = null;
        CollectionModel collectionModel = (CollectionModel) tree.getValue();
        treeBinding = (JUCtrlHierBinding) collectionModel.getWrappedData();
        JUCtrlHierNodeBinding nodeBinding = null;
        nodeBinding = treeBinding.findNodeByKeyPath(key);
        Row rw = nodeBinding.getRow();
        BigDecimal FilesLocationPk   = (BigDecimal)rw.getAttribute("FilesLocationPk");
        ViewObject vo = ADFUtils.findIterator("ArcOldDocumentView3Iterator").getViewObject();
        String securityLevelWhereClause = GenLib.getFiterDocumentsBySecurityLevelsWhereClause("DOCUMENT_SECURITY_FK");
        vo.setWhereClause("FILES_LOCATION_FK = " + FilesLocationPk + " AND ( " + securityLevelWhereClause + ")");
        ViewObject vo1 = ADFUtils.findIterator("ArcFilesLocationTlView1Iterator").getViewObject();
        vo1.setWhereClause("FILES_LOCATION_FK = " + FilesLocationPk);
        vo.executeQuery();
        vo1.executeQuery();
        
//        ADFUtils.findIterator("ArcFilesLocationView4Iterator").setCurrentRowWithKeyValue(FilesLocationPk);
     }
    }

  public void setArcDocumentsView(RichDocument arcDocumentsView)
  {
    this.arcDocumentsView = arcDocumentsView;
  }

  public RichDocument getArcDocumentsView()
  {
    return arcDocumentsView;
  }



  public void refreshView(SelectionEvent selectionEvent)
  {
    Util.invokeMethod("#{bindings.HcmDepartmentsVwDocumentView.collectionModel.makeCurrent}", null, new Class[] {SelectionEvent.class},
                         new Object[] {selectionEvent});
    ViewObject vo = ADFUtils.findIterator("ArcOldDocumentView3Iterator").getViewObject();
    ViewObject vo1 = ADFUtils.findIterator("ArcFilesLocationDepartmentMasterRVOIterator").getViewObject();
    vo.setWhereClause("1=2");

    vo1.executeQuery();
    vo.executeQuery();

  }
}
