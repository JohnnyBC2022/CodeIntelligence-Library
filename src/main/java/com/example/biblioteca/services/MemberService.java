package com.example.biblioteca.services;

import com.example.biblioteca.models.MemberModel;

import java.util.List;

public interface MemberService {
    public MemberModel saveMember(MemberModel member);

    public MemberModel getMemberById(Integer id);

    public List<MemberModel> getAllMembers();

    public void deleteMemberById(Integer id);

    public MemberModel updateMember(Integer id, MemberModel memberToUpdate);
}
