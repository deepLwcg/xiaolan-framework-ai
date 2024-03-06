package buzz.xiaolan.framework.ai.shell;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.FrameworkFactory;
import org.osgi.framework.BundleException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description FelixHandle
 */
@Getter
@Component
public class FelixHandler {

    private Felix felix;


    @PostConstruct
    public void init() throws BundleException {
        FrameworkFactory frameworkFactory = new FrameworkFactory();
        Map<String, String> config = new HashMap<>();
        felix = (Felix)frameworkFactory.newFramework(config);
        felix.start();
    }

}
