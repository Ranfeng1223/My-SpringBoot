package vv.cc.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import vv.cc.entity.TestPOJO;
import vv.cc.service.TestServices;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by melo on 2016/12/7.
 */
@Api(value = "/test",tags = {"spring-boot"},description = "spring-boot测试")
@RestController
public class SpringController {

    @Autowired
    private TestServices testServices;


    @RequestMapping(value="/show")
    public String show(){
        return testServices.show();
    }

    @ApiOperation(value = "查询用户信息",notes = "根据id查询用户信息",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "token",value = "身份验证令牌",required = true,paramType = "path",dataType = "String")})
    @ApiResponses(value =  {
            @ApiResponse(code = 505,message = "token错误"),
            @ApiResponse(code = 200,message = "成功")
    })
    @RequestMapping(value="/showDao/{id}",method = RequestMethod.GET)
    public Object showDao(@ApiParam(value = "id",required = true)@PathVariable("id") String id){
        Map<String,Object> map = new HashMap<String,Object>();
        TestPOJO tp = testServices.showDao(id);
        map.put("account_data",tp);
        return map;
    }
}
