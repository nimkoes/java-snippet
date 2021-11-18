package me.nimkoes.section_006;

import me.nimkoes.common.template.DurationTemplate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsingSystemOutPrintln extends DurationTemplate {

    @Override
    public void coreLogic() {
        String localTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        String packageName = "me.nimkoes.section_006.";
        String message = "test print";

        System.out.println(localTime + " [main] INFO " + packageName + this.getClass().getSimpleName() + " - " + message);
    }
}
