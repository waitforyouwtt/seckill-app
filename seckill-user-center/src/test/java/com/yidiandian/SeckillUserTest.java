package com.yidiandian;

import com.google.gson.Gson;
import com.utils.IdCardUtil;
import com.utils.ResultInfo;
import com.utils.Search;
import com.utils.SecurityUtil;
import com.yidiandian.entity.SeckillUserinfo;
import com.yidiandian.service.SeckillUserinfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 11:27
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Component
@Slf4j
public class SeckillUserTest extends SeckillUserCenterApplicationTests {

    @Value( "${md5.private.key}" )
    private String md5Key;

    @Value( "${aes.private.key}" )
    private String aesKey;

    @Value( "${des.private.key}" )
    private String desKey;

    @Value( "${seckill.private.key}" )
    private String seckillPrivateKey;

    @Value( "${seckill.public.key}" )
    private String seckillPublicKey;


    public static final String secretKey = "seckillabcd1234e";

    @Autowired
    SeckillUserinfoService seckillUserinfoService;

    @Test
    public void save() throws Exception {
        SeckillUserinfo userinfo = new SeckillUserinfo();

        userinfo.setUserId( "003" );
        userinfo.setUserName( "张杰" );
        userinfo.setNickName( "兔牙妹妹" );
        userinfo.setPassword( "2fdfasdfs" );
        userinfo.setIdCard( "411421199308236039" );
        userinfo.setWeChat( "1140867582" );
        userinfo.setQq( "1140867582" );
        userinfo.setPhone( "17621007255" );
        userinfo.setTelPhone( "17621007255" );
        userinfo.setHomeAddress( "河南沈丘" );
        userinfo.setStatus( 0 );
        userinfo.setCreateTime( new Date(  ) );
        userinfo.setUpdateTime( new Date(  ) );
        SeckillUserinfo insert = seckillUserinfoService.insert( userinfo );
        log.info( "添加秒杀用户信息：{}",insert );

    }

    @Test
    public void toolTest() throws Exception {
        Map<String, String> carInfo = IdCardUtil.getCarInfo( "411421199308236039" );
        log.info( "根据身份证获取生日，年龄，性别：{}",carInfo );
    }

    @Test
    public void queryMessage(){
        Search s = new Search("your_key" ) ;
        String result = s.seatchID("330326198903081211");
        Gson gson = new Gson() ;
        ResultInfo resultInfo  = gson.fromJson(result, ResultInfo.class);
        System.out.println("根据聚合网站获取用户信息，暂未使用");
    }

    @Test
    public void securityUtilTest() throws Exception {
        String base64Encode = SecurityUtil.base64Encode( "hello" );
        log.info( "base 加密的结果：{}",base64Encode );
        String base64Decode = SecurityUtil.base64Decode( "aGVsbG8=" );
        log.info( "base 解密的结果：{}",base64Decode );
        String aesEncrypt = SecurityUtil.aesEncrypt( "hello", aesKey );
        log.info( "aes 加密后的结果：{}", aesEncrypt);
        String aesDecrypt = SecurityUtil.aesDecrypt("4f73450efa5e821710ec4826e5bcf59b",aesKey);
        log.info( "aes 解密的结果：{}",aesDecrypt );
        String  desEncrypt = SecurityUtil.desEncrypt("hello",desKey);
        log.info( "des 加密后的结果：{}", desEncrypt);
        String  desDecrypt = SecurityUtil.desDecrypt("e945e4c64c350676",desKey);
        log.info( "des 解密后的结果：{}", desDecrypt);
        String threeDesEncrypt = SecurityUtil.threeDesEncrypt("hello",secretKey);
        log.info( "3DES 加密后的结果：{}", threeDesEncrypt);
        String threeDesDecrypt = SecurityUtil.threeDesDecrypt ("72a83431c13f3b5a",secretKey);
        log.info( "3DES 解密后的结果：{}", threeDesDecrypt);
        //生成公钥 私钥
        // SecurityUtil.genKeyPair();
        String rsaEncrypt  = SecurityUtil.buildRSAEncryptByPublicKey("hello",seckillPublicKey);
        log.info( "rsa公钥加密 加密后的结果:{}",rsaEncrypt );
        String rsadecrypt = SecurityUtil.buildRSADecryptByPrivateKey("hMmeArCX78GxmrZ1FZ0L-k0dIIfY1wS7SditgSJQp9Gzr9MLSamhdV5htWRzeC4QwYXts5sW_1DECnLK_imUf5rYS0PBoG__cTqiWznZsLGBWj_D1BMV2o_B1KA0we7jhvoGhrxm_W8eI86MWZ5KiaJ6-FdT-U564Xew2OWBR4o",seckillPrivateKey);
        log.info( "rsa私钥解密 解密后的结果：{}", rsadecrypt);
    }

    @Test
    public void rsaTest() throws NoSuchAlgorithmException {


    }
}
