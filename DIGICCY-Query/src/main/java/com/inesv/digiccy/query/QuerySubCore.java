package com.inesv.digiccy.query;

import com.inesv.digiccy.dto.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/8 0008.
 */
@Component
public class QuerySubCore {

    private static Logger logger = LoggerFactory.getLogger(QuerySubCore.class);

    @Autowired
    private QueryRunner queryRunner;

    /**
     * Create by huguokai date:2016年11月8日14:18:00
     * @return list
     * @throws SQLException
     */
    public List<SubCoreDto> getSubRecordInfo(){
        String sql = "select * from t_inesv_sub_core";
        List<SubCoreDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubCoreDto>(SubCoreDto.class));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询认购中心所有币种失败");
        }
        return list;
    }

    public List<SubRecordDto> getAllSubRecordInfo(){
        String sql = "select r.id as id,c.coin_name as attr2,s.sub_name as sub_name,r.sub_price as sub_price," +
                "r.sub_num as sub_num,r.sum_price as sum_price," +
                "r.thaw_num as thaw_num,r.thaw_time as thaw_time," +
                "r.sur_frozen as sur_frozen,r.state as state,r.date as date," +
                "r.thaw_sum as thaw_sum,u.username as attr1 " +
                "from t_inesv_sub_record r " +
                "join t_inesv_coin_type c on r.coin_no = c.coin_no " +
                "join t_inesv_sub_core s on r.sub_name = s.id " +
                "join t_inesv_user u on r.user_no = u.user_no";
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询认购中心记录失败");
        }
        return list;
    }

    public SubCoreDto getSubCoreById(int id){
        String sql = "select * from t_inesv_sub_core where id = ?";
        SubCoreDto subCoreDto = null;
        Object params[] = {id};
        try {
            subCoreDto = queryRunner.query(sql,new BeanHandler<SubCoreDto>(SubCoreDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询认购中心所有币种失败");
        }
        return subCoreDto;
    }

    /**
     * Create by huguokai date:2016年11月8日14:17:52
     * @param coinType
     * @return list
     * @throws SQLException
     */
    public List<SubCoreDto> getSubRecordInfoByCoinType(Integer coinType){
        String sql = "select * from t_inesv_sub_core where coin_type = ?";
        Object params[] = {coinType};
        List<SubCoreDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubCoreDto>(SubCoreDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("根据货币种类查询认购中心失败");
        }
        return list;
    }



    /**
     * Create by huguokai date:2016年11月8日15:24:17
     * @param userNo
     * @return UserBalanceDto
     * @throws SQLException
     */
    public UserBalanceDto getUserBalance(Integer userNo,Integer coinType){
        String sql = "select * from t_inesv_user_balance where user_no = ? and coin_type = ?";
        Object params[] = {userNo,coinType};
        UserBalanceDto userBalanceDto = null;
        try {
            userBalanceDto = queryRunner.query(sql,new BeanHandler<UserBalanceDto>(UserBalanceDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("根据用户编号查询用户资产失败");
        }
        return userBalanceDto;
    }

    /**
     * create by huguokai date:2016年11月9日10:45:26
     * 查询用户信息记录
     * @param userNo
     * @return UserInfoDto
     */
     public UserInfoDto getUserInfo(Integer userNo){
         String sql = "select * from t_inesv_user where user_no = ?";
         Object params[] = {userNo};
         UserInfoDto uid = null;
         try {
             uid = queryRunner.query(sql,new BeanHandler<UserInfoDto>(UserInfoDto.class),params);
         } catch (SQLException e) {
             e.printStackTrace();
             logger.error("查询用户信息失败");
         }
         return uid;
     }

     /**
      * create by huguokai date:2016年11月9日10:45:26
      * 根据用户编号查找所有用户的信息
      * @param userNo
      * @return UserInfoDto
      */
      public InesvUserDto getInesvUserByUserNo(Integer userNo){
          String sql = "select * from t_inesv_user where user_no = ?";
          Object params[] = {userNo};
          InesvUserDto uid = null;
          try {
              uid = queryRunner.query(sql,new BeanHandler<InesvUserDto>(InesvUserDto.class),params);
              if(uid != null) {
              uid.setPassword((uid.getPassword()==null||uid.getPassword().isEmpty())?"0":"1");
              }
             // uid.setDeal_pwd((uid.getDeal_pwd()==null||uid.getDeal_pwd().isEmpty())?"0":"1");
          } catch (SQLException e) {
              e.printStackTrace();
              logger.error("查询用户信息失败");
          }
          return uid;
      }
      
    /**
     * create by huguokai date:2016年11月16日15:32:10
     * 查询认购记录
     * @param userNo
     * @return UserInfoDto
     */
    public List<SubRecordDto> getSubRecordInfo(Integer userNo,Integer coinType){
        String sql = "select * from t_inesv_sub_record where user_no = ? and coin_no = ? ";
        Object params[] = {userNo,coinType};
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询认购记录失败");
        }
        return list;
    }

    /**
     * create by huguokai date:2016年11月16日15:32:10
     * 查询认购记录
     * @param userNo
     * @return UserInfoDto
     */
    public List<SubRecordDto> getAllSubRecord(){
        String sql = "select * from t_inesv_sub_record r join t_inesv_sub_core c on r.sub_name = c.id ";
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class));
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询认购记录失败");
        }
        return list;
    }

    public List<SubRecordDto> getSubRecordInfoById(long id){
        String sql = "select * from t_inesv_sub_record where id = ?";
        Object params[] = {id};
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("根据id查询认购记录失败");
        }
        return list;
    }

    public List<SubRecordDto> getRecordInfoByUserNo(Integer userNo){
        String sql = "select * from t_inesv_sub_record where user_no = ?";
        Object params[] = {userNo};
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SubRecordDto> getRecordInfo(){
        String sql = "SELECT u.username,t.sub_name,t.coin_no,t.sub_price,t.sub_num,t.sum_price,t.thaw_num,t.thaw_time,t.sur_frozen,t.thaw_sum,t.state FROM t_inesv_sub_record t LEFT JOIN t_inesv_user u ON t.user_no=u.user_no  ";
        List<SubRecordDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubRecordDto>(SubRecordDto.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SubCoreDto> getSubCoreInfo(){
        String sql = "select * from t_inesv_sub_core";
        List<SubCoreDto> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<SubCoreDto>(SubCoreDto.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
