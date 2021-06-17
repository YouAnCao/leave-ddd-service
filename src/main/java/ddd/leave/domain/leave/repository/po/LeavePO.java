package ddd.leave.domain.leave.repository.po;

import ddd.leave.domain.leave.entity.Leave;
import ddd.leave.domain.leave.entity.valueobject.LeaveType;
import ddd.leave.domain.leave.entity.valueobject.Status;
import ddd.leave.domain.person.entity.valueobject.PersonType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "`leave`")
public class LeavePO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String id;

    @Column(name = "`applicant_id`")
    private String applicantId;

    @Column(name = "`applicant_name`")
    private String applicantName;

    @Enumerated(EnumType.STRING)
    @Column(name = "`applicant_type`")
    private PersonType applicantType;

    @Column(name = "`approver_id`")
    private String approverId;

    @Column(name = "`approver_name`")
    private String approverName;

    @Enumerated(EnumType.STRING)
    @Column(name = "`leave_type`")
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    @Column(name = "`status`")
    private Status status;

    @Column(name = "`start_time`")
    private Date startTime;

    @Column(name = "`end_time`")
    private Date endTime;

    @Column(name = "`duration`")
    private long duration;

    @Transient
    private List<ApprovalInfoPO> historyApprovalInfoPOList;

    public Leave toLeave() {
        return new Leave();
    }

}
