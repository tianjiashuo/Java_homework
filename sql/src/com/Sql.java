package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Sql implements SqlUtil {
    @Override
    public String query(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuffer result = new StringBuffer();
        String CLASS_NAME = "com.User";
        Class<?> clazz = Class.forName(CLASS_NAME);
        Field[] fields = clazz.getDeclaredFields();

        boolean flag = clazz.isAnnotationPresent(Table.class);
        //获取表名
        if (flag){
            Table table = (Table)clazz.getAnnotation(Table.class);
            result.append("SELECT * FROM `" + table.tableName()+"` WHERE");
        }
        //获取成员变量
        Set<Field> set = new HashSet<Field>();
        for (int i = 0; i < fields.length; i++) {
            boolean flag2 = fields[i].isAnnotationPresent(Column.class);
            if(flag2){
                set.add(fields[i]);
            }
        }
        //获取非空成员变量
        Map<String,String> selectColumn = new HashMap<>();
        for (Field m:set) {
            Column column = m.getAnnotation(Column.class);
//            System.out.print(column.columnName());
//            System.out.println(clazz.getMethod("get"+initCap(column.columnName())).invoke(user));
            if(clazz.getMethod("get"+initCap(column.columnName())).invoke(user)!=null){
//                    System.out.println("ok");
                String content = clazz.getMethod("get"+initCap(column.columnName())).invoke(user).toString();
                selectColumn.put(column.columnName(),content);
            }
        }
        for (Map.Entry<String,String> s:selectColumn.entrySet()){
            result.append("`"+s.getKey()+"` = "+"`"+s.getValue()+"`");
            result.append(" AND ");
        }
        String query = result.substring(0,result.length()-5);
        return query;
    }

    @Override
    public String insert(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuffer result = new StringBuffer();
        String CLASS_NAME = "com.User";
        Class<?> clazz = Class.forName(CLASS_NAME);
        Field[] fields = clazz.getDeclaredFields();

        boolean flag = clazz.isAnnotationPresent(Table.class);
        //获取表名
        if (flag){
            Table table = (Table)clazz.getAnnotation(Table.class);
            result.append("INSERT INTO `" + table.tableName() +"`");
        }
        //获取成员变量
        Set<Field> set = new HashSet<Field>();
        for (int i = 0; i < fields.length; i++) {
            boolean flag2 = fields[i].isAnnotationPresent(Column.class);
            if(flag2){
                set.add(fields[i]);
            }
        }
        //获取成员变量的值
        Map<String,String> selectColumn = new HashMap<>();
        for (Field m:set) {
            Column column = m.getAnnotation(Column.class);
            if(clazz.getMethod("get"+initCap(column.columnName())).invoke(user)!=null){
                String content = clazz.getMethod("get"+initCap(column.columnName())).invoke(user).toString();
                selectColumn.put(column.columnName(),content);
            }
        }

        StringBuffer keys = new StringBuffer();
        keys.append(" (");
        for (Map.Entry<String,String> s:selectColumn.entrySet()){
            keys.append("`"+s.getKey()+"`, ");
        }
        String string1 = keys.substring(0,keys.length()-2);
        result.append(string1+") VALUES");

        StringBuffer values = new StringBuffer();
        values.append(" (");
        for (Map.Entry<String,String> s:selectColumn.entrySet()){
            values.append("`"+s.getValue()+"`, ");
        }
        String string2 = values.substring(0,values.length()-2);
        result.append(string2+")");
        String insert = result.toString();
        return insert;
    }

    @Override
    public String insert(List<User> users) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        StringBuffer result = new StringBuffer();
        String CLASS_NAME = "com.User";
        Class<?> clazz = Class.forName(CLASS_NAME);
        Field[] fields = clazz.getDeclaredFields();

        boolean flag = clazz.isAnnotationPresent(Table.class);
        //获取表名
        if (flag){
            Table table = (Table)clazz.getAnnotation(Table.class);
            result.append("INSERT INTO `" + table.tableName() +"`");
        }
        //获取成员变量
        Set<Field> set = new HashSet<Field>();
        for (int i = 0; i < fields.length; i++) {
            boolean flag2 = fields[i].isAnnotationPresent(Column.class);
            if(flag2){
                set.add(fields[i]);
            }
        }
        //获取成员变量的值
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            Map<String,String> map = new HashMap<>();
            for (Field m:set)
            {
                Column column = m.getAnnotation(Column.class);
                if (clazz.getMethod("get" + initCap(column.columnName())).invoke(users.get(i)) != null) {
                    String content = clazz.getMethod("get" + initCap(column.columnName())).invoke(users.get(i)).toString();
                    map.put(column.columnName(), content);
                }
            }
            if(count == 0){
                StringBuffer keys = new StringBuffer();
                keys.append(" (");
                for (Map.Entry<String,String> s:map.entrySet()){
                    keys.append("`"+s.getKey()+"`, ");
                }
                String string1 = keys.substring(0,keys.length()-2);
                result.append(string1+") VALUES");
            }

            StringBuffer values = new StringBuffer();
            values.append(" (");
            for (Map.Entry<String,String> s:map.entrySet()){
                values.append("`"+s.getValue()+"`, ");
            }
            String string2 = values.substring(0,values.length()-2);
            result.append(string2+") ,");
            count ++;
        }

        String insert = result.substring(0,result.length()-2);
        return insert;
    }

    @Override
    public String delete(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        StringBuffer result = new StringBuffer();
        String CLASS_NAME = "com.User";
        Class<?> clazz = Class.forName(CLASS_NAME);
        Field[] fields = clazz.getDeclaredFields();

        boolean flag = clazz.isAnnotationPresent(Table.class);
        if (flag){
            Table table = (Table)clazz.getAnnotation(Table.class);
            result.append("DELETE FROM `" + table.tableName()+"` WHERE");
        }

        Set<Field> set = new HashSet<Field>();
        for (int i = 0; i < fields.length; i++) {
            boolean flag2 = fields[i].isAnnotationPresent(Column.class);
            if(flag2){
                set.add(fields[i]);
            }
        }

        Map<String,String> map = new HashMap<>();
        for (Field m:set) {
            Column column = m.getAnnotation(Column.class);
            if(clazz.getMethod("get"+initCap(column.columnName())).invoke(user)!=null){
                String content = clazz.getMethod("get"+initCap(column.columnName())).invoke(user).toString();
                map.put(column.columnName(),content);
            }
        }
        for (Map.Entry<String,String> s:map.entrySet()){
            result.append(" `"+s.getKey()+"` = "+"`"+s.getValue()+"`");
        }
        String delete = result.toString();
        return delete;
    }

    @Override
    public String update(User user) throws  NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        StringBuffer result = new StringBuffer();
        String CLASS_NAME = "com.User";
        Class<?> clazz = Class.forName(CLASS_NAME);
        Field[] fields = clazz.getDeclaredFields();

        boolean flag = clazz.isAnnotationPresent(Table.class);
        if (flag){
            Table table = (Table)clazz.getAnnotation(Table.class);
            result.append("UPDATE `" + table.tableName()+"` SET");
        }
        Set<Field> set = new HashSet<Field>();
        for (int i = 0; i < fields.length; i++) {
            boolean flag2 = fields[i].isAnnotationPresent(Column.class);
            if(flag2){
                set.add(fields[i]);
            }
        }
        Map<String,String> map = new HashMap<>();
        for (Field s:set) {
            Column column = s.getAnnotation(Column.class);
            if(clazz.getMethod("get"+initCap(column.columnName())).invoke(user)!=null){
                String content = clazz.getMethod("get"+initCap(column.columnName())).invoke(user).toString();
                map.put(column.columnName(),content);
            }
        }
        for (Map.Entry<String,String> m:map.entrySet()){
            if(!m.getKey().equals("id")){
                result.append(" `"+m.getKey()+"` = "+"`"+m.getValue()+"`");
                result.append(",");
            }
        }
        int length = result.length();
        result.append(" WHERE `id` = "+map.get("id"));
        String update = result.delete(length-1,length).toString();
        return update;
    }

    public static String initCap(String str){
        //name->Name
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
