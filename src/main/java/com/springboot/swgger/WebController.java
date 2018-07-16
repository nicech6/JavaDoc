package com.springboot.swgger;

import com.springboot.swgger.base.BaseResult;
import com.springboot.swgger.db.Shop;
import com.springboot.swgger.db.ShopRepository;
import com.springboot.swgger.mybatis.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "FirstApi", description = "相关接口")
public class WebController {
    @RequestMapping(value = "/user/{name}/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户接口", httpMethod = "GET", tags = "api")

    /**
     * 参数为字符串
     */
    public BaseResult getUserByName(@PathVariable String name, @PathVariable int id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        BaseResult result = new BaseResult();
        result.setData(userInfo);
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    /**
     * 参数为map
     */
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "返回Map", httpMethod = "GET", tags = "api")
    public BaseResult getUserName(@PathVariable String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        BaseResult result = new BaseResult();
        result.setData(map);
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    /**
     * 参数为list
     */
    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    @ApiOperation(value = "返回list", httpMethod = "GET", tags = "api")
    public BaseResult getList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        BaseResult result = new BaseResult();
        result.setData(stringList);
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * 参数为 RequestBody
     */

    @RequestMapping(value = "/body/{body}", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "参数为Body", httpMethod = "POST", tags = "api")
    public BaseResult getBody(@RequestBody UserInfo body) {
        BaseResult result = new BaseResult();
        result.setData(body);
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * RequestParam
     */
    @RequestMapping(value = "/user/param/{id}/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "有默认值", httpMethod = "GET", tags = "api")
    public BaseResult getUser(@RequestParam(value = "id", defaultValue = "1", required = false) Integer id, @RequestParam(value = "name", defaultValue = "cuihai") String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setId(id);
        BaseResult result = new BaseResult();
        result.setData(userInfo);
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * 查询数据库（shop）
     */
    @Autowired
    private ShopRepository shopRepository;

    @RequestMapping(value = "/shop/queryAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有数据", httpMethod = "GET", tags = "shop")
    @ResponseBody
    public List<Shop> queryAll() {
        List<Shop> list = new ArrayList<>();
        list = shopRepository.findAll();
        return list;
    }

    @Autowired
    private UserService userService;

    /**
     * 查询数据库(mybatis)
     */
    @RequestMapping(value = "/user/mybatis/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "mybatis查询name", httpMethod = "GET", tags = "user")
    public String queryId(@PathVariable("id") int id) {
        UserInfo userInfo = userService.userInfo(id);
        return userInfo.getName();
    }

    /**
     * 查询数据库(mybatis)
     */
    @RequestMapping(value = "/user/mybatis/", method = RequestMethod.GET)
    @ApiOperation(value = "mybatis查询name", httpMethod = "GET", tags = "user")
    public List<UserInfo> queryAllUser() {
        List<UserInfo> userList = userService.getUserList();
        return userList;
    }

    /**
     * 插入一条数据（mybatis)
     */
    @RequestMapping(value = "/user/mtbatis/insert/{id}/{name}/{money}", method = RequestMethod.GET)
    @ApiOperation(value = "mybatis插入数据", httpMethod = "GET", tags = "user")
    public BaseResult insertUser(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("money") String money) {
        userService.insertUser(id, name, money);
        BaseResult result = new BaseResult();
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * 删除一条数据（mybatis)
     */
    @RequestMapping(value = "/user/mybatis/delete/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "mybati删除数据", httpMethod = "GET", tags = "user")
    public BaseResult deleteUserById(@PathVariable("id") int id) {
        userService.delete(id);
        BaseResult result = new BaseResult();
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * 更新一条数据（mybatis)
     */
    @RequestMapping(value = "/user/mybatis/update/{id}/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "mybatis更细数据", httpMethod = "GET", tags = "user")
    public BaseResult updateResult(@PathVariable("id") int id, @PathVariable("name") String name) {
        userService.update(id, name);
        BaseResult result = new BaseResult();
        result.setMsg("suc");
        result.setCode(200);
        return result;
    }

    /**
     * 查询一条数据（redis字符串)
     */
    @RequestMapping(value = "/redis/{key}", method = RequestMethod.GET)
    @ApiOperation(value = "redis数据库", httpMethod = "GET", tags = "redis")
    public BaseResult redis(@PathVariable("key") String key) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String s = jedis.get(key);
        BaseResult result = new BaseResult();
        result.setMsg("suc");
        result.setCode(200);
        result.setData(s);
        return result;
    }
}