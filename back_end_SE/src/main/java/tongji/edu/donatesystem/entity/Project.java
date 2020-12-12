package tongji.edu.donatesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@TableName(value = "project")
public class Project implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "p_id", type = IdType.AUTO)
      private Integer pId;

    private String pName;

    private String pPath;

    private String pUser;

    private LocalDateTime endtime;

    private Float amount;

    private Float current;

    private String status; //"已结题","筹款中","审核中"


}
