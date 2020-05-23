package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.utils.AutoGeneration;
import com.utils.DateUtil;
import com.utils.IdCardUtil;
import com.utils.Md5Util;
import com.yidiandian.dao.SeckillUserinfoDao;
import com.yidiandian.entity.SeckillUserinfo;
import com.yidiandian.enums.UserBusinessEnums;
import com.yidiandian.request.SeckillLoginRequest;
import com.yidiandian.request.SeckillUserinfoRequest;
import com.yidiandian.service.SeckillUserinfoService;
import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (SeckillUserinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-05-23 11:18:28
 */
@Service
@Slf4j
public class SeckillUserinfoServiceImpl implements SeckillUserinfoService {

    @Autowired
    private SeckillUserinfoDao seckillUserinfoDao;

    @Value( "${md5.private.key}" )
    private String md5Key;

    /**
     * 用户注册
     *
     * @param userinfoRequest
     * @return
     */
    @Override
    public ResponseResult register(SeckillUserinfoRequest userinfoRequest) {

        log.info( "用户注册请求参数：{}" , JSON.toJSONString(userinfoRequest) );
        SeckillUserinfo seckillUserinfo = new SeckillUserinfo();

        if (StringUtils.isEmpty( userinfoRequest.getIdCard() )){
            return ResponseResult.error(UserBusinessEnums.ID_CARD_NULL.getCode(),UserBusinessEnums.ID_CARD_NULL.getMessage(),null);
        }
        SeckillUserinfo querySeckillUserinfo = queryByParams(userinfoRequest);
        if (querySeckillUserinfo != null){
            return ResponseResult.error( UserBusinessEnums.USER_ALREADY_EXISTS.getCode(),UserBusinessEnums.USER_ALREADY_EXISTS.getMessage(),querySeckillUserinfo);
        }
        saveSeckillUserInfoMessage( userinfoRequest, seckillUserinfo );
        return ResponseResult.success(seckillUserinfo);
    }

    private void saveSeckillUserInfoMessage(SeckillUserinfoRequest userinfoRequest, SeckillUserinfo seckillUserinfo) {

        BeanCopier beanCopier = BeanCopier.create(SeckillUserinfoRequest.class,SeckillUserinfo.class,false  );
        beanCopier.copy(userinfoRequest, seckillUserinfo,null );
        validateIfIdCardNull( userinfoRequest, seckillUserinfo );
        seckillUserinfo.setUserId( AutoGeneration.getStringRandom(9) );
        seckillUserinfo.setPassword( Md5Util.md5(seckillUserinfo.getPassword(),md5Key) );
        this.seckillUserinfoDao.insert(seckillUserinfo);
    }

    private void validateIfIdCardNull(SeckillUserinfoRequest userinfoRequest, SeckillUserinfo seckillUserinfo) {
        Map<String, String> carInfo = IdCardUtil.getCarInfo( seckillUserinfo.getIdCard());

        if (StringUtils.isEmpty( userinfoRequest.getTelPhone() )){
            seckillUserinfo.setTelPhone( userinfoRequest.getPhone() );
        }
        if (StringUtils.isEmpty(userinfoRequest.getAge())){
            seckillUserinfo.setAge( Integer.valueOf( carInfo.get( "age" ) ) );
        }
        if (StringUtils.isEmpty(userinfoRequest.getBirthday())){
            seckillUserinfo.setBirthday( DateUtil.getDate(  carInfo.get( "birthday" ),DateUtil.dateFormat));
        }
        if (StringUtils.isEmpty( userinfoRequest.getGender() )){
            seckillUserinfo.setGender( Integer.valueOf( carInfo.get( "gender" ) ) );
        }
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeckillUserinfo queryById(Integer id) {
        return this.seckillUserinfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SeckillUserinfo> queryAllByLimit(int offset, int limit) {
        return this.seckillUserinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param seckillUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillUserinfo insert(SeckillUserinfo seckillUserinfo) throws Exception {

        return seckillUserinfo;
    }

    /**
     * 修改数据
     *
     * @param seckillUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public SeckillUserinfo update(SeckillUserinfo seckillUserinfo) {
        this.seckillUserinfoDao.update(seckillUserinfo);
        return this.queryById(seckillUserinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.seckillUserinfoDao.deleteById(id) > 0;
    }

    /**
     * 根据条件查询秒杀用户
     *
     * @param userinfoRequest
     * @return
     */
    @Override
    public SeckillUserinfo queryByParams(SeckillUserinfoRequest userinfoRequest) {
        log.info( "根据条件查询秒杀用户请求参数：{}",JSON.toJSONString( userinfoRequest ) );

        SeckillUserinfo queryParams = new SeckillUserinfo();
        queryParams.setIdCard( userinfoRequest.getIdCard() );
        List<SeckillUserinfo> userinfoList = seckillUserinfoDao.queryAll( queryParams );
        if (CollectionUtils.isEmpty( userinfoList )){
            return null;
        }
        return userinfoList.get( 0 );
    }

    /**
     * 用户登录
     *
     * @param seckillLoginRequest
     * @return
     */
    @Override
    public ResponseResult login(SeckillLoginRequest seckillLoginRequest) {
        SeckillUserinfoRequest userinfoRequest = new SeckillUserinfoRequest();
        userinfoRequest.setUserName(seckillLoginRequest.getUserName());
        SeckillUserinfo seckillUserinfo = queryByParams( userinfoRequest );
        if (seckillUserinfo == null){
            return ResponseResult.error( UserBusinessEnums.USER_DOES_NOT_EXIST.getCode(),UserBusinessEnums.USER_DOES_NOT_EXIST.getMessage(),null );
        }
        if (Md5Util.verify( seckillLoginRequest.getPassword(), md5Key,seckillUserinfo.getPassword())){
            return ResponseResult.success( seckillUserinfo );
        }
        return ResponseResult.error( "用户密码错误" );
    }
}