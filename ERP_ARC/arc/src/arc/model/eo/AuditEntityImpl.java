package arc.model.eo;

import gen.common.BaseAuditEntityImpl;

import oracle.jbo.server.EntityDefImpl;

public class AuditEntityImpl extends BaseAuditEntityImpl
{
  EntityDefImpl auditModificationDefImpl = ArcAuditModificationsImpl.getDefinitionObject();
  
  @Override
  public EntityDefImpl getAuditEntityInstance()
  {
    return auditModificationDefImpl;
  }
}
