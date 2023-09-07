package hetftest.online.gameLinker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hetftest.online.gameLinker.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> getAllStudents(@Param("idstudent") Integer idstudent, @Param("studentname") String studentname);
}
