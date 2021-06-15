package ddd.leave.domain.leave.repository.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ApprovalInfoPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String approvalInfoId;

    private String leaveId;

    private String applicantId;

    private String approverId;

    private int approverLevel;

    private String approverName;

    private String msg;

    private long time;

}
