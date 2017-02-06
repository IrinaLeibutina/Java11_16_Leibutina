package com.company.nodes;

public class Filter {

    private String filterName;
    private String filterClass;
    private InitParam initParam = new InitParam();

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterClass() {
        return filterClass;
    }

    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }


    public InitParam getInitParam() {
        return initParam;
    }

    public void setAddress(InitParam initParam) {
        this.initParam = initParam;
    }

    @Override
    public String toString() {
        return "\n\tFilter" +
                "\nfilterName='" + filterName + '\'' +
                ", \nfilterClass='" + filterClass + '\'' +
                ", \ninitParam=" + initParam;

    }

    public static class InitParam {

        private String paramName;
        private String paramValue;

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public String getParamValue() {
            return paramValue;
        }

        public void setParamValue(String paramValue) {
            this.paramValue = paramValue;
        }

        @Override
        public String toString() {
            return "\n\tInitParam" +
                    "\nparamName='" + paramName + '\'' +
                    ", paramValue='" + paramValue + '\'';
        }
    }

}


