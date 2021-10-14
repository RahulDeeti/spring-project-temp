package com.mydiaryapplication.userdiary.rest;

import com.mydiaryapplication.userdiary.dao.DiaryDao;
import com.mydiaryapplication.userdiary.entity.Diary;
import com.mydiaryapplication.userdiary.entity.User;
import com.mydiaryapplication.userdiary.service.DiaryService;
import com.mydiaryapplication.userdiary.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController
@RequestMapping("/api")
public class TempRest
{
    @Autowired
    private UserService userService;

   @Autowired
   private DiaryDao diaryDao;

   @PostMapping("/users")
    public void saveData(@RequestBody User user)
   {

//       User user = new User();
//
//
//       user.setFirstName("Rahul");
//       user.setLastName("Raj");
//       user.setEmail("Raj@gmail.com");
//       user.setPassword("123456");
//       user.setUserName("Raj98765");
      // user.addDiary(diary);

     userService.save(user);

   }
   @GetMapping("users/{userId}")
    public User getData(@PathVariable String userId)
   {
        return userService.get(userId);
   }

   @DeleteMapping("users/{userId}")
    public void deleteData(@PathVariable String userId)
   {
       userService.delete(userId);
   }


}
