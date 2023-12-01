package com.example.secondday;

import com.example.secondday.EntryDTO.CardDTO;
import com.example.secondday.Models.EmployModel;
import com.example.secondday.Models.Identycard;
import com.example.secondday.Models.teamMember;
import com.example.secondday.convertor.CardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {
    @Autowired
    Reposetory reposetory;
    @Autowired
    RepoTeam repoTeam;
    public String addEmploy(String name){
        EmployModel az = new EmployModel();
        az.setName(name);
        Identycard identycard = new Identycard();
        identycard.name = name;
        identycard.setEmployModel(az);
        az.setIdentycard(identycard);

        reposetory.save(az);
        return "added";
    }
    public String addteam(int evenOROdd,String name){
      int count=0;
      teamMember teamMember = new teamMember();
       reposetory.findAll().listIterator();
      try {

          List<EmployModel> list = reposetory.findAll();


          List<EmployModel> list1 = new ArrayList<>();
          for (int i=0;i<list.size();i++){
              if(i%evenOROdd==0){
                  list.get(i).setTeamMember(teamMember);
                  list1.add(list.get(i));
                  count++;
              }
          }

            teamMember.setGroupName(name);
          teamMember.setEmployModels(list1);
          repoTeam.save(teamMember);
          return "addedmember"+count;
      }
      catch (Exception e){
          System.out.println(e.getMessage());
      }
      return "Failed";
    }
    public List<EmployModel> getAllTeam(){

        List<teamMember> teamMembers = repoTeam.findAll();
        System.out.print(teamMembers.size());
        for(int i=0;i<teamMembers.size();i++){
            System.out.print(teamMembers.get(i).getEmployModels());
            return teamMembers.get(i).getEmployModels();
        }

return new ArrayList<>();
    }

    public String addCard( CardDTO cardDTO){
        Identycard identycard = CardConverter.converter(cardDTO);
        EmployModel employModel = new EmployModel();
        employModel.setName(cardDTO.getName());
        employModel.setIdentycard(identycard);
        reposetory.save(employModel);
        return "Added";
    }
}
