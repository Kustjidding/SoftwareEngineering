package tongji.edu.donatesystem.service;

import tongji.edu.donatesystem.entity.Account;
import tongji.edu.donatesystem.entity.Report;
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
public interface ReportService extends IService<Report> {
    List<Report> findAll();
    void saveReport(Report report);
    void deleteReport(String id);
    Report findReportByUser(String uid); // 根据举报人id查询Report
    Report findReportByProject(String pid); // 根据项目名id查询Report
    void updateReport(Report report);
}
