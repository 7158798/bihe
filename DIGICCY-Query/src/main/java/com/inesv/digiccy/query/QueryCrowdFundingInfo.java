package com.inesv.digiccy.query;

import com.inesv.digiccy.dto.CrowdFundingDetailsDto;
import com.inesv.digiccy.dto.CrowdFundingDto;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 众筹项目查询
 * Created by JimJim on 2017/06/05 0017.
 */
@Component
public class QueryCrowdFundingInfo {

    private static Logger logger = LoggerFactory.getLogger(QueryCrowdFundingInfo.class);

    @Autowired
    QueryRunner queryRunner;
    
    /**
     * 查询所有众筹项目信息
     * @return
     */
    public List<CrowdFundingDto> queryAllCrowdFunding(String pageSize,String lineSize){
        List<CrowdFundingDto> crowdfundingList = new ArrayList<>();
        String sql = "SELECT * FROM t_crowdfunding WHERE ico_state != 2 limit ?,?";
        Object params[] = {Integer.valueOf(pageSize)*Integer.valueOf(lineSize),Integer.valueOf(lineSize)};
        try {
            crowdfundingList = queryRunner.query(sql,new BeanListHandler<>(CrowdFundingDto.class),params);
        } catch (SQLException e) {
            logger.error("查询众筹项目失败");
            e.printStackTrace();
        }
        return crowdfundingList;
    }
    
    /**
     * 查询所有众筹项目信息
     * @return
     */
    public List<CrowdFundingDto> queryAllCrowdFundingBack(){
        List<CrowdFundingDto> crowdfundingList = new ArrayList<>();
        String sql = "SELECT * FROM t_crowdfunding WHERE ico_state != 2";
        try {
            crowdfundingList = queryRunner.query(sql,new BeanListHandler<>(CrowdFundingDto.class));
        } catch (SQLException e) {
            logger.error("查询众筹项目失败");
            e.printStackTrace();
        }
        return crowdfundingList;
    }
    
    /**
     * 查询指定众筹项目信息
     * @return
     */
    public CrowdFundingDto queryCrowdFundingInfo(String icoNo){
        CrowdFundingDto crowdfunding = new CrowdFundingDto();
        String sql = "SELECT * FROM t_crowdfunding WHERE ico_no=?";
        Object params[] = {icoNo};
        try {
            crowdfunding = queryRunner.query(sql,new BeanHandler<>(CrowdFundingDto.class),params);
        } catch (SQLException e) {
            logger.error("查询众筹项目失败");
            e.printStackTrace();
        }
        return crowdfunding;
    }
    
    /**
     * 查询所有用户众筹项目信息
     * @return
     */
    public List<CrowdFundingDetailsDto> queryAllCrowdFundingDetailBack(){
        List<CrowdFundingDetailsDto> crowdfundingList = new ArrayList<>();
        String sql = "SELECT * FROM t_crowdfunding_details";
        try {
            crowdfundingList = queryRunner.query(sql,new BeanListHandler<>(CrowdFundingDetailsDto.class));
        } catch (SQLException e) {
            logger.error("查询众筹项目失败");
            e.printStackTrace();
        }
        return crowdfundingList;
    }

}
