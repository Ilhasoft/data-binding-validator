package br.com.ilhasoft.support.validation.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomRuleCaller {
    public static boolean isString(String func, String arg){
        final String clazzName = func.substring(0,func.lastIndexOf("."));
        final String funcName = func.substring(func.lastIndexOf(".")+1);
        try {
            final Class c = Class.forName(clazzName);
            Method m = c.getDeclaredMethod(funcName, String.class);
            Object o = m.invoke(null, arg);
            return (boolean) o;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
