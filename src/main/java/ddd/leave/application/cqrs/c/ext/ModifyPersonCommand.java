package ddd.leave.application.cqrs.c.ext;

import ddd.leave.application.cqrs.c.Command;
import ddd.leave.application.service.PersonApplicationService;
import ddd.leave.domain.person.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 编辑人员命令处理类
 */
@Service
public class ModifyPersonCommand implements Command<Person> {

    @Resource
    private PersonApplicationService personApplicationService;

    @Override
    public Object execute(Person person) {
        // 具体的逻辑
        personApplicationService.update(person);
        return null;
    }

}
