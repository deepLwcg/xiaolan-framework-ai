package buzz.xiaolan.framework.ai.plugins;

import buzz.xiaolan.framework.ai.plugins.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceRegistration;

/**
 * @Author Wang Chenguang
 * @Email wcg.chen@foxmail.com
 * @Date on 2024/3/6
 * @Description HelloActivator
 */
@Slf4j
public class HelloActivator implements BundleActivator, ServiceListener {
    private ServiceRegistration<HelloService> serviceRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.addServiceListener(this);
        serviceRegistration = bundleContext.registerService(HelloService.class, new HelloServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        bundleContext.removeServiceListener(this);
        serviceRegistration.unregister();
    }


    @Override
    public void serviceChanged(ServiceEvent event) {
        String[] objectClass = (String[])
                event.getServiceReference().getProperty("objectClass");

        if (event.getType() == ServiceEvent.REGISTERED) {
            log.warn(
                    "Ex1: Service of type " + objectClass[0] + " registered.");
        } else if (event.getType() == ServiceEvent.UNREGISTERING) {
            log.warn(
                    "Ex1: Service of type " + objectClass[0] + " unregistered.");
        } else if (event.getType() == ServiceEvent.MODIFIED) {
            log.warn(
                    "Ex1: Service of type " + objectClass[0] + " modified.");
        }

    }
}
