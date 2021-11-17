package me.nimkoes.section_004;

import me.nimkoes.common.template.DurationTemplate;

import static me.nimkoes.section_004.Util.getRandomElem;
import static me.nimkoes.section_004.Util.tickOver;

public class UsingIf extends DurationTemplate {

    @Override
    public void coreLogic() {
        Elem elem = getRandomElem();

        if (Elem.ELEM_0.equals(elem)) tickOver();
        if (Elem.ELEM_1.equals(elem)) tickOver();
        if (Elem.ELEM_2.equals(elem)) tickOver();
        if (Elem.ELEM_3.equals(elem)) tickOver();
        if (Elem.ELEM_4.equals(elem)) tickOver();
        if (Elem.ELEM_5.equals(elem)) tickOver();
        if (Elem.ELEM_6.equals(elem)) tickOver();
        if (Elem.ELEM_7.equals(elem)) tickOver();
        if (Elem.ELEM_8.equals(elem)) tickOver();
        if (Elem.ELEM_9.equals(elem)) tickOver();
    }
}
