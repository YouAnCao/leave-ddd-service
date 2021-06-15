package ddd.leave.interfaces.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private String personId;

    private String personName;

    private String roleId;

    private String personType;

    private String createTime;

    private String lastModifyTime;

    private String status;

}
