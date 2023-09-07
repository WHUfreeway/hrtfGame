package hetftest.online.gameLinker.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    private int idstudent;
    private String studentname;
}
