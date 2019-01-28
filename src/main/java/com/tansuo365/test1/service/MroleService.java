package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.bean.Mrole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface MroleService {

    public Set<String> listMroleNames(String userName);

    public List<Mrole> listMroles(String userName);

    public List<Mrole> listMroles(Member member);

    public List<Mrole> list();

    public void add(Mrole mrole);

    public void delete(Long id);

    public Mrole get(Long id);

    public void update(Mrole mrole);
}
