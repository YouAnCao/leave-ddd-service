package ddd.leave.infrastructure.common.event;

import lombok.Data;

import java.util.Date;

@Data
public class DomainEvent {

    private String id;

    private Date timestamp;

    private String source;

    private String data;

}
