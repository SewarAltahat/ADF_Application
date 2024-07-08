package arc.controller.bean;


public class FileLocationsStandardBean extends ArcBaseBean
{

  public void displayStandardDescChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFlStandardsView1Iterator", "FlStandardsPk", "ArcFlStandardsTlView1Iterator", "StandardDesc");
  }

  public void displayNotesChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFlStandardsView1Iterator", "FlStandardsPk", "ArcFlStandardsTlView1Iterator", "Notes");
  }

  public void displayFileLocationDescChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFlsLocationsView1Iterator", "FlsLocationsPk", "ArcFlsLocationsTlView3Iterator", "FileLocationDesc");
  }

  public void displayFileLocationNotesChanged(javax.faces.event.ValueChangeEvent vce)
  {
    masterTranslationChanged(vce, "ArcFlsLocationsView1Iterator", "FlsLocationsPk", "ArcFlsLocationsTlView3Iterator", "Notes");
  }

  public void commitArcFlStandardsTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFlStandardsView1Iterator");
  }

  public void cancelArcFlStandardsTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFlStandardsView1Iterator");
  }

  public void commitArcFlsLocationsTlTranslation(oracle.adf.view.rich.event.DialogEvent de)
  {
    commitTranslation(de, "ArcFlsLocationsView1Iterator");
  }

  public void cancelArcFlsLocationsTlTranslation(oracle.adf.view.rich.event.PopupCanceledEvent de)
  {
    cancelTranslation(de, "ArcFlsLocationsView1Iterator");
  }

}