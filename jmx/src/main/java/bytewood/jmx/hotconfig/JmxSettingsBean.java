package bytewood.jmx.hotconfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
@ManagedResource(
        objectName = "bean:name=settingsBean",
        description = "Bean for dynamically updating settings"
)
@RequiredArgsConstructor
public class JmxSettingsBean implements IJmxSettings {

    private final SettingsBean settings;

    public Long getId() {
        return settings.getId();
    }

    public void setId(final Long id) {
        settings.setId(id);
    }

    public String getName() {
        return settings.getName();
    }

    public void setName(final String name) {
        settings.setName(name);
    }

    public boolean isFlag() {
        return settings.isFlag();
    }

    public void setFlag(final boolean flag) {
        settings.setFlag(flag);
    }

    @ManagedAttribute()
    public String getValue() {
        return settings.getValue().toString();
    }

    @ManagedAttribute(description = "A Mutable Value", persistPolicy = "OnUpdate")
    public void setValue(final String value) {
        settings.setValue(new BigDecimal(value));
    }

    @ManagedOperation(description = "Apply these attributes to bean that use them")
    @Override
    public void refresh(final int delayInSeconds) {
        log.debug("refreshing...");
    }
}
