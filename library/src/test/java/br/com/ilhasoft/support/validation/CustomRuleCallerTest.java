package br.com.ilhasoft.support.validation;

import org.junit.Test;

import br.com.ilhasoft.support.validation.util.CustomRuleCaller;

import static org.junit.Assert.assertEquals;

public class CustomRuleCallerTest {
    @Test
    public void it_is_foo() throws Exception {
        assertEquals(true, CustomRuleCaller.isString("br.com.ilhasoft.support.validation.CustomRuleCallerTest.isItFoo", "Foo"));
    }

    @Test
    public void it_is_not_foo() throws Exception {
        assertEquals(false, CustomRuleCaller.isString("br.com.ilhasoft.support.validation.CustomRuleCallerTest.isItFoo", "Bar"));
    }

    public static boolean isItFoo(String arg){
        return "foo".equals(arg.toLowerCase());
    }
}