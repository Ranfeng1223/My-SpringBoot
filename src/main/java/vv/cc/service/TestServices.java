package vv.cc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vv.cc.dao.TestDao;
import vv.cc.entity.TestPOJO;

import java.util.List;

/**
 * Created by melo on 2016/12/8.
 */
@Service
public class TestServices {

    @Autowired
    private TestDao testDao;

    public String show(){
        return "hello world";
    }

    public TestPOJO showDao(String id){
        return testDao.selectByPrimaryKey(id);
    }
}
