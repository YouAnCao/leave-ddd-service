package ddd.leave.application.cqrs.c;

/**
 * 命令处理base接口
 */
public interface Command<T> {

    /**
     * 执行
     *
     * @param commandModel
     * @return
     */
    Object execute(T commandModel);

}
