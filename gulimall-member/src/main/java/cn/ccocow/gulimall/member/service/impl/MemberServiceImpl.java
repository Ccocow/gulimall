package cn.ccocow.gulimall.member.service.impl;

import cn.ccocow.gulimall.member.entity.MemberEntity;
import cn.ccocow.gulimall.member.mapper.MemberMapper;
import cn.ccocow.gulimall.member.service.IMemberService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements IMemberService {


}