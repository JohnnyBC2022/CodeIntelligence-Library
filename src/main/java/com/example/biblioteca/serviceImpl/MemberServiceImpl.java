package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.MemberModel;
import com.example.biblioteca.repository.MemberRepository;
import com.example.biblioteca.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepo;

    @Override
    public MemberModel saveMember(MemberModel member) {
        MemberModel result = new MemberModel();

        try {
            result = memberRepo.save(member);
        } catch (Exception e) {
            System.out.println("[saveMember] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public MemberModel getMemberById(Integer id) {
        MemberModel result = new MemberModel();

        try {
            result = memberRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getMemberById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<MemberModel> getAllMembers() {
        List<MemberModel> members = null;

        try{
            members = memberRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllMembers] exception: " + e.getMessage());
        }

        return members;
    }

    @Override
    public void deleteMemberById(Integer id) {
        try {
            memberRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteMemberById] exception: " + e.getMessage());
        }
    }
}
