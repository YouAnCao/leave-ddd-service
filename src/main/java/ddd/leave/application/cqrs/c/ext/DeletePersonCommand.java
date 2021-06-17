package ddd.leave.application.cqrs.c.ext;

import ddd.leave.application.cqrs.c.Command;
import ddd.leave.application.service.PersonApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 编辑人员命令处理类
 */
@Service
public class DeletePersonCommand implements Command<String> {

    @Resource
    private PersonApplicationService personApplicationService;

    @Override
    public Object execute(String personId) {
        // 具体的逻辑
        personApplicationService.deleteById(personId);
        return null;
    }

}
