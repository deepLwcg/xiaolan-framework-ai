package buzz.xiaolan.framework.ai.server;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description AiServerApplication
 */

@SpringBootApplication
public class AiServerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder(AiServerApplication.class);
        application.bannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
