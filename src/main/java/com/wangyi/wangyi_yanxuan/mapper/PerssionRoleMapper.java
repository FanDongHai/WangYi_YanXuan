package com.wangyi.wangyi_yanxuan.mapper;

import com.wangyi.wangyi_yanxuan.domain.PerssionRole;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

public interface PerssionRoleMapper {
    /**
     *  根据角色id给角色添加权限
     * @param record
     * @return
     */
    int addRolePerssion(int rid, int fid);

    /**
     * 根据角色id删除权限
     * @param rid
     * @return
     */
    int deletePerssionRole(int rid,int fid);


}
