package com.company.service.factory;

import com.company.service.AbstractWebAppBuilder;
import com.company.service.impl.dom.WebAppDOMBuilder;
import com.company.service.impl.sax.WebAppSAXBuilder;
import com.company.service.impl.stax.WebAppSTaXBuilder;

public class WebAppBuilderFactory {
    private enum TypeParser {SAX, STAX, DOM}

    public AbstractWebAppBuilder createWebAppBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new WebAppDOMBuilder();
            case STAX:
                return new WebAppSTaXBuilder();
            case SAX:
                return new WebAppSAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
