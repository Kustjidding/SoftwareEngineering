package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Info;
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
public interface InfoService extends IService<Info> {
    List<Info> findAll();
    void saveInfo(Info info);
    void clearInfo(String id);
    Info findOneInfo(String id); //根据用户id查询个人信息
    void updateInfo(Info info); //修改个人信息
    void initInfo(String id); // 初始化个人信息
    void deleteInfo(String id);//根据id删除个人信息

}
