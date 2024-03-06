package buzz.xiaolan.framework.ai.plugins;

import buzz.xiaolan.framework.ai.plugins.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description HelloServiceImpl
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        log.warn("Hello " + name);
        return "Hello " + name;
    }
}
