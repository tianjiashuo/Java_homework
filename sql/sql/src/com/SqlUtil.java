package com;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
//创建接口
public interface SqlUtil {

    /**
     * 根据传入的参数返回查询语句
     * @param user
     * @return 返回查询语句
     */
    String query(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     */
    String insert(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    /**
     * 根据传入的参数返回插入语句
     * @param users
     * @return 返回插入语句
     */
    String insert(List<User> users) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     * @param user
     * @return 返回删除语句
     */
    String delete(User user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    /**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     * @param user
     * @return 返回更新语句
     */
    String update(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException;
}
