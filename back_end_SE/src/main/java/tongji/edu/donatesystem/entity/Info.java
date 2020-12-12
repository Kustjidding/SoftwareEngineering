package tongji.edu.donatesystem.entity;

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
@TableName(value = "info")
public class Info implements Serializable {

    private static final long serialVersionUID=1L;

      private String infoUser;

    private String realname;

    private String idnumber;

    private String sex;

    private Integer age;

    private String userpath;


}
