package hetftest.online.gameLinker;

import com.google.gson.Gson;
import hetftest.online.gameLinker.mapper.StudentMapper;
import hetftest.online.gameLinker.pojo.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
//    @Autowired
//    // private StudentMapper studentMapper;
//
//    private Gson gson = new Gson();
//    @GetMapping("/test")
//    public String test(){
//        List<Student> students = studentMapper.selectList(null);
//        return gson.toJson(students);
//    }
}
