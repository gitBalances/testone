package com.tansuo365.test1.unused;//package com.tansuo365.test1.unused;
//
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//
//public interface MemberMapper {
//    long countByExample(MemberExample example);
//
//    int deleteByExample(MemberExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Member record);
//
//    //动态插入
//    int insertSelective(Member member);
//
//    List<Member> selectByExample(MemberExample example);
//
//    //动态选择
//    List<Member> selectMemberSelective(Member member);
//
//    Member selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);
//
//    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);
//
//    //动态更新
//    int updateByPrimaryKeySelective(Member record);
//
//    int updateByPrimaryKey(Member record);
//}