package ddd.leave.domain.leave.repository.po;

import ddd.leave.domain.leave.event.LeaveEventType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "`leave_event`")
public class LeaveEventPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "`_id`")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "`leave_event_type`")
    private LeaveEventType leaveEventType;

    @Column(name = "`timestamp`")
    private Date timestamp;

    @Column(name = "`source`")
    private String source;

    @Column(name = "`data`")
    private String data;

}
