package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote.properties",
        "classpath:config/local.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("firefox")
    String browser();
    @DefaultValue("88.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
    @DefaultValue("4000")
    int timeout();
}
