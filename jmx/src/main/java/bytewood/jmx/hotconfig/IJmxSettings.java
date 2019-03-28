package bytewood.jmx.hotconfig;

public interface IJmxSettings {
    Long getId();
    void setId(final Long id);
    String getName();
    void setName(final String name);
    boolean isFlag();
    void setFlag(final boolean flag);
    String getValue();
    void setValue(final String value);
    void refresh(final int delayInSeconds);
}
