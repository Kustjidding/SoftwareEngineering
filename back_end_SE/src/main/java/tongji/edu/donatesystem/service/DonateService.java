package tongji.edu.donatesystem.service;

import tongji.edu.DonatesystemApplication;
import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Donate;
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
public interface DonateService extends IService<Donate> {
    List<Donate> findAll();
    void saveDonate(Donate donate); //添加募捐记录
    void deleteDonate(String id); //删除募捐记录
    List<Donate> findDonatebyUid(String uid); //根据捐助者查询募捐记录
    List<Donate> findDonatebyPid(String pid); //根据项目编号查询募捐记录
    Donate findDonatebyTradeNo(String outTradeNo); //根据订单号查询募捐记录
    void updateDonate(Donate donate); //更改项目


}
