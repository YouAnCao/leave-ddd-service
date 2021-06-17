package ddd.leave.interfaces.facade;

import ddd.leave.application.service.LoginApplicationService;
import ddd.leave.infrastructure.common.api.Response;
import ddd.leave.interfaces.assembler.PersonAssembler;
import ddd.leave.interfaces.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * 权限 用户接口层
 * 传统DDD 实现案例
 */
@RestController
@Slf4j
public class AuthApi {

    @Resource
    private LoginApplicationService loginApplicationService;

    @PostMapping("/auth/login.json")
    public Response login(@RequestBody PersonDTO personDTO) {
        try {
            return loginApplicationService.login(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
