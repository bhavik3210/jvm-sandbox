package com.spring.expression.language;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

//public class AppExpressionParser {
//    public static void main(String[] args) {
//        SpelExpressionParser spelParser = new SpelExpressionParser();
//
//        /* Simple Expressions */
//        Expression helloWorldExpression = spelParser.parseExpression("'Hello World'");
//        String textFromHelloWorldExpression = (String) helloWorldExpression.getValue();
//        print("Simple String: " + helloWorldExpression.getExpressionString() + " => " + textFromHelloWorldExpression);
//
//        Expression stringLengthExpression = spelParser.parseExpression("'Hello World'.length()");
//        print("Method Call: " + stringLengthExpression.getExpressionString() + " => " + stringLengthExpression.getValue());
//
//        Expression operationExpression = spelParser.parseExpression("'Hello World'.length() * 10");
//        print("Math Operation: " + operationExpression.getExpressionString() + " => " + operationExpression.getValue());
//
//        Expression conditionalExpression = spelParser.parseExpression("'Hello World'.length() > 10");
//        print("Conditional Evalutation: " + conditionalExpression.getExpressionString() + " => " + conditionalExpression.getValue());
//
//        Expression conditionEvaluationExpression = spelParser.parseExpression("'Hello World'.length() > 10 and 'Hello World'.length() < 10");
//        print("Conditional Evalutation: " + conditionEvaluationExpression.getExpressionString() + " => " + conditionEvaluationExpression.getValue());
//
//        System.out.println("");
//
//        /* Evaluation Context */
//        StandardEvaluationContext ec1 = new StandardEvaluationContext();
//        ec1.setVariable("greeting", "Hello World!");
//        print((String) spelParser.parseExpression("#greeting.substring(6)").getValue(ec1));
//
//        User user = new User();
//        StandardEvaluationContext customUserContext = new StandardEvaluationContext(user);
//        spelParser.parseExpression("country").setValue(customUserContext, "Brazil");
//        spelParser.parseExpression("language").setValue(customUserContext, "Portuguese");
//        print(user.toString());
//
//        /* systemProperties */
//        StandardEvaluationContext systemPropsContext = new StandardEvaluationContext();
//        systemPropsContext.setVariable("systemProperties", System.getProperties());
//
//        // add  -Duser.timezone=Chicago    in VM Options
//        Expression expTimezone = spelParser.parseExpression("#systemProperties['user.timezone']");
//        spelParser.parseExpression("timezone").setValue(customUserContext, expTimezone.getValue(systemPropsContext));
//
//        // add  -Duser.name=JohnDoe      in VM Options
//        Expression expName = spelParser.parseExpression("#systemProperties['user.name']");
//        spelParser.parseExpression("name").setValue(customUserContext, expName.getValue(systemPropsContext));
//
//
//        print(user.toString());
//
//
//    }
//
//    public static void print(String message) {
//        System.out.println(message);
//    }
//}

