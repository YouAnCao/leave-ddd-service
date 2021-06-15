package ddd.leave.interfaces.dto;

import lombok.Data;

@Data
public class ApplicantDTO {

    private String personId;

    private String personName;

    private String leaderId;

    private String applicantType;

    private String roleLevel;

}
