package com.company;

public class WebAppBuilderFactory {
    private enum TypeParser {SAX, STaX, DOM}

    public AbstractWebAppBuilder createWebAppBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
        //  case DOM:
        //     // return new WebAppDOMBuilder();
        //  case STaX:
        //     // return new WebAppSTaXBuilder();
            case SAX:
                return new WebAppSAXBuilder();

            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
