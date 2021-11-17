package me.nimkoes.section_004;

import me.nimkoes.common.template.DurationTemplate;

import static me.nimkoes.section_004.Util.*;

public class UsingSwitch extends DurationTemplate {

    @Override
    public void coreLogic() {
        switch (getRandomElem()) {
            case ELEM_0: tickOver(); break;
            case ELEM_1: tickOver(); break;
            case ELEM_2: tickOver(); break;
            case ELEM_3: tickOver(); break;
            case ELEM_4: tickOver(); break;
            case ELEM_5: tickOver(); break;
            case ELEM_6: tickOver(); break;
            case ELEM_7: tickOver(); break;
            case ELEM_8: tickOver(); break;
            case ELEM_9: tickOver(); break;
        }
    }
}
