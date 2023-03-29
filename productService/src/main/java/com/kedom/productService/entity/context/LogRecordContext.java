package com.kedom.productService.entity.context;


import org.springframework.expression.*;

import java.util.*;

public class LogRecordContext {

    private static final InheritableThreadLocal<Stack<Map<String, Object>>> VARIABLE_MAP_STACK = new InheritableThreadLocal<>();
    private static final InheritableThreadLocal<Map<String, Object>> GLOBAL_VARIABLE = new InheritableThreadLocal<>();
    private static final InheritableThreadLocal<LinkedList<String>> LOG_LIST = new InheritableThreadLocal<>();





    private static final String GLOBAL_Exception_KEY = "globalException";

    private LogRecordContext() {
        throw new IllegalStateException("Utility class");
    }

    public static void addLog(String log) {
        if (LOG_LIST.get() == null) {
            LinkedList<String> logList = new LinkedList<>();
            LOG_LIST.set(logList);
        }
        LOG_LIST.get().addFirst(log);
    }

    public static List<String> getLogList() {
        return LOG_LIST.get();
    }



    public Boolean isGlobalVariableEmpty() {
        return GLOBAL_VARIABLE.get() == null || GLOBAL_VARIABLE.get().isEmpty();
    }
    public static Boolean globalVariableExist(String key) {
        if (GLOBAL_VARIABLE.get() == null) {
            return false;
        }
        return GLOBAL_VARIABLE.get().containsKey(key);
    }
    public static Boolean globalExistException() {
       return globalVariableExist(GLOBAL_Exception_KEY);
    }
    public static void putException(Throwable throwable){
        putGlobalVariable(GLOBAL_Exception_KEY, throwable);
    }

    public static void putGlobalVariable(String global_exception_key, Object object) {
        if (GLOBAL_VARIABLE.get() == null) {
            Map<String, Object> map =new HashMap<>();
            GLOBAL_VARIABLE.set(map);
        }
        GLOBAL_VARIABLE.get().put(global_exception_key, object);
    }

    public static Object getGlobalVariable(String global_key) {
        if (GLOBAL_VARIABLE.get() == null) {
            return null;
        }
        return GLOBAL_VARIABLE.get().get(global_key);
    }

    public static void clearGlobalVariable(String name) {
        if (GLOBAL_VARIABLE.get() == null) {
            return;
        }
        GLOBAL_VARIABLE.get().remove(name);
    }

    public static void clearLogList() {
        if (LOG_LIST.get() == null) {
            return;
        }
        LOG_LIST.remove();
    }


    public static void putVariable(String name, Object value) {
        if (VARIABLE_MAP_STACK.get() == null) {
            Stack<Map<String, Object>> stack =new Stack<>();
            VARIABLE_MAP_STACK.set(stack);
        }
        Stack<Map<String, Object>> mapStack = VARIABLE_MAP_STACK.get();
        if (mapStack.empty()) {
            VARIABLE_MAP_STACK.get().push(new HashMap<>());
        }
        VARIABLE_MAP_STACK.get().peek().put(name, value);
    }

//    public static void putVariable(Object bean) {
//        if (VARIABLE_MAP_DEQUE.get() == null) {
//            Deque<Map<String, Object>> stack = new ArrayDeque<>();
//            VARIABLE_MAP_DEQUE.set(stack);
//        }
//        Deque<Map<String, Object>> mapStack = VARIABLE_MAP_DEQUE.get();
//        if (mapStack.isEmpty()) {
//            VARIABLE_MAP_DEQUE.get().push(new HashMap<>());
//        }



//        VARIABLE_MAP_DEQUE.get().element().put(name, value);
//    }




    public static Object getVariable(String key) {
        Map<String, Object> variableMap = VARIABLE_MAP_STACK.get().peek();
        return variableMap == null ? null : variableMap.get(key);
    }

    public static Map<String, Object> getVariables() {
        Stack<Map<String, Object>> mapStack = VARIABLE_MAP_STACK.get();
        return mapStack.peek();
    }

    public static void clear() {
        if (VARIABLE_MAP_STACK.get() == null) {
            return;
        }
        if (VARIABLE_MAP_STACK.get().size()>1) {
            VARIABLE_MAP_STACK.get().pop();
        }
    }

    public static void putEmptySpan() {
        Stack<Map<String, Object>> mapStack = VARIABLE_MAP_STACK.get();
        if (mapStack == null) {
            Stack<Map<String, Object>> stack = new Stack<>();
            VARIABLE_MAP_STACK.set(stack);
        }
        VARIABLE_MAP_STACK.get().push(new HashMap<>());
    }



}
