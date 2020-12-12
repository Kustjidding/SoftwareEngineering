package tongji.edu.donatesystem.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kunshen
 * @since 2020-11-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@TableName(value = "report")
public class Report implements Serializable {

    private static final long serialVersionUID=1L;

      private String rUser;

    private Integer rProject;

    private String reason;

    private Integer type; // 0表示提交审核，1表示延期审核，2表示结题审核，3表示证明报告
    private LocalDateTime changeTime; //延期审核要延期的日期



}
