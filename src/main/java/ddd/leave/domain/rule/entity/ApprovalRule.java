package ddd.leave.domain.rule.entity;

import ddd.leave.domain.leave.entity.Leave;
import lombok.Data;

@Data
public class ApprovalRule {

    private String personType;

    private String leaveType;

    private long duration;

    private int maxLeaderLevel;

    public static ApprovalRule getByLeave(Leave leave) {
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(leave.getApplicant().getPersonType());
        rule.setLeaveType(leave.getType().toString());
        rule.setDuration(leave.getDuration());
        return rule;
    }

}
