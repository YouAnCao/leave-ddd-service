package ddd.leave.application.cqrs.c;

import org.springframework.stereotype.Component;

/**
 * 命令总线
 */
@Component
public class CommandBus {

    /**
     * 命令分发
     *
     * @param cmd
     * @param model
     * @param <T>
     * @return
     */
    public <T> Object dispatch(Command<T> cmd, T model) {
        return cmd.execute(model);
    }

}
