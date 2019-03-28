package bytewood.jmx.hotconfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({SettingsBean.class})
@EnableScheduling
@RequiredArgsConstructor
public class HotconfigApplication {

    private final SettingsBean settings;

    public static void main(String[] args) {
        SpringApplication.run(HotconfigApplication.class, args);
    }

    @Scheduled(initialDelay = 1000L, fixedDelay = 1000L)
    public void schedule() throws Exception {
        log.debug("{}", settings.getValue());
    }
}
