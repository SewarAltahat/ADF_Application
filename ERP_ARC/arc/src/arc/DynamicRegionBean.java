package arc;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class DynamicRegionBean
  implements Serializable
{

    public static String taskFlowId = "/WEB-INF/NoDataTF.xml#NoDataTF";

  public DynamicRegionBean()
  {
  }

  public TaskFlowId getDynamicTaskFlowId()
  {
    return TaskFlowId.parse(taskFlowId);
  }

  public void setDynamicTaskFlowId(String taskFlowId)
  {
    this.taskFlowId = taskFlowId;
  }
}
