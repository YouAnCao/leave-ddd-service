package ddd.leave.domain.leave.repository.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`approval_info`")
public class ApprovalInfoPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String approvalInfoId;

    @Column(name = "`leave_id`")
    private String leaveId;

    @Column(name = "`applicant_id`")
    private String applicantId;

    @Column(name = "`approver_id`")
    private String approverId;

    @Column(name = "`approver_level`")
    private int approverLevel;

    @Column(name = "`approver_name`")
    private String approverName;

    @Column(name = "`msg`")
    private String msg;

    @Column(name = "`time`")
    private long time;

}
