package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
public interface AccountService extends IService<Account> {
    List<Account> findAll();
    void saveUser(Account emp);
    void deleteUser(String id);
    Account findOneUser(String id);
    void updateUser(Account user);
    void register(Account user);
    Account login(Account user);

}
