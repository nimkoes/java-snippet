package me.nimkoes.section_006;

import lombok.extern.slf4j.Slf4j;
import me.nimkoes.common.template.DurationTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UsingLogback extends DurationTemplate {

    private static Logger logger = LoggerFactory.getLogger(UsingLogback.class);

    @Override
    public void coreLogic() {
        log.info("test print");
    }
}
