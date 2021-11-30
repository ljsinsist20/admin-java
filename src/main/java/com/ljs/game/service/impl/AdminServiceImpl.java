package com.ljs.game.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljs.game.mapper.AdminMapper;
import com.ljs.game.pojo.entity.Admin;
import com.ljs.game.service.AdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;


    @Override
    public PageInfo list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminMapper.list();
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int add(Admin admin) {
        int i = adminMapper.findByName(admin.getUserName());
        if (i == 1) {
            return -1;
        }
        int count = adminMapper.add(admin.getUserName(),MD5.create().digestHex(admin.getPassWord()), admin.getRole());
        return count;
    }

    @Override
    public int delete(Integer id, String role) {
        if ("administrator".equals(role)) {
            int num = adminMapper.findByAdmin();
            if (num == 1) {
                return 2;
            }
        }
        int count = adminMapper.delete(id);
        return count;
    }

    @Override
    public int updateStateById(Integer id) {
        int count = adminMapper.updateStateById(id);
        return count;
    }
}
