package com.tyb1222.aspect;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelParser {

    private final static ExpressionParser parser = new SpelExpressionParser();

    public static String getValue(String key, String[] parms, Object[] args) {
        Expression expression = parser.parseExpression(key);
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        if (null == evaluationContext) {
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            evaluationContext.setVariable(parms[i], args[i]);
        }
        return expression.getValue(evaluationContext, String.class);
    }

    public static void main(String[] args) {
        String exp = "#id+ '' + #code";
        String id = "001";
        String code = "bei1ing";
        String [] param = new String[]{"id","code"};
        Object[] values = new Object[]{id, code};
        System.out.println(SpelParser.getValue(exp,param,values));

    }
}
