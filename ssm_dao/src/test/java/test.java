import com.richard.dao.CourseMapper;
import com.richard.domain.CourseVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void test() {
        CourseVO courseVO = new CourseVO("文案",1);
        System.out.println(courseMapper.findCourseByConditioin(courseVO));
    }

}
