package buzz.xiaolan.framework.ai.shell;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description ShellApplication
 */

@SpringBootApplication
public class ShellApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder(ShellApplication.class);
        application.web(WebApplicationType.NONE);
        application .bannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
