package buzz.xiaolan.framework.ai.shell;

import org.apache.felix.framework.Felix;
import org.apache.felix.framework.FrameworkFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description HelloComponent
 */
@ShellComponent
public class HelloComponent {

    private FelixHandler felixHandler;

    @ShellMethod(key = {"hello", "hi"}, value = "运行插件")
    public String hello(String name) {
        Felix felix = felixHandler.getFelix();
        BundleContext bundleContext = felix.getBundleContext();
        Bundle bundle = bundleContext.getBundle();
        ServiceReference<?>[] registeredServices = bundle.getRegisteredServices();

        for (ServiceReference<?> serviceReference : registeredServices) {
            System.out.println(serviceReference);
        }

        return "运行成功: " + name;
    }

    @ShellMethod(key = {"add"}, value = "绑定插件")
    public String add(String path) throws BundleException {

        Felix felix = felixHandler.getFelix();
        BundleContext bundleContext = felix.getBundleContext();
        Bundle bundle = bundleContext.installBundle(path);
        for (ServiceReference<?> registeredService : bundle.getRegisteredServices()) {
            System.out.println(registeredService);
        }
        return "绑定成功";
    }


    @Autowired
    public void setFelixHandler(FelixHandler felixHandler) {
        this.felixHandler = felixHandler;
    }

    public static void main(String[] args) throws BundleException {
        FrameworkFactory frameworkFactory = new FrameworkFactory();
        Map<String, String> config = new HashMap<>();
        Felix felix = (Felix) frameworkFactory.newFramework(config);
        felix.start();

        for (ServiceReference<?> registeredService : felix.getRegisteredServices()) {
            System.out.println(registeredService);
        }


        BundleContext bundleContext = felix.getBundleContext();
        Bundle bundle = bundleContext.installBundle("file:\\project\\xiaolan-framework-ai\\bundle\\xiaolan-ai-plugins-0.0.1-SNAPSHOT.jar");

        bundle.start();

        ServiceReference<?>[] registeredServices = bundle.getRegisteredServices();
        for (ServiceReference<?> serviceReference : registeredServices) {
            System.out.println(serviceReference);
        }

        felix.stop();
    }
}
