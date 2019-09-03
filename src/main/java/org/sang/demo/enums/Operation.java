package org.sang.demo.enums;

/**
 * Created by CJF on 2019/5/27.
 */
public enum Operation {
    plus("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    sub("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    };
    private final String oper;

    Operation(String oper) {
        this.oper = oper;
    }

    public String getOper() {
        return oper;
    }

    Operation getValue(String oper) {
        for (Operation op : Operation.values()) {
            if(op.getOper().equals(oper)) {
                return op;
            }
        }
        return null;
    }

    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double a = 2, b = 5;
        for (Operation op : Operation.values()) {
            System.out.println(op.apply(a, b));
        }
    }
}
