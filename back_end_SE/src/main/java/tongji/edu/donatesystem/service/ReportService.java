package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
public interface ReportService extends IService<Report> {
    List<Report> findAll();
    void saveReport(Report report);
    void deleteReport(String id);
    Report findReportByUser(String uid); // 根据举报人id查询Report
    Report findReportByProject(String pid); // 根据项目名id查询Report
    void updateReport(Report report);
    void recallreport(int pid,String uid); //提交申请撤回报告
    void addStartCommit(int pid,String uid);//提交项目的申请报告
    void examine(String id); //管理员审核申请
    List<Report> findByKind(int type); //寻找相应类别的申请report
    List<Map<String,Object>> findHelp(String pid);
}
