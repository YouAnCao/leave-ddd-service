# Domain-Driven Design Example
## leave-ddd-service
## 基于领域驱动设计的请假微服务
v1：
1. 建立DDD四层代码目录结构
2. 各层采用对应的数据对象 VO DTO DO PO
3. 用户接口层使用 assembler类 以及 DTO类 完成数据转换（DTO）
4. 用户接口层为外部用户访问底层系统提供交互界面和数据表示（DTO）
5. 应用层负责 组合/编排/转发 领域服务，面向用例构建执行顺序，以及结果对象的构建（安全，事务控制）（DTO DO）
6. 领域层基于领域服务（聚合）实现实体的核心业务逻辑（DO）
7. 基础设施层 使用仓储/工厂模式 与基础数据产生初始化以及持久化关系（PO）
8. 使用领域事件进行领域外的通知调用

v2:
1. 加入CQRS样例代码