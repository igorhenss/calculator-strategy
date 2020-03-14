package com.igorhenss.domain.operation;

import com.igorhenss.domain.Number;

public interface Operation {

    Double operate(Double x, Double y);

    Boolean hasIdentityElement();

    Number getIdentityElement();

}
