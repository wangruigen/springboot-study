package com.study.wrg.repository;

import com.study.wrg.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class UserRepository {

    public UserRepository() {
    }

    private static int id;

    //模拟数据库做增删改查操作的集合
    private static Vector<User> vector = new Vector<>();

    //初始化分配默认值
    static{
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setId(""+(++id));
            user.setName("name"+i);
            user.setAge(i);
            vector.add(user);
        }
    }


    /**
     * 查询所有User
     * @return
     */
    public Vector<User> selectAllUser() {
        return vector;
    }

    /**
     * 根据Id查询User
     * @param id
     * @return
     */
    public User selectUser(String id) {
        AtomicReference<User> result = new AtomicReference<>(null);
        vector.forEach(user -> { if (user.getId().equals(id)) result.set(user);});
        return result.get();
    }

    /**
     * 添加User
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        user.setId(""+(++id));
        vector.add(user);
        return true;
    }

    /**
     * 删除User
     * @param id
     * @return
     */
    public boolean deleteUser(String id) {
        Iterator<User> iterator = vector.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * 更改User
     * @param user
     * @return
     */
    public boolean updateUser(User user){
        for (User updateUser : vector) {
            if (updateUser.getId().equals(user.getId())) {
                updateUser.setName(user.getName());
                updateUser.setAge(user.getAge());
                return true;
            }
        }
        return false;
    }
}
