package ddd.leave.interfaces.dto;

import lombok.Data;

@Data
public class ApprovalInfoDTO {

    private String approvalInfoId;

    private ApproverDTO approverDTO;

    private String msg;

    private long time;

}
