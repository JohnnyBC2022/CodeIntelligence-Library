package com.example.biblioteca.controller;

import com.example.biblioteca.models.MemberModel;
import com.example.biblioteca.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping(value = "/save")
    public MemberModel saveMember(@RequestBody MemberModel member){
        MemberModel result = new MemberModel();

        result = memberService.saveMember(member);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public MemberModel getMemberById(@PathVariable(value = "id") Integer id){
        MemberModel result = new MemberModel();

        result = memberService.getMemberById(id);

        return result;
    }

    @GetMapping
    public List<MemberModel> getAllMembers(){
        return memberService.getAllMembers();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable(value = "id") Integer id){
        memberService.deleteMemberById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public MemberModel updateMember(@PathVariable(value = "id") Integer id, @RequestBody MemberModel memberToUpdate) {
        return memberService.updateMember(id, memberToUpdate);
    }
}
