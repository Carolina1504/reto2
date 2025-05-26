package runners;

public @interface CucumberOptions {

    String features();

    String[] plugin();

    String[] glue();

    boolean monochrome();

}
