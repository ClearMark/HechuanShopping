package com.kedom.productService.aop;

import com.kedom.common.entity.productServiceEntity.PmsCategory;
import com.kedom.productService.entity.context.LogRecordContext;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LogRecordSpELParse {

    public static String parse(String expressionString) {
        expressionString =expressionString.replaceAll("\\{", "{#root.get('");
        expressionString = expressionString.replaceAll("\\}", "')}");
        TemplateParserContext templateParserContext = new TemplateParserContext("{", "}");
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expressionString,templateParserContext);
        return expression.getValue(LogRecordContext.getVariables()).toString();
    }
}
