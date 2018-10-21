package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.mapper.LoginLogMapper;
import com.wangyi.wangyi_yanxuan.service.LoginLogService;
import com.wangyi.wangyi_yanxuan.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public PageBean<LoginLog> findAll(int page, int limit) {
        PageBean<LoginLog> pageInfo = new PageBean<>();

        pageInfo.setCurrentPage(page);

        // 设置每页显示的记录数
        pageInfo.setPageSize(limit);

        // 获取表中的记录总数
        int count = loginLogMapper.count();
        // 设置总记录数
        pageInfo.setCount(count);
        // 计算总页数
        if(count % pageInfo.getPageSize() == 0){
            pageInfo.setTotalPage(count / pageInfo.getPageSize());
        }else{
            pageInfo.setTotalPage(count / pageInfo.getPageSize()+ 1);
        }
        // 根据页码计算分页查询时的开始索引
        int index = (page - 1) * pageInfo.getPageSize();
        Map<String, Object> map = new HashMap<>();
        map.put("index", index);
        map.put("size", pageInfo.getPageSize());
        List<LoginLog> list = loginLogMapper.findAll(map);
        pageInfo.setPageInfos(list);

        return pageInfo;
    }
}
