package arc.controller.bean;

import com.sd.util.adf.ADFUtils;

import java.util.Iterator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class FilesLocationTreeBean
{
  public FilesLocationTreeBean()
  {
    super();
  }

  public void selectFileLocation(SelectionEvent selectionEvent)
  {
    String adfSelectionListener = "#{bindings.ArcFilesLocationMasterRVO.treeModel.makeCurrent}";
    FacesContext fctx = FacesContext.getCurrentInstance();
    Application application = fctx.getApplication();
    ELContext elCtx = fctx.getELContext();
    ExpressionFactory exprFactory = application.getExpressionFactory();

    MethodExpression me = exprFactory.createMethodExpression(elCtx, adfSelectionListener, Object.class,
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
      String FilesLocationPk = rw.getAttribute("FilesLocationPk") + "";
      ViewObject vo = ADFUtils.findIterator("ArcFilesLocationView4Iterator").getViewObject();     
      vo.executeQuery();
      ADFUtils.findIterator("ArcFilesLocationView4Iterator").setCurrentRowWithKeyValue(FilesLocationPk);
    }
  }
  
  public void selectFileLocationTable(SelectionEvent selectionEvent)
  {
    String adfSelectionListener = "#{bindings.ArcFilesLocationDepartmentRVO.collectionModel.makeCurrent}";
    FacesContext fctx = FacesContext.getCurrentInstance();
    Application application = fctx.getApplication();
    ELContext elCtx = fctx.getELContext();
    ExpressionFactory exprFactory = application.getExpressionFactory();

    MethodExpression me = exprFactory.createMethodExpression(elCtx, adfSelectionListener, Object.class,
                                         new Class[] { SelectionEvent.class });
    me.invoke(elCtx, new Object[] { selectionEvent });

    RichTable table = (RichTable) selectionEvent.getSource();

    //get selected nodes
    RowKeySet rowKeySet = selectionEvent.getAddedSet();
    Iterator<Object> rksIterator = rowKeySet.iterator();
    //for single select configurations,this only is called once
    while (rksIterator.hasNext())
    {
      @SuppressWarnings("unchecked")
      List<Object> key = (List<Object>) rksIterator.next();
      JUCtrlHierBinding treeBinding = null;
      CollectionModel collectionModel = (CollectionModel) table.getValue();
      treeBinding = (JUCtrlHierBinding) collectionModel.getWrappedData();
      JUCtrlHierNodeBinding nodeBinding = null;
      nodeBinding = treeBinding.findNodeByKeyPath(key);
      Row rw = nodeBinding.getRow();
      String FilesLocationPk = rw.getAttribute("FilesLocationPk") + "";
      ViewObject vo = ADFUtils.findIterator("ArcFilesLocationView4Iterator").getViewObject();     
      vo.executeQuery();
      ADFUtils.findIterator("ArcFilesLocationView4Iterator").setCurrentRowWithKeyValue(FilesLocationPk);
    }
  }
  
  public void updateFilesLocationFk(DialogEvent dialogEvent)
  {
   Object FilesLocationPk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "FilesLocationPk");
   Object DisplayFilesLocationFk = ADFUtils.getAttributeInViewObject("ArcFilesLocationView4", "DisplayFileLocationDesc");

    ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "FilesLocationFk",FilesLocationPk);
   ADFUtils.setAttribute("ArcOldDocumentView1Iterator", "DisplayFilesLocationFk",DisplayFilesLocationFk); 

  }
}
