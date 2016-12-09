package vv.cc.dao;

import org.apache.ibatis.annotations.Mapper;
import vv.cc.entity.TestPOJO;

import java.util.List;

/**
 * Created by melo on 2016/12/8.
 */
@Mapper
public interface TestDao {

    TestPOJO selectByPrimaryKey(String id);
}
