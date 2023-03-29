package com.kedom.productService.controller;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.kedom.common.entity.productServiceEntity.PmsCategory;
import com.kedom.productService.entity.context.LogRecordContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        ParserContext context = new TemplateParserContext("{", "}");

        Expression springContextStr = parser.parseExpression("ok{#bb}", context);


        String expressionString = "ok{bb}{cc}";
        expressionString =expressionString.replaceAll("\\{", "{#root.get('");
        expressionString = expressionString.replaceAll("\\}", "')}");


        Expression MyContext = parser.parseExpression(expressionString, context);
        LogRecordContext.putVariable("bb", "my");
        LogRecordContext.putVariable("cc", "maay");
        System.out.println(MyContext.getValue(LogRecordContext.getVariables()));//okmy




        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("bb", "spring");
        evaluationContext.registerFunction("my", TestMain.class.getDeclaredMethods()[0]);


        System.out.println(springContextStr.getValue(evaluationContext)); //okpring
    }
}
