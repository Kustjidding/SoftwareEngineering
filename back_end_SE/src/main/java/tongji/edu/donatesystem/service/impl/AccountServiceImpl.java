package tongji.edu.donatesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.mapper.AccountMapper;
import tongji.edu.donatesystem.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@Service
@MapperScan("tongji.edu.donatesystem.mapper")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public List<Account> findAll() {
        QueryWrapper wrapper =new QueryWrapper();
             wrapper.orderByAsc("user_id");
        return mapper.selectList(wrapper);
    }

    @Override
    public void saveUser(Account user) {
        mapper.insert(user);
    }


    @Override
    public void deleteUser(String id) {

        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("user_id",id);
        if(mapper.selectOne(wrapper)==null){
            throw new RuntimeException("用户不存在！");
        }
        mapper.delete(wrapper);
    }

    @Override
    public Account findOneUser(String id) {
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("user_id",id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public void updateUser(Account user) {
        mapper.updateById(user);

    }

    @Override
    public void register(Account user) {
        //0.根据输入的用户名判断用户是否存在？
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",user.getUsername());
        Account userDB = mapper.selectOne(wrapper);
        if(userDB== null) {
            // 3.调用用户的Dao层
            mapper.insert(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }

    }

    @Override
    public Account login(Account user) {
        //1.根据用户输入的用户名
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",user.getUsername());
        Account userDB = mapper.selectOne(wrapper);
        if(!ObjectUtils.isEmpty(userDB)){
            //如果找到username的用户
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }else{
                throw new RuntimeException("密码输入不正确！");
            }
        }else {
            throw new RuntimeException("用户名输入不正确！");
        }
    }
}
