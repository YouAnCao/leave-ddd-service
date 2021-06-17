package ddd.leave.interfaces.facade;

import ddd.leave.application.cqrs.c.CommandBus;
import ddd.leave.application.cqrs.c.ext.CreatePersonCommand;
import ddd.leave.application.cqrs.c.ext.DeletePersonCommand;
import ddd.leave.application.cqrs.c.ext.ModifyPersonCommand;
import ddd.leave.application.cqrs.q.GetPersonInfoService;
import ddd.leave.domain.person.entity.Person;
import ddd.leave.infrastructure.common.api.Response;
import ddd.leave.interfaces.assembler.PersonAssembler;
import ddd.leave.interfaces.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * 人员 用户接口层
 * CQRS 实现案例
 */
@RestController
@Slf4j
public class PersonApi {

    @Resource
    private GetPersonInfoService GetPersonInfoService;

    @Resource
    private CreatePersonCommand createPersonCommand;

    @Resource
    private ModifyPersonCommand modifyPersonCommand;

    @Resource
    private DeletePersonCommand deletePersonCommand;

    @Resource
    private CommandBus commandBus;

    @PostMapping("/person.json")
    public Response create(@RequestBody PersonDTO personDTO) {
        try {
            commandBus.dispatch(createPersonCommand, PersonAssembler.toDO(personDTO));
            return Response.ok();
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
    }

    @PutMapping("/person.json")
    public Response update(@RequestBody PersonDTO personDTO) {
        try {
            commandBus.dispatch(modifyPersonCommand, PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
        return Response.ok();
    }

    @DeleteMapping("/person/{personId}")
    public Response delete(@PathVariable String personId) {
        commandBus.dispatch(deletePersonCommand, personId);
        return Response.ok();
    }

    @GetMapping("/person/{personId}")
    public Response get(@PathVariable String personId) {
        Person person = GetPersonInfoService.findById(personId);
        return Response.ok(PersonAssembler.toDTO(person));
    }

    @GetMapping("/person/findFirstApprover.json")
    public Response findFirstApprover(@RequestParam String applicantId, @RequestParam int leaderMaxLevel) {
        Person person = GetPersonInfoService.findFirstApprover(applicantId, leaderMaxLevel);
        return Response.ok(PersonAssembler.toDTO(person));
    }

}
