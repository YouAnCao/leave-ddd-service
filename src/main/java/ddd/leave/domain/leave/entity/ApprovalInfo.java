package ddd.leave.domain.leave.entity;

import ddd.leave.domain.leave.entity.valueobject.ApprovalType;
import ddd.leave.domain.leave.entity.valueobject.Approver;
import lombok.Data;

@Data
public class ApprovalInfo {

    private String approvalInfoId;

    private Approver approver;

    private ApprovalType approvalType;

    private String msg;

    private long time;

}
