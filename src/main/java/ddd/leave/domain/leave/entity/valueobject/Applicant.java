package ddd.leave.domain.leave.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {

    private String personId;

    private String personName;

    private String personType;

}
